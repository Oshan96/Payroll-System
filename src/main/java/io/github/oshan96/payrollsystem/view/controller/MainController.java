package io.github.oshan96.payrollsystem.view.controller;

import io.github.oshan96.payrollsystem.db.controller.impl.EmployeeController;
import io.github.oshan96.payrollsystem.model.db.Employee;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author oshan
 */
public class MainController implements Initializable {

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtHours;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtBSal;

    @FXML
    private TextField txtPos;

    @FXML
    private TextField txtOPay;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtTotSal;

    @FXML
    private TextField txtDob;

    @FXML
    private TextField txtEtf;

    @FXML
    private TextArea txtAddress;

    @FXML
    private TextField txtNetSal;

    private EmployeeController empCon;

    private Employee emp;

    public MainController() {
        try {
            empCon = new EmployeeController();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void idAction() {
        String id = txtId.getText();
        try {
            emp = empCon.get(id);
            txtName.setText(emp.getName());
            txtAddress.setText(emp.getAddress());
            txtNic.setText(emp.getNic());
            txtDob.setText(emp.getDob());
            txtBSal.setText(""+emp.getPost().getBasicSalary());
            txtPos.setText(emp.getPost().getId());
            txtEtf.setText(emp.getPost().getBasicSalary()*0.5 + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void calculateSalary() {
        double bSal = emp.getPost().getBasicSalary();
        double oSal = Double.parseDouble(txtHours.getText()) * emp.getPost().getHourlyRate();
        double totalSal = bSal + oSal;

        double netSal = totalSal - Double.parseDouble(txtEtf.getText());

        txtOPay.setText(oSal+"");
        txtTotSal.setText(totalSal+"");
        txtNetSal.setText(netSal+"");
    }


}

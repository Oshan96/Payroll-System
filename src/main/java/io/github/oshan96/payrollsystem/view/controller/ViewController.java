package io.github.oshan96.payrollsystem.view.controller;

import io.github.oshan96.payrollsystem.db.controller.impl.EmployeeController;
import io.github.oshan96.payrollsystem.model.db.Employee;
import io.github.oshan96.payrollsystem.model.table.ViewTableModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author oshan
 */
public class ViewController implements Initializable {

    @FXML
    TableView<ViewTableModel> tblView;
    @FXML
    TableColumn<ViewTableModel,String> colId,colName,colNic,colDob,colAdd;

    @FXML
    TextField txtSal;
    @FXML
    ComboBox<String> cmb;

    private EmployeeController empController;

    public ViewController() {
        try {
            empController = new EmployeeController();
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

        cmb.getItems().setAll("Below","Above");

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colAdd.setCellValueFactory(new PropertyValueFactory<>("address"));

    }

    @FXML
    private void populate() {
        tblView.getItems().clear();
        try {
            double sal = Double.parseDouble(txtSal.getText());
            List<Employee> employees;
            if(cmb.getValue().equals("Below")) {
                employees = empController.getEmployeesBelow(sal);
            } else {
                employees = empController.getEmployeesAbove(sal);
            }

            for(Employee emp : employees) {
                tblView.getItems().add(
                  new ViewTableModel(
                          emp.getId(),
                          emp.getName(),
                          emp.getNic(),
                          emp.getDob(),
                          emp.getAddress()
                  )
                );
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

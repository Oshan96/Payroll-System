package io.github.oshan96.payrollsystem.view.controller;

import com.jfoenix.controls.JFXDatePicker;
import io.github.oshan96.payrollsystem.db.controller.impl.EmployeeController;
import io.github.oshan96.payrollsystem.db.controller.impl.PostController;
import io.github.oshan96.payrollsystem.db.util.idGenerator.IDGenerator;
import io.github.oshan96.payrollsystem.model.db.Employee;
import io.github.oshan96.payrollsystem.model.db.Post;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author oshan
 */
public class AddEmpController implements Initializable {
    @FXML
    private TextField txtId,txtName,txtNic;
    @FXML
    private JFXDatePicker dtPckr;
    @FXML
    private TextArea txtAddress;
    @FXML
    private ComboBox<String> cmbPos;
    @FXML
    private Button btnAdd;

    private String id = "";
    private PostController postController;
    private EmployeeController employeeController;

    public AddEmpController() {
        try {
            postController = new PostController();
            employeeController = new EmployeeController();
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            id = IDGenerator.getNewID("employee","id","E");
            cmbPos.getItems().setAll(postController.getIDs());
        } catch (Exception e) {
            e.printStackTrace();
        }

        txtId.setText(id);
    }

    @FXML
    private void addEmployee() {
        String name = txtName.getText();
        String nic = txtNic.getText();
        String address = txtAddress.getText();
        String dob = dtPckr.getValue().toString();
        Post post = null;

        try {
            post = postController.get(cmbPos.getValue());
            Employee emp = new Employee(id,name,address,nic,dob,post);

            if(employeeController.add(emp)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Successfully Added!",ButtonType.OK);
                alert.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}

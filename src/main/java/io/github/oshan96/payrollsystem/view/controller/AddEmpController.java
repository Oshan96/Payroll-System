package io.github.oshan96.payrollsystem.view.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import io.github.oshan96.payrollsystem.db.util.idGenerator.IDGenerator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            id = IDGenerator.getNewID("employee","id","E");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        txtId.setText(id);
    }

    @FXML
    private void addEmployee() {
        
    }
}

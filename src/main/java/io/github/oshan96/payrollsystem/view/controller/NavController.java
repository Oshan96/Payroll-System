package io.github.oshan96.payrollsystem.view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.vivoxalabs.customstage.CustomStage;
import lk.vivoxalabs.scenemanager.SceneManager;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author oshan
 */
public class NavController implements Initializable {
    @FXML
    Button btnCal,btnComp,btnAdd,btnView,btnEdit,btnDel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void loadView(ActionEvent evt) {
        String id = ((Button)evt.getSource()).getId();
        Stage stage = (Stage) (((Button)evt.getSource()).getScene().getWindow());
        SceneManager mngr = CustomStage.getDefaultSceneManager();
        switch (id) {
            case "btnCal" : ((CustomStage) stage).changeScene(mngr.getScene("main"));
            break;

            case "btnComp" : ((CustomStage) stage).changeScene(mngr.getScene("view"));
            break;

            case "btnAdd" : ((CustomStage) stage).changeScene(mngr.getScene("addEmp"));
            break;

            case "btnDel" : ((CustomStage) stage).changeScene(mngr.getScene("delEmp"));
            break;

            case "btnEdit" : ((CustomStage) stage).changeScene(mngr.getScene("editEmp"));
            break;
        }
    }
}

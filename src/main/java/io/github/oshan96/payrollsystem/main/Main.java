package io.github.oshan96.payrollsystem.main;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.vivoxalabs.customstage.CustomStage;
import lk.vivoxalabs.customstage.CustomStageBuilder;
import lk.vivoxalabs.customstage.tools.NavigationType;
import lk.vivoxalabs.customstage.tools.Style;

/**
 * @author oshan
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane nav = new AnchorPane();
        nav.setStyle("-fx-background-color: #2196f3;");

        CustomStage stage = new CustomStageBuilder()
                .setDimensions(200,200,1980,1024)
                .setWindowTitle("Payroll System")
                .setWindowColor("#1769aa")
                .setTitleColor("white")
//                .setActionIcons(new Image("icons/title-bar/btnClose.png"),
//                        new Image("icons/title-bar/btnMinimize.png"),
//                        new Image("icons/title-bar/btnMaximize.png"),
//                        new Image("icons/title-bar/btnRestore.png"))
                .setNavigationPane(Style.DYNAMIC,NavigationType.LEFT,nav,30,0,false)
                .build();

        stage.getScene().getRoot().setOnMouseClicked(e->stage.dynamicDrawerEvent(NavigationType.LEFT));

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

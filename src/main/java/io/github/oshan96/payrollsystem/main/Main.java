package io.github.oshan96.payrollsystem.main;

import javafx.application.Application;
import javafx.stage.Stage;
import lk.vivoxalabs.customstage.CustomStage;
import lk.vivoxalabs.customstage.CustomStageBuilder;

/**
 * @author oshan
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        CustomStage stage = new CustomStageBuilder()
                .setDimensions(200,200,1980,1024)
                .setWindowTitle("Payroll System")
                .setWindowColor("#81d4fa")
                .setTitleColor("black")
                .build();

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

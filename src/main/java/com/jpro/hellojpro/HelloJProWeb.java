package com.jpro.hellojpro;

import com.jpro.web.sessionmanager.SessionManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import fr.brouillard.oss.cssfx.CSSFX;

public class HelloJProWeb extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        CSSFX.start();

        HelloJProApp app = new HelloJProApp(stage);
        Scene scene = new Scene(app);
        stage.setScene(scene);
        stage.show();
        app.start(SessionManager.getDefault(app, stage));
    }
}

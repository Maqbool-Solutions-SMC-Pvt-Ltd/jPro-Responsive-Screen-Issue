package com.jpro.hellojpro;

import com.jpro.hellojpro.page.InfoPage;
import com.jpro.web.Redirect;
import com.jpro.web.WebApp;
import javafx.stage.Stage;

public class HelloJProApp extends WebApp {

    HelloJProApp(Stage stage) {
        super(stage);

        addRouteJava((s) -> {
            switch (s) {
                case "":
                case "/":
                    return new Redirect("/info");
                case "/info":
                    return new InfoPage();
                default:
                    return null;
            }
        });
    }
}

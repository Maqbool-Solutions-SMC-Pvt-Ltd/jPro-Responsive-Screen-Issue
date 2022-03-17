package com.jpro.hellojpro.page;

import com.jpro.web.View;
import com.sandec.mdfx.MarkdownView;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;

public class InfoPage extends View {

    private File readmeFile = new File("README.md");

    @Override
    public String title() {
        return "Markdown Test Project";
    }

    @Override
    public String description() {
        return "";
    }

    @Override
    public Node content() {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));
        borderPane.getStylesheets().add("/com/sandec/mdfx/mdfx-default.css");

        VBox vbxMain = new VBox(10);

        String readmeStr = "";
        try {
            readmeStr = IOUtils.toString(readmeFile.toURI(), "utf-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MarkdownView mview = new MarkdownView(readmeStr);

        VBox hbxFooter = new VBox(10);
        hbxFooter.setStyle("-fx-background-color: blue");
        hbxFooter.setPadding(new Insets(10));

        for (int i = 1; i <= 200; i++) {
            Label lbl = new Label(i + " Hello JPro");
            lbl.setFont(new Font(25));
            lbl.setStyle("-fx-text-fill: white");

            hbxFooter.getChildren().add(lbl);
        }

        vbxMain.getChildren().addAll(mview, hbxFooter);

        borderPane.setCenter(vbxMain);

        return borderPane;
    }
}

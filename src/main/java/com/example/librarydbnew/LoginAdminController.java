package com.example.librarydbnew;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginAdminController {
    public void switchAdminPage(ActionEvent Action) throws IOException {
        final var stage = new Stage();
        final FXMLLoader fxmlLoader = new FXMLLoader(BookApplication.class.getResource("AdminPage.fxml"));
        final Scene adminPage = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Admin Page");
        stage.setScene(adminPage);
        stage.show();
    }
}

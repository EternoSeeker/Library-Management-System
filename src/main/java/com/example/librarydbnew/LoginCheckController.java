package com.example.librarydbnew;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginCheckController {
    @FXML
    private Label welcomeText;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Hello");
    }

    public void switchMember(ActionEvent Action) throws IOException {
        final var stage = new Stage();
        final FXMLLoader fxmlLoader = new FXMLLoader(BookApplication.class.getResource("LoginMember.fxml"));
        final Scene login_member = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Member");
        stage.setScene(login_member);
        stage.show();
    }
    public void switchAdmin(ActionEvent Action) throws IOException {
        final var stage = new Stage();
        final FXMLLoader fxmlLoader = new FXMLLoader(BookApplication.class.getResource("LoginAdmin.fxml"));
        final Scene login_admin = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Admin ");
        stage.setScene(login_admin);
        stage.show();
    }
}
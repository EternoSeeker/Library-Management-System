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

    public void switch_scene_member(Stage stage1) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BookApplication.class.getResource("LoginMember.fxml"));
        Scene login_member = new Scene(fxmlLoader.load(), 600, 400);
        stage1.setTitle("Member");
        stage1.setScene(login_member);
        stage1.show();
    }
    public void switch_member(ActionEvent Action) throws IOException {
        switch_scene_member(new Stage());
    }

    public void switch_scene_admin(Stage stage1) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BookApplication.class.getResource("LoginAdmin.fxml"));
        Scene login_admin = new Scene(fxmlLoader.load(), 600, 400);
        stage1.setTitle("Admin");
        stage1.setScene(login_admin);
        stage1.show();
    }
    public void switch_admin(ActionEvent Action) throws IOException {
        switch_scene_admin(new Stage());
    }
}
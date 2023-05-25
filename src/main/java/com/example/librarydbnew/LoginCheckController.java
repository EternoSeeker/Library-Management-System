package com.example.librarydbnew;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginCheckController {
    private Repository repository = null;
    public BookApplication bookApplication = new BookApplication();
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public void switchMember(ActionEvent Action) throws IOException {
        final var stage = new Stage();
        final FXMLLoader fxmlLoader = new FXMLLoader(BookApplication.class.getResource("LoginMember.fxml"));
        final Scene loginMember = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Member");
        stage.setScene(loginMember);
        stage.show();
    }

    public void switchAdmin(ActionEvent Action) throws IOException {
        final var stage = new Stage();
        final FXMLLoader fxmlLoader = new FXMLLoader(BookApplication.class.getResource("LoginAdmin.fxml"));
        final Scene loginAdmin = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Admin ");
        stage.setScene(loginAdmin);
        stage.show();
    }

    public void switchSignUp(ActionEvent Action) throws IOException {
        final var stage = new Stage();
        final FXMLLoader fxmlLoader = new FXMLLoader(BookApplication.class.getResource("SignUp.fxml"));
        final Scene signUp = new Scene(fxmlLoader.load(), 800, 600);
        final SignUpController controller = fxmlLoader.getController();
        controller.setRepository(repository);
        stage.setTitle("Sign Up ");
        stage.setScene(signUp);
        stage.show();
    }


}
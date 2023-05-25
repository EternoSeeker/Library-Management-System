package com.example.librarydbnew;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SignUpController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    private Repository repository = null;

    public LoginCheckController loginCheckController = new LoginCheckController();

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public void insertSignUp(ActionEvent event) throws SQLException, IOException {
        //String hashPass = password.getText();
        repository.insertMember(firstName.getText(), lastName.getText(), email.getText(), password.getText());
        loginCheckController.switchMember(event);
    }
}

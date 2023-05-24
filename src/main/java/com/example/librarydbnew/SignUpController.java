package com.example.librarydbnew;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public void insertSignUp(ActionEvent event) throws SQLException {
        //String hashPass = password.getText();
        repository.insertMember(firstName.getText(), lastName.getText(), email.getText(), password.getText());
    }
}

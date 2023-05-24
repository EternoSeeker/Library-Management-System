package com.example.librarydbnew;
import javafx.application.Application;
import com.example.librarydbnew.Repository;
import javafx.event.ActionEvent;
import java.sql.*;
import com.example.librarydbnew.Repository;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    public void insertSignUp(ActionEvent event) throws SQLException {
        //System.out.println(firstName.getText());
        Repository.insertMember(firstName.getText(), lastName.getText(), email.getText(), password.getText());
    }
}

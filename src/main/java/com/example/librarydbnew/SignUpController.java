package com.example.librarydbnew;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.regex.Pattern;

public class SignUpController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private Label invalidEmail;
    @FXML
    private Label invalidPassword;
    @FXML
    private Label confirmPassMatch;
    private Repository repository = null;

    public LoginCheckController loginCheckController = new LoginCheckController();

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public static boolean isValidEmailAddress(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public static String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertSignUp(ActionEvent event) throws SQLException, IOException {
        String pass = password.getText();
        String confirmPass = confirmPassword.getText();
        boolean passCheck = pass.length() >= 8;
        boolean emailCheck = isValidEmailAddress(email.getText());
        boolean confirmCheck = Objects.equals(pass, confirmPass);
        if (emailCheck && passCheck && confirmCheck) {
            pass = encryptPassword(pass);
            //System.out.println(pass);
            repository.insertMember(firstName.getText(), lastName.getText(), email.getText(), pass);
            loginCheckController.switchMember(event);
        }
        else if(!passCheck && !emailCheck){
            invalidPassword.setText("Min. 8 Characters");
            invalidEmail.setText("Invalid email format");
            confirmPassMatch.setText("");
        }
        else if (!emailCheck) {
            invalidEmail.setText("Invalid email format");
            invalidPassword.setText("");
            confirmPassMatch.setText("");
        }
        else if (!passCheck) {
            invalidPassword.setText("Min. 8 Characters");
            invalidEmail.setText("");
            confirmPassMatch.setText("");
        }
        else {
            confirmPassMatch.setText("Password don't match");
            invalidEmail.setText("");
            invalidPassword.setText("");
        }
    }
}

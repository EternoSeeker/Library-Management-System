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
        if(isValidEmailAddress(email.getText()) && password.getText().length() >= 8 && Objects.equals(pass, confirmPass)){
            pass = encryptPassword(pass);
            System.out.println(pass);
            repository.insertMember(firstName.getText(), lastName.getText(), email.getText(), pass);
            loginCheckController.switchMember(event);
        }
        if(!isValidEmailAddress(email.getText())){
            invalidEmail.setText("Invalid email format");
        }
        if(password.getText().length() < 8){
            invalidPassword.setText("Min. 8 Characters");
        }
        if(!Objects.equals(password.getText(), confirmPass)){
            confirmPassMatch.setText("Password don't match");
        }
    }
}

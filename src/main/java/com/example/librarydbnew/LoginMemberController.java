package com.example.librarydbnew;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Objects;

public class LoginMemberController {

    @FXML
    private PasswordField memberPassword;
    @FXML
    private TextField memberEmail;
    @FXML
    private Label invalidEmail;
    @FXML
    private Label invalidPassword;
    private Repository repository = null;
    String[] memberDetails = new String[3];

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

    public void switchMemberPage(ActionEvent Action) throws IOException, SQLException {
        final var stage = new Stage();
        final FXMLLoader fxmlLoader = new FXMLLoader(BookApplication.class.getResource("MemberPage.fxml"));
        final Scene memberPage = new Scene(fxmlLoader.load(), 800, 600);
        String emailAdd = memberEmail.getText();
        if(repository.checkMemberEmail(emailAdd)){
            memberDetails = repository.returnMemberDetail(emailAdd);
            String pass = memberPassword.getText();
            if(Objects.equals(encryptPassword(pass), memberDetails[2])){
                stage.setTitle("Member Page");
                stage.setScene(memberPage);
                stage.show();
            }
            else{
                invalidPassword.setText("Wrong password");
            }
        }
        else{
            invalidEmail.setText("Email not found");
        }
        stage.setTitle("Member Page");
        stage.setScene(memberPage);
        stage.show();
    }
//    public void goBackToLoginCheck(ActionEvent event) throws IOException{
//    }
}

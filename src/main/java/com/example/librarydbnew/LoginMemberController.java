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
    String[] memberDet = new String[3];

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
        var stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(BookApplication.class.getResource("MemberPage.fxml"));
        Scene memberPage = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Member Page");
        stage.setScene(memberPage);
        stage.show();
//        String emailAdd = memberEmail.getText();
//        String pass = memberPassword.getText();
//        memberDet = repository.returnMemberDetail(emailAdd);
//        MemberPageController memberPageController = new MemberPageController();
//        if(repository.checkMemberEmail(emailAdd)){
//            if(Objects.equals(encryptPassword(pass), memberDet[2])){
//                stage.setTitle("Member Page");
//                stage.setScene(memberPage);
//                stage.show();
//            }
//            else{
//                invalidPassword.setText("Wrong password");
//            }
//        }
//        else{
//            invalidEmail.setText("Email not found");
//        }
    }
}

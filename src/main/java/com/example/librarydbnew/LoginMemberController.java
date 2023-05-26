package com.example.librarydbnew;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginMemberController {

    public void switchMemberPage(ActionEvent Action) throws IOException {
        final var stage = new Stage();
        final FXMLLoader fxmlLoader = new FXMLLoader(BookApplication.class.getResource("MemberPage.fxml"));
        final Scene memberPage = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Member Page");
        stage.setScene(memberPage);
        stage.show();
    }
    public void goBackToLoginCheck(ActionEvent event) throws IOException{
    }
}

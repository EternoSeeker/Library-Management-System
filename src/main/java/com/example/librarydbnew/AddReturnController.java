package com.example.librarydbnew;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class AddReturnController {
    @FXML
    private Label cp;
    @FXML
    private TextField memberID;
    @FXML
    private TextField bookID;
    private Repository repository = null;
    public void setRepository(Repository repository) {
        this.repository = repository;
    }
    public void issueBookToMember(ActionEvent event) throws IOException, SQLException{
        Repository repo = new Repository();
        int membID = Integer.parseInt(memberID.getText());
        int bID = Integer.parseInt(bookID.getText());
        repo.issueBook(membID, bID);
        cp.setText("Book Issued Successfully!");
    }

    public void returnBookFromMember(ActionEvent event) throws IOException, SQLException{
        Repository repo = new Repository();
        int membID = Integer.parseInt(memberID.getText());
        int bID = Integer.parseInt(bookID.getText());
        repo.returnBook(membID, bID);
        cp.setText("Book Returned Successfully!");
    }
}

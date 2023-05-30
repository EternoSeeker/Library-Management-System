package com.example.librarydbnew;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import java.io.IOException;
import java.sql.SQLException;

public class AddBookController {
    @FXML
    private Label confirmAddBook;
    @FXML
    private TextField bookName;
    @FXML
    private TextField bookISBN;
    @FXML
    private TextField bookCopies;
    @FXML
    private TextField bookPrice;
    @FXML
    private TextField bookAuthor;
    @FXML
    private TextField bookPages;
    private Repository repository = null;
    public AdminPageController adminPageController = new AdminPageController();
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public void insertBook(ActionEvent event) throws IOException, SQLException{
        Repository repo = new Repository();
        int copies = Integer.parseInt(bookCopies.getText());
        int price = Integer.parseInt(bookPrice.getText());
        int pages = Integer.parseInt(bookPages.getText());
        repo.insertBook(bookName.getText(), bookISBN.getText(), copies, price, bookAuthor.getText(), pages);
        confirmAddBook.setText("Book Added Successfully!");
    }
}

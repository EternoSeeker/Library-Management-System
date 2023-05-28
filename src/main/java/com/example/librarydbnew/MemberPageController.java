package com.example.librarydbnew;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MemberPageController {
    @FXML
    private Label bookTitle;
    @FXML
    private Label bookAuthor;
    @FXML
    private Label bookPages;
    @FXML
    private Label bookISBN;
    @FXML
    private Label bookCopies;
    @FXML
    private Label bookTitleData;
    @FXML
    private Label bookAuthorData;
    @FXML
    private Label bookPageData;
    @FXML
    private Label bookISBNData;
    @FXML
    private Label bookCopiesData;
    @FXML
    private TextField searchBookTitle;

    public void searchBook(ActionEvent actionEvent) throws IOException, SQLException {
        String search = searchBookTitle.getText();
        Repository repo = new Repository();
        final List<Book> books = repo.getAllBooks(search);

        bookTitle.setText("Title: ");
        bookAuthor.setText("Author: ");
        bookPages.setText("Pages: ");
        bookISBN.setText("ISBN: ");
        bookCopies.setText("Copies: ");

        String title = null;
        String author = null;
        String ISBN = null;
        String pages = null;
        String copies = null;
        for (final Book book : books) {
            title = book.getName();
            author = book.getAuthorName();
            ISBN = book.getIsbn();
            pages = String.valueOf(book.getPages());
            copies = String.valueOf(book.getTotalCopies());
        }
        bookTitleData.setText(title);
        bookAuthorData.setText(author);
        bookISBNData.setText(ISBN);
        bookPageData.setText(pages);
        bookCopiesData.setText(copies);
    }
}

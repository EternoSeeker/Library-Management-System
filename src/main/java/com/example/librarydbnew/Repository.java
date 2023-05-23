package com.example.librarydbnew;
import javafx.event.ActionEvent;

import java.security.cert.CertPath;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    public static  Connection getConnection(){
        String url = "jdbc:oracle:thin:@localhost:1521/XE";
        String username = "system";
        String password = "shr!";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private static final Connection connection = Repository.getConnection();

    public List<Book> getAllBooks() throws SQLException{
        final Statement statement = connection.createStatement();
        final ResultSet result = statement.executeQuery("SELECT * FROM book WHERE book_name LIKE 'A%' ORDER BY book_name");

        ArrayList<Book> books = new ArrayList<Book>();
        while(result.next()){
            final long id = result.getLong("id");
            final String name = result.getString("book_name");
            final String isbn = result.getString("isbn");
            final long totalCopies = result.getLong("total_copies");
            final long price = result.getLong("price");
            final String authorName = result.getString("author_name");
            final long pages = result.getLong("pages");
            final String issueDate = result.getString("issue_date");
            final Book book = new Book(id, name, isbn, totalCopies, price, authorName, pages, issueDate);
            books.add(book);
        }
        return books;
    }

    public void insertMember() throws SQLException{
        final Statement statement = connection.createStatement();
        statement.executeQuery("insert into member (member_id, first_name, last_name, email, password, book_issue_date, book_id) values (11, 'ABC', 'XYZ', 'afahrenbach0@mail.com', '4kV1FN4kTr5A', '10-NOV-22', null)");
        System.out.println("Inserted data test");
    }


    public static void main(String[] args) throws SQLException {
        final Repository repo = new Repository();
        repo.insertMember();
        final List<Book> books = repo.getAllBooks();
        for(final Book book : books){
            System.out.println("ID: "+ book.getId());
            System.out.println("Name: " + book.getName());
            System.out.println("Pages: " + book.getPages());
        }
    }
}



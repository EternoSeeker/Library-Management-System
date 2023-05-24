package com.example.librarydbnew;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private final Connection connection;

    public Repository() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/XE",
                "system",
                "shr!"
        );
    }

    public List<Book> getAllBooks() throws SQLException {
        final Statement statement = connection.createStatement();
        final ResultSet result = statement.executeQuery("SELECT * FROM book WHERE book_name LIKE 'A%' ORDER BY book_name");

        ArrayList<Book> books = new ArrayList<Book>();
        while (result.next()) {
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

    public void insertMember(String firstName, String lastName, String emailAddress, String pas) throws SQLException {
        String sql = "insert into member (member_id, first_name, last_name, email, password, book_issue_date, book_id) values (member_id.NEXTVAL, ?, ?, ?, ?, null, null)";
        PreparedStatement statement;
        statement = connection.prepareStatement(sql);
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setString(3, emailAddress);
        statement.setString(4, pas);
        statement.executeUpdate();
    }


    public static void main(String[] args) throws SQLException {
        final Repository repo = new Repository();
        final List<Book> books = repo.getAllBooks();
        for (final Book book : books) {
            System.out.println("ID: " + book.getId());
            System.out.println("Name: " + book.getName());
            System.out.println("Pages: " + book.getPages());
        }
    }
}



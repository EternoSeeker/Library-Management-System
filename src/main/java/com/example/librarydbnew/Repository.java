package com.example.librarydbnew;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    public static String encrypt(String password) {
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

    public List<Book> getAllBooks(String nameOfBook) throws SQLException {
        String sql = "SELECT * FROM book WHERE book_name = ?";
        PreparedStatement statement;
        statement = connection.prepareStatement(sql);
        statement.setString(1, nameOfBook);
        statement.executeUpdate();
        final ResultSet result = statement.getResultSet();

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

    public void insertBook(String bookName, String bookISBN, long totalCopies, long bookPrice, String bookAuthor, long bookPages) throws SQLException {
        String sql = "insert into book (id, book_name, isbn, total_copies, price, author_name, pages, issue_date) values (104, ?, ?, ?, ?, ?, ?, null)";
        PreparedStatement statement;
        statement = connection.prepareStatement(sql);
        statement.setString(1, bookName);
        statement.setString(2, bookISBN);
        statement.setLong(3, totalCopies);
        statement.setLong(4, bookPrice);
        statement.setString(5, bookAuthor);
        statement.setLong(6, bookPages);
        statement.executeUpdate();
    }

    public void issueBook(long memberID, long bookID) throws SQLException{
        String sql1 = "UPDATE member SET book_issue_date = SYSDATE WHERE member_id = ?";
        String sql2 = "UPDATE book SET issue_date = SYSDATE WHERE id = ?";
        String sql3 = "UPDATE member SET book_id = ? WHERE member_id = ?";
        PreparedStatement statement1;
        PreparedStatement statement2;
        PreparedStatement statement3;
        statement1 = connection.prepareStatement(sql1);
        statement1.setLong(1, memberID);
        statement2 = connection.prepareStatement(sql2);
        statement2.setLong(1, bookID);
        statement3 = connection.prepareStatement(sql3);
        statement3.setLong(1, bookID);
        statement3.setLong(2, memberID);
        statement1.executeUpdate();
        statement2.executeUpdate();
    }

    public void returnBook(long memberID, long bookID) throws SQLException{
        String sql1 = "UPDATE member SET book_issue_date = null, book_id = null WHERE member_id = ?";
        String sql2 = "UPDATE book SET issue_date = null WHERE id = ?";
        PreparedStatement statement1;
        PreparedStatement statement2;
        statement1 = connection.prepareStatement(sql1);
        statement1.setLong(1, memberID);
        statement2 = connection.prepareStatement(sql2);
        statement2.setLong(1, bookID);
        statement1.executeUpdate();
        statement2.executeUpdate();
    }
    public String[] returnMemberDetail(String emailAddress) throws SQLException {
        String[] memberdetails = new String[3];
        String sql = "SELECT first_name, last_name, password FROM member WHERE email = ?";
        PreparedStatement statement;
        statement = connection.prepareStatement(sql);
        statement.setString(1, emailAddress);
        statement.executeUpdate();
        final ResultSet result = statement.getResultSet();
        while(result.next()){
            memberdetails[0] = result.getString("first_name");
            memberdetails[1] = result.getString("last_name");
            memberdetails[2] = result.getString("password");
        }
        return memberdetails;
    }

    public boolean checkMemberEmail(String emailAddress) throws SQLException {
        String emailCheck = null;
        String sql = "SELECT email FROM member WHERE email = ?";
        PreparedStatement statement;
        statement = connection.prepareStatement(sql);
        statement.setString(1, emailAddress);
        statement.executeUpdate();
        final ResultSet result = statement.getResultSet();
        emailCheck = result.getString("email");
        return emailCheck != null;
    }
    public static void main(String[] args) throws SQLException {
        final Repository repo = new Repository();
        final List<Book> books = repo.getAllBooks("Fury");
        for (final Book book : books) {
            System.out.println("ID: " + book.getId());
            System.out.println("Name: " + book.getName());
            System.out.println("Pages: " + book.getPages());
            System.out.println("Author name: " + book.getAuthorName());
        }
    }
}



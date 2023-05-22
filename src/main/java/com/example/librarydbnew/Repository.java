package com.example.librarydbnew;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    final Connection connection;

    public Repository() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/XE",
                "system",
                "shr!"
        );
    }

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
            final Book book = new Book(id, name, isbn, totalCopies, price);
            books.add(book);
        }
        return books;
    }


    public static void main(String[] args) throws SQLException {
        final Repository repo = new Repository();

        final List<Book> books = repo.getAllBooks();
        for(final Book book : books){
            System.out.println(book.id);
            System.out.println(book.name);
        }
    }
}



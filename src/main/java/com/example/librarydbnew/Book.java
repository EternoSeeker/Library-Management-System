package com.example.librarydbnew;

public class Book {
    final long id;
    final String name;
    final String isbn;
    final long totalCopies;
    final long price;

    Book(long id, String name, String isbn, long totalCopies, long price ){
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.totalCopies = totalCopies;
        this.price = price;
    }
}

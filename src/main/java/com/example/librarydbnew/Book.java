package com.example.librarydbnew;

public class Book {
    private long id;
    private String name;
    private String isbn;
    private long totalCopies;
    private long price;
    private String authorName;
    private long pages;
    private String issue_date;
    Book(long id, String name, String isbn, long totalCopies, long price, String authorName, long pages, String issue_date ){
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.totalCopies = totalCopies;
        this.price = price;
        this.authorName = authorName;
        this.pages = pages;
        this.issue_date = issue_date;
    }
    Book(String name, String isbn, long totalCopies, long price, String authorName, long pages, String issue_date ){
        this.name = name;
        this.isbn = isbn;
        this.totalCopies = totalCopies;
        this.price = price;
        this.authorName = authorName;
        this.pages = pages;
        this.issue_date = issue_date;
    }
    Book(){
    }

    public long getId(){return id;}
    public String getName(){return name;}
    public String getIsbn(){return isbn;}
    public long getTotalCopies(){return totalCopies;}
    public long getPrice(){return price;}
    public String getAuthorName(){return authorName;}
    public long getPages(){return pages;}
    public String getIssue_date(){return issue_date;}

    public void setId(long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public void setTotalCopies(long totalCopies){
        this.totalCopies = totalCopies;
    }

    public void setPrice(long price){
        this.price = price;
    }
    public void setAuthorName(String authorName){
        this.authorName = authorName;
    }
    public void setPages(long pages){
        this.pages = pages;
    }
    public void setIssue_date(String issue_date){
        this.issue_date = issue_date;
    }


}

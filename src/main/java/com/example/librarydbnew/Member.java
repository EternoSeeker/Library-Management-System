package com.example.librarydbnew;

public class Member {
    final long member_id;
    final String first_name;
    final String last_name;

    final String email;

    final String password;

    final String book_issue_date;

    final long book_id;

    Member(long member_id, String first_name,String last_name ,String email, String password, String book_issue_date, long book_id){
        this.member_id = member_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.book_issue_date = book_issue_date;
        this.book_id = book_id;
    }
}
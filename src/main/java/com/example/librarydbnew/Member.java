package com.example.librarydbnew;

public class Member {
    private long member_id;
    private String first_name;
    private String last_name;

    private String email;

    private String password;

    private String book_issue_date;

    private long book_id;

    Member(long member_id, String first_name,String last_name ,String email, String password, String book_issue_date, long book_id){
        this.member_id = member_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.book_issue_date = book_issue_date;
        this.book_id = book_id;
    }
    Member(String first_name,String last_name ,String email, String password, String book_issue_date, long book_id){
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.book_issue_date = book_issue_date;
        this.book_id = book_id;
    }

    Member(){
    }

    public long getMemberId(){
        return member_id;
    }
    public void setMemberId(long member_id){
        this.member_id = member_id;
    }
    public void setFirst_Name(String first_name){
        this.first_name= first_name;
    }
    public void setLast_Name(String last_name){
        this.last_name = last_name;
    }
    public void setEmailId(String Email){
        this.email = Email;
    }
    public void setPassword(String Pass){
        this.password = Pass;
    }
    public void setBookIssueDate(String Date){
        this.book_issue_date = Date;
    }
    public void setBookid(long id){
        this.book_id= id;
    }
}
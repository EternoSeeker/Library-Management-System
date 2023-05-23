package com.example.librarydbnew;
import com.example.librarydbnew.Repository;
import javafx.event.ActionEvent;

import java.sql.*;

import com.example.librarydbnew.Repository;

public class SignUpController {

    //private static Connection connection1 = Repository.getConnection();
    public void insertSignUp(ActionEvent actionEvent) throws SQLException {
        String sql = "insert into member (member_id, first_name, last_name, email, password, book_issue_date, book_id) values (11, 'ABC', 'XYZ', 'afahrenbach0@mail.com', '4kV1FN4kTr5A', '10-NOV-22', null)";
    }
}

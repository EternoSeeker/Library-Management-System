package com.example.librarydbnew;
import com.example.librarydbnew.Repository;
import javafx.event.ActionEvent;

import java.sql.*;

import com.example.librarydbnew.Repository;

public class SignUpController {

    private static Connection connection1 = Repository.getConnection();
    public void insertSignUp(ActionEvent actionEvent) throws SQLException {
        String sql = "insert into member (member_id, first_name, last_name, email, password, book_issue_date, book_id) values (1, 'Agace', 'Fahrenbach', 'afahrenbach0@typepad.com', '4kV1FN4kTr5A', '10-Nov-2022', null)";
        PreparedStatement statement;
            statement = connection1.prepareStatement(sql);
            int i = statement.executeUpdate();
            System.out.println(i + " Record Inserted...");
    }
}

package com.example.librarydbnew;
import com.example.librarydbnew.Repository;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.example.librarydbnew.Repository;

public class SignUpController {

    private static Connection connection1 = Repository.getConnection();
    public void insertSignUp(ActionEvent actionEvent) throws SQLException {

        Statement statement = connection1.createStatement();
        ResultSet result = statement.executeQuery("INSERT INTO MEMBER ");
    }
}

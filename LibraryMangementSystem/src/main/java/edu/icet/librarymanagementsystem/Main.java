package edu.icet.librarymanagementsystem;

import edu.icet.librarymanagementsystem.db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Starter.main(args);
        Connection connection= DBConnection.getInstance().getConnection();
        System.out.println(connection);
    }

}
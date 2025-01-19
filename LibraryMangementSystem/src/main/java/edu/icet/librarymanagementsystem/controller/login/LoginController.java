package edu.icet.librarymanagementsystem.controller.login;

import edu.icet.librarymanagementsystem.db.DBConnection;


import java.sql.*;

public class LoginController implements LoginService  {

    private static LoginController instance;

    private LoginController(){

    }

    public static LoginController getInstance(){
        return instance == null ? instance= new LoginController() : instance;
    }

    @Override
    public boolean authenticateUser(String email, String password) throws SQLException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("SELECT password FROM users WHERE email = ?");
        preparedStatement.setString(1, email);

        ResultSet rst = preparedStatement.executeQuery();
        if (rst.next()) {
            String encryptedPassword = rst.getString("password");
            return password.equals(encryptedPassword);
        } else {
            return false;
        }
    }
}

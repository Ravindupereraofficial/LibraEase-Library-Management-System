package edu.icet.librarymanagementsystem.controller.login;

import java.sql.SQLException;

public interface LoginService {
    boolean authenticateUser(String userName, String password) throws SQLException;

}

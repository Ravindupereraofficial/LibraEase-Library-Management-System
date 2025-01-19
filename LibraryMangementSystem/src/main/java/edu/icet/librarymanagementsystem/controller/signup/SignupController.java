package edu.icet.librarymanagementsystem.controller.signup;

import edu.icet.librarymanagementsystem.db.DBConnection;
import edu.icet.librarymanagementsystem.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignupController implements SignupService{
    private static  SignupController innstance;

    private SignupController(){

    }
    public static SignupController getInnstance(){
        return innstance==null ? innstance=new SignupController() : innstance;
    }

    @Override
    public boolean checkemailrepeat(String email) {
        return false;
    }

    @Override
    public boolean registerUser(User newUser) {
        return false;
    }

    @Override
    public String generateId() {
        String newId = "L0001"; // Default ID if no rows exist
        String query = "SELECT id FROM users ORDER BY id DESC LIMIT 1";

        try (Connection connection = DBConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet rst = statement.executeQuery(query)) {

            if (rst.next()) {
                String existId = rst.getString(1);
                int id = Integer.parseInt(existId.substring(1)); // Extract numeric part
                newId = String.format("L%04d", id + 1); // Increment and format
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately in production code
        }

        return newId;
    }

}

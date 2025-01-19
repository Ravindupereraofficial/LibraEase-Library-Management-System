package edu.icet.librarymanagementsystem.controller.signup;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignupFormController implements Initializable {
    public JFXTextField txtUserName;
    public JFXTextField txtEmail;
    public JFXTextField txtpassword;
    public Label txtUserid;

    public void btnSignupOnAction(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            getUserID();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private  void getUserID() throws SQLException {
        String userId=SignupController.getInnstance().generateId();
        txtUserid.setText(userId);
    }
}

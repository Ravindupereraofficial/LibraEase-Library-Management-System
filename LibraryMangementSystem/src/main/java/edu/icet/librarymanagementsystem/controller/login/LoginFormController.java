package edu.icet.librarymanagementsystem.controller.login;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    public JFXTextField emailTextField;
    public JFXTextField passwordTextField;

    public void btnLoginOnAction(ActionEvent actionEvent) throws SQLException {
    if (LoginController.getInstance().authenticateUser(emailTextField.getText(),passwordTextField.getText())){
        System.out.println("user have");
    }else {
        System.out.println("not found");
    }
    }

    public void btnSignupOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Signup_Form.fxml"))));
        stage.show();
    }
}

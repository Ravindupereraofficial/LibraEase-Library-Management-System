package edu.icet.librarymanagementsystem.controller.login;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;

public class LoginFormController {
    public JFXTextField emailTextField;
    public JFXTextField passwordTextField;

    public void btnLoginOnAction(ActionEvent actionEvent) {
    if (LoginController.getInstance().authenticateUser(emailTextField.getText(),passwordTextField.getText())){
        System.out.println("user have");
    }else {
        System.out.println("not found");
    }
    }
}

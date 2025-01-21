package edu.icet.librarymanagementsystem.controller.signup;

import com.jfoenix.controls.JFXTextField;
import edu.icet.librarymanagementsystem.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import org.jasypt.util.text.BasicTextEncryptor;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignupFormController implements Initializable {
    public JFXTextField txtUserName;
    public JFXTextField txtEmail;
    public JFXTextField txtpassword;
    public Label txtUserid;

    public void btnSignupOnAction(ActionEvent actionEvent) throws SQLException {
        if(SignupController.getInnstance().checkemailrepeat(txtEmail.getText())){
            String password=encryptPassword();
            if(SignupController.getInnstance().registerUser(new User(txtUserid.getText(),txtUserName.getText(), txtEmail.getText(), password))) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "User Registered Successfully");
                alert.show();

            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "User Not Registerd");
                alert.show();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Email Alredy Exits");
            alert.show();
        }
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

    public String encryptPassword(){
        String key="12345";
        BasicTextEncryptor basicTextEncryptor=new BasicTextEncryptor();
        String password=txtpassword.getText();

        basicTextEncryptor.setPassword(key);
        String encriptpassword=basicTextEncryptor.encrypt(password);
        return encriptpassword;
    }
}
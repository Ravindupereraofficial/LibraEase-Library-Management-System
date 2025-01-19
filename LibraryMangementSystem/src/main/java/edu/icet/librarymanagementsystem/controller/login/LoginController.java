package edu.icet.librarymanagementsystem.controller.login;

public class LoginController implements LoginService  {

    private static LoginController instance;

    private LoginController(){

    }

    public static LoginController getInstance(){
        return instance == null ? instance= new LoginController() : instance;
    }

    @Override
    public boolean authenticateUser(String email, String password) {
        return false;
    }
}

package edu.icet.librarymanagementsystem.controller.login;

public class LoginController  {

    private static LoginController instance;

    private LoginController(){

    }

    public static LoginController getInstance(){
        return instance == null ? instance= new LoginController() : instance;
    }
}

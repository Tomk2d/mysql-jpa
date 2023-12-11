package mysql.ex.mysqljpa.controller;

public class LoginFailureException extends RuntimeException{
    public LoginFailureException(String message) {
        super(message);
    }
}

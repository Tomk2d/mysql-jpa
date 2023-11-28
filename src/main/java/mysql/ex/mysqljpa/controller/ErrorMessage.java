package mysql.ex.mysqljpa.controller;

public class ErrorMessage extends RuntimeException{
    public ErrorMessage(String message) {
        super(message);
    }


}

package mysql.ex.mysqljpa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    // 중복 회원 메세지
    @ExceptionHandler(ErrorMessage.class)
    public ResponseEntity<String> handleDuplicateMemberException(ErrorMessage e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // 로그인 실패 메세지
    @ExceptionHandler(LoginFailureException.class)
    public ResponseEntity<String> handleLoginFailureException(LoginFailureException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

}

package com.example.usercompositeservice.AOP;


import com.example.usercompositeservice.dto.GeneralResponse;
import com.example.usercompositeservice.exception.InvalidAuthorityException;
import com.example.usercompositeservice.exception.InvalidTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = {InvalidTokenException.class})
    public ResponseEntity<GeneralResponse> handleInvalidTokenException(InvalidTokenException e){
        return new ResponseEntity(GeneralResponse.builder().statusCode("403").message(e.getMessage()).build(), HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(value = {InvalidAuthorityException.class})
    public ResponseEntity<GeneralResponse> handleInvalidAuthorityException(InvalidAuthorityException e){
        return new ResponseEntity(GeneralResponse.builder().statusCode("403").message(e.getMessage()).build(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<GeneralResponse> handleAccessDeniedException(AccessDeniedException e) {
        return new ResponseEntity(GeneralResponse.builder().statusCode("400").message(e.getMessage()).build(), HttpStatus.FORBIDDEN);
    }
}

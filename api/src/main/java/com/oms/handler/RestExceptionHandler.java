package com.oms.handler;

import com.oms.exception.OrderNotFoundException;
import com.oms.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            OrderNotFoundException ex) {
        System.out.println("Error Message----"+ ex);
        System.out.println("Error Message----"+ ex.getMessage());

        ApiResponse apiError = new ApiResponse(404, HttpStatus.NOT_FOUND.toString(), ex.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}

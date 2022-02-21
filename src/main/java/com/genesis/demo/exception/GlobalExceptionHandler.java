package com.genesis.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex)
    {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) ->
        {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<ErrorModel> handleEntityNotFound(EntityNotFoundException ex){
        ErrorModel error = new ErrorModel(HttpStatus.NOT_FOUND, "Entity not found", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ContactVatNumberException.class)
    private ResponseEntity<ErrorModel> handleVatNumberException(ContactVatNumberException ex){
        ErrorModel error = new ErrorModel(HttpStatus.BAD_REQUEST, "VAT number is either required or not allowed", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VatNumberAlreadyExistsException.class)
    private ResponseEntity<ErrorModel> handleDuplicateVAT(VatNumberAlreadyExistsException ex){
        ErrorModel error = new ErrorModel(HttpStatus.CONFLICT, "VAT number exists",ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}


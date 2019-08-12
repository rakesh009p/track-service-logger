package com.stackroute.trackservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity<?> trackNotFound(TrackNotFoundException e) {
        return new ResponseEntity<String>("Track Not Found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TrackAlreadyExistException.class)
    public ResponseEntity<?> idAlreadyExists(TrackAlreadyExistException ex) {
        return new ResponseEntity<String>("Track Already exists", HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler( HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<?>internalServrError(HttpServerErrorException.InternalServerError error){
        return  new ResponseEntity<String>("internal server occured",HttpStatus.CREATED);
    }
}
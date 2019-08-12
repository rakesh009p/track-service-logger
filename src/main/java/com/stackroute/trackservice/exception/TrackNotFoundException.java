package com.stackroute.trackservice.exception;

//track  not found exception
public class TrackNotFoundException extends Throwable {
    private String message;

    public TrackNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    //empty constructor
    public TrackNotFoundException() {
    }
}

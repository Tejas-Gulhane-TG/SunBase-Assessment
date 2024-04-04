package com.example.SunBaseAssignment.Exception;


public class customerAlreadyExists extends RuntimeException{
    public customerAlreadyExists(String message){
        super(message);
    }
}
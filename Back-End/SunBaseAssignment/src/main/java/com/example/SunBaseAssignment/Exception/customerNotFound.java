package com.example.SunBaseAssignment.Exception;


public class customerNotFound extends RuntimeException{

    public customerNotFound(String message){
        super(message);
    }
}
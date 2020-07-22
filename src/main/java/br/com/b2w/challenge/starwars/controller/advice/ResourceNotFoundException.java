package br.com.b2w.challenge.starwars.controller.advice;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }

}

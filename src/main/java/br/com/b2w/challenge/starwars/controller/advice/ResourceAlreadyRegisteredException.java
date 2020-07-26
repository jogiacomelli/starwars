package br.com.b2w.challenge.starwars.controller.advice;

public class ResourceAlreadyRegisteredException extends RuntimeException {
    public ResourceAlreadyRegisteredException(String message){
        super(message);
    }
}

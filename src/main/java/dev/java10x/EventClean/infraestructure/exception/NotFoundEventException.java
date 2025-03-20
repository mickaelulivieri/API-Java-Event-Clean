package dev.java10x.EventClean.infraestructure.exception;

public class NotFoundEventException extends RuntimeException{

    public NotFoundEventException(String message){
        super(message);
    }
}

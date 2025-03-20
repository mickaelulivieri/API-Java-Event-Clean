package dev.java10x.EventClean.infraestructure.exception;

public class DuplicateEventException extends RuntimeException{

    public DuplicateEventException(String message){
        super(message);
    }

}

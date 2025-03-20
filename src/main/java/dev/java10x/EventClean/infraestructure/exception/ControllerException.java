package dev.java10x.EventClean.infraestructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerException extends RuntimeException {

    public ResponseEntity<Map<String, String>> handleDuplicateEventExceptions() {
        Map<String, String> response = new HashMap<>();
        response.put("Erro", "Já existe outro identificador igual a esse");
        response.put("Message", "Por favor cadastre um hash id válido");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundEventException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundEventException(NotFoundEventException exception){
        Map<String, String> response = new HashMap<>();
        response.put("Error:", exception.getMessage());
        response.put("Message: ", "Please, insert a valid HashId for your event");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
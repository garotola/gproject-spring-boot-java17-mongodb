package com.garotinho.gprojectmongo.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.garotinho.gprojectmongo.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandle {
    
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException err, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError response = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", err.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(response);
    }

}

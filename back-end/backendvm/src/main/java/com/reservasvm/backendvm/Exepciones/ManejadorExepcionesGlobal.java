package com.reservasvm.backendvm.Exepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice 
public class ManejadorExepcionesGlobal {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity manejarRuntimeException(RuntimeException ex) {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("error", ex.getMessage());
        
        // Retorna un código HTTP 400 (Bad Request) con el mensaje exacto que pusiste en el throw
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
    }
}

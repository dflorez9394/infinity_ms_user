package com.infinity.user.exception;

import com.infinity.user.configs.ExceptionConfigs;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Map;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class HandleException {

    private final ExceptionConfigs exceptionConfigs;

    //metodo para obtener o controlar errores del siste o desconocidas
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,String>> handleGeneral(Exception ex){

        String mensaje = exceptionConfigs.getTipoException(ExceptionConfigs.SYSTEM);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("error",mensaje));
    }
    //Validacion lanzdas por nosotros de negocio
    @ExceptionHandler(MyHandleException.class)
    public ResponseEntity<Map<String,Object>> handleMyException(MyHandleException ex){
        log.error(
                "{} - {}" ,
                exceptionConfigs.getTipoException(ExceptionConfigs.PERSONALIZADA),
                ex.getMessage());

        return ResponseEntity
                .badRequest()
                .body(Map.of("mensaje",ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleValidationException(MethodArgumentNotValidException ex) {

        List<String> errorsList = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ":   " + error.getDefaultMessage())
                .toList();

        log.error(
                "{} - INFO : {}" ,
                exceptionConfigs.getTipoException(ExceptionConfigs.PERSONALIZADA),
                errorsList);

        return ResponseEntity
                .badRequest()
                .body(
                        Map.of(
                                "mensaje",exceptionConfigs.getTipoException(ExceptionConfigs.PERSONALIZADA),
                                "error ", errorsList
                        )
                );
    }
}

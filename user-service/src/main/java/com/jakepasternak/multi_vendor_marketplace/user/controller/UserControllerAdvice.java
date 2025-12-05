package com.jakepasternak.multi_vendor_marketplace.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.h2.util.json.JSONNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler
    ResponseEntity<?> handleException(Throwable exception, HttpServletRequest request) {
        log.error("Something went wrong:", exception);

        return ResponseEntity.internalServerError().body(Map.of("error",exception.getMessage()));
    }

    @ExceptionHandler(ValidationException.class)
    ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException exception, HttpServletRequest request) {
        log.error("Something went wrong:", exception);
        var constraintViolations = exception.getConstraintViolations().stream().sorted().map(cv -> {
            var details = new HashMap<>();
            details.put("field", cv.getPropertyPath().toString().split("\\.")[cv.getPropertyPath().toString().split("\\.").length - 1]);
            details.put("value", cv.getInvalidValue());
            details.put("reason", cv.getMessage());
            return details;
        }).sorted(Comparator.comparing(f -> (String) f.get("field"))).toList();

        return ResponseEntity.internalServerError().body(Map.of("constraintViolations",constraintViolations));
    }

}

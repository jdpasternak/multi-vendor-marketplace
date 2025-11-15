package com.jakepasternak.multi_vendor_marketplace.auth.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;


@Slf4j
@ControllerAdvice
public class AuthControllerAdvice {

    @ExceptionHandler
    ResponseEntity<?> handleException(Throwable exception, HttpServletRequest request) {
        log.error(exception.getMessage());
        var problemDetail = base(HttpStatus.INTERNAL_SERVER_ERROR, request, "Server Error", "ERROR");
        problemDetail.setDetail("Server error.");

        return ResponseEntity.internalServerError().body(problemDetail);

    }

    private static ProblemDetail base(HttpStatus status, HttpServletRequest req, String title, String code) {
        var pd = ProblemDetail.forStatus(status);
        pd.setTitle(title);
        pd.setType(URI.create("about:blank"));
        pd.setInstance(URI.create(req.getRequestURI()));
        pd.setProperty("error.code", code);
        return pd;
    }
}

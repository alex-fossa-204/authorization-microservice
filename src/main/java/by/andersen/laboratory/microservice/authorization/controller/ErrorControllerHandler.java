package by.andersen.laboratory.microservice.authorization.controller;

import by.andersen.laboratory.microservice.authorization.controller.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;


import java.util.Objects;

import static by.andersen.laboratory.microservice.authorization.controller.constant.ErrorControllerHandlerConstant.*;
import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ErrorControllerHandler implements ErrorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorControllerHandler.class);

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseEntity<HttpResponse> noHandlerFoundExceptionHandler(NoHandlerFoundException exception) {
        LOGGER.error(exception.getMessage());
        return createHttpResponse(NOT_FOUND, NO_HANDLER_FOUND_ERROR_MSG);
    }

    @ExceptionHandler(value = UnsupportedOperationException.class)
    public ResponseEntity<HttpResponse> unsupportedOperationExceptionHandler(UnsupportedOperationException exception) {
        LOGGER.error(exception.getMessage());
        return createHttpResponse(BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<HttpResponse> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException exception) {
        LOGGER.error(exception.getMessage());
        return createHttpResponse(BAD_REQUEST, HTTP_MESSAGE_UNREADABLE_ERROR_MSG);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<HttpResponse> methodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException exception) {
        LOGGER.error(exception.getMessage());
        HttpMethod supportedMethod = Objects.requireNonNull(exception.getSupportedHttpMethods()).iterator().next();
        return createHttpResponse(METHOD_NOT_ALLOWED, String.format(METHOD_IS_NOT_ALLOWED, supportedMethod));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<HttpResponse> internalServerErrorHandler(Exception exception) {
        LOGGER.error(exception.getMessage());
        return createHttpResponse(INTERNAL_SERVER_ERROR, exception.getMessage());
    }

    private ResponseEntity<HttpResponse> createHttpResponse(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, message), httpStatus);
    }
}

package soluction.com.portal.exceptions;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.detail;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private Object ProblemType;

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        StardarError stardarError = createProblemDetail(status, RESOURCE_NOT_FOUND, detail, detail).build();
        return handleNoHandlerFoundException(ex, stardarError, headers, status, request);
    }

    private ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex,
            StardarError problem,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        StardarError stardarError = createProblemDetail(status, RESOURCE_NOT_FOUND, detail, detail).build();
        return handleNoHandlerFoundException(ex, problem, headers, status, request);
    }
}
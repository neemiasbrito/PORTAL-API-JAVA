package soluction.com.portal.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;
import static soluction.com.portal.exceptions.ProblemType.RESOURSE_NOT_FOURD;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    // entidade não encontrada erro 404 (handlerEntidadeNaoEncontradaException)
    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<?> handlerEntidadeNaoEncontradaException(
            EntidadeNaoEncontradaException ex,WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ProblemType problemType = ProblemType.ENTIDADE_NAO_ENCONTRADA;
        String detail = ex.getMessage();
        Problem problem = createProblemBuilder(status, problemType, detail, detail).build();
        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    private Problem.ProblemBuilder createProblemBuilder(HttpStatus status, ProblemType problemType, String detail, String s) {
        return Problem.builder()
                .dateTime(LocalDateTime.now())
                .status(status.value())
                .type(problemType.getUri())
                .title(problemType.getTitle())
                .detail(detail);

    }

    @ExceptionHandler(EntidadeEmUsoException.class)
    public ResponseEntity<?> handleEntidadeEmUsoException(
            EntidadeEmUsoException ex, WebRequest request) {
        Problem problem = Problem.builder().build();
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(),
                HttpStatus.CONFLICT, request);
    }


    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<?> handleNegocioException(NegocioException ex, WebRequest request) {
        Problem problem = Problem.builder()
                .dateTime(LocalDateTime.now())
                .userMessage(ex.getMessage()).build();
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(),
                HttpStatus.BAD_REQUEST, request);
    }


    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String detail = String.format("O recurso '%' de verso %s, não é um de nossos serviços.", ex.getRequestURL(), ex.getHttpMethod());
        Problem problem = createProblemBuilder((HttpStatus) status, RESOURSE_NOT_FOURD, detail, detail).build();
        return handleNoHandlerFoundException(ex, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(
            TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        if (ex instanceof MethodArgumentTypeMismatchException){
            return handleTypeMismatch((MethodArgumentTypeMismatchException)ex, headers, status, request);
        }
        return super.handleTypeMismatch(ex, headers, status, request);
    }


    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String detail = String.format("método não permitido para o verbo %s", ex.getMethod());
        Problem problem = createProblemBuilder((HttpStatus) status, ProblemType.METHOD_NOT_SUPORTED, detail, detail).build();
        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Throwable rootCause = ExceptionUtils.getRootCause(ex);

        if (rootCause instanceof InvalidFormatException){
            return handleInvalidFormatException((InvalidFormatException) rootCause, headers, (HttpStatus) status, request);
        }
        ProblemType problemType = ProblemType.MESAGEM_INCOMPREENSIVEL;
        String detail = "o corpo da requisição está inválido, verifique erro de sintaxe";

        Problem problem = createProblemBuilder((HttpStatus) status, problemType, detail, detail).build();

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    private ResponseEntity<Object> handleInvalidFormatException(InvalidFormatException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ProblemType problemType = ProblemType.MESAGEM_INCOMPREENSIVEL;
        String detail = String.format("A propriedade '%s' recebeu o valor '%s', "
                + "que é de um tipo inválido, Corrija para o tipo %s.",
                "a", ex.getValue(), ex.getTargetType().getSimpleName());
        Problem problem = createProblemBuilder(status, problemType, detail, detail).build();
        return handleExceptionInternal(ex, problem, headers, status, request);
    }


    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, Object body, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        if (body == null) { //
            body = Problem.builder()
                    .dateTime(LocalDateTime.now())
                    //.title(status.getReasonPhrase())
                    .status(status.value())
                    .detail(status.toString())
                    .build();
        } else if (body instanceof String) {
            body = Problem.builder()
                    .dateTime(LocalDateTime.now())
                    //.title((String) body)
                    .status(status.value())
                    .detail((String) body)
                    .build();
        }
            return super.handleExceptionInternal(ex, body, headers, status, request);
    }

}
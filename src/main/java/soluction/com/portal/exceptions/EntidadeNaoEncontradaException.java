package soluction.com.portal.exceptions;

import java.io.Serial;

public abstract class EntidadeNaoEncontradaException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}

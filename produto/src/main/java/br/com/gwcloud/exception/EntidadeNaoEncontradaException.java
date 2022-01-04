package br.com.gwcloud.exception;

public class EntidadeNaoEncontradaException extends NegocioException{
    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}

package br.com.fintech.model;

public class LimiteTransacoesExcedidoException extends Exception {

    public LimiteTransacoesExcedidoException(String mensagem) {
        super(mensagem);
    }
}
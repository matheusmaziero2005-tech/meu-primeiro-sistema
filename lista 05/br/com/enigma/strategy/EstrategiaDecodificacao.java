package br.com.enigma.strategy;

public interface EstrategiaDecodificacao {
    String decodificar(String dadosCifrados, String chave);
}

package br.com.enigma.strategy;

import java.util.Base64;

public class DecodificadorBase64 implements EstrategiaDecodificacao {
    @Override
    public String decodificar(String dadosCifrados, String chave) {
        byte[] decodedBytes = Base64.getDecoder().decode(dadosCifrados);
        return new String(decodedBytes);
    }
}

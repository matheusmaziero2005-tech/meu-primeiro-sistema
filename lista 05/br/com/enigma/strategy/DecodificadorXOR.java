package br.com.enigma.strategy;

public class DecodificadorXOR implements EstrategiaDecodificacao {
    @Override
    public String decodificar(String dadosCifrados, String chave) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < dadosCifrados.length(); i++) {
            char c = (char) (dadosCifrados.charAt(i) ^ chave.charAt(i % chave.length()));
            resultado.append(c);
        }
        return resultado.toString();
    }
}

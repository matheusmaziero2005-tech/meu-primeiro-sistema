package br.com.enigma.strategy;

public class ContextoDecodificador {
    private EstrategiaDecodificacao estrategia;

    public void setEstrategia(EstrategiaDecodificacao estrategia) {
        this.estrategia = estrategia;
    }

    public String executarDecodificacao(String dados, String chave) {
        if (this.estrategia == null) {
            throw new IllegalStateException("Nenhuma estratégia de decodificação definida.");
        }
        return this.estrategia.decodificar(dados, chave);
    }
}

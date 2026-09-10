package br.com.fintech.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CarteiraDigital {

    private final String codigoLote;
    private final int capacidadeMaximaPacotes;
    private final Set<Transacao> transacoes;

    public CarteiraDigital(String codigoLote, int capacidadeMaximaPacotes) {

        if (codigoLote == null || codigoLote.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Codigo do lote nao pode ser nulo ou vazio."
            );
        }

        if (capacidadeMaximaPacotes < 0) {
            throw new IllegalArgumentException(
                    "A capacidade maxima nao pode ser negativa."
            );
        }

        this.codigoLote = codigoLote;
        this.capacidadeMaximaPacotes = capacidadeMaximaPacotes;
        this.transacoes = new HashSet<>();
    }

    public String getCodigoLote() {
        return codigoLote;
    }

    public int getCapacidadeMaximaPacotes() {
        return capacidadeMaximaPacotes;
    }

    public int getQuantidadeTransacoes() {
        return transacoes.size();
    }

    public Set<Transacao> getTransacoes() {
        return Collections.unmodifiableSet(transacoes);
    }

    public void adicionarTransacao(Transacao transacao)
            throws LimiteTransacoesExcedidoException {

        if (transacoes.size() >= capacidadeMaximaPacotes) {

            throw new LimiteTransacoesExcedidoException(
                    "Carteira '" + codigoLote
                            + "' atingiu o limite maximo de "
                            + capacidadeMaximaPacotes
                            + " transacoes."
            );
        }

        if (transacao == null) {
            throw new IllegalArgumentException(
                    "Transacao nao pode ser nula."
            );
        }

        transacoes.add(transacao);
    }

    public double calcularTarifaTotal() {

        return transacoes.stream()
                .mapToDouble(Transacao::getTarifa)
                .sum();
    }

    public long contarPorTipo(String tipo) {

        return transacoes.stream()
                .filter(transacao ->
                        tipo != null
                                && transacao.getTipo() != null
                                && transacao.getTipo().equalsIgnoreCase(tipo)
                )
                .count();
    }
}

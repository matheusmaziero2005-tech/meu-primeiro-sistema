package br.com.fintech.model;

import java.util.Locale;
import java.util.Objects;

public class Transacao {

    private final String idTransacao;
    private final String tipo;
    private final double valor;
    private final double tarifa;

    public Transacao(String idTransacao, String tipo, double valor, double tarifa) {

        if (idTransacao == null || idTransacao.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "ID de transacao nao pode ser nulo ou vazio."
            );
        }

        this.idTransacao = idTransacao;
        this.tipo = tipo;
        this.valor = valor;
        this.tarifa = tarifa;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public double getTarifa() {
        return tarifa;
    }

    @Override
    public String toString() {
        return String.format(
                Locale.US,
                "Transacao[id=%s, tipo=%s, valor=R$ %.2f, tarifa=R$ %.2f]",
                idTransacao,
                tipo,
                valor,
                tarifa
        );
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Transacao)) {
            return false;
        }

        Transacao outra = (Transacao) obj;

        return Objects.equals(
                this.idTransacao,
                outra.idTransacao
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransacao);
    }
}
package br.com.fintech.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GatewayPagamentos {

    private final Map<String, CarteiraDigital> carteiras;

    public GatewayPagamentos() {
        this.carteiras = new HashMap<>();
    }

    public void cadastrarLote(CarteiraDigital carteira) {

        if (carteira == null) {
            throw new IllegalArgumentException(
                    "Carteira nao pode ser nula."
            );
        }

        carteiras.put(
                carteira.getCodigoLote(),
                carteira
        );
    }

    public Optional<CarteiraDigital> buscarCarteira(
            String codigoCarteira) {

        if (codigoCarteira == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(
                carteiras.get(codigoCarteira)
        );
    }
}
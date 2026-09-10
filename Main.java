package br.com.fintech.main;

import br.com.fintech.model.CarteiraDigital;
import br.com.fintech.model.GatewayPagamentos;
import br.com.fintech.model.LimiteTransacoesExcedidoException;
import br.com.fintech.model.Transacao;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // ==========================================
        // P01 - Instanciar 4 transacoes
        // ==========================================

        Transacao t1 = new Transacao(
                "TX-101-BR",
                "PIX",
                500.00,
                2.50
        );

        Transacao t2 = new Transacao(
                "TX-102-BR",
                "CARTAO",
                1200.00,
                36.00
        );

        Transacao t3 = new Transacao(
                "TX-103-BR",
                "PIX",
                350.00,
                1.75
        );

        Transacao t4 = new Transacao(
                "TX-104-BR",
                "BOLETO",
                800.00,
                4.50
        );

        System.out.println(t1);
        System.out.println(t4);


        // ==========================================
        // P02 - Criar carteira e cadastrar no gateway
        // ==========================================

        CarteiraDigital carteira =
                new CarteiraDigital(
                        "WALLET-CORP-01",
                        3
                );

        GatewayPagamentos gateway =
                new GatewayPagamentos();

        gateway.cadastrarLote(carteira);

        System.out.println(
                "Carteira '" +
                        carteira.getCodigoLote() +
                        "' cadastrada com limite de " +
                        carteira.getCapacidadeMaximaPacotes() +
                        " transacoes."
        );


        // ==========================================
        // P03 - Adicionar t1, t2 e t3
        // ==========================================

        try {

            carteira.adicionarTransacao(t1);

            System.out.println(
                    "Transacao " +
                            t1.getIdTransacao() +
                            " adicionada com sucesso."
            );

            carteira.adicionarTransacao(t2);

            System.out.println(
                    "Transacao " +
                            t2.getIdTransacao() +
                            " adicionada com sucesso."
            );

            carteira.adicionarTransacao(t3);

            System.out.println(
                    "Transacao " +
                            t3.getIdTransacao() +
                            " adicionada com sucesso."
            );

        } catch (LimiteTransacoesExcedidoException e) {

            System.out.println(
                    "Excecao capturada: " +
                            e.getMessage()
            );
        }


        // ==========================================
        // P04 - Tentar adicionar t4
        // ==========================================

        try {

            carteira.adicionarTransacao(t4);

        } catch (LimiteTransacoesExcedidoException e) {

            System.out.println(
                    "Excecao capturada: " +
                            e.getMessage()
            );
        }


        // ==========================================
        // P05 - Buscar carteira pelo gateway
        // ==========================================

        Optional<CarteiraDigital> encontrada =
                gateway.buscarCarteira(
                        "WALLET-CORP-01"
                );

        encontrada.ifPresent(carteiraEncontrada ->
                System.out.println(
                        "Carteira localizada no gateway: " +
                                carteiraEncontrada.getCodigoLote()
                )
        );


        // ==========================================
        // P06 - Calcular tarifa total
        // ==========================================

        System.out.printf(
                java.util.Locale.US,
                "Tarifa total da carteira: R$ %.2f%n",
                carteira.calcularTarifaTotal()
        );


        // ==========================================
        // P07 - Contar transacoes PIX
        // ==========================================

        System.out.println(
                "Transacoes PIX: " +
                        carteira.contarPorTipo("PIX")
        );


        // ==========================================
        // P08 - Testar HashSet e duplicidade
        // ==========================================

        Set<Transacao> set =
                new HashSet<>();

        set.add(t1);

        Transacao duplicada =
                new Transacao(
                        "TX-101-BR",
                        "PIX",
                        900.00,
                        4.50
                );

        set.add(duplicada);

        set.add(t2);

        System.out.println(
                "Tamanho do Set: " +
                        set.size()
        );


        // ==========================================
        // P09 - Testar Fail-Fast
        // ==========================================

        try {

            new Transacao(
                    "",
                    "PIX",
                    100.00,
                    1.00
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Construtor validado: " +
                            e.getMessage()
            );
        }
    }
}
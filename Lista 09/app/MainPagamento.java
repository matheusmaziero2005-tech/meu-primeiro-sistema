package app;

import model.*;

public class MainPagamento {
    public static void main(String[] args) {
        ProcessadorPagamento processador = new ProcessadorPagamento();

        Pagamento pix = new PagamentoPix();
        Pagamento cartao = new PagamentoCartao();

        // Polimorfismo dinâmico sem estruturas de decisão
        processador.finalizarCompra(150.00, pix);
        processador.finalizarCompra(299.90, cartao);
    }
}
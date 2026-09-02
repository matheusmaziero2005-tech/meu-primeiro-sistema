package br.com.ecommerce.main;

import br.com.ecommerce.exception.TipoFreteInvalidoException;
import br.com.ecommerce.model.*;

public class MainTeste {
    public static void main(String[] args) {
        CalculadoraFrete calculadora = new CalculadoraFrete();
        double valorPedido = 100.00;

        try {
            System.out.println("--- Testes de Fretes Válidos ---");
            
            double freteSedex = calculadora.processarFrete(valorPedido, new FreteSedex());
            System.out.println("Frete SEDEX (R$ 100.00): R$ " + freteSedex);

            double fretePac = calculadora.processarFrete(valorPedido, new FretePac());
            System.out.println("Frete PAC (R$ 100.00): R$ " + fretePac);

            double freteMotoboy = calculadora.processarFrete(valorPedido, new FreteMotoboy());
            System.out.println("Frete MOTOBOY (R$ 100.00): R$ " + freteMotoboy);

            System.out.println("\n--- Teste de Erro Forçado ---");
            // Forçando o erro enviando null no lugar da estratégia
            calculadora.processarFrete(valorPedido, null);

        } catch (TipoFreteInvalidoException e) {
            System.out.println("Erro capturado com sucesso: " + e.getMessage());
        }
    }
}

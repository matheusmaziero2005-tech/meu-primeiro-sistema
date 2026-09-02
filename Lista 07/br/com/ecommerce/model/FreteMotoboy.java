package br.com.ecommerce.model;

public class FreteMotoboy implements EstrategiaFrete {
    @Override
    public double calcular(double valorPedido) {
        return 15.00; // Taxa fixa de R$ 15,00
    }
}
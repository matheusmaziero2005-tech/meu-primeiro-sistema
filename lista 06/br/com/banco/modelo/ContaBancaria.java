package br.com.banco.modelo;

public class ContaBancaria {
    private String numeroConta;
    private double saldo;
    private Cliente titular;

    public ContaBancaria(String numeroConta, Cliente titular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldoInicial;
        Agencia.registrarNovaConta();
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        double valorTotal = valor + Agencia.TAXA_SAQUE;
        if (this.saldo >= valorTotal) {
            this.saldo -= valorTotal;
            return true;
        }
        return false;
    }
}
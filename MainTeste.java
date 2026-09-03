package br.com.banco.main;

import br.com.banco.modelo.Agencia;
import br.com.banco.modelo.Cliente;
import br.com.banco.modelo.ContaBancaria;

public class MainTeste {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("123.456.789-00", "Carlos Silva", "carlos@email.com");
        Cliente c2 = new Cliente("123.456.789-00", "Carlos Eduardo", "carlos.eduardo@email.com");

        if (c1.equals(c2)) {
            System.out.println("RN02 OK: Clientes são considerados iguais pelo CPF.");
        } else {
            System.out.println("Falha na RN02: Clientes com o mesmo CPF deveriam ser iguais.");
        }

        System.out.println(c1.toString());

        ContaBancaria conta = new ContaBancaria("0001-9", c1, 50.0);

        boolean resultadoSaque = conta.sacar(50.0);
        System.out.println("Saque de 50.0 realizado? " + resultadoSaque);
        System.out.println("Saldo atual: " + conta.getSaldo());

        System.out.println("Total de contas abertas: " + Agencia.getTotalContasAbertas());
    }
}

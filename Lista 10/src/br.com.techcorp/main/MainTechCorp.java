package br.com.techcorp.main;

import br.com.techcorp.controle.ControleDeAcesso;
import br.com.techcorp.model.Funcionario;

public class MainTechCorp {

    public static void main(String[] args) {

        ControleDeAcesso controle = new ControleDeAcesso();

        Funcionario f1 = new Funcionario(
                "T-001",
                "Alice",
                "Desenvolvedora"
        );

        Funcionario f2 = new Funcionario(
                "T-001",
                "Alice Duplicada",
                "Analista"
        );

        System.out.println("=== TESTE DA CATRACA ===");

        controle.registrarPassagem(f1);
        controle.registrarPassagem(f2);

        System.out.println("Passagens registradas com sucesso.");

        System.out.println("\n=== TESTE DA SALA SEGURA ===");

        controle.concederAcessoSala(f1);
        controle.concederAcessoSala(f2);
    }
}
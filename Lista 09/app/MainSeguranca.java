package app;

import model.Credencial;
import model.Sede;

public class MainSeguranca {
    public static void main(String[] args) {
        Sede sede = new Sede();
        Credencial c1 = new Credencial("ADM-001");

        System.out.println("--- 1. Teste Catraca (List) ---");
        sede.registrarPassagemCatraca(c1);
        sede.registrarPassagemCatraca(c1);
        System.out.println("Registros na Catraca: " + sede.getHistoricoCatraca().size());

        System.out.println("\n--- 2. Teste Cofre (Set) ---");
        sede.autorizarEntradaCofre(c1);
        sede.autorizarEntradaCofre(c1); // Deve disparar o alerta

        System.out.println("\n--- 3. Teste Vagas Garagem (Array) ---");
        try {
            sede.estacionarVeiculo("ABC-1234", 0);
            sede.estacionarVeiculo("DEF-5678", 1);
            sede.estacionarVeiculo("GHI-9012", 2);
            System.out.println("Vagas de 0 a 2 preenchidas com sucesso.");

            // Forçando estouro de limite do array
            System.out.println("Tentando estacionar na vaga de índice 3...");
            sede.estacionarVeiculo("JKL-3456", 3);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exceção capturada com sucesso: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
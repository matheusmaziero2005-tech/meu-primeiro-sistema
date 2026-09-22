package br.com.cybercorp.main;

import br.com.cybercorp.model.Credencial;
import br.com.cybercorp.model.Departamento;
import br.com.cybercorp.model.Funcionario;
import br.com.cybercorp.model.Veiculo;
import br.com.cybercorp.service.SistemaSeguranca;

public class MainTeste {
    public static void main(String[] args) {
        
        Departamento depto = new Departamento("DEV", "Desenvolvimento", 2);
        Funcionario func = new Funcionario("F9876", "Ana Souza", depto);
        Veiculo veiculo = new Veiculo("ABC-1234", "Civic", func);

 
        SistemaSeguranca sistema = new SistemaSeguranca(2);

        Credencial c1 = new Credencial("FFF-999", true, func);
        Credencial clone = new Credencial("FFF-999", true, func);

    
        System.out.println("=== TESTE DA CATRACA ===");
        sistema.registrarCatraca(func);
        sistema.registrarCatraca(func);

   
        System.out.println("\n=== TESTE DO COFRE ===");
        sistema.acessarCofre(c1);
        sistema.acessarCofre(clone);

        
        System.out.println("\n=== TESTE DA GARAGEM ===");
        sistema.estacionarVeiculo(veiculo, 0);

        System.out.println("\nForçando erro de limite do array (vaga 5)...");
        sistema.estacionarVeiculo(veiculo, 5); 
}

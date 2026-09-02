package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sede {
    // Questão 15: Array estático com 3 vagas
    private String[] vagasGaragem = new String[3];

    // Questão 17: Coleção dinâmica ordenada (List)
    private List<Credencial> historicoCatraca = new ArrayList<>();

    // Questão 18: Coleção de elementos únicos (Set)
    private Set<Credencial> acessoCofre = new HashSet<>();

    // Questão 19: Métodos operacionais
    public void estacionarVeiculo(String placa, int vaga) {
        this.vagasGaragem[vaga] = placa;
    }

    public void registrarPassagemCatraca(Credencial c) {
        historicoCatraca.add(c);
        System.out.println("Passagem registrada na catraca: " + c.getCodigoHex());
    }

    public void autorizarEntradaCofre(Credencial c) {
        if (!acessoCofre.add(c)) {
            System.out.println("Alerta de Segurança: Tentativa de acesso duplicado com credencial já ativa no cofre");
        } else {
            System.out.println("Acesso ao cofre liberado: " + c.getCodigoHex());
        }
    }

    public List<Credencial> getHistoricoCatraca() {
        return historicoCatraca;
    }
}
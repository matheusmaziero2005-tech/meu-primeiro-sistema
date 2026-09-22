package br.com.techinvoice.main;

import br.com.techinvoice.config.GerenciadorConfiguracao;
import br.com.techinvoice.factory.DocumentoFactory;
import br.com.techinvoice.model.IDocumento;

public class Main {
    public static void main(String[] args) {
        
        GerenciadorConfiguracao gen1 = GerenciadorConfiguracao.getInstance();
        System.out.println("API Key: " + gen1.getApiKey());

      
        GerenciadorConfiguracao gen2 = GerenciadorConfiguracao.getInstance();
        if (gen1 == gen2) {
            System.out.println("Confirmado: gen1 e gen2 apontam para o mesmo endereço de memória!");
        }

     
        IDocumento nf = DocumentoFactory.criarDocumento("NF");
        nf.gerarPDF();

        
        try {
            IDocumento boleto = DocumentoFactory.criarDocumento("BOLETO");
            boleto.gerarPDF();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao processar documento: " + e.getMessage());
        }
    }
}

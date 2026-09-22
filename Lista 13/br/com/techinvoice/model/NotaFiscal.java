package br.com.techinvoice.model;

public class NotaFiscal implements IDocumento {
    @Override
    public void gerarPDF() {
        System.out.println("Gerando Nota Fiscal com impostos...");
    }
}

package br.com.techinvoice.factory;

import br.com.techinvoice.model.IDocumento;
import br.com.techinvoice.model.NotaFiscal;
import br.com.techinvoice.model.Recibo;

public class DocumentoFactory {
    public static IDocumento criarDocumento(String tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo de documento não pode ser nulo.");
        }

        if (tipo.equalsIgnoreCase("NF")) {
            return new NotaFiscal();
        } else if (tipo.equalsIgnoreCase("RECIBO")) {
            return new Recibo();
        } else {
            throw new IllegalArgumentException("Tipo de documento inválido: " + tipo);
        }
    }
}

package br.com.enigma.main;

import br.com.enigma.stegano.LeitorEsteganografia;
import br.com.enigma.strategy.ContextoDecodificador;
import br.com.enigma.strategy.DecodificadorBase64;
import br.com.enigma.strategy.DecodificadorXOR;

public class ProcessadorPistas {
    public static void main(String[] args) {
        try {
 
            String dadosOcultos = LeitorEsteganografia.extrairTextoOculto("pista_01.jpg");
            System.out.println("Dados extraídos da imagem: " + dadosOcultos);

           
            ContextoDecodificador contexto = new ContextoDecodificador();
            
      
            contexto.setEstrategia(new DecodificadorBase64());
            String passo1 = contexto.executarDecodificacao(dadosOcultos, null);

        
            contexto.setEstrategia(new DecodificadorXOR());
            String instrucaoSuprema = contexto.executarDecodificacao(passo1, "ENIGMA_KEY");

            System.out.println("Instrução Revelada: " + instrucaoSuprema);

        } catch (Exception e) {
            System.err.println("Erro ao processar as pistas: " + e.getMessage());
        }
    }
}

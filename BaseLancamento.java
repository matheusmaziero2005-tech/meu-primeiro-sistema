package br.com.starlog.model;

import java.util.Map;
import java.util.HashMap;

public class BaseLancamento {
    private Map<String, Carga> ModuloCarga = new HashMap<>();


   public void cadastrarModulo(Carga ModuloCarga){
        this.ModuloCarga.put(ModuloCarga.getCodigoRastreio(), ModuloCarga);
   }

   public Carga buscarCarga(String codigoRastreio){
        return this.ModuloCarga.get(codigoRastreio);
   }

    
}

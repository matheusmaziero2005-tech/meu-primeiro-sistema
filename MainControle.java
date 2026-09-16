package br.com.starlog.main;

import java.util.HashSet;
import java.util.Set;

import javax.management.modelmbean.ModelMBeanAttributeInfo;

import br.com.starlog.model.BaseLancamento;
import br.com.starlog.model.Carga;
import br.com.starlog.model.ModuloCarga;

public class MainControle {
    public static void main(String[] args) {

        Carga c1 = new Carga("ORB-101-SP","CRIOGENICA", 2.5, 450.00);
        Carga c2 = new Carga("ORB-102-RJ","PADRAO", 8.0, 120.00);
        Carga c3 = new Carga("ORB-103-MG","CRIOGENICA", 12.0, 850.00);
        Carga c4 = new Carga("ORB-104-PR","BIOLOGICA", 15.0, 300.00);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);

         Set<Carga> Modulo = new HashSet<>();
         cargas.add(c1);
         cargas.add(c2);
         cargas.add(c3);
         cargas.add(c4);

          try {
            new Carga("", "", 10.0, 0.1);
        } catch (IllegalArgumentException e) {
            System.out.println(
                "Construtor validado: " + e.getMessage()
            );
        }

        System.out.printf(
            "Seguro total do item: R$ %.2f%n",
            ModuloCarga.calcularSeguroTotal();
        );
        System.out.println(
            "contar por categria: " + ModuloCarga.contarCargasPorCategoria("%.2f%n");
        );
        System.out.printf(
            "Cargas pessadas:%.2f%n",
            ModuloCarga.contarSeguroCargasPesadas();
        );

    }
    
}


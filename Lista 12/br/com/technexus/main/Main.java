package br.com.technexus.main;

import br.com.technexus.model.Loja;
import br.com.technexus.model.Produto;

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja();

        
        loja.cadastrar(new Produto("The Witcher", "GAMES", 150.0));
        loja.cadastrar(new Produto("FIFA", "GAMES", 200.0));
        loja.cadastrar(new Produto("Java for Dummies", "LIVROS", 100.0));
        loja.cadastrar(new Produto("Clean Code", "LIVROS", 80.0));
        loja.cadastrar(new Produto("Mouse", "HARDWARE", 50.0));

        
        System.out.println("--- Produtos da Categoria GAMES ---");
        System.out.println(loja.buscarPorCategoria("GAMES"));

      
        System.out.println("\n--- Património Total em Stock ---");
        System.out.println("R$ " + loja.calcularPatrimonioTotal());

     
        System.out.println("\n--- Total da Categoria LIVROS ---");
        System.out.println("R$ " + loja.calcularTotalPorCategoria("LIVROS"));
    }
}

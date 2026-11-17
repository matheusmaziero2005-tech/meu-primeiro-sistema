package br.com.bookstore.main;

import java.util.List;
import br.com.bookstore.dao.LivroDAO;
import br.com.bookstore.dao.LivroDAOSqlite;
import br.com.bookstore.model.Livro;

public class Main {
    public static void main(String[] args) {
        
        LivroDAO dao = new LivroDAOSqlite();

        
        Livro l1 = new Livro("Clean Code", "Robert C. Martin", 95.90);
        Livro l2 = new Livro("Design Patterns", "Erich Gamma et al.", 129.50);
        Livro l3 = new Livro("Refactoring", "Martin Fowler", 115.00);

        dao.salvar(l1);
        dao.salvar(l2);
        dao.salvar(l3);

        System.out.println("=== IDs GERADOS NA PERSISTÊNCIA ===");
        System.out.println("Livro 1 ID: " + l1.getId());
        System.out.println("Livro 2 ID: " + l2.getId());
        System.out.println("Livro 3 ID: " + l3.getId());

        
        System.out.println("\n=== CONSULTA POR ID (2L) ===");
        dao.buscarPorId(2L).ifPresentOrElse(
            livro -> System.out.println("Encontrado: " + livro),
            () -> System.out.println("Aviso: Livro com ID 2 não encontrado.")
        );

        
        System.out.println("\n=== CONSULTA POR ID INEXISTENTE (999L) ===");
        dao.buscarPorId(999L).ifPresentOrElse(
            livro -> System.out.println("Encontrado: " + livro),
            () -> System.out.println("Aviso amigável: Nenhum livro localizado para o ID 999.")
        );

       
        System.out.println("\n=== CATÁLOGO COMPLETO DE LIVROS ===");
        System.out.printf("%-5s | %-25s | %-22s | %-10s%n", "ID", "TÍTULO", "AUTOR", "PREÇO");
        System.out.println("-----------------------------------------------------------------------");
        List<Livro> catalogo = dao.listarTodos();
        for (Livro l : catalogo) {
            System.out.printf("%-5d | %-25s | %-22s | R$ %7.2f%n",
                    l.getId(), l.getTitulo(), l.getAutor(), l.getPreco());
        }
    }
}

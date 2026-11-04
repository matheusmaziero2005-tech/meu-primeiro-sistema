
package src.br.com.bookstore;

import java.util.List;

import src.br.com.bookstore.dao.LivroDAO;
import src.br.com.bookstore.dao.LivroDAOSqlite;
import src.br.com.bookstore.model.Livro;

public class Main {

    public static void main(String[] args) {

        // Inversão de dependência (DIP)
        LivroDAO dao = new LivroDAOSqlite();

        System.out.println("==================================");
        System.out.println("     BOOKSTORE ENTERPRISE");
        System.out.println("==================================");

        // 1. Criando os livros
        Livro livro1 = new Livro(
            "Clean Code",
            "Robert C. Martin",
            89.90
        );

        Livro livro2 = new Livro(
            "Design Patterns",
            "Erich Gamma",
            119.90
        );

        Livro livro3 = new Livro(
            "Refactoring",
            "Martin Fowler",
            99.90
        );

        // 2. Persistindo os livros
        dao.salvar(livro1);
        dao.salvar(livro2);
        dao.salvar(livro3);

        System.out.println("\n--- LIVROS SALVOS ---");

        System.out.println(livro1);
        System.out.println(livro2);
        System.out.println(livro3);

        // 3. Buscando livro de ID 2
        System.out.println("\n--- BUSCA POR ID 2 ---");

        dao.buscarPorId(2L).ifPresentOrElse(
            livro -> System.out.println(
                "Livro encontrado: " + livro
            ),
            () -> System.out.println(
                "Aviso: Livro não encontrado."
            )
        );

        // 4. Buscando ID inexistente
        System.out.println("\n--- BUSCA POR ID 999 ---");

        dao.buscarPorId(999L).ifPresentOrElse(
            livro -> System.out.println(livro),
            () -> System.out.println(
                "Nenhum livro encontrado com ID 999."
            )
        );

        // 5. Listando todos os livros
        System.out.println("\n--- CATÁLOGO COMPLETO ---");

        List<Livro> livros = dao.listarTodos();

        System.out.printf(
            "%-5s %-25s %-25s %12s%n",
            "ID", "TÍTULO", "AUTOR", "PREÇO"
        );

        System.out.println(
            "-----------------------------------------------------------------------"
        );

        for (Livro livro : livros) {

            System.out.printf(
                "%-5d %-25s %-25s R$ %9.2f%n",
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getPreco()
            );
        }

        System.out.println(
            "\nTotal de livros cadastrados: " + livros.size()
        );

        System.out.println("\nAplicação finalizada!");
    }
}

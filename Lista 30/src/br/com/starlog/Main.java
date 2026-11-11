package br.com.starlog;

import br.com.starlog.dao.ProdutoDao;
import br.com.starlog.dao.ProdutoDAOSqlite;
import br.com.starlog.model.Produto;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ProdutoDao dao = new ProdutoDAOSqlite();

        System.out.println("==========================================================================");
        System.out.println("            SISTEMA DE ALMOXARIFADO STARLOG - CICLO CRUD COMPLETO        ");
        System.out.println("==========================================================================");

        // ------------------------------------------------------------------
        // ETAPA 1: [CREATE] - Cadastrar Produtos
        // ------------------------------------------------------------------
        System.out.println("\n--- [ETAPA 1: CREATE] Cadastrando novos produtos no catálogo ---");
        
        Produto p1 = new Produto("Teclado Mecânico RGB", 320.00, 10);
        Produto p2 = new Produto("Mousepad Speed XL", 89.90, 25);

        dao.salvar(p1);
        dao.salvar(p2);

        System.out.println("✔ Produto 1 cadastrado com sucesso! ID gerado: " + p1.getId());
        System.out.println("✔ Produto 2 cadastrado com sucesso! ID gerado: " + p2.getId());

        // ------------------------------------------------------------------
        // ETAPA 2: [READ] - Listar Produtos Cadastrados
        // ------------------------------------------------------------------
        System.out.println("\n--- [ETAPA 2: READ] Listando todos os produtos (ORDER BY nome ASC) ---");
        exibirTabela(dao.listarTodos());

        // ------------------------------------------------------------------
        // ETAPA 3: [UPDATE] - Atualizar Produto Existente
        // ------------------------------------------------------------------
        System.out.println("\n--- [ETAPA 3: UPDATE] Modificando preço e estoque do Teclado ---");
        
        p1.setEstoque(15);
        p1.setPreco(289.90);

        boolean atualizado = dao.atualizar(p1);
        System.out.println("Retorno do método atualizar(): " + atualizado);

        if (atualizado) {
            dao.buscarPorId(p1.getId()).ifPresent(p -> 
                System.out.println("✔ Registro atualizado no BD: " + p)
            );
        }

        // ------------------------------------------------------------------
        // ETAPA 4: [DELETE] - Exclusão Válida e Teste de Resiliência
        // ------------------------------------------------------------------
        System.out.println("\n--- [ETAPA 4: DELETE] Testando exclusão ---");

        // 4.1 Exclusão com sucesso
        boolean deletado = dao.excluir(p2.getId());
        System.out.println("✔ Removendo '" + p2.getNome() + "' (ID " + p2.getId() + ") -> Sucesso? " + deletado);

        // 4.2 Exclusão de ID inexistente (tratamento amigável sem exceção)
        Long idInexistente = 888L;
        boolean deletadoInexistente = dao.excluir(idInexistente);
        System.out.println("⚠️ Tentando remover ID inexistente (" + idInexistente + ") -> Retorno: " + deletadoInexistente);
        if (!deletadoInexistente) {
            System.out.println("✔ O sistema tratou o retorno 'false' com sucesso sem travar a aplicação!");
        }

        // ------------------------------------------------------------------
        // ETAPA 5: [FINAL STATE] - Validação do Estado Final do Banco
        // ------------------------------------------------------------------
        System.out.println("\n--- [ETAPA 5: FINAL STATE] Catálogo final armazenado no SQLite ---");
        List<Produto> catalogoFinal = dao.listarTodos();
        exibirTabela(catalogoFinal);
        
        System.out.println("\nTotal de produtos remanescentes: " + catalogoFinal.size() + " (Esperado: 1)");
        System.out.println("==========================================================================");
    }

    private static void exibirTabela(List<Produto> produtos) {
        System.out.println("+------+---------------------------+--------------+------------+");
        System.out.println("| ID   | Nome do Produto           | Preço (R$)   | Estoque    |");
        System.out.println("+------+---------------------------+--------------+------------+");
        if (produtos.isEmpty()) {
            System.out.println("|              Nenhum produto cadastrado no banco.                |");
        } else {
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
        System.out.println("+------+---------------------------+--------------+------------+");
    }
}
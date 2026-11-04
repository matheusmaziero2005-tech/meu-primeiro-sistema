
package src.br.com.bookstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import src.br.com.bookstore.model.Livro;

public class LivroDAOSqlite implements LivroDAO {

    private static final String URL = "jdbc:sqlite:bookstore.db";

    // Construtor: inicialização determinística
    public LivroDAOSqlite() {
        String sql = """
            CREATE TABLE IF NOT EXISTS livros (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                titulo TEXT NOT NULL,
                autor TEXT NOT NULL,
                preco REAL NOT NULL
            );
            """;

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (SQLException e) {
            throw new RuntimeException(
                "Erro ao inicializar o banco de dados.", e
            );
        }
    }

    // Salvar livro
    @Override
    public void salvar(Livro livro) {

        String sql = """
            INSERT INTO livros (titulo, autor, preco)
            VALUES (?, ?, ?)
            """;

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(
                 sql, Statement.RETURN_GENERATED_KEYS
             )) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setDouble(3, livro.getPreco());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {

                if (rs.next()) {
                    livro.setId(rs.getLong(1));
                } else {
                    throw new SQLException(
                        "Não foi possível recuperar o ID gerado."
                    );
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                "Erro ao salvar o livro.", e
            );
        }
    }

    // Buscar por ID
    @Override
    public Optional<Livro> buscarPorId(Long id) {

        String sql = """
            SELECT id, titulo, autor, preco
            FROM livros
            WHERE id = ?
            """;

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(mapearLinha(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                "Erro ao buscar livro por ID.", e
            );
        }

        return Optional.empty();
    }

    // Listar todos os livros
    @Override
    public List<Livro> listarTodos() {

        List<Livro> livros = new ArrayList<>();

        String sql = """
            SELECT id, titulo, autor, preco
            FROM livros
            ORDER BY id
            """;

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                livros.add(mapearLinha(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                "Erro ao listar livros.", e
            );
        }

        return livros;
    }

    // Mapeamento centralizado
    private Livro mapearLinha(ResultSet rs) throws SQLException {

        return new Livro(
            rs.getLong("id"),
            rs.getString("titulo"),
            rs.getString("autor"),
            rs.getDouble("preco")
        );
    }
}

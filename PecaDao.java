package br.com.autotech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.autotech.factory.ConexaoFactory;
import br.com.autotech.model.Peca;

public class PecaDao {


    public void criarTabelaSeNaoExistir() {
        String sql = """
                CREATE TABLE IF NOT EXISTS pecas (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    codigo TEXT UNIQUE NOT NULL,
                    nome TEXT NOT NULL,
                    preco REAL NOT NULL,
                    estoque INTEGER NOT NULL
                );
                """;

        try (Connection conn = ConexaoFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            
            stmt.execute(sql);
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela 'pecas': " + e.getMessage(), e);
        }
    }

    
    public void salvar(Peca peca) {
        String sql = "INSERT INTO pecas (codigo, nome, preco, estoque) VALUES (?, ?, ?, ?);";

        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, peca.getCodigo());
            stmt.setString(2, peca.getNome());
            stmt.setDouble(3, peca.getPreco());
            stmt.setInt(4, peca.getEstoque());

            stmt.executeUpdate();

            try (ResultSet chaves = stmt.getGeneratedKeys()) {
                if (chaves.next()) {
                    peca.setId(chaves.getLong(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar peça (" + peca.getCodigo() + "): " + e.getMessage(), e);
        }
    }

    
    public List<Peca> listarTodas() {
        String sql = "SELECT id, codigo, nome, preco, estoque FROM pecas ORDER BY nome;";
        List<Peca> lista = new ArrayList<>();

        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Peca peca = new Peca();
                peca.setId(rs.getLong("id"));
                peca.setCodigo(rs.getString("codigo"));
                peca.setNome(rs.getString("nome"));
                peca.setPreco(rs.getDouble("preco"));
                peca.setEstoque(rs.getInt("estoque"));
                
                lista.add(peca);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todas as peças: " + e.getMessage(), e);
        }

        return lista;
    }

    
    public Peca buscarPorCodigo(String codigo) {
        String sql = "SELECT id, codigo, nome, preco, estoque FROM pecas WHERE codigo = ?;";

        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, codigo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Peca peca = new Peca();
                    peca.setId(rs.getLong("id"));
                    peca.setCodigo(rs.getString("codigo"));
                    peca.setNome(rs.getString("nome"));
                    peca.setPreco(rs.getDouble("preco"));
                    peca.setEstoque(rs.getInt("estoque"));
                    return peca;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar peça por código (" + codigo + "): " + e.getMessage(), e);
        }

        return null;
    }


    public boolean darBaixaEstoque(long id, int qtd) {
        String sql = "UPDATE pecas SET estoque = estoque - ? WHERE id = ? AND estoque >= ?;";

        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, qtd);
            stmt.setLong(2, id);
            stmt.setInt(3, qtd);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao dar baixa no estoque da peça ID " + id + ": " + e.getMessage(), e);
        }
    }
}
package br.com.starlog.model;

public class Produto {

    private Long id;
    private String nome;
    private double preco;
    private int estoque;

    // Construtor de negócio (sem ID - para novos cadastros)
    public Produto(String nome, double preco, int estoque) {
        validarNome(nome);
        validarPreco(preco);
        validarEstoque(estoque);
        
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    // Construtor de persistência (com ID - para reconstrução vinda do BD)
    public Produto(Long id, String nome, double preco, int estoque) {
        this(nome, preco, estoque);
        this.id = id;
    }

    // --- Controle de Invariantes / Validações ---
    private void validarNome(String nome) {
        if (nome == null || nome.trim().length() < 3) {
            throw new IllegalArgumentException("O nome do produto é obrigatório e deve conter no mínimo 3 caracteres.");
        }
    }

    private void validarPreco(double preco) {
        if (preco <= 0.0) {
            throw new IllegalArgumentException("O preço do produto deve ser estritamente maior que zero (0.0).");
        }
    }

    private void validarEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException("O estoque do produto não pode ser negativo.");
        }
    }

    // --- Getters e Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarNome(nome);
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        validarPreco(preco);
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        validarEstoque(estoque);
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return String.format("ID: %-4d | Nome: %-25s | Preço: R$ %8.2f | Estoque: %4d un",
                id != null ? id : 0, nome, preco, estoque);
    }
}

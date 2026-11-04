package src.br.com.bookstore.model;

public class Livro {

    private Long id;
    private String titulo;
    private String autor;
    private double preco;

    // Construtor completo: hidratação do banco
    public Livro(Long id, String titulo, String autor, double preco) {
        validar(titulo, autor, preco);

        this.id = id;
        this.titulo = titulo.trim();
        this.autor = autor.trim();
        this.preco = preco;
    }

    // Construtor de negócio: novo livro
    public Livro(String titulo, String autor, double preco) {
        this(null, titulo, autor, preco);
    }

    private void validar(String titulo, String autor, double preco) {

        if (titulo == null || titulo.trim().length() < 2) {
            throw new IllegalArgumentException(
                "O título deve possuir pelo menos 2 caracteres."
            );
        }

        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "O autor não pode ser nulo ou vazio."
            );
        }

        if (!Double.isFinite(preco) || preco <= 0.0) {
            throw new IllegalArgumentException(
                "O preço de venda deve ser estritamente positivo."
            );
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPreco() {
        return preco;
    }

    // Único setter permitido
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
            "ID: %d | Título: %s | Autor: %s | Preço: R$ %.2f",
            id, titulo, autor, preco
        );
    }
}

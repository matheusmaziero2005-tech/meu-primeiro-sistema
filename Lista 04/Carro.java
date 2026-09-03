public class Carro {
    // Encapsulamento: atributos privados
    private String modelo;
    private String cor;
    private int velocidade;

    // Construtor padrão
    public Carro() {
    }

    // Getters e Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getVelocidade() {
        return velocidade;
    }

    // PASSO 4: Validação de segurança no setter
    public void setVelocidade(int velocidade) {
        if (velocidade < 0) {
            System.out.println("Erro: Velocidade não pode ser negativa!");
        } else {
            this.velocidade = velocidade;
        }
    }
}
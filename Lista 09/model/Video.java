package model;

public class Video {
    private String titulo;
    private int duracaoMinutos;

    // Questão 04: Construtor parametrizado obrigatório
    public Video(String titulo, int duracaoMinutos) {
        this.titulo = titulo;
        setDuracaoMinutos(duracaoMinutos); // Executa a validação do setter
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getDuracaoMinutos() { return duracaoMinutos; }

    // Questão 03: Regra de negócio na alteração da duração
    public void setDuracaoMinutos(int duracaoMinutos) {
        if (duracaoMinutos <= 0) {
            this.duracaoMinutos = 1;
        } else {
            this.duracaoMinutos = duracaoMinutos;
        }
    }
}
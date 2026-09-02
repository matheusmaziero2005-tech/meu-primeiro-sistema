package model;

import java.util.Objects;

public class Usuario {
    // Questão 08: Constante global
    public static final String NOME_PLATAFORMA = "JavaFlix";
    
    // Questão 09: Atributo estático contador
    private static int totalUsuarios = 0;

    // Questões 01 e 03: Atributos privados e encapsulados
    private String nome;
    private String email;
    private boolean ativo;

    // Construtor
    public Usuario(String nome, String email, boolean ativo) {
        this.nome = nome;
        this.email = email;
        this.ativo = ativo;
        Usuario.totalUsuarios++; // Questão 09: Incremente a cada nova instância
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    // Questão 09: Método estático para consulta
    public static int getTotalUsuarios() {
        return totalUsuarios;
    }

    // Questão 06: Sobrescrita do toString()
    @Override
    public String toString() {
        return "Usuário: " + nome + " | Contato: " + email + " | Ativo: " + ativo;
    }

    // Questão 07: Sobrescrita do equals() baseada no e-mail
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
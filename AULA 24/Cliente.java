import java.util.Objects;
public class Cliente {
    private String cpf;
    private String nome;

    // Construtor para inicializar os dados obrigatórios do cliente. 
    public Cliente(String cpf, String nome) {
        this.cpf = cpf; 
        this.nome = nome; 
    }
    // Método getter para recuperar o CPF do cliente. 
    public String getCpf() {
        return cpf;
    }

    // Método getter para recuperar o nome do cliente. 
    public String getNome() {
        return nome;
    }

    // Sobrescrita do equals baseada estritamente no CPF (Regra de Identidade de Negócio)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Verifica se apontam para o mesmo endereço de memória
        if (obj == null || getClass() != obj.getClass()) return false; // Valida nulos e compatibilidade de tipos. 
        Cliente cliente = (Cliente) obj; // Faz o cast seguro para Cliente.
        return Objects.equals(cpf, cliente.cpf); // Dois clientes são iguais se possuem o mesmo CPF. 
    }

    // Sobrescrita do hashCode baseada no atributo de identidade (CPF). 
    @Override
    public int hashCode() {
        return Objects.hash(cpf); // Gera o hash code utilizando o CPF. RA:25271116-2
    }
}
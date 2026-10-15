import java.util.Objects;
public class Container {
    private String id;
    private String nomeApp;
    private double ramNecessaria;

    // Construtor para instanciar o container com seus dados obrigatórios.
    public Container(String id, String nomeApp, double ramNecessaria) {
        this.id = id;
        this.nomeApp = nomeApp;
        this.ramNecessaria = ramNecessaria; 
    }

    // Getter para recuperar o identificador único do container. 
    public String getId() {
        return id; 
    }

    // Getter para recuperar o nome da aplicação hospedada no container
    public String getNomeApp() {
        return nomeApp;
    }

    // Getter para recuperar a memória RAM necessária para execução. 
    public double getRamNecessaria() {
        return ramNecessaria;
    }

    // Sobrescrita do equals baseada estritamente no ID do container
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Verifica se é a mesma referência na memória
        if (obj == null || getClass() != obj.getClass()) return false; // Verifica nulidade e classes
        Container container = (Container) obj; // Converte o objeto genérico para Container
        return Objects.equals(id, container.id); // Dois containers são iguais se possuem o mesmo ID.
    }

    // Sobrescrita do hashCode baseada no ID
    @Override
    public int hashCode() {
        return Objects.hash(id); // Gera o código hash baseado no ID. RA: 25271116-2
    }
}
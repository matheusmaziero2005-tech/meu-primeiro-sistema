import java.util.Objects;


public class Container {
    private String id;
    private String nomeApp;
    private double ramNecessaria;

    
    public Container(String id, String nomeApp, double ramNecessaria) {
        this.id = id;
        this.nomeApp = nomeApp;
        this.ramNecessaria = ramNecessaria;
    }

   
    public String getId() {
        return id;
    }

    public double getRamNecessaria() {
        return ramNecessaria;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Container container = (Container) obj;
        return Objects.equals(id, container.id);
    }

    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
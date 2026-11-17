
public class MainCloud {
    public static void main(String[] args) {
       
        CloudManager manager = new CloudManager();

       
        Cliente cliente = new Cliente("111.222.333-44", "Wayne Enterprises");


        Servidor servidor = new Servidor("192.168.0.1", 16.0, 5.50);

        
        manager.registrarCliente(cliente);
        manager.provisionarServidor(cliente, servidor);

        
        Container c1 = new Container("C-01", "Batcomputer-Core", 10.0);
        Container c2 = new Container("C-02", "Oracle-Database", 8.0);

    
       
        servidor.ligar();

        
        try {
            servidor.alocarContainer(c1);
            System.out.println("Sucesso: Container " + c1.getId() + " alocado com sucesso!");
        } catch (CapacidadeExcedidaException e) {
            System.out.println(e.getMessage());
        }

        
        try {
            servidor.alocarContainer(c2);
        } catch (CapacidadeExcedidaException e) {
           
            System.out.println("Alerta capturado -> " + e.getMessage());
        }

       
        double faturaAtiva = manager.calcularFaturaAtiva(cliente);
        System.out.printf("Fatura Ativa do Cliente %s: R$ %.2f%n", cliente.getNome(), faturaAtiva);
    }
}
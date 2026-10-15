
public class MainCloud {
    public static void main(String[] args) {
        //Instancie o CloudManager
        CloudManager manager = new CloudManager();

        //Instancie 1 Cliente
        Cliente cliente = new Cliente("111.222.333-44", "Wayne Enterprises");  

        //Instancie 1 Servidor
        Servidor servidor = new Servidor("192.168.0.1", 16.0, 5.50); 

        //Registre o cliente no banco de dados do Manager e adicione o servidor a ele
        manager.registrarCliente(cliente); // Registra o cliente no manager
        manager.provisionarServidor(cliente, servidor); // Vincula o servidor ao cliente provisionado

        //Instancie 2 Containers diferentes
        Container c1 = new Container("C-01", "AppWeb", 10.0);
        Container c2 = new Container("C-02", "BancoDados", 8.0);  

        //Siga em frente: Comente a linha do Passo 6 após testar. Chame o método ligar() do servidor
        servidor.ligar(); // Altera o status do servidor para ligado

        try {
            //Alocou com sucesso: Aloque o Container 1 no Servidor
            servidor.alocarContainer(c1); // Alocação bem-sucedida pois o servidor está ligado e tem espaço. 
        } catch (Exception e) {
            e.printStackTrace(); // Tratamento preventivo caso ocorra exceção inesperada. 
        }

        //Teste Falha Checked: Envolva a alocação do Container 2 em try-catch (estourará 16GB)
        try {
            servidor.alocarContainer(c2); // Tenta alocar 8GB adicionais (10 + 8 = 18 > 16), disparando a exceção
        } catch (CapacidadeExcedidaException e) {
            System.out.println("[LOG DE ERRO CAPTURADO]: " + e.getMessage()); 
        }

        //Imprima no console o valor retornado por calcularFaturaAtiva (Esperado: 5.50)
        double fatura = manager.calcularFaturaAtiva(cliente); // Calcula a fatura considerando apenas os servidores ligados 
        System.out.println("Fatura Ativa do Cliente: R$ " + fatura); // Imprime o resultado RA:25271116-2
    }
}
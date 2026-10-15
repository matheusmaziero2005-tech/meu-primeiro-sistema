import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class CloudManager {
    private Map<Cliente, Set<Servidor>> bancoDeDados;

    // Construtor que inicializa o mapa de dados
    public CloudManager() {
        this.bancoDeDados = new HashMap<>();
    }

    // Método para registrar um novo cliente no banco de dados 
    public void registrarCliente(Cliente c) {
        // Insere o cliente no mapa associando-o a um conjunto (Set) vazio de servidores. 
        bancoDeDados.putIfAbsent(c, new HashSet<>());
    }

    // Método para provisionar/vincular um servidor a um cliente específico
    public void provisionarServidor(Cliente c, Servidor s) {
        registrarCliente(c); // Assegura que o cliente está registrado no banco de dados. 
        bancoDeDados.get(c).add(s); // Adiciona o servidor ao Set de servidores do cliente sem duplicação
    }

    // Motor Financeiro utilizando Streams API para calcular a fatura ativa
    public double calcularFaturaAtiva(Cliente c) {
        // Verifica se o cliente existe no mapa para evitar NullPointerException. 
        if (!bancoDeDados.containsKey(c)) {
            return 0.0;
        }

        // Acessa o conjunto de servidores do cliente e aplica Streams
        return bancoDeDados.get(c).stream()
                .filter(Servidor::isStatusLigado) // Filtra para manter APENAS os servidores que estão LIGADOS 
                .mapToDouble(Servidor::getPrecoPorHora) // Extrai o preço por hora de cada servidor
                .sum(); // Retorna a soma final dos valores extraídos. RA: 25271116-2
    }
}
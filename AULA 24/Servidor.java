import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Servidor {
    private String ip;
    private double ramTotal;
    private double precoPorHora;
    private boolean statusLigado;
    // Lista cronológica de containers inicializada diretamente para evitar NullPointerException
    private List<Container> containers = new ArrayList<>();

    // Construtor do servidor; nasce desligado por padrão (statusLigado = false). 
    public Servidor(String ip, double ramTotal, double precoPorHora) {
        this.ip = ip; 
        this.ramTotal = ramTotal; 
        this.precoPorHora = precoPorHora; 
        this.statusLigado = false;
    }

    // Método para ligar o servidor, alterando seu status para true
    public void ligar() {
        this.statusLigado = true; // Altera o status para ligado. 
    }

    // Método para desligar o servidor, alterando seu status para false
    public void desligar() {
        this.statusLigado = false; // Altera o status para desligado. 
    }

    // Getter para consultar o preço por hora do servidor. 
    public double getPrecoPorHora() {
        return precoPorHora; 
    }

    // Getter para consultar se o servidor está ligado
    public boolean isStatusLigado() {
        return statusLigado;
    }

    // Motor de Auditoria utilizando Streams API para calcular a RAM em uso
    public double calcularRamEmUso() {
        // Usa Stream para extrair a RAM necessária de cada container e somá-las
        return containers.stream()
                .mapToDouble(Container::getRamNecessaria) 
                .sum(); 
    }

    // Motor de Alocação e Resiliência contendo as validações de Fail-Fast
    public void alocarContainer(Container c) throws CapacidadeExcedidaException {
        // Regra 1: Valida se o servidor está desligado, lançando exceção Unchecked se verdadeiro
        if (!statusLigado) {
            throw new ServidorOfflineException("Erro: Não é possível alocar containers em um servidor desligado.");
        }

        // Regra 2: Valida se a RAM atual somada à nova ultrapassa a capacidade total
        if (calcularRamEmUso() + c.getRamNecessaria() > ramTotal) {
            throw new CapacidadeExcedidaException("Falha Crítica: Memória RAM insuficiente no servidor " + ip + "."); 
        }

        // Se passou pelas validações, adiciona o container cronologicamente à lista
        containers.add(c);
    }

    // Sobrescrita do equals baseada estritamente no endereço IP (Regra de Identidade)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Verifica igualdade de referência na memória.
        if (obj == null || getClass() != obj.getClass()) return false; // Verifica nulidade e tipos.
        Servidor servidor = (Servidor) obj; // Realiza o cast seguro para Servidor.
        return Objects.equals(ip, servidor.ip); // Dois servidores são iguais se possuem o mesmo IP 
    }

    // Sobrescrita do hashCode baseada no IP
    @Override
    public int hashCode() {
        return Objects.hash(ip); // Gera o código hash baseado no IP. RA: 25271116-2
    }
}
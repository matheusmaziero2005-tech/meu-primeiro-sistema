public class CapacidadeExcedidaException extends Exception {
    // Construtor que recebe a mensagem de erro e repassa para a superclasse.
    public CapacidadeExcedidaException(String msg) {
        super(msg); // Inicializa a Exception com a mensagem de falha crítica. RA: 25271116-2
    }
}
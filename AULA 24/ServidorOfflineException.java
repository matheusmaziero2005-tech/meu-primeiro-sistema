public class ServidorOfflineException extends RuntimeException {
    // Construtor que recebe a mensagem de erro e repassa para a superclasse. 
    public ServidorOfflineException(String msg) {
        super(msg); // Inicializa a RuntimeException com a mensagem descritiva. RA: 25271116-2
    }
}
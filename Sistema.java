public class Sistema {
    public static void main(String[] args) {
        Carro meuCarro = new Carro();

        // Uso das "catracas" de acesso (setters)
        meuCarro.setModelo("Fusca");
        meuCarro.setCor("Azul");
        
        // Tentativa de inserção de valor inválido
        meuCarro.setVelocidade(-500); // Imprime a mensagem de erro e não altera a velocidade

        // Exibindo dados via getters
        System.out.println("Modelo: " + meuCarro.getModelo());
        System.out.println("Cor: " + meuCarro.getCor());
        System.out.println("Velocidade atual: " + meuCarro.getVelocidade());
    }
}
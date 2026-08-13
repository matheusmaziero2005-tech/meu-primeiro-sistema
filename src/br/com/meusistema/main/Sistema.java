package br.com.meusistema.main;
// 🚨 OLHE O IMPORT AQUI! O Sistema precisa avisar que vai usar o Carro do outro "bairro".
import br.com.meusistema.model.Carro;
public class Sistema {
    public static void main(String[] args) {
    System.out.println("Iniciando o sistema...");
// Criando o objeto (Construindo o Carro 1)
Carro meuCarro = new Carro();
meuCarro.setModelo("Fusca");
meuCarro.setCor("Azul");
meuCarro.setVelocidade(-500);
// Chamando o método (Comportamento)
meuCarro.buzinar();
// Desafio Rápido: Crie um "Carro 2", de outro modelo e cor, e faça ele buzinar também!
    }
}
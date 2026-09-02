package app;

import model.Usuario;
import model.Video;

public class MainStreaming {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Lucas Silva", "lucas@email.com", true);
        Video videoValido = new Video("Java Avançado", 120);
        Video videoInvalido = new Video("Atribuição Incorreta", -45);

        System.out.println(usuario);
        System.out.println("Duração do Vídeo 1: " + videoValido.getDuracaoMinutos() + " min");
        System.out.println("Duração ajustada do Vídeo 2: " + videoInvalido.getDuracaoMinutos() + " min");
    }
}
package app;

import model.Usuario;

public class MainMemoria {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("Ana", "ana@dominio.com", true);
        Usuario u2 = new Usuario("Ana Maria", "ana@dominio.com", false);

        if (u1.equals(u2)) {
            System.out.println("Resultado: Os usuários são logicamente equivalentes (mesmo e-mail).");
        } else {
            System.out.println("Resultado: Usuários diferentes.");
        }

        // Acesso aos membros estáticos diretamente pela Classe
        System.out.println("Plataforma: " + Usuario.NOME_PLATAFORMA);
        System.out.println("Total de Usuários cadastrados: " + Usuario.getTotalUsuarios());
    }
}

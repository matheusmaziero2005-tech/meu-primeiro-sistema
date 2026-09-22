package br.com.enigma.stegano;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeitorEsteganografia {
    public static String extrairTextoOculto(String caminhoImagem) throws IOException {
        byte[] bytes = Files.readAllBytes(Path.of(caminhoImagem));
        
        // Procura pelo marcador de fim de JPEG (0xFF 0xD9)
        int eoiIndex = -1;
        for (int i = 0; i < bytes.length - 1; i++) {
            if ((bytes[i] & 0xFF) == 0xFF && (bytes[i + 1] & 0xFF) == 0xD9) {
                eoiIndex = i + 2;
                break;
            }
        }

        if (eoiIndex != -1 && eoiIndex < bytes.length) {
            return new String(bytes, eoiIndex, bytes.length - eoiIndex).trim();
        }
        
        return "";
    }
}

package br.com.techinvoice.config;

public class GerenciadorConfiguracao {
    private String apiKey = "AWS-12345-KEY";
    private static GerenciadorConfiguracao instance;

    
    private GerenciadorConfiguracao() {}

    
    public static GerenciadorConfiguracao getInstance() {
        if (instance == null) {
            instance = new GerenciadorConfiguracao();
        }
        return instance;
    }

    public String getApiKey() {
        return apiKey;
    }
}

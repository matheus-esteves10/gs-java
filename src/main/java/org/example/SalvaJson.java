package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class SalvaJson extends Report {

    public SalvaJson(String local, String dataChamado, String descricao, String detalhesOcorrencia, String cpf) {
        super(local, dataChamado, descricao, detalhesOcorrencia, cpf);
        setNumeroProtocolo(); // Chama o método para gerar o número de protocolo
    }

    public void salvaJson() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String directoryPath = "D:\\Global Solution - 1 semestre\\Java\\src\\main\\PoliciaAmbiental\\";
        String nomeArquivo;

        if (tipoReport(this.getDescricao()) == 0) {
            nomeArquivo = "pescaIlegal" + this.getNumeroProtocolo() + ".json";
        } else if (tipoReport(this.getDescricao()) == 1) {
            nomeArquivo = "descarteDeLixo" + this.getNumeroProtocolo() + ".json";
        } else if (tipoReport(this.getDescricao()) == 2) {
            directoryPath = "D:\\Global Solution - 1 semestre\\Java\\src\\main\\Bombeiros\\";
            nomeArquivo = "resgateAnimal" + this.getNumeroProtocolo() + ".json";
        } else {
            throw new IllegalArgumentException("Tipo de report desconhecido");
        }

        String finalSave = directoryPath + nomeArquivo;

        Files.createDirectories(Paths.get(directoryPath));

        String json = gson.toJson(this);

        try (FileWriter escrita = new FileWriter(finalSave)) {
            escrita.write(json);
        }
    }
}



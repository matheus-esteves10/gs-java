package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class SalvaJson extends Report {

    public SalvaJson(String local, String dataChamado, String descricao, String detalhesOcorrencia) {
        super(local, dataChamado, descricao, detalhesOcorrencia);
    }

    public void salvaJson() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String fileName;
        if (tipoReport(this.getDescricao()) == 0) {
            fileName = "pescaIlegal.json";
        } else if (tipoReport(this.getDescricao()) == 1) {
            fileName = "descarteLixo.json";
        } else if (tipoReport(this.getDescricao()) == 2) {
            fileName = "resgateAnimal.json";
        } else {
            throw new IllegalArgumentException("Tipo de report desconhecido");
        }

        String json = gson.toJson(this);

        try (FileWriter escrita = new FileWriter(fileName)) {
            escrita.write(json);
        }
    }
}


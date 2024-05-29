package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class SalvaJson {
    private ReportJson reportJson;
    public SalvaJson(Report report) {
        report.setNumeroProtocolo();
        reportJson = new ReportJson(report.getCpf(), report.getEstado(), report.getCidade(), report.getBairro(), report.getRua(), report.getDataChamado(), report.getDescricao(), report.getDetalhesOcorrencia(), report.getNumeroProtocolo());
    }

    public void salvaJson() throws IOException {
        Report report = new Report("");
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        String directoryPath = "D:\\gs-java\\src\\main\\PoliciaAmbiental\\";
        String nomeArquivo;

        if (report.tipoReport(this.reportJson.descricao()) == 0) {
            nomeArquivo = "pescaIlegal" + this.reportJson.numeroProtocolo() + ".json";
        } else if (report.tipoReport(this.reportJson.descricao()) == 1) {
            nomeArquivo = "descarteDeLixo" + this.reportJson.numeroProtocolo() + ".json";
        } else if (report.tipoReport(this.reportJson.descricao()) == 2) {
            directoryPath = "D:\\gs-java\\src\\main\\Bombeiros\\";
            nomeArquivo = "resgateAnimal" + this.reportJson.numeroProtocolo() + ".json";
        } else {
            throw new IllegalArgumentException("Tipo de report desconhecido");
        }

        String finalSave = directoryPath + nomeArquivo;

        Files.createDirectories(Paths.get(directoryPath));

        String json = gson.toJson(report);

        try (FileWriter escrita = new FileWriter(finalSave)) {
            escrita.write(json);
        }
    }
}



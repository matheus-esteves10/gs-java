package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class SalvaJson {
    private ReportJson reportJson;
    private Report report;
    public SalvaJson(Report report) {
        this.report = report;
        report.setNumeroProtocolo();
        reportJson = new ReportJson(report.getCpf(), report.getEstado(), report.getCidade(), report.getBairro(), report.getRua(), report.getDataChamado(), report.getDescricao(), report.getDetalhesOcorrencia(), report.getNumeroProtocolo());
    }

    public void salvaJson() throws IOException {
        Report report = new Report("");
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String directoryPath = "D:\\Global Solution - 1 semestre\\Java\\src\\main\\Bombeiros\\";
        String nomeArquivo;

        if (report.tipoReport(this.reportJson.descricao()) == 0) {
            nomeArquivo = "pescaIlegal" + this.reportJson.numeroProtocolo() + ".json";
        } else if (report.tipoReport(this.reportJson.descricao()) == 1) {
            nomeArquivo = "descarteDeLixo" + this.reportJson.numeroProtocolo() + ".json";
        } else if (report.tipoReport(this.reportJson.descricao()) == 2) {
            directoryPath = "D:\\Global Solution - 1 semestre\\Java\\src\\main\\PoliciaAmbiental";
            nomeArquivo = "resgateAnimal" + this.reportJson.numeroProtocolo() + ".json";
        } else {
            throw new IllegalArgumentException("Tipo de report desconhecido");
        }

        String finalSave = directoryPath + nomeArquivo;

        Files.createDirectories(Paths.get(directoryPath));

        String json = gson.toJson(reportJson);


        try (FileWriter escrita = new FileWriter(finalSave)) {
            escrita.write(json);
        }
    }
}



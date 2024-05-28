package org.example;

import java.util.Random;

public class Report extends Usuario {
    private int numeroProtocolo;
    private String local;
    private String dataChamado;
    private String descricao;
    private String detalhesOcorrencia;


    public Report(String local, String dataChamado, String descricao, String detalhesOcorrencia, String cpf) {
        super(cpf);
        this.local = local;
        this.dataChamado = dataChamado;
        this.descricao = descricao;
        this.detalhesOcorrencia = detalhesOcorrencia;
    }



    public int getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo() {
        if(this.numeroProtocolo == 0) { // Verifica se o número de protocolo ainda não foi atribuído
            Random random = new Random();
            int numeroProtocoloAleatorio = random.nextInt(99999) + 1;
            this.numeroProtocolo = numeroProtocoloAleatorio;
        }
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDataChamado() {
        return dataChamado;
    }

    public void setDataChamado(String dataChamado) {
        this.dataChamado = dataChamado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDetalhesOcorrencia() {
        return detalhesOcorrencia;
    }

    public void setDetalhesOcorrencia(String detalhesOcorrencia) {
        this.detalhesOcorrencia = detalhesOcorrencia;
    }

    public double tipoReport(String descricao) {
        if (descricao.equalsIgnoreCase("Pesca ilegal")) {
            return 0;
        } else if (descricao.equalsIgnoreCase("Descarte de lixo")) {
            return 1;
        } else if (descricao.equalsIgnoreCase("Ajuda de animal")) {
            return 2;
        } else {
            return 3;
        }
    }
}

package org.example;

public class UnidadeAutoridade {

    private String nomeUnidade;
    private String telefone;
    private String endereco;
    private String tipoUnidade;

    public UnidadeAutoridade(String nomeUnidade, String telefone, String endereco, String tipoUnidade) {
        this.nomeUnidade = nomeUnidade;
        this.telefone = telefone;
        this.endereco = endereco;
        this.tipoUnidade = tipoUnidade;
    }
    public String getNomeUnidade() {
        return nomeUnidade;
    }

    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoUnidade() {
        return tipoUnidade;
    }

    public void setTipoUnidade(String tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }


}

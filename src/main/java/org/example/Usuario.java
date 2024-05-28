package org.example;

public class Usuario {
    private String cpf;
    private String email;
    private String senha;
    private int quantidadeReportsSolucionados;

    public Usuario(String cpf) {
        this.cpf = cpf;
    }

    public double checarPontos(int quantidadeReportsSolucionados){
        double valorPontos = quantidadeReportsSolucionados / 2.0;
        return valorPontos;
    }



}

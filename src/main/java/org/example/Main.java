package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo a central de atendimento dos mares e oceanos");
        System.out.println("Qual o motivo do seu chamado? (pesca ilegal, descarte de lixo, ajuda de animal): ");
        String descricao = scanner.nextLine();

        System.out.println("Qual é o local do ocorrido? (insira o nome do local ou latitude e longitude): ");
        String local = scanner.nextLine();
        System.out.println("Digite a data do acontecimento no formato dd/MM/yyyy:");
        String data = scanner.nextLine();
        System.out.println("Descreva os detalhes da sua solicitação: ");
        String detalhesOcorrencia = scanner.nextLine();

        SalvaJson json = new SalvaJson(local, data, descricao, detalhesOcorrencia);
        try {
            json.salvaJson();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
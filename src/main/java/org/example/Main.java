package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo a central de atendimento dos mares e oceanos.");
        System.out.println("(1): Realizar um chamado um chamado");
        System.out.println("(2): Checar minha quantidade de pontos");
        System.out.println("Informe o que você deseja fazer: ");
        int opcao = scanner.nextInt();

        if (opcao == 1) {

            System.out.println("Qual o motivo do seu chamado? (pesca ilegal, descarte de lixo, ajuda de animal): ");
            String descricao = scanner.nextLine();

            System.out.println("Qual é o local do ocorrido? (insira o nome do local ou latitude e longitude): ");
            String local = scanner.nextLine();
            System.out.println("Digite a data do acontecimento no formato dd/MM/yyyy:");
            String data = scanner.nextLine();
            System.out.println("Descreva os detalhes da sua solicitação: ");
            String detalhesOcorrencia = scanner.nextLine();
            System.out.println("Informe o seu cpf: ");
            String cpf = scanner.nextLine();
            System.out.println("Obriado pela solicitação. Caso a solicitação concretize alguma ajuda você ganhará 1 ponto no sistema. Esses pontos poderão ser trocados por descontos em algumas empresas");

            SalvaJson json = new SalvaJson(local, data, descricao, detalhesOcorrencia, cpf);
            try {
                json.salvaJson();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else if (opcao == 2){
            Usuario usuario = new Usuario("");
            System.out.println("Informe sua quantidade de reports atendidos e solucionados: ");
            int quantidade = scanner.nextInt();
            double quantPontos = usuario.checarPontos(quantidade);
            System.out.println("Você possui R$" + quantPontos + " para troca. Você pode receber esse valor em desconto nas empresas parceiras a qualquer momento");

        } else {
            throw new RuntimeException("Essa opção não existe");
        }
    }
}
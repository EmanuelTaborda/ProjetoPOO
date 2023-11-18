package util;

import java.util.Scanner;

public class InterfaceUsuario {


    //Método para solicitar ao usuário para que digite o valor do imóvel
    public static double solicitaValorImovel(){

        Scanner scanner = new Scanner(System.in);
        double valorImovel;

        do {
            System.out.print("Informe o valor do imóvel: R$");
            valorImovel = scanner.nextDouble();

            if (valorImovel <= 0) {
                System.out.println("Por gentileza, informe um valor positivo.");
            }
        } while (valorImovel <= 0);

        return valorImovel;
    }

    //Método para solicitar ao usuário para que digite o prazo do financiamento
    public static int solicitaPrazoFinanciamento(){

        Scanner scanner = new Scanner(System.in);
        int prazoFinanciamento;

        do {
            System.out.print("Informe o prazo do financiamento em anos: ");
            prazoFinanciamento = scanner.nextInt();

            if (prazoFinanciamento <= 0) {
                System.out.println("Por gentileza, informe um valor positivo.");
            }
        } while (prazoFinanciamento <= 0);

        return prazoFinanciamento;
    }

    //Método para solicitar ao usuário para que digite a taxa de juros
    public static double solicitaTaxaDeJuros(){

        Scanner scanner = new Scanner(System.in);
        double taxaJurosAnual;

        do {
            System.out.print("Informe a taxa de juros (%): ");
            taxaJurosAnual = scanner.nextDouble();

            if (taxaJurosAnual <= 0) {
                System.out.println("Por gentileza, informe um valor positivo.");
            }
        } while (taxaJurosAnual <= 0);

        return taxaJurosAnual / 100;
    }

    public static int verificaTipoDoImovel() {
        Scanner scanner = new Scanner(System.in);
        int tipoImovel;

        do {
            System.out.println("Informe o tipo do imóvel que deseja financiar: ");
            System.out.println("(1) Casa\n(2) Apartamento\n(3) Terreno");
            System.out.print("Indique apenas o número referente a opção desejada: ");
            tipoImovel = scanner.nextInt();

            if (tipoImovel <=0 || tipoImovel >3){
                System.out.println("Por gentileza, informe um valor válido entre as opções.");
            }
        } while (tipoImovel <= 0 || tipoImovel >3);

        return tipoImovel;
    }
}

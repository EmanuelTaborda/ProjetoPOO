package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criar um ArrayList para armazenar os financiamentos
        var financiamentos = new ArrayList<Financiamento>();

        //Modelos de financiamento
        financiamentos.add(new Casa(500000.00,10,0.10, 100, 200));
        financiamentos.add(new Casa(600000.00,11,0.10, 200, 300));
        financiamentos.add(new Apartamento(500000.00,10,0.10, 2, 4));
        financiamentos.add(new Apartamento(600000.00,11,0.10, 1, 2));
        financiamentos.add(new Terreno(500000.00,11,0.10, true));

        // Solicitar informações para o financiamento
        System.out.println("Informe os dados para o financiamento: ");
        double valorImovel = InterfaceUsuario.solicitaValorImovel();
        int prazoFinanciamento = InterfaceUsuario.solicitaPrazoFinanciamento();
        double taxaJurosAnual = InterfaceUsuario.solicitaTaxaDeJuros();
        //verifica o tipo do imóvel para obter o calculo correto e os demais atributos
        int tipoImovel = InterfaceUsuario.verificaTipoDoImovel();
        System.out.println("\n");

        //Caso seja casa
        if (tipoImovel == 1) {
            Scanner scanner = new Scanner(System.in);
            double areaConstruida;
            do {
                System.out.print("Informe o tamanho da área construída da casa (m²): ");
                areaConstruida = scanner.nextDouble();

                if (areaConstruida <= 0) {
                    System.out.println("Por gentileza, informe um valor positivo.");
                }
            } while (areaConstruida <= 0);
            double tamTerreno;
            do {
                System.out.print("Informe o tamanho do terreno (m²): ");
                tamTerreno = scanner.nextDouble();

                if (tamTerreno <= 0) {
                    System.out.println("Por gentileza, informe um valor positivo.");
                }
            } while (tamTerreno <= 0);
            financiamentos.add(new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, areaConstruida, tamTerreno));
        }

        //Caso seja apartamento
        else if (tipoImovel == 2) {
            Scanner scanner = new Scanner(System.in);
            int vagasGaragem;
                System.out.print("Informe o número de vagas de garagem disponível: ");
                vagasGaragem = scanner.nextInt();
            int nAndar;
            System.out.print("Informe o número do andar: ");
            nAndar = scanner.nextInt();
                financiamentos.add(new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, vagasGaragem, nAndar));
        }

        //Caso seja terreno
        else if (tipoImovel == 3) {
            Scanner scanner = new Scanner(System.in);
            boolean zonaComercial = true;
            int confere;

            do {

                System.out.println("O terreno se encontra em zona comercial?");
                System.out.println("(1) Sim\n(2) Não");
                System.out.print("Indique apenas o número referente a opção desejada: ");
                confere = scanner.nextInt();
                if (confere <= 0 || confere > 2) {
                    System.out.println("\nPor gentileza, informe um valor válido entre as opções.");
                }
            } while (confere <= 0 || confere > 2);

            if (confere == 1) {
                zonaComercial = true;
            } else if (confere == 2) {
                zonaComercial = false;
            }
            financiamentos.add(new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, zonaComercial));
        }

        // Calcular e mostrar os valores dos financiamentos
        int contagem = 0;
        for (var financiamento : financiamentos) {
            contagem++;
            System.out.println("Financiamento n°" + contagem);
            financiamento.mostrarDadosFinanciamento();
            System.out.println();
        }

        // Calcular o valor total de imóveis e financiamentos
        double valorTotalImoveis = 0;
        double valorTotalFinanciamentos = 0;

        for (var financiamento : financiamentos) {
            valorTotalImoveis += financiamento.getValorImovel();
            valorTotalFinanciamentos += financiamento.calcTotalDoPagamento();
        }

        // Exibir os resultados
        System.out.printf("Valor total dos imóveis: R$%.2f\n", valorTotalImoveis);
        System.out.printf("Valor total dos financiamentos: R$%.2f\n", valorTotalFinanciamentos);
    }
}

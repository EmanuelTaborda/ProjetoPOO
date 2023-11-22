package util;

import java.util.Scanner;
import java.util.InputMismatchException;

public class InterfaceUsuario {


    //Método para solicitar ao usuário para que digite o valor do imóvel
    public static double solicitaValorImovel() {

        Scanner scanner = new Scanner(System.in);
        double valorImovel;

        do {
            try {
                System.out.print("Informe o valor do imóvel: R$");
                valorImovel = scanner.nextDouble();

                if (valorImovel <= 0) {
                    System.out.println("\nPor gentileza, informe um valor positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nPor gentileza, informe um valor válido.");
                scanner.nextLine(); // Limpar o valor recebido do scanner para não ocorrer um loop infinito
                valorImovel = -1; // Atribuir um valor inválido para repetir o loop
            }
        } while (valorImovel <= 0);

        return valorImovel;
    }

    //Método para solicitar ao usuário para que digite o prazo do financiamento
    public static int solicitaPrazoFinanciamento(){

        Scanner scanner = new Scanner(System.in);
        int prazoFinanciamento;

        do {
            try {
                System.out.print("Informe o prazo do financiamento em anos: ");
                prazoFinanciamento = scanner.nextInt();

                if (prazoFinanciamento <= 0) {
                    System.out.println("\nPor gentileza, informe um valor positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nPor gentileza, informe um valor válido.");
                scanner.nextLine(); // Limpar o valor recebido do scanner para não ocorrer um loop infinito
                prazoFinanciamento = -1; // Atribuir um valor inválido para repetir o loop
            }
        } while (prazoFinanciamento <= 0);

        return prazoFinanciamento;
    }

    //Método para solicitar ao usuário para que digite a taxa de juros
    public static double solicitaTaxaDeJuros(){

        Scanner scanner = new Scanner(System.in);
        double taxaJurosAnual;

        do {
            try {
                System.out.print("Informe a taxa de juros (%): ");
                taxaJurosAnual = scanner.nextDouble();

                if (taxaJurosAnual <= 0) {
                    System.out.println("\nPor gentileza, informe um valor positivo.");
                } else if (taxaJurosAnual >= 100) {
                    System.out.println("\nTaxa de juros muito alta! Por gentileza, informe um valor a baixo de 100%.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nPor gentileza, informe um valor válido.");
                scanner.nextLine(); // Limpar o valor recebido do scanner para não ocorrer um loop infinito
                taxaJurosAnual = -1; // Atribuir um valor inválido para repetir o loop
            }
        } while (taxaJurosAnual <= 0 || taxaJurosAnual >100);

        return taxaJurosAnual / 100;
    }

    //Metodo para verificar tipo do imóvel para financiamento
    public static int verificaTipoDoImovel() {
        Scanner scanner = new Scanner(System.in);
        int tipoImovel;

        do {
            try {
                System.out.println("Informe o tipo do imóvel que deseja financiar: ");
                System.out.println("(1) Casa\n(2) Apartamento\n(3) Terreno");
                System.out.print("Indique apenas o número referente a opção desejada: ");
                tipoImovel = scanner.nextInt();

                if (tipoImovel <=0 || tipoImovel >3){
                    System.out.println("\nPor gentileza, informe um valor válido entre as opções.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nPor gentileza, informe um valor válido entre as opções.");
                scanner.nextLine(); // Limpar o valor recebido do scanner para não ocorrer um loop infinito
                tipoImovel = -1; // Atribuir um valor inválido para repetir o loop
            }
        } while (tipoImovel <= 0 || tipoImovel >3);

        return tipoImovel;
    }

    //Método para solicitar Area construída da casa
    public static double solicitaAreaConstruida () {
        Scanner scanner = new Scanner(System.in);
        double areaConstruida;
        do {
            try {
                System.out.print("Informe o tamanho da área construída da casa (m²): ");
                areaConstruida = scanner.nextDouble();

                if (areaConstruida <= 0) {
                    System.out.println("Por gentileza, informe um valor positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nPor gentileza, informe um valor válido.");
                scanner.nextLine(); // Limpar o valor recebido do scanner para não ocorrer um loop infinito
                areaConstruida = -1; // Atribuir um valor inválido para repetir o loop
            }
        } while (areaConstruida <= 0);
        return areaConstruida;
    }

    //Método para solicitar tamanho do terreno da casa
    public static double solicitaTamTerreno() {
        Scanner scanner = new Scanner(System.in);
        double tamTerreno;
        do {
            try {
                System.out.print("Informe o tamanho do terreno (m²): ");
                tamTerreno = scanner.nextDouble();

                if (tamTerreno <= 0) {
                    System.out.println("Por gentileza, informe um valor positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nPor gentileza, informe um valor válido.");
                scanner.nextLine(); // Limpar o valor recebido do scanner para não ocorrer um loop infinito
                tamTerreno = -1; // Atribuir um valor inválido para repetir o loop
            }
        } while (tamTerreno <= 0);
        return tamTerreno;
    }

    //Método para solicitar n° de vagas de garagem
    public static int solicitaVagasGaragem() {
        Scanner scanner = new Scanner(System.in);
        int vagasGaragem;
        do {
            try {
                System.out.print("\nInforme o número de vagas de garagem disponível: ");
                vagasGaragem = scanner.nextInt();

                if (vagasGaragem <=-1) {
                    System.out.print("\nPor gentileza, informe um valor válido");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nPor gentileza, informe um valor válido.");
                scanner.nextLine(); // Limpar o valor recebido do scanner para não ocorrer um loop infinito
                vagasGaragem = -1; // Atribuir um valor inválido para repetir o loop
            }
        } while (vagasGaragem <=-1);
        return vagasGaragem;
    }

    //Método para solicitar n° do andar
    public static int solicitaAndar() {
        Scanner scanner = new Scanner(System.in);
        int nAndar;
        do {
            try {
                System.out.print("\nInforme o número do andar: ");
                nAndar = scanner.nextInt();

                if (nAndar <=-1) {
                    System.out.print("\nPor gentileza, informe um valor válido");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nPor gentileza, informe um valor válido.");
                scanner.nextLine(); // Limpar o valor recebido do scanner para não ocorrer um loop infinito
                nAndar = -1; // Atribuir um valor inválido para repetir o loop
            }
        } while (nAndar <=-1);
        return nAndar;
    }

    //Método para defininir tipo da zona do terreno
    public static String defineZona() {
        Scanner scanner = new Scanner(System.in);
        int confereZona;
        String zona;
        do {
            try {
                System.out.println("Informe o tipo de região em que o terreno se encontra: ");
                System.out.println("(1) Zona Residencial\n(2) Zona Comercial");
                System.out.print("Indique apenas o número referente a opção desejada: ");
                confereZona = scanner.nextInt();

                if (confereZona <= 0 || confereZona > 2) {
                    System.out.println("\nPor gentileza, informe um valor válido entre as opções.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nPor gentileza, informe um valor válido entre as opções.");
                scanner.nextLine(); // Limpar o valor recebido do scanner para não ocorrer um loop infinito
                confereZona = -1; // Atribuir um valor inválido para repetir o loop
            }
        } while (confereZona <= 0 || confereZona > 2);
        if (confereZona == 1) {
            zona = "Residencial";
        } else {
            zona = "Comercial";
        }
        return zona;
    }
}

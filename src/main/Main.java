package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        // Criar um ArrayList para armazenar os financiamentos
        var financiamentos = new ArrayList<Financiamento>();

        //Modelos de financiamento
        Casa casa1 = new Casa(500000, 10, 0.10, 100, 200);
        Casa casa2 = new Casa(600000, 11, 0.10, 200, 300);
        Apartamento ap1 = new Apartamento(500000, 10, 0.10, 2, 4);
        Apartamento ap2 = new Apartamento(600000, 11, 0.10, 1, 2);
        Terreno terreno1 = new Terreno(500000, 11, 0.10, "Residencial");
        financiamentos.add(casa1);
        financiamentos.add(casa2);
        financiamentos.add(ap1);
        financiamentos.add(ap2);
        financiamentos.add(terreno1);

        // Solicitar informações para o financiamento
        System.out.println("Informe os dados para o financiamento: ");
        double valorImovel = InterfaceUsuario.solicitaValorImovel();
        int prazoFinanciamento = InterfaceUsuario.solicitaPrazoFinanciamento();
        double taxaJurosAnual = InterfaceUsuario.solicitaTaxaDeJuros();
        //verifica o tipo do imóvel para obter o calculo correto e os demais atributos das subclasses
        int tipoImovel = InterfaceUsuario.verificaTipoDoImovel();
        System.out.println("\n");

        //Caso seja casa
        if (tipoImovel == 1) {
            double areaConstruida = InterfaceUsuario.solicitaAreaConstruida();
            double tamTerreno = InterfaceUsuario.solicitaTamTerreno();
            financiamentos.add(new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, areaConstruida, tamTerreno));
        }

        //Caso seja apartamento
        else if (tipoImovel == 2) {
            int vagasGaragem = InterfaceUsuario.solicitaVagasGaragem();
            int nAndar = InterfaceUsuario.solicitaAndar();
                financiamentos.add(new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, vagasGaragem, nAndar));
        }

        //Caso seja terreno
        else if (tipoImovel == 3) {
            String zona = InterfaceUsuario.defineZona();
            financiamentos.add(new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, zona));
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

        salvarDadosEmArquivo(financiamentos);
        lerArquivo();
    }

    public static void salvarDadosEmArquivo(ArrayList<Financiamento> financiamentos) {
        String texto = "";
        FileWriter out = null;
        int contLetra = 0;
        try {
            out = new FileWriter("arquivo1.txt");
            for (Financiamento g: financiamentos ) {
                texto = texto + "\n" + g.toString() + "\n";
            }
            while (contLetra <texto.length()) {
                out.write(texto.charAt(contLetra));
                contLetra++;
            }
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lerArquivo() {
        FileReader in = null;
        System.out.println("\nDados do arquivo: \n");
        try {
            in = new FileReader("arquivo1.txt");
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

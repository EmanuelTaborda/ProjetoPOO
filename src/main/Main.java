package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Criar um ArrayList para armazenar os financiamentos
        var financiamentos = new ArrayList<Financiamento>();

        //Modelos de financiamento
        financiamentos.add(new Casa(500000.00,10,10));
        financiamentos.add(new Casa(600000.00,11,10));
        financiamentos.add(new Apartamento(500000.00,10,10));
        financiamentos.add(new Apartamento(600000.00,11,10));
        financiamentos.add(new Terreno(500000.00,11,10));

        // Solicitar informações para o financiamento
        System.out.println("Informe os dados para o financiamento: ");
        double valorImovel = InterfaceUsuario.solicitaValorImovel();
        int prazoFinanciamento = InterfaceUsuario.solicitaPrazoFinanciamento();
        double taxaJurosAnual = InterfaceUsuario.solicitaTaxaDeJuros();
        //verifica o tipo do imóvel para obter o calculo correto
        int tipoImovel = InterfaceUsuario.verificaTipoDoImovel();
        System.out.println("\n");

        if (tipoImovel == 1) {
            financiamentos.add(new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual));
        } else if (tipoImovel == 2) {
            financiamentos.add(new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual));
        } else if (tipoImovel == 3) {
            financiamentos.add(new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual));
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

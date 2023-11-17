package modelo;

public class Casa extends Financiamento{

    //Método construtor
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    @Override
    //Adicionando o valor de R$80,00 para a casa
    public double calcPagamentoMensal() {
        return super.calcPagamentoMensal() + 80;
    }
}

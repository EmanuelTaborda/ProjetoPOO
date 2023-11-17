package modelo;

public class Apartamento extends Financiamento {
    //Atributos da Subclasse
    private double ApTxMensal = this.taxaJurosAnual / 12;
    private double ApMeses = this.prazoFinanciamento * 12;

    //Método construtor
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }


    @Override
    public double calcPagamentoMensal() {
        double pagamentoMensal = ((this.valorImovel * ApTxMensal) * (Math.pow((1 + ApTxMensal) , (ApMeses)))) / (Math.pow((1 + ApTxMensal), ApMeses)-1);
        return pagamentoMensal;
    }
}

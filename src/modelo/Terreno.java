package modelo;

public class Terreno extends Financiamento{
    //Atributo característico da subclasse
    private boolean zonaComercial;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, boolean zonaComercial) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
        this.zonaComercial = zonaComercial;
    }


    //Adicionando 2% sobre o valor da mensalidade
    public double calcPagamentoMensal() {
        double pagamentoMensal = (this.valorImovel / this.prazoFinanciamento) * (1 + (this.taxaJurosAnual / 12));
        return pagamentoMensal * 1.02;
    }
}

package modelo;

public class Terreno extends Financiamento{
    //Atributo característico da subclasse
    private String zona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String zona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
        this.zona = zona;
    }

    public String toString() {
        return "Terreno{" +
                "Valor do Imovel=" + valorImovel +
                ", Prazo do Financiamento=" + prazoFinanciamento +
                ", Taxa de juros anual=" + taxaJurosAnual +
                ", Zona='" + zona + '\'' +
                '}';
    }

    //Adicionando 2% sobre o valor da mensalidade
    public double calcPagamentoMensal() {
        double pagamentoMensal = (this.valorImovel / this.prazoFinanciamento) * (1 + (this.taxaJurosAnual / 12));
        return pagamentoMensal * 1.02;
    }
}

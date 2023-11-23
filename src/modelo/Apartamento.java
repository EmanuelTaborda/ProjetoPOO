package modelo;

public class Apartamento extends Financiamento {
    //Atributos específicos da Subclasse
    private double ApTxMensal = this.taxaJurosAnual / 12;
    private double ApMeses = this.prazoFinanciamento * 12;
    private int vagasGaragem;
    private int nAndar;

    //Método construtor
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int nAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
        this.vagasGaragem = vagasGaragem;
        this.nAndar = nAndar;
    }

    public String toString() {
        return "Apartamento{" +
                "Valor do Imovel=" + valorImovel +
                ", Prazo do Financiamento=" + prazoFinanciamento +
                ", Taxa de juros anual=" + taxaJurosAnual +
                ", N° de vagas de garagem=" + vagasGaragem +
                ", n° do andar=" + nAndar +
                '}';
    }

    @Override
    public double calcPagamentoMensal() {
        double pagamentoMensal = ((this.valorImovel * ApTxMensal) * (Math.pow((1 + ApTxMensal) , (ApMeses)))) / (Math.pow((1 + ApTxMensal), ApMeses)-1);
        return pagamentoMensal;
    }
}

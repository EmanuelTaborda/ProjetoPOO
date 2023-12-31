package modelo;

public class Casa extends Financiamento{
    //Atributos específicos da subclasse
    private double areaConstruida;
    private double tamTerreno;

    //Método construtor
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
        this.areaConstruida = areaConstruida;
        this.tamTerreno = tamTerreno;
    }

    public String toString() {
        return "Casa{" +
                "Valor do Imovel=" + valorImovel +
                ", Prazo do Financiamento=" + prazoFinanciamento +
                ", Taxa de juros anual=" + taxaJurosAnual +
                ", Area Construida=" + areaConstruida +
                ", Tamanho do Terreno=" + tamTerreno +
                '}';
    }

    @Override
    //Adicionando o valor de R$80,00 para a casa
    public double calcPagamentoMensal() {
        return super.calcPagamentoMensal() + 80;
    }
}

package modelo;

public abstract class Financiamento {
    // Atributos da classe
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    // Método construtor
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // Método para calcular o pagamento mensal
    public double calcPagamentoMensal() {
        double pagamentoMensal = (this.valorImovel / this.prazoFinanciamento) * (1 + (this.taxaJurosAnual / 12));
        return pagamentoMensal;
    }

    // Método para calcular o total do pagamento
    public double calcTotalDoPagamento() {
        double totalDoPagamento = calcPagamentoMensal() * this.prazoFinanciamento;
        return totalDoPagamento;
    }

    //Método para mostrar dados do financiamento
    public void mostrarDadosFinanciamento() {
        System.out.printf("Valor do imóvel: R$%.2f \n", valorImovel);
        System.out.printf("Valor total do financiamento: R$%.2f \n", calcTotalDoPagamento());
    }

    public String toString() {
        return "Financiamento{" +
                "Valor do Imovel=" + valorImovel +
                ", Prazo do Financiamento=" + prazoFinanciamento +
                ", Taxa de juros anual=" + taxaJurosAnual +
                '}';
    }

    // Getters
    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }
}
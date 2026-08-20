public class Gerente extends FuncionarioCLT {
    private int tamanhoEquipe;
    private double percentualBonus;

    public Gerente(String nome, String matricula, double salarioBase,
                    String dataAdmissao, double valeTransporte,
                    double valeAlimentacao, int tamanhoEquipe,
                    double percentualBonus) {
        super(nome, matricula, salarioBase, dataAdmissao, valeTransporte, valeAlimentacao);
        this.tamanhoEquipe = tamanhoEquipe;
        this.percentualBonus = percentualBonus;
    }

    public int getTamanhoEquipe() {
        return tamanhoEquipe;
    }

    public double getPercentualBonus() {
        return percentualBonus;
    }

    @Override
    public double calcularSalario() {
        // cálculo de FuncionarioCLT + bônus (salarioBase * percentualBonus)
        double bonus = getSalarioBase() * percentualBonus;
        return super.calcularSalario() + bonus;
    }

    @Override
    public double calcularDesconto() {
        // cálculo de FuncionarioCLT + R$ 100,00 se a equipe tiver mais de 10 pessoas
        double desconto = super.calcularDesconto();
        if (tamanhoEquipe > 10) {
            desconto += 100.00;
        }
        return desconto;
    }
}

package loja;

/**
 * Representa um produto da loja.
 * Responsabilidade única (SRP): apenas guardar os dados do produto.
 */
public class Produto {

    private final String nome;
    private double preco;
    private int estoque;

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return nome + " (R$ " + String.format("%.2f", preco) + ", estoque: " + estoque + ")";
    }
}

package loja;

import java.util.ArrayList;
import java.util.List;

import assinantes.Assinante;
import eventos.TipoEvento;

/**
 * Publicador concreto: contém a regra de negócio da loja.
 *
 * Quando algo importante acontece (produto chega, preço cai), a Loja
 * apenas avisa o gerenciador de eventos. Ela NÃO conhece nenhuma classe
 * concreta de assinante (DIP) e nunca precisa mudar quando surge um
 * novo tipo de assinante (OCP).
 */
public class Loja implements Publicador {

    private final List<Produto> produtos = new ArrayList<Produto>();
    private final GerenciadorDeEventos eventos = new GerenciadorDeEventos();

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void reabastecer(Produto produto, int quantidade) {
        boolean estavaSemEstoque = produto.getEstoque() == 0;
        produto.setEstoque(produto.getEstoque() + quantidade);
        System.out.println("Loja: reabastecido -> " + produto);
        if (estavaSemEstoque && produto.getEstoque() > 0) {
            eventos.notificar(TipoEvento.PRODUTO_DISPONIVEL, produto);
        }
    }

    public void alterarPreco(Produto produto, double novoPreco) {
        boolean reduziu = novoPreco < produto.getPreco();
        produto.setPreco(novoPreco);
        System.out.println("Loja: preço alterado -> " + produto);
        if (reduziu) {
            eventos.notificar(TipoEvento.PRECO_REDUZIDO, produto);
        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    @Override
    public void assinar(TipoEvento tipo, Assinante assinante) {
        eventos.assinar(tipo, assinante);
    }

    @Override
    public void cancelarAssinatura(TipoEvento tipo, Assinante assinante) {
        eventos.cancelarAssinatura(tipo, assinante);
    }
}

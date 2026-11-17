package apresentacao;

import assinantes.ClienteApp;
import assinantes.ClienteEmail;
import assinantes.RegistroLog;
import eventos.TipoEvento;
import loja.Loja;
import loja.Produto;

/**
 * Cliente do padrão: cria a publicadora e os assinantes separadamente
 * e depois registra cada assinante nos eventos de seu interesse.
 */
public class MiniLojaApp {

    public static void main(String[] args) {
        Loja loja = new Loja();
        Produto notebook = new Produto("Notebook Gamer", 5000.00, 0);
        Produto fone = new Produto("Fone Bluetooth", 300.00, 10);
        loja.cadastrarProduto(notebook);
        loja.cadastrarProduto(fone);

        ClienteEmail maria = new ClienteEmail("Maria", "maria@email.com");
        ClienteApp joao = new ClienteApp("joao");
        RegistroLog log = new RegistroLog();

        titulo("1) Inscrevendo os assinantes");
        loja.assinar(TipoEvento.PRODUTO_DISPONIVEL, maria);
        loja.assinar(TipoEvento.PRECO_REDUZIDO, maria);
        loja.assinar(TipoEvento.PRODUTO_DISPONIVEL, joao);
        loja.assinar(TipoEvento.PRODUTO_DISPONIVEL, log);
        loja.assinar(TipoEvento.PRECO_REDUZIDO, log);
        System.out.println("Maria: disponibilidade + preço | João: só disponibilidade | Log: tudo");

        titulo("2) Notebook chega na loja (evento PRODUTO_DISPONIVEL)");
        loja.reabastecer(notebook, 5);

        titulo("3) Preço do fone cai (evento PRECO_REDUZIDO)");
        loja.alterarPreco(fone, 250.00);

        titulo("4) Maria cancela a assinatura de disponibilidade");
        loja.cancelarAssinatura(TipoEvento.PRODUTO_DISPONIVEL, maria);
        Produto tablet = new Produto("Tablet", 1500.00, 0);
        loja.cadastrarProduto(tablet);
        loja.reabastecer(tablet, 3);

        titulo("5) Histórico guardado pelo RegistroLog");
        for (String linha : log.getHistorico()) {
            System.out.println("  " + linha);
        }
    }

    private static void titulo(String texto) {
        System.out.println();
        System.out.println("=== " + texto + " ===");
    }
}

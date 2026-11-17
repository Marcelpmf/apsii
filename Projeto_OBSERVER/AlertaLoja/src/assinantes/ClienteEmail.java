package assinantes;

import eventos.TipoEvento;
import loja.Produto;

/**
 * Assinante concreto: avisa o cliente por e-mail (simulado no console).
 */
public class ClienteEmail implements Assinante {

    private final String nome;
    private final String email;

    public ClienteEmail(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    @Override
    public void atualizar(TipoEvento tipo, Produto produto) {
        System.out.println("  [E-MAIL para " + email + "] Olá, " + nome + "! "
                + descrever(tipo, produto));
    }

    private String descrever(TipoEvento tipo, Produto produto) {
        switch (tipo) {
            case PRODUTO_DISPONIVEL:
                return "O produto '" + produto.getNome() + "' chegou na loja por R$ "
                + String.format("%.2f", produto.getPreco()) + "!";
            case PRECO_REDUZIDO:
                return "O preço de '" + produto.getNome() + "' caiu para R$ "
                        + String.format("%.2f", produto.getPreco()) + ".";
            default:
                return "Novidade sobre '" + produto.getNome() + "'.";
        }
    }
}

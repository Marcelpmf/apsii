package assinantes;

import eventos.TipoEvento;
import loja.Produto;

/**
 * Assinante concreto: envia notificação push no aplicativo (simulado no console).
 * Foi criado sem alterar nenhuma linha da Loja (OCP).
 */
public class ClienteApp implements Assinante {

    private final String usuario;

    public ClienteApp(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public void atualizar(TipoEvento tipo, Produto produto) {
        System.out.println("  [PUSH para @" + usuario + "] " + tipo + ": " + produto.getNome());
    }
}

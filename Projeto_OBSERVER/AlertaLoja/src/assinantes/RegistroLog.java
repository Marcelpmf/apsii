package assinantes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import eventos.TipoEvento;
import loja.Produto;

/**
 * Assinante concreto: guarda um histórico de tudo o que aconteceu na loja.
 * Mostra que assinantes não precisam ser "clientes": qualquer objeto
 * que implemente Assinante pode observar a Loja.
 */
public class RegistroLog implements Assinante {

    private final List<String> historico = new ArrayList<String>();

    @Override
    public void atualizar(TipoEvento tipo, Produto produto) {
        String linha = tipo + " -> " + produto;
        historico.add(linha);
        System.out.println("  [LOG] " + linha);
    }

    public List<String> getHistorico() {
        return Collections.unmodifiableList(historico);
    }
}

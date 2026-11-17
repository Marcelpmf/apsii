package loja;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import assinantes.Assinante;
import eventos.TipoEvento;

/**
 * Cuida somente da lista de assinantes e das notificações (SRP).
 * A Loja usa esta classe por composição, em vez de herança.
 * (Mesma ideia do EventManager do material do Observer.)
 */
public class GerenciadorDeEventos implements Publicador {

    private final Map<TipoEvento, List<Assinante>> assinantes =
            new EnumMap<TipoEvento, List<Assinante>>(TipoEvento.class);

    public GerenciadorDeEventos() {
        for (TipoEvento tipo : TipoEvento.values()) {
            assinantes.put(tipo, new ArrayList<Assinante>());
        }
    }

    @Override
    public void assinar(TipoEvento tipo, Assinante assinante) {
        List<Assinante> lista = assinantes.get(tipo);
        if (!lista.contains(assinante)) {
            lista.add(assinante);
        }
    }

    @Override
    public void cancelarAssinatura(TipoEvento tipo, Assinante assinante) {
        assinantes.get(tipo).remove(assinante);
    }

    public void notificar(TipoEvento tipo, Produto produto) {
        // cópia da lista: um assinante pode cancelar durante a notificação
        List<Assinante> copia = new ArrayList<Assinante>(assinantes.get(tipo));
        for (Assinante assinante : copia) {
            assinante.atualizar(tipo, produto);
        }
    }
}

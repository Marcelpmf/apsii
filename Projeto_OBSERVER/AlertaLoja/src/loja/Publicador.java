package loja;

import assinantes.Assinante;
import eventos.TipoEvento;

/**
 * Interface do Publicador (Subject).
 * Define apenas os métodos de inscrição (ISP).
 */
public interface Publicador {

    void assinar(TipoEvento tipo, Assinante assinante);

    void cancelarAssinatura(TipoEvento tipo, Assinante assinante);
}

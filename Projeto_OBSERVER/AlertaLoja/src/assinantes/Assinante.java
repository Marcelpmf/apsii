package assinantes;

import eventos.TipoEvento;
import loja.Produto;

/**
 * Interface do Assinante (Observer).
 *
 * É a única coisa que a Loja conhece sobre quem a observa (DIP).
 * Possui um único método de notificação (ISP).
 */
public interface Assinante {

    void atualizar(TipoEvento tipo, Produto produto);
}

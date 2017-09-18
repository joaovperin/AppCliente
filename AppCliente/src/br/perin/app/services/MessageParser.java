/*
 * AppCliente
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.perin.app.services;

import br.perin.app.bean.Message;

/**
 * Descrição da classe.
 */
public class MessageParser {

    public Message parse(String crudeMsg) {
        int cod = Integer.valueOf(crudeMsg.substring(0, 3));
        String msg = crudeMsg.substring(3, crudeMsg.length());
        return new Message(cod, msg.length(), msg);
    }

}

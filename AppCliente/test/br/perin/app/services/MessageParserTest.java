/*
 * AppCliente
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.perin.app.services;

import br.perin.app.bean.Message;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Perin
 */
public class MessageParserTest {

    @Test
    public void testSomeMethod() {
        Message parse = new MessageParser().parse("111005abcde");
        Assert.assertEquals(parse.getCod(), 111);
        Assert.assertEquals(5, parse.getLen());
        Assert.assertEquals(parse.getMsg(), "abcde");
    }

}

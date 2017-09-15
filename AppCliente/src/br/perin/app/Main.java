/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.perin.app;

import br.perin.app.services.PropertyLoader;

/**
 *
 * @author Joaov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Testa passando a propriedade de diretório
        args = new String[] { "-d=C:\\a\\tst.properties" };
        Options opt = ArgsParser.get().parse(args);
        // Busca o valor do diretório passado
        String propsDir = opt.get("d");
        PropertyLoader.get().load(propsDir);
        // Printa todas as propriedades carregadas
        PropertyLoader.get().printAll(System.out);
        System.out.println();
        System.out.println(opt.toString());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.perin.app.services;

import br.perin.app.Opt;
import br.perin.app.bean.Options;

/**
 * Classe ArgsParser
 *
 * @author Joaov
 */
public class ArgsParser {

    /** Instância do Singleton */
    public static ArgsParser instance;

    /**
     * Realiza o parse de um array de argumentos de linha de comando
     *
     * @param cmdLineArgs
     * @return Options
     */
    public Options parse(String[] cmdLineArgs) {
        Options opt = new Options();
        for (String a : cmdLineArgs) {
            opt.put(parseOpt(a));
        }
        return opt;
    }

    /**
     * Realiza o parse de um argumento de linha de comando
     *
     * @param args
     * @return Opt
     */
    private Opt parseOpt(String args) {
        int idxEqual = args.indexOf('=');
        String key = args.substring(1, idxEqual);
        String value = args.substring(idxEqual + 1, args.length());
        return new Opt(key, value);
    }

    /**
     * Retorna a instância do Singleton
     *
     * @return ArgsParser
     */
    public static ArgsParser get() {
        if (instance == null) {
            instantiate();
        }
        return instance;
    }

    /**
     * Instancia o Singleton
     */
    private static synchronized void instantiate() {
        if (instance == null) {
            instance = new ArgsParser();
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.perin.app;

/**
 * Classe ArgsParser
 *
 * @author Joaov
 */
public class ArgsParser {

    public static ArgsParser instance;

    public Options parse(String[] args) {
        Options opt = new Options();
        for (String a : args) {
            opt.put(parseOpt(a));
        }
        return opt;
    }

    private Opt parseOpt(String a) {
        int idxEqual = a.indexOf('=');
        String key = a.substring(1, idxEqual);
        String value = a.substring(idxEqual+1, a.length());
        return new Opt(key, value);
    }

    public static ArgsParser get() {
        if (instance == null) {
            instantiate();
        }
        return instance;
    }

    private static synchronized void instantiate() {
        if (instance == null) {
            instance = new ArgsParser();
        }
    }

}

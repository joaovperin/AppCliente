/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.perin.app;

/**
 *
 * @author Joaov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        args = new String[]{"-f=C:\\tmp\\ppt.properties", "-std=c99"};
        Options opt = OptionsParser.get().parse(args);
        System.out.println(opt.toString());
    }

}

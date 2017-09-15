/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.perin.app.services;

import java.util.Properties;

/**
 * Classe PropertyLoader
 *
 * @author Joaov
 */
public class PropertyLoader {

    private static PropertyLoader instance;

    private final Properties properties;

    private PropertyLoader() {
        this.properties = new Properties();
    }

    public void load() {
        throw new UnsupportedOperationException("implementar o Load.");
    }

    public static PropertyLoader get() {
        if (instance == null) {
            instantiate();
        }
        return instance;
    }

    private static synchronized void instantiate() {
        if (instance == null) {
            instance = new PropertyLoader();
        }
    }

}

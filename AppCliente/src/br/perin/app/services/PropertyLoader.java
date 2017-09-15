/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.perin.app.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

/**
 * Classe PropertyLoader
 *
 * @author Joaov
 */
public class PropertyLoader {

    /** Instância Singleton */
    private static PropertyLoader instance;

    /** Cache de propriedades */
    private final Properties properties;

    /**
     * Construtor privado do Singleton
     */
    private PropertyLoader() {
        this.properties = new Properties();
    }

    /**
     * Carrega as propriedades dado um diretório
     *
     * @param dir
     */
    public void load(String dir) {
        try {
            InputStream f = new FileInputStream(dir);
            properties.load(f);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Arquivo não encontrado:" + dir);
        } catch (IOException ex) {
            System.out.println("Falha ao carregar propriedadesd do arquivo:" + dir);
        }
    }

    /**
     * Printa todas as propriedades carregadas
     *
     * @param output
     */
    public void printAll(PrintStream output) {
        getProperties().forEach((k, v) -> {
            output.println(k.toString().concat("=").concat(v.toString()));
        });
    }

    private Properties getProperties() {
        if (properties.isEmpty()) {
            throw new RuntimeException("Não carregou nenhuma propriedade");
        }
        return properties;
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

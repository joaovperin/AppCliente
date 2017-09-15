/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.perin.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe Options
 *
 * @author Joaov
 */
public class Options {

    private final List<Opt> options;

    public Options() {
        this.options = new ArrayList<>();
    }

    public void put(Opt option) {
        if (options.contains(option)) {
            throw new RuntimeException("Opção já existe");
        }
        options.add(option);
    }

    public String get(String alias) {
        try {
            return options.stream().filter((o) -> {
                return alias.equals(o.getAlias());
            }).findFirst().get().getValue();
        } catch (Exception e) {
            throw new RuntimeException("Parâmetro não encontrado :/");
        }
    }

    public List<Opt> getOptions() {
        return Collections.synchronizedList(options);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(1000);
        sb.append("Opções:\n");
        options.stream().forEach((e) -> {
            sb.append(e.toString()).append('\n');
        });
        return sb.toString();
    }

}

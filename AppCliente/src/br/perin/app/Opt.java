/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.perin.app;

import java.util.Objects;

/**
 * Classe Opt
 *
 * @author Joaov
 */
public class Opt {

    private static final int BUFF_SIZE = 128;
    
    private final String alias;
    private final String value;

    public Opt(String alias, String value) {
        this.alias = alias;
        this.value = value;
    }

    public String getAlias() {
        return alias;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(BUFF_SIZE);
        sb.append(getAlias()).append("=").append(getValue());
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Opt other = (Opt) obj;
        if (!Objects.equals(this.alias, other.alias)) {
            return false;
        }
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }    

}

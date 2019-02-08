package com.everest.bean;

import com.everest.strategy.Strategy;

import java.util.Collection;
import java.util.List;

public class Universe {
    private Kingdom ruler;
    private List<Kingdom> kingdoms;

    public Universe(List<Kingdom> kingdoms) {
        this.kingdoms = kingdoms;
    }

    public Kingdom selectRuler(Strategy strategy) throws Exception {
        Kingdom ruler= null;
        ruler = strategy.getRuler();
        this.ruler=ruler;
        return ruler;
    }

    public Kingdom getRuler() {
        return ruler;
    }

    public void setRuler(Kingdom ruler) {
        this.ruler = ruler;
    }

    public Collection<Kingdom> getKingdoms() {
        return kingdoms;
    }

    public void setKingdoms(List<Kingdom> kingdoms) {
        this.kingdoms = kingdoms;
    }

    @Override
    public String toString() {
        return "Universe{" +
                "ruler=" + ruler +
                ", kingdoms=" + kingdoms +
                '}';
    }
}

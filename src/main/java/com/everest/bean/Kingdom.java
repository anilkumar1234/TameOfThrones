package com.everest.bean;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Kingdom {
    private String name;
    private String emblem;
    private Set<Kingdom> allies;

    public Kingdom(String name, String emblem) {
        this.name = name;
        this.emblem = emblem;
        this.allies=new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public String getEmblem() {
        return emblem;
    }

    public Set<Kingdom> getAllies() {
        return allies;
    }

    public void clearAllies(){
        this.allies.clear();
    }

    public void sendInvitation(Message message) {
        if(message.isValid()) {
            this.allies.add(message.getReceiver());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kingdom)) return false;
        Kingdom kingdom = (Kingdom) o;
        return Objects.equals(name, kingdom.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}

package com.everest.bean;

import java.util.HashSet;
import java.util.Set;

public class Ballot {

    private Set<Message> alligianceRequests;

    public Ballot(){
        alligianceRequests=new HashSet<>();
    }

    public void put(Message message){
        alligianceRequests.add(message);
    }

    public Set<Message> getRequests(){
        return alligianceRequests;
    }
}

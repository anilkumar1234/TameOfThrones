package com.everest.strategy;

import com.everest.bean.Kingdom;
import com.everest.bean.Message;
import com.everest.bean.Universe;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AlligianceStrategy implements Strategy {

    private final Universe universe;
    private Kingdom conqueror;
    private List<Message> messages;

    public AlligianceStrategy(Universe universe, Kingdom conqueror, List<Message> messages){
        this.universe=universe;
        this.messages=messages;
        this.conqueror=conqueror;
    }

    @Override
    public Kingdom getRuler() throws Exception {
        if(messages.size()<3){
            throw new Exception("Atleast more than 3 messages should be given to conquer");
        }
        universe.getKingdoms().stream().forEach(kingdom -> kingdom.clearAllies());
        universe.setRuler(null);
        for(Message message:messages){
            conqueror.sendInvitation(message);
        }
        Optional<Kingdom> mostAlliedKingdom=universe.getKingdoms().stream().max(Comparator.comparing(kingdom -> kingdom.getAllies().size()));
        mostAlliedKingdom.ifPresent(kingdom -> {
            if(kingdom.getAllies().size()>=3){
                universe.setRuler(kingdom);
            }
        });
        return universe.getRuler();
    }
}

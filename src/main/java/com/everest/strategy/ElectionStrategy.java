package com.everest.strategy;

import com.everest.bean.*;
import com.everest.generator.ContentGenerator;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class ElectionStrategy implements Strategy {

    private Universe universe;
    private Ballot ballot;
    private Priest priest;
    private Collection<Kingdom> candidates;
    private ContentGenerator contentGenerator;

    public ElectionStrategy(Universe universe, Collection<Kingdom> candidates, ContentGenerator contentGenerator){
        this.universe=universe;
        this.candidates=candidates;
        this.ballot=new Ballot();
        this.priest=new Priest();
        this.contentGenerator=contentGenerator;
    }

    @Override
    public Kingdom getRuler() throws Exception {
        if(candidates.size()<=1){
            throw new Exception("Atleast two candidates must compete for election");
        }else if(candidates.size()>=universe.getKingdoms().size()){
            throw new Exception("Candidates should be lessa than total kingdoms");
        }
        universe.getKingdoms().stream().forEach(kingdom -> kingdom.clearAllies());
        universe.setRuler(null);
        startElection();
        return universe.getRuler();
    }

    private List<Message> generateMessages(){
        List<Message> messages=new ArrayList<>();
        for(Kingdom candidate:candidates){
            for(Kingdom kingdom:universe.getKingdoms()) {
                if (!candidates.contains(kingdom)) {
                    String content = contentGenerator.generate();
                    Message msg = new Message(content, candidate, kingdom);
                    messages.add(msg);
                }
            }
        }
        return messages;
    }

    private void startElection(){
        start(1);
    }

    private void start(int roundNum){
        candidates.stream().forEach(candidate->candidate.clearAllies());
        //Election process
        List<Message> messages=generateMessages();
        for(Message message:messages){
            ballot.put(message);
        }

        //Priest picking random messages
        List<Message> pickedMessages=priest.pickRandomRequests(ballot,6);
        for(Message message:pickedMessages){
            message.getSender().sendInvitation(message);
        }
        //System.out.println("#########################");
        System.out.println();
        System.out.println("Results after round #"+roundNum+" ballot count");
        for(Kingdom candidate:candidates){
            System.out.println("Allies for "+candidate.getName()+" : "+candidate.getAllies().size());
        }
        Map<Integer,List<Kingdom>> allyCount= candidates.stream()
                .collect(groupingBy(kingdom -> kingdom.getAllies().size()));
        List<Kingdom> winners=allyCount.get(allyCount.keySet().stream().max(Integer::compareTo).get());
        if(winners.size()==1){
            //System.out.println("Winner :"+winners.get(0));
            universe.setRuler(winners.get(0));
        }else{
            candidates=new HashSet<>(winners);
            //System.out.println("Tie #"+roundNum);
            start(roundNum+1);
        }
    }
}

package com.everest.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Priest {
    public List<Message> pickRandomRequests(Ballot ballot,int count) {
        Set<Message> ballotRequests=ballot.getRequests();
        List<Message> messages=new ArrayList<>();
        messages.addAll(ballotRequests);
        Random random=new Random();
        List<Message> pickedMessages=new ArrayList<>();
        for(int i=0;i<count;i++){
            int randNum=random.nextInt(messages.size());
            Message msg=messages.remove(randNum);
            pickedMessages.add(msg);
        }
        return pickedMessages;
    }
}

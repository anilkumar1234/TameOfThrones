package com.everest.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Message {
    private Kingdom sender;
    private Kingdom receiver;
    private String content;

    public Message(String content,Kingdom sender,Kingdom receiver){
        this.content=content;
        this.sender=sender;
        this.receiver=receiver;
    }

    public boolean isValid(){
        Map<Character,Integer> charCounts=new HashMap<Character, Integer>();
        for(char c:content.toLowerCase().toCharArray()){
            if(!charCounts.containsKey(c)){
                charCounts.put(c,0);
            }
            charCounts.put(c,charCounts.get(c)+1);
        }

        Map<Character,Integer> emblemCounts=new HashMap<Character, Integer>();
        for(char c:receiver.getEmblem().toLowerCase().toCharArray()){
            if(!emblemCounts.containsKey(c)){
                emblemCounts.put(c,0);
            }
            emblemCounts.put(c,emblemCounts.get(c)+1);
        }

        for(char c:emblemCounts.keySet()){
            if(!charCounts.containsKey(c) || charCounts.get(c)<emblemCounts.get(c)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return sender.equals(message.sender) &&
                receiver.equals(message.receiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender, receiver);
    }

    public Kingdom getSender() {
        return sender;
    }

    public Kingdom getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender=" + sender +
                ", receiver=" + receiver +
                ", content='" + content + '\'' +
                '}';
    }
}

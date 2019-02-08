package com.everest.generator;

import com.everest.constants.AppConstants;

import java.util.Random;

public class MessageContentGenerator implements ContentGenerator{

    private String[] messageSource;

    public MessageContentGenerator(String[] messages) {
        messageSource=AppConstants.MESSAGES;
    }

    @Override
    public String generate() {
        Random random=new Random();
        int randNum=random.nextInt(messageSource.length);
        return messageSource[randNum];
    }
}

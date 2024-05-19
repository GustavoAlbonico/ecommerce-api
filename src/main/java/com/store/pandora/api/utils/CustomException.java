package com.store.pandora.api.utils;

import java.util.ArrayList;
import java.util.List;

public class CustomException extends Exception{
    private List<String> messageList =  new ArrayList<>();

    public CustomException(List<String> mensagens){
        this.messageList = mensagens;
    }


    public CustomException(String mensagem){
        super(mensagem);//como se estivese usando o construtor da classe pai
    }

    public List<String> getMessages(){
        if (messageList.isEmpty()){
            messageList.add(super.getMessage());
        }

        return messageList;
    }

    public String getMessage(){
        if(messageList.isEmpty()){
            return super.getMessage();
        }
        return messageList.toString();
    }
}

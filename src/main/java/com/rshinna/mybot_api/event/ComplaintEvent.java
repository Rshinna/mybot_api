package com.rshinna.mybot_api.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ComplaintEvent extends ApplicationEvent {

    private final String mensagem;

    public ComplaintEvent(Object source, String mensagem) {
        super(source);
        this.mensagem = mensagem;
    }

}

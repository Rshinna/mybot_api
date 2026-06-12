package com.rshinna.mybot_api.handler;

import com.rshinna.mybot_api.event.ComplaintEvent;
import org.springframework.context.ApplicationEventPublisher;

public class ComplaintHandler extends Handler {

    private final ApplicationEventPublisher publisher;

    public ComplaintHandler(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String handle(String mensagem) {

        if (mensagem.toLowerCase().contains("reclamação") || mensagem.toLowerCase().contains("problema")) {

            publisher.publishEvent(new ComplaintEvent(this, mensagem));
            return "Bot: Entendi sua reclamação, encaminhei para o suporte.";

        } else if (next != null) {
            return next.handle(mensagem);
        }
        return "Bot: Desculpe, não entendi sua mensagem.";
    }
}

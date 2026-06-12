package com.rshinna.mybot_api.service;

import com.rshinna.mybot_api.handler.ComplaintHandler;
import com.rshinna.mybot_api.handler.FAQHandler;
import com.rshinna.mybot_api.handler.GreetingHandler;
import com.rshinna.mybot_api.handler.Handler;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final Handler chain;

    public ChatService(ApplicationEventPublisher publisher) {

        Handler greeting = new GreetingHandler();
        Handler faq = new FAQHandler();
        Handler complaint = new ComplaintHandler(publisher);

        greeting.setNext(faq);
        faq.setNext(complaint);

        this.chain = greeting;
    }

    public String processarMensagem(String mensagem) {

        return chain.handle(mensagem);
    }
}

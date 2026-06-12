package com.rshinna.mybot_api.service;

import com.rshinna.mybot_api.config.BotConfig;
import com.rshinna.mybot_api.handler.ComplaintHandler;
import com.rshinna.mybot_api.handler.FAQHandler;
import com.rshinna.mybot_api.handler.GreetingHandler;
import com.rshinna.mybot_api.handler.Handler;
import com.rshinna.mybot_api.strategy.ResponseStrategy;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final Handler chain;
    private final ResponseStrategy strategy;
    private final BotConfig botConfig;

    public ChatService(ApplicationEventPublisher publisher, ResponseStrategy strategy, BotConfig botConfig) {

        Handler greeting = new GreetingHandler();
        Handler faq = new FAQHandler();
        Handler complaint = new ComplaintHandler(publisher);

        greeting.setNext(faq);
        faq.setNext(complaint);

        this.chain = greeting;
        this.strategy = strategy;
        this.botConfig = botConfig;
    }

    public String processarMensagem(String mensagem) {

        String resposta = chain.handle(mensagem);

        if ("casual".equalsIgnoreCase(botConfig.getTone())) {
            return "Bot (Casual): " + resposta + " \uD83D\uDE09";
        }
        return strategy.formatResponse(resposta);
    }
}

package com.rshinna.mybot_api.strategy;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("casual")
public class CasualResponse implements ResponseStrategy {

    @Override
    public String formatResponse(String mensagem) {
        return "Bot (Casual): " + mensagem + " \uD83D\uDE09";
    }
}

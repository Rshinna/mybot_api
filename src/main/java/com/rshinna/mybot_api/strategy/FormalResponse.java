package com.rshinna.mybot_api.strategy;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("formal")
public class FormalResponse implements ResponseStrategy {

    @Override
    public String formatResponse(String mensagem) {
        return "Bot (Formal): " + mensagem;
    }
}

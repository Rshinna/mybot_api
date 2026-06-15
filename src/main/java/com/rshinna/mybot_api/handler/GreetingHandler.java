package com.rshinna.mybot_api.handler;

import java.text.Normalizer;

public class GreetingHandler extends Handler {

    @Override
    public String handle(String mensagem) {

        String lower = mensagem.toLowerCase();
        String normalizada = Normalizer.normalize(lower, Normalizer.Form.NFD).replaceAll("\\p{M}", "");


        if (normalizada.contains("oi") || normalizada.contains("ola")) {
            return "Bot: Olá, seja bem vindo!";
        } else if (next != null) {
            return next.handle(mensagem);
        }
        return "Bot: Desculpe, não entendi sua mensagem.";
    }
}

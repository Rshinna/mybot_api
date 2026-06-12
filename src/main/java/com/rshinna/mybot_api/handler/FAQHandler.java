package com.rshinna.mybot_api.handler;

public class FAQHandler extends Handler {

    @Override
    public String handle(String mensagem) {
        if (mensagem.toLowerCase().contains("horário")) {
            return "Bot: Funcionamos das 9h às 18h.";
        } else if (mensagem.toLowerCase().contains("endereço")) {
            return "Bot: Estamos localizados na Rua Central, nº 123.";

        } else if (next != null) {
            return next.handle(mensagem);

        }
        return "Bot: Desculpe, não entendi sua mensagem.";
    }
}

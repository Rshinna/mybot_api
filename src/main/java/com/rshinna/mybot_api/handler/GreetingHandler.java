package com.rshinna.mybot_api.handler;

import java.text.Normalizer;
import java.util.Arrays;

public class GreetingHandler extends Handler {

  @Override
  public String handle(String mensagem) {

      System.out.println("Mensagem recebida: " + mensagem);
      System.out.println("Bytes: " + Arrays.toString(mensagem.getBytes()));
    
      String lower = mensagem.toLowerCase();
    String normalizada = Normalizer.normalize(lower, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
    
    System.out.println("Normalizada: " + normalizada);

    if (normalizada.contains("oi") || normalizada.contains("ola")) {
      return "Bot: Olá, seja bem vindo!";
    } else if (next != null) {
      return next.handle(mensagem);
    }
    return "Bot: Desculpe, não entendi sua mensagem. ";
  }
}

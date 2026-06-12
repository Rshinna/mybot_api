package com.rshinna.mybot_api.service;

import com.rshinna.mybot_api.handler.GreetingHandler;
import com.rshinna.mybot_api.handler.Handler;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

  private final Handler chain;

  public ChatService() {

    Handler greeting = new GreetingHandler();
    this.chain = greeting;
  }

  public String processarMensagem(String mensagem) {
    return chain.handle(mensagem);
  }
}

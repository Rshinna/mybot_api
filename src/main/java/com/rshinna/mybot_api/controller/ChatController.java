package com.rshinna.mybot_api.controller;

import com.rshinna.mybot_api.dto.MensagemRequest;
import com.rshinna.mybot_api.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

  private final ChatService chatService;

  public ChatController(ChatService chatService) {
    this.chatService = chatService;
  }

  @PostMapping
  public String conversar(@RequestBody MensagemRequest request) {
    return chatService.processarMensagem(request.getMensagem());
  }
}

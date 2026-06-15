package com.rshinna.mybot_api.controller;

import com.rshinna.mybot_api.dto.MensagemRequest;
import com.rshinna.mybot_api.dto.MensagemResponse;
import com.rshinna.mybot_api.service.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
@Tag(name = "ChatBot", description = "Operações de interação com o chatbot")
public class ChatController {

  private final ChatService chatService;

  public ChatController(ChatService chatService) {
    this.chatService = chatService;
  }

  @PostMapping
  @Operation(
      summary = "Enviar mensagem",
      description = "Recebe uma mensagem do usuário e retorna uma resposta do chatbot")
  public MensagemResponse conversar(@RequestBody MensagemRequest request) {
    String resposta = chatService.processarMensagem(request.getMensagem());

    return new MensagemResponse(resposta);
  }
}

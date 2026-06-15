package com.rshinna.mybot_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Resposta retornada pelo chatbot")
public record MensagemResponse(
    @Schema(description = "Mensagem gerada pelo chatbot", example = "Bot: Olá, seja bem-vindo!")
        String resposta) {}

package com.rshinna.mybot_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Solicitação de alteração do tom do chatbot")
public record ToneRequest(
    @Schema(
            description = "Tom das respostas do chatbot",
            example = "casual",
            allowableValues = {"formal", "casual"})
        String tone) {}

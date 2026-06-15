package com.rshinna.mybot_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(description = "Mensagem enviada ao chatbot")
public class MensagemRequest {

    @Schema(
            description = "Texto enviado pelo usuário",
            example = "Olá, tudo bem?",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String mensagem;

}

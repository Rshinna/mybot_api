package com.rshinna.mybot_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Resposta da atualização de configuração")
public record ConfigResponse(
        @Schema(description = "Mensagem de confirmação", example = "Tom atualizado para: casual")
        String mensagem) {
}

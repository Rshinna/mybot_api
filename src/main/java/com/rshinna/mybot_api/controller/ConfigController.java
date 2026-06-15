package com.rshinna.mybot_api.controller;

import com.rshinna.mybot_api.config.BotConfig;
import com.rshinna.mybot_api.dto.ConfigResponse;
import com.rshinna.mybot_api.dto.ToneRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@Tag(name = "Configuração", description = "Endpoints de configuração do chatbot")
public class ConfigController {

  private final BotConfig botConfig;

  public ConfigController(BotConfig botConfig) {

    this.botConfig = botConfig;
  }

  @PutMapping("/tone")
  @Operation(
      summary = "Alterar tom das respostas",
      description = "Permite alterar o estilo da resposta do chatbot entre casual ou formal")
  public ConfigResponse updateTone(@RequestBody ToneRequest request) {

    if (!"formal".equalsIgnoreCase(request.tone()) && !"casual".equalsIgnoreCase(request.tone())) {
      throw new IllegalArgumentException("O tom deve ser 'formal' ou 'casual'");
    }
    botConfig.setTone(request.tone());

    return new ConfigResponse("Tom atualizado para: " + request.tone());
  }
}

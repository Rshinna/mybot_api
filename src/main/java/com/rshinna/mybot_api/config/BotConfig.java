package com.rshinna.mybot_api.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class BotConfig {

    private String language = "pt-BR";
    private String tone = "formal";

}

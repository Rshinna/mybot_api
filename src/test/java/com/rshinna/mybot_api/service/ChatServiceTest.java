package com.rshinna.mybot_api.service;

import com.rshinna.mybot_api.config.BotConfig;
import com.rshinna.mybot_api.strategy.ResponseStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ChatServiceTest {

    private ApplicationEventPublisher publisher;
    private ResponseStrategy strategy;
    private BotConfig botConfig;
    private ChatService chatService;

    @BeforeEach
    void setUp() {

        publisher = mock(ApplicationEventPublisher.class);
        strategy = mock(ResponseStrategy.class);

        botConfig = new BotConfig();
        botConfig.setTone("formal");

        chatService = new ChatService(
                publisher, strategy, botConfig);
    }

    @Test
    void deveResponderSaudacao() {
        when(strategy.formatResponse(anyString())).thenAnswer(invocation -> "Bot (Formal): " + invocation.getArgument(0));

        String resposta = chatService.processarMensagem("oi");

        assertTrue(resposta.contains("Olá"));

        verify(strategy).formatResponse(anyString());
    }

    @Test
    void deveRetornarMensagemPadraoQuandoNaoEntender() {

        when(strategy.formatResponse(anyString()))
                .thenAnswer(invocation ->
                        "Bot (Formal): " + invocation.getArgument(0));

        String resposta =
                chatService.processarMensagem("xyz123");

        assertTrue(resposta.contains("não entendi"));
    }

    @Test
    void deveResponderFaqHorario() {
        when(strategy.formatResponse(anyString())).thenAnswer(invocation -> "Bot (Formal): " + invocation.getArgument(0));

        String resposta = chatService.processarMensagem("Qual o horário de funcionamento?");

        assertTrue(resposta.contains("9h às 18h"));

    }

    @Test
    void deveResponderReclamacao() {

        when(strategy.formatResponse(anyString()))
                .thenAnswer(invocation ->
                        "Bot (Formal): " + invocation.getArgument(0));

        String resposta =
                chatService.processarMensagem("Tenho uma reclamação");

        assertTrue(resposta.contains("encaminhei para o suporte"));
    }

    @Test
    void devePublicarEventoQuandoReceberReclamacao() {

        when(strategy.formatResponse(anyString()))
                .thenAnswer(invocation ->
                        "Bot (Formal): " + invocation.getArgument(0));

        chatService.processarMensagem("Tenho uma reclamação");

        verify(publisher, times(1))
                .publishEvent(any());
    }

    @Test
    void deveAplicarTomCasual() {

        botConfig.setTone("casual");

        String resposta =
                chatService.processarMensagem("oi");

        assertTrue(resposta.contains("😉"));
        assertTrue(resposta.contains("Casual"));
    }

}
package com.rshinna.mybot_api.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ComplaintListener {

    @EventListener
    public void handleComplaint(ComplaintEvent event) {
        System.out.println("\uD83D\uDCE2 Notificação: Reclamação recebida -> " + event.getMensagem());
    }
}

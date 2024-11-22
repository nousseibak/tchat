package com.openclassroom.tchat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    // Méthode pour recevoir et diffuser le message
    @MessageMapping("/sendMessage")
    public void sendMessage(String message) {
        messagingTemplate.convertAndSend("/topic/messages", message);  // Diffuser le message à tous les abonnés
    }

    @GetMapping("/")
    public String chat(Model model) {
        model.addAttribute("messages", new ArrayList<>());
        return "chat";  // Renvoie le template Thymeleaf "chat.html"
    }
}

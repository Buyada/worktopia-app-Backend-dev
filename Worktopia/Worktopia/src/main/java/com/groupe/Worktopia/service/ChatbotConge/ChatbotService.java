package com.groupe.Worktopia.service.ChatbotConge;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ChatbotService {
    private final Map<String, String> responses;

    public ChatbotService() {
        responses = new HashMap<>();
        responses.put("bonjour", "Bonjour ! Comment puis-je vous aider ?");
        responses.put("comment ça va ?", "Je suis un chatbot, donc je vais toujours bien !");
        responses.put("au revoir", "Au revoir ! Passez une bonne journée !");
        responses.put("merci", "Je vous en pries ! Vous pouvez à tout moment nous contacter au sujet de tout souci à propos de notre plate-forme LogoneDigital sur les Congés et les absences  !");
    }

    public String getResponse(String message) {
        message = message.toLowerCase().trim();
        return responses.getOrDefault(message, "Désolé, je ne comprends pas cette question.");
    }
}
package com.groupe.Worktopia.controller;

import com.groupe.Worktopia.service.ChatbotConge.ChatbotService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chatbot")
public class ChatbotController {
    private final ChatbotService chatbotService;

    public ChatbotController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }

    @PostMapping("/ask")
    public String askChatbot(@RequestBody String message) {
        return chatbotService.getResponse(message);
    }
}

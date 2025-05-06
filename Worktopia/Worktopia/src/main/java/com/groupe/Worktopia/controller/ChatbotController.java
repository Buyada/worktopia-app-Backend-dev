package com.groupe.Worktopia.controller;

import com.groupe.Worktopia.service.ChatbotConge.ChatbotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chatbot")
public class ChatbotController {
    private final ChatbotService chatbotService;

    public ChatbotController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }

    @PostMapping("/ask")
    public ResponseEntity<String> ask(@RequestBody String question) {
        String response = chatbotService.getResponse(question);
        return ResponseEntity.ok(response);
    }

}

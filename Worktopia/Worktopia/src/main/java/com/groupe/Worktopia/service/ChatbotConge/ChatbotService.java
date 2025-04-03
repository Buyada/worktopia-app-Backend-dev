package com.groupe.Worktopia.service.ChatbotConge;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ChatbotService {
    public String getResponse(String userInput) {
        String response = "";

        // Exemple de règles simples
        if (userInput.contains("Bonjour") || userInput.contains("Salut")) {
            response = "Bonjour, comment puis-je vous aider ?";
        } else if (userInput.contains("temps") || userInput.contains("météo")) {
            response = "Je ne peux pas vous donner la météo, mais je peux vous aider pour d'autres questions !";
        } else {
            response = "Désolé, je n'ai pas compris votre question.";
        }
        if (userInput.contains("Congé") || userInput.contains("Salut")) {
            response = "vous voulez savoir à quand vos congés ? si oui, donnez-moi votre ID";
        } else if (userInput.contains("Absence") || userInput.contains("pas présent")) {
            response = "Vous aimeriez savoir combien d'absences vous avez eu ce mois ? si oui, donnez-moi votre ID et je pourrais vous informer";
        } else {
            response = "Il se peut que vous essayez d'entrer une information que je n'ai pas";
        }
        return response;
    }

}
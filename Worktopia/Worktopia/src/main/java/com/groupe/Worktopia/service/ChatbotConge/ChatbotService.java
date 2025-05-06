package com.groupe.Worktopia.service.ChatbotConge;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ChatbotService {
    public String getResponse(String userInput) {
        String response = "";



        if (userInput.contains("Congé") || userInput.contains("Salut")) {
            response = "vous voulez savoir à quand vos congés ? si oui, donnez-moi votre ID";
        } else if (userInput.contains("Absence") || userInput.contains("pas présent")) {
            response = "Vous aimeriez savoir combien d'absences vous avez eu ce mois ? si oui, donnez-moi votre ID et je pourrais vous informer";
        } else {
            response = "Il se peut que vous essayez d'entrer une information que je n'ai pas";
        }
        if (userInput.contains("Bonjour")) {
            response = "Bonjour, comment puis-je vous aider ?";
        }
        if (userInput.contains("Permission")) {
            response = "Désirez-vous prendre une permission ou alors en faire la demande?";
        }
        if (userInput.contains("Id")) {
            response = "Un instant je vais rechercher des informations sur votre profil";
        }
        if (userInput.contains("Travail")) {
            response = "Les heures de services sont mentionnées dans le calendrier hebdomadaire de l'entreprise. voulez-vous une copie du calendrier ? ";
        }
        return response;
    }

}
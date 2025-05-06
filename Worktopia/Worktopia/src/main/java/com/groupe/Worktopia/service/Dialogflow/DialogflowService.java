package com.groupe.Worktopia.service.Dialogflow;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DialogflowService {

    private final RestTemplate restTemplate;

    // Injection via le constructeur
    public DialogflowService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    private final String dialogflowUrl = "https://dialogflow.googleapis.com/v2/projects/YOUR_PROJECT_ID/agent/sessions/YOUR_SESSION_ID:detectIntent";


        public String getResponseFromDialogflow(String query) {
            // Appel à l'API Dialogflow (ici il faut configurer l'authentification et le corps de la requête)
            // Exemple simple (vérifie la documentation de Dialogflow pour l'implémentation exacte)
            String response = restTemplate.postForObject(dialogflowUrl, query, String.class);
            return response;
        }
    }


package com.groupe.Worktopia;

import com.groupe.Worktopia.service.mail.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class  WorktopiaApplication {

//		private EmailSenderService emailSenderService;
//		public WorktopiaApplication(EmailSenderService emailSenderService){
//			this.emailSenderService = emailSenderService;
//		}
	public static void main(String[] args) {

			SpringApplication.run(WorktopiaApplication.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void sendMail(){
//		emailSenderService.sendEmail("dongmosammmar@gmail.com",
//				"Demande de formation",
//				"Pour ameliorer mes competences en front-end, pour cela" +
//						"je sollicite votre bienveillance pour m'accorder une formation" +
//						"qui sera benefique non seulement pour moi mais aussi pour l'entreprise"
//				);
//	}

}


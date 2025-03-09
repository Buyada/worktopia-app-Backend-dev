package com.groupe.Worktopia.controller;

import com.groupe.Worktopia.entities.BulletinPaie;
import com.groupe.Worktopia.entities.Employe;
import com.groupe.Worktopia.exception.RessourceNotFoundException;
import com.groupe.Worktopia.repository.BulletinPaieRepo;
import com.groupe.Worktopia.service.Pdf.PdfService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "api/generer_pdf")
public class PdfController {

    private BulletinPaieRepo bulletinPaieRepo;
    private PdfService pdfService;
    public  PdfController(BulletinPaieRepo bulletinPaieRepo,PdfService pdfService ){
        this.bulletinPaieRepo = bulletinPaieRepo;
        this.pdfService = pdfService;
    }

    @GetMapping("/generate/{bulletinId}")
    public ResponseEntity<byte[]> genererBulletinPaiePdf(@PathVariable Long bulletinId) throws IOException {
        BulletinPaie bulletin = bulletinPaieRepo.findById(bulletinId)
                .orElseThrow(() -> new RessourceNotFoundException("Bulletin non trouvé"));

        byte[] pdfBytes = pdfService.genererBulletinPaiePdf(bulletin);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=bulletin_paie.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}

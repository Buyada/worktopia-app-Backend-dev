package com.groupe.Worktopia.service.Pdf;

import com.groupe.Worktopia.entities.BulletinPaie;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

@Service
public class PdfService {

    public byte[] genererBulletinPaiePdf(BulletinPaie bulletin) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4);

        // Ajout du titre
        PdfFont titleFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        document.add(new Paragraph("Bulletin de Paie")
                .setFont(titleFont)
                .setFontSize(18)
                .setFontColor(ColorConstants.BLUE)
                .setBold()
                .setMarginBottom(20));

        // Informations de l'employé
        document.add(new Paragraph("Nom : " + bulletin.getEmploye().getFirstName() + " " + bulletin.getEmploye().getLastName()));
        document.add(new Paragraph("Poste : " + bulletin.getEmploye().getPoste()));
        document.add(new Paragraph("Date : " + bulletin.getDateGeneration().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));

        document.add(new Paragraph("\n")); // Saut de ligne

        // Création du tableau des détails de la paie
        float[] columnWidths = {200F, 200F}; // Deux colonnes
        Table table = new Table(columnWidths);

        table.addCell("Salaire Brut");
        table.addCell(String.format("%.2f FCFA", bulletin.getSalaireBrut()));

        table.addCell("Prime");
        table.addCell(String.format("%.2f FCFA", bulletin.getEmploye().getPrime()));

        table.addCell("Salaire Net");
        table.addCell(String.format("%.2f FCFA", bulletin.getSalaireNet()));

        document.add(table);

        // Fin du document
        document.close();

        return out.toByteArray();
    }
}
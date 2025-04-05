package com.groupe.Worktopia.dto.profil;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class ProfilReqDTO {
//    @NotEmpty(message = "please fill this!")
//    @NotNull(message = "this field couldn't be null")
//    private String username;
//    @Lob
//    @Column(name = "cv")
//    private byte[] cv;


    private String firstname;
    private String lastname;
    private long numerotelephone;
    private String adresse;
    private String datedenaissance;
    private String genre;
    private byte[] photodeprofil;
    private byte[] cv;


    public ProfilReqDTO() {
    }

    public ProfilReqDTO(String firstname, String lastname, long numerotelephone, String adresse, String datedenaissance, String genre, byte[] photodeprofil, byte[] cv) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.numerotelephone = numerotelephone;
        this.adresse = adresse;
        this.datedenaissance = datedenaissance;
        this.genre = genre;
        this.photodeprofil = photodeprofil;
        this.cv = cv;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public long getNumerotelephone() {
        return numerotelephone;
    }

    public void setNumerotelephone(long numerotelephone) {
        this.numerotelephone = numerotelephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDatedenaissance() {
        return datedenaissance;
    }

    public void setDatedenaissance(String datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public byte[] getPhotodeprofil() {
        return photodeprofil;
    }

    public void setPhotodeprofil(byte[] photodeprofil) {
        this.photodeprofil = photodeprofil;
    }

    public byte[] getCv() {
        return cv;
    }

    public void setCv(byte[] cv) {
        this.cv = cv;
    }
}

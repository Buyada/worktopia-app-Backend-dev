package com.groupe.Worktopia.dto.EmployeDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeDto {
     @JsonIgnore
    private Long idEmploye;
    @NotEmpty(message = "veuillez remplir ce champs !")
   // @NotNull(message = "ce champ ne peut pas etre nul !")
    private String firstName;

    private String lastName;
    @NotEmpty(message = "ce champ est obligatoire !")
   // @NotNull(message = "ce champ ne peut pas etre nul !")
    private String poste;
    //@NotEmpty(message = "veuillez remplir ce champs !")
    //@NotNull(message = "ce champ ne peut pas etre nul !")
    private double salaireBase;

    private double prime;
    @Email(message = "email ou format email incorrect !")
    private String email;

    public Long getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(Long idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public double getSalaireBase() {
        return salaireBase;
    }

    public void setSalaireBase(double salaireBase) {
        this.salaireBase = salaireBase;
    }

    public double getPrime() {
        return prime;
    }

    public void setPrime(double prime) {
        this.prime = prime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeDto(Long idEmploye, String email, double prime, String poste, double salaireBase, String lastName, String firstName) {
        this.idEmploye = idEmploye;
        this.email = email;
        this.prime = prime;
        this.poste = poste;
        this.salaireBase = salaireBase;
        this.lastName = lastName;
        this.firstName = firstName;
    }
}

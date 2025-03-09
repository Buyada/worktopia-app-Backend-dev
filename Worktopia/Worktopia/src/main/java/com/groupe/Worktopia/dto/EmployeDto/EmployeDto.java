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
}

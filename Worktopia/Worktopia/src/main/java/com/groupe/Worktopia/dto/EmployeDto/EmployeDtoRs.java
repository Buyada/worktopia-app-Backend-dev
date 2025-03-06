package com.groupe.Worktopia.dto.EmployeDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeDtoRs {
    private Long idEmploye;
    private String firstName;
    private String lastName;
    private String poste;
    private double salaireBase;
    private double prime;
    private String email;
}

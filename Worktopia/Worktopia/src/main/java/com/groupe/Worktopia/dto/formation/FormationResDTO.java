package com.groupe.Worktopia.dto.formation;

import com.groupe.Worktopia.dto.categorie.CategorieResDTO;
import com.groupe.Worktopia.entities.Categorie;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FormationResDTO {
    private Integer formationId;
    @NotEmpty(message = "please fill this field !")
    @NotNull(message = "this field couldn't be null !")
    private String intitule;
    @NotEmpty(message = "please fill this field !")
    @NotNull(message = "this field couldn't be null !")
    private String description;
    private Integer duree;


}

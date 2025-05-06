package com.groupe.Worktopia.dto.categorie;

import com.groupe.Worktopia.dto.formation.FormationResDTO;
import com.groupe.Worktopia.entities.Formation;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CategorieResDTO {
    private Integer categorieId;
    @NotEmpty(message = "please fill this field !")
    @NotNull(message = "this field couldn't be null !")
    private String intitule;
    @NotEmpty(message = "please fill this field !")
    @NotNull(message = "this field couldn't be null !")
    private String description;



    private List<FormationResDTO> formations ;

}

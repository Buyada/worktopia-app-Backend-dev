package com.groupe.Worktopia.dto.demandeformation;

import com.groupe.Worktopia.dto.formation.FormationResDTO;
import com.groupe.Worktopia.entities.Formation;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DemandeformationResDTO {
    private Integer demandeformationId;
    @NotEmpty(message = "please fill this field !")
    @NotNull(message = "this field couldn't be null !")
    private String objet;
    @NotEmpty(message = "please fill this field !")
    @NotNull(message = "this field couldn't be null !")
    private String commentaire;
    private FormationResDTO formationResDTO;

    public void setObjet(String objet){this.objet = objet;};
    public String getObjet(){return objet;}

    public void setCommentaire(String commentaire){
        this.commentaire = commentaire;
    }
    public String getCommentaire(){return commentaire;}
}

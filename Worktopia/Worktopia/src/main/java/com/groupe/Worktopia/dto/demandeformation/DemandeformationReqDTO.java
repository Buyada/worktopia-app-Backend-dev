package com.groupe.Worktopia.dto.demandeformation;

import com.groupe.Worktopia.entities.Formation;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DemandeformationReqDTO {
    @NotEmpty(message = "please fill this field !")
    @NotNull(message = "this field couldn't be null !")
    private String objet;
    @NotEmpty(message = "please fill this field !")
    @NotNull(message = "this field couldn't be null !")
    private String commentaire;
    private Integer formationId;
    private Integer userId;

    public void setObjet(String objet){this.objet = objet;};
    public String getObjet(){return objet;}

    public void setCommentaire(String commentaire){
        this.commentaire = commentaire;
    }
    public String getCommentaire(){return commentaire;}

    public void setFormationId(Integer formationId){
        this.formationId = formationId;
    }
    public Integer getFormationId(){
        return formationId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }
    public Integer getUserId(){
        return userId;
    }
}

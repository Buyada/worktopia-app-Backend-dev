package com.groupe.Worktopia.dto.demandeformation;

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

    public void setObjet(String objet){this.objet = objet;};
    public String getObjet(){return objet;}

    public void setCommentaire(String commentaire){
        this.commentaire = commentaire;
    }
    public String getCommentaire(){return commentaire;}
}

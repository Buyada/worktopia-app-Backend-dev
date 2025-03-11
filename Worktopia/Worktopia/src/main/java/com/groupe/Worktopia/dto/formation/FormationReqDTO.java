package com.groupe.Worktopia.dto.formation;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FormationReqDTO {
    @NotEmpty(message = "please fill this field !")
    @NotNull(message = "this field couldn't be null !")
    private String intitule;
    @NotEmpty(message = "please fill this field !")
    @NotNull(message = "this field couldn't be null !")
    private String description;
    private Integer duree;

    public void setIntitule(String intitule){
        this.intitule = intitule;
    }
    public String getIntitule(){
        return intitule;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setDuree(Integer duree){
        this.duree = duree;
    }
    public Integer getDuree(){
        return  duree;
    }
}

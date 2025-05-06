package com.groupe.Worktopia.dto.categorie;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CategorieReqDTO {
    @NotEmpty(message = "please fill this field !")
    @NotNull(message = "this field couldn't be null !")
    private String intitule;
    @NotEmpty(message = "please fill this field !")
    @NotNull(message = "this field couldn't be null !")
    private String description;



    public void setIntitule(String intitule){
        this.intitule = intitule;
    }
    public String getIntitule()
    {
        return intitule;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }


}

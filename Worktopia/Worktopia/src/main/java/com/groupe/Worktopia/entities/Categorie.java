package com.groupe.Worktopia.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categorie implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categorieId;
    private String intitule;
    private String description;
    private String typeFormation; //en ligne , en presentiel, mixte
    private Boolean Status;
    private Date createdAt;
    private Date updatedAt;

@OneToMany
   private List<Formation> formations = new ArrayList<>();
}

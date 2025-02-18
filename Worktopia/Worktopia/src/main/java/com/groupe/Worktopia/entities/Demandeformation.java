package com.groupe.Worktopia.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Demandeformation implements Serializable {
    @Serial
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer demandeformationId;
    private String titreFormation;
    private String objet;
    private Boolean statut;           //en attente, refusee, aprouvee
    private String commentaire;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne
    private Formation formation;

//    @ManyToOne
//    private User user;
}

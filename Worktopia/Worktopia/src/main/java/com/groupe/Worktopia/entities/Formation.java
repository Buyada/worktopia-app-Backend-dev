package com.groupe.Worktopia.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Formation implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer formationId;
    private String intitule;
    private String description;
    private Integer duree;
    private Boolean Status;
    private Date createdAt;
    private Date updatedAt;



    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
}

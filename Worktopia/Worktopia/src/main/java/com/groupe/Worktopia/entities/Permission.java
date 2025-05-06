package com.groupe.Worktopia.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "permission")
@Data
public class Permission {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPermission;
    private Date dateDepermission;
    private String raison;
    private Date dateDeRetour;

    @OneToOne
    @JoinColumn(name = "absence_id")
    private Absence absence;

    public Permission() {
    }

    public Permission(Long idPermission, Date dateDepermission, String raison, Date dateDeRetour, Absence absence) {
        this.idPermission = idPermission;
        this.dateDepermission = dateDepermission;
        this.raison = raison;
        this.dateDeRetour = dateDeRetour;
        this.absence = absence;
    }

}

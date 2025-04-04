package com.groupe.Worktopia.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profil")
//@Table(name = "profil")

public class Profil implements Serializable {

@Serial
    private  static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer profilId;


    private String firstname;
    private String lastname;
    private long numerotelephone;
    private String adresse;
    private String datedenaissance;
    private String genre;
    private byte[] photodeprofil;
    private byte[] cv;

    private Date createdAt;
    private Date updatedAt;// Stocke le CV en base

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


}

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
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profil implements Serializable {

@Serial
    private  static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer profilId;
    @NotEmpty(message = "please fill this!")
    @NotNull(message = "this field couldn't be null")
    private String firstname;
    @NotEmpty(message = "please fill this!")
    @NotNull(message = "this field couldn't be null")
    private String lastname;
    @NotEmpty(message = "please fill this!")
    @NotNull(message = "this field couldn't be null")
    private Integer numerotelephone;
    private String datenaissance;
    private String addresse;
    @Lob
    @Column(name = "cv")
    private byte[] cv;

    private Date createdAt;
    private Date updatedAt;// Stocke le CV en base

@OneToMany(mappedBy = "profil")
    private List<User> users;



}

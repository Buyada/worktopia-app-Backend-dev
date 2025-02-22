package com.groupe.Worktopia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "Users")
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
    private String Username;
    @Lob
    @Column(name = "cv")
    private byte[] cv;  // Stocke le CV en base

    @OneToOne(mappedBy = "profil")
    private User user;

}

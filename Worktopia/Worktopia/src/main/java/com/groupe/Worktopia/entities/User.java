package com.groupe.Worktopia.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.ScrollableResults;
import org.hibernate.event.spi.PreInsertEvent;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User implements Serializable {
    @Serial
    private  static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UserId;
    private  String Firstname;
    private String lastname;
    private String email;
    private String MotdePasse;
    private Date creatAT;
    private  Date updateAt;
    private Boolean statut;

    @ManyToOne
    private UserRole role;

    @OneToOne(cascade = CascadeType.ALL)
    private Profil profil;
    
}

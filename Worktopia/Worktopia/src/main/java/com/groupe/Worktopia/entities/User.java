package com.groupe.Worktopia.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")

public class User implements Serializable {
    @Serial
    private  static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String firstname;
    private String lastname;
    private String email;
    private Integer numeroTelephone;
    private String dateNaissance;
    private String addresse;
    @Lob
    private String motDePasse;
    private Date createdAt;
    private  Date updateAt;


    @ManyToOne
//  @JoinColumn(name = "profil_id")
    private Profil profil;


    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;
}

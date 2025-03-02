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
public class User implements Serializable {
    @Serial
    private  static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @NotEmpty(message = "please fill this!")
    @NotNull(message = "this field couldn't be null")
    private String username;
    @Email(message = "email is not correct !")
private String email;
    private String motdePasse;

    private Date createdAt;
    private  Date updateAt;

//
//@ManyToOne
//    private Profil profil;
//
//@ManyToMany
//    private List<Role> roles;
//
}

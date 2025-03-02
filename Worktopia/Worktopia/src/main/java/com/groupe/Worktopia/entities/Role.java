package com.groupe.Worktopia.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role implements Serializable {
    @Serial
    private  static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer roleId;
    @NotEmpty(message = "please fill this!")
    @NotNull(message = "this field couldn't be null")
    private String name;
    private Date createdAt;
    private  Date updateAt;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}

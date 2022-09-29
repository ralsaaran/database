package com.elm.hackathon.model;

import com.elm.hackathon.model.enums.RoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "role")
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private RoleEnum name;

    public Role(RoleEnum name) {
        this.name = name;
    }
    @JsonIgnore
    @ManyToMany(mappedBy="roles")
    private Set<User> users = new HashSet<>();
}

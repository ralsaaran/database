package com.elm.hackathon.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.elm.hackathon.model.enums.RoleEnum;
import com.elm.hackathon.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "USER")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PK_USER_ID")
  private Long id;
  private String firebaseId;

  private String username;

  private String email;

  private String phoneNumber;

  private Gender gender;

  private String age;

  private String city;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "USER_ROLE",
          joinColumns = @JoinColumn(name = "FK_USER_ID"),
          inverseJoinColumns = @JoinColumn(name = "FK_ROLE_ID"))
  private Set<Role> roles = new HashSet<Role>();




}

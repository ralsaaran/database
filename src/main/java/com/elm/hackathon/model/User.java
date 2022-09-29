package com.elm.hackathon.model;

import java.util.ArrayList;
import java.util.List;

import com.elm.hackathon.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.elm.hackathon.model.enums.Gender;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("USERS")
@JsonIgnoreProperties(value = {"target"})
public class User {

  @Id
  private String id;

  @Indexed(unique = true, sparse = true)
  private String firebaseId;

  private String username;

  @Indexed(unique = true, sparse = true)
  private String email;

  private String phoneNumber;

  private Gender gender;

  private String age;

  private String city;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private List<Role> roleList = new ArrayList<>();


  public User() {
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirebaseId() {
    return firebaseId;
  }

  public void setFirebaseId(String firebaseId) {
    this.firebaseId = firebaseId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public List<Role> getRoleList() {
    return roleList;
  }

  public void addRole(Role role) {
    this.roleList.add(role);
  }

}

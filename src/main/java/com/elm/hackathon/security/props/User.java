package com.elm.hackathon.security.props;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
  @Serial
  private static final long serialVersionUID = 4408418647685225829L;

  private String uid;

  private String name;

  private String email;

  private boolean isEmailVerified;

  private String issuer;

  private String picture;

}

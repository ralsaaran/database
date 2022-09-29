package com.elm.hackathon.security;

import javax.servlet.http.HttpServletRequest;

import com.elm.hackathon.security.props.User;
import com.elm.hackathon.security.props.Credentials;
import com.elm.hackathon.security.props.SecurityProperties;
import com.elm.hackathon.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SecurityService {

  @Autowired
  HttpServletRequest httpServletRequest;

  @Autowired
  CookieUtils cookieUtils;

  @Autowired
  SecurityProperties securityProps;

  public User getUser() {
    User userPrincipal = null;
    SecurityContext securityContext = SecurityContextHolder.getContext();
    Object principal = securityContext.getAuthentication().getPrincipal();
    if (principal instanceof User) {
      userPrincipal = ((User) principal);
    }
    return userPrincipal;
  }

  public Credentials getCredentials() {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    return (Credentials) securityContext.getAuthentication().getCredentials();
  }

  public String getBearerToken(HttpServletRequest request) {
    String bearerToken = null;
    String authorization = request.getHeader("Authorization");
    if (StringUtils.hasText(authorization) && authorization.startsWith("Bearer ")) {
      bearerToken = authorization.substring(7);
    }
    return bearerToken;
  }
}

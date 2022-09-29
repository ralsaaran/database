package com.elm.hackathon.security.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("security")
public class SecurityProperties {

  CookieProperties cookieProps;

  FirebaseProperties firebaseProps;

  boolean allowCredentials;

  public CookieProperties getCookieProps() {
    return cookieProps;
  }

  public void setCookieProps(CookieProperties cookieProps) {
    this.cookieProps = cookieProps;
  }

  public FirebaseProperties getFirebaseProps() {
    return firebaseProps;
  }

  public void setFirebaseProps(FirebaseProperties firebaseProps) {
    this.firebaseProps = firebaseProps;
  }

  public boolean isAllowCredentials() {
    return allowCredentials;
  }

  public void setAllowCredentials(boolean allowCredentials) {
    this.allowCredentials = allowCredentials;
  }
}
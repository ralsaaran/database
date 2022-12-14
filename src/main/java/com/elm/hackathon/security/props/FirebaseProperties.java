package com.elm.hackathon.security.props;

public class FirebaseProperties {

  int sessionExpiryInDays;

  boolean enableStrictServerSession;

  boolean enableCheckSessionRevoked;

  boolean enableLogoutEverywhere;

  public int getSessionExpiryInDays() {
    return sessionExpiryInDays;
  }

  public void setSessionExpiryInDays(int sessionExpiryInDays) {
    this.sessionExpiryInDays = sessionExpiryInDays;
  }

  public boolean isEnableStrictServerSession() {
    return enableStrictServerSession;
  }

  public void setEnableStrictServerSession(boolean enableStrictServerSession) {
    this.enableStrictServerSession = enableStrictServerSession;
  }

  public boolean isEnableCheckSessionRevoked() {
    return enableCheckSessionRevoked;
  }

  public void setEnableCheckSessionRevoked(boolean enableCheckSessionRevoked) {
    this.enableCheckSessionRevoked = enableCheckSessionRevoked;
  }

  public boolean isEnableLogoutEverywhere() {
    return enableLogoutEverywhere;
  }

  public void setEnableLogoutEverywhere(boolean enableLogoutEverywhere) {
    this.enableLogoutEverywhere = enableLogoutEverywhere;
  }
}
package com.elm.hackathon.security;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.elm.hackathon.security.props.SecurityProperties;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class FirebaseConfig {

  @Autowired
  SecurityProperties secProps;

  @Value("${security.config-file}")
  private String configFile;

  @Primary
  @Bean
  public void firebaseInit() {
    InputStream inputStream = new ByteArrayInputStream(configFile.getBytes());
    try {

      FirebaseOptions options = new FirebaseOptions.Builder()
          .setCredentials(GoogleCredentials.fromStream(inputStream))
          .build();

      if (FirebaseApp.getApps().isEmpty()) {
        FirebaseApp.initializeApp(options);
      }
      System.out.println("Firebase Initialize");

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}

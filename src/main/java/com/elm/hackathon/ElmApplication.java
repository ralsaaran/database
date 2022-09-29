package com.elm.hackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ElmApplication {

  public static void main(String[] args) {
    SpringApplication.run(ElmApplication.class, args);
  }

}

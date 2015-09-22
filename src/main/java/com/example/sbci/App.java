package com.example.sbci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.sbci.viewhelper.MyDialect;

@SpringBootApplication
public class App {
  public static void main( String[] args ) {
    SpringApplication.run(App.class, args);
  }

  //THYMELEAF Utility Object
  @Bean
  MyDialect myDialect(){
    return new MyDialect();
  }

}
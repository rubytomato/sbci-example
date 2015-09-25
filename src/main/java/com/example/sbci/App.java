package com.example.sbci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.sbci.viewhelper.MyDialect;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.sbci.domain"})
@EnableJpaRepositories(basePackages = {"com.example.sbci.repository"})
@EnableTransactionManagement(proxyTargetClass = true)
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
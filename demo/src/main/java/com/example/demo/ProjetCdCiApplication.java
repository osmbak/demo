package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.neo4j.driver.Driver;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.demo.repository")
//@ComponentScan("com.example.demo.entity.*")
@EntityScan(basePackages = "com.example.demo.entity")
public class ProjetCdCiApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ProjetCdCiApplication.class, args);

	}
//	final Driver driver;
//
//	public ProjetCdCiApplication(@Autowired Driver driver) {
//		this.driver = driver;
//	}
//
//	public final void run(String... args) {
//		driver.verifyConnectivity();
//	}
}

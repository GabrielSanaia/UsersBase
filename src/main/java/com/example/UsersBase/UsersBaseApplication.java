package com.example.UsersBase;

import com.example.UsersBase.Model.Person;
import com.example.UsersBase.Repository.PersonRepository;
import com.example.UsersBase.Service.PersonService;
import com.example.UsersBase.Service.PersonServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"Repository"})
//@EntityScan(basePackages = {"Model"} )

public class UsersBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersBaseApplication.class, args);
	}
}

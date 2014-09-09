package com.pelican;

import com.pelican.entity.LoginInfo;
import com.pelican.repositories.LoginRepository;
import com.pelican.utils.MD5;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by Nightingale on 29.08.2014.
 */
@Configuration
@EnableAutoConfiguration
//@ComponentScan("com.pelican.repositories")
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        LoginRepository repository = context.getBean(LoginRepository.class);

        // save a couple of customers

        repository.save(new LoginInfo("Jack", MD5.getHash("Jack")));

        // fetch all customers
        Iterable<LoginInfo> customers = repository.findAll();
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (LoginInfo customer : customers) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer by ID
        LoginInfo customer = repository.findOne(1);
        System.out.println("Customer found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(customer);
        System.out.println();

        // fetch customers by last name
        LoginInfo bauers = repository.findByLogin("qwerty");
        System.out.println("Customer found with findByLastName('Bauer'):");
        System.out.println(bauers);
        context.close();
    }
}

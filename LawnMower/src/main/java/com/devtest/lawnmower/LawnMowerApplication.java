package com.devtest.lawnmower;

import com.devtest.lawnmower.service.LawnMowerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.FileNotFoundException;

/**
 * @author Bassam El Khoury
 */
@SpringBootApplication
public class LawnMowerApplication {
    public static void main(String[] args) throws FileNotFoundException {
        ApplicationContext applicationContext = SpringApplication.run(LawnMowerApplication.class, args);

        LawnMowerService lawnMowerService = applicationContext.getBean(LawnMowerService.class);
        lawnMowerService.executeLawnMowerProgram();
    }

}

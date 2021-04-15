package com.devtest.lawnmower;

import com.devtest.lawnmower.service.LawnMowerService;
import com.devtest.lawnmower.service.LawnService;
import com.devtest.lawnmower.service.impl.initializationServiceImpl;
import com.devtest.lawnmower.service.impl.LawnMowerServiceImpl;
import com.devtest.lawnmower.service.impl.LawnServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Bassam El Khoury
 */
@SpringBootApplication
public class LawnMowerApplication {


    public static void main(String[] args) {
        SpringApplication.run(LawnMowerApplication.class, args);

        LawnMowerService lawnMowerService = new LawnMowerServiceImpl();
        LawnService lawnService = new LawnServiceImpl(lawnMowerService);

        initializationServiceImpl initializationServiceImpl =
                new initializationServiceImpl(lawnService, lawnMowerService);

        initializationServiceImpl.run();
    }

}

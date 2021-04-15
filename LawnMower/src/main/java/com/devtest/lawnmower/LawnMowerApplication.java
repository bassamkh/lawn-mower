package com.devtest.lawnmower;

import com.devtest.lawnmower.model.LawnMower;
import com.devtest.lawnmower.model.enums.Direction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Bassam El Khoury
 */
@SpringBootApplication
public class LawnMowerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LawnMowerApplication.class, args);
		LawnMower mower = new LawnMower(1,2, Direction.NORTH);
		System.out.println(mower.getPostion().length);
	}

}

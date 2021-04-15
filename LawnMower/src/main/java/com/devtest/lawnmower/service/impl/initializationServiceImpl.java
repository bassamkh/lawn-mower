package com.devtest.lawnmower.service.impl;

import com.devtest.lawnmower.model.Lawn;
import com.devtest.lawnmower.model.LawnMower;
import com.devtest.lawnmower.model.enums.Direction;
import com.devtest.lawnmower.service.LawnMowerService;
import com.devtest.lawnmower.service.LawnService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Scanner;

/**
 * @author Bassam El Khoury
 */
@Service
@RequiredArgsConstructor
public class initializationServiceImpl {

    @Autowired
    private final LawnService lawnService;
    @Autowired
    private final LawnMowerService lawnMowerService;

    public void run() {
        int count = 0;
        String perimeter = "";
        String lawnMowerParameter = "";
        String commands = "";

        LawnMower lawnMower = null;
        LawnMower resultlawnMower = null;
        Lawn lawn = null;

        try {
            File file = new File("src/main/resources/TextFile");
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (count == 0) {
                    perimeter = data;
                } else if (count % 2 == 1) {
                    lawnMowerParameter = data;
                    lawnMower = createLawnMower(lawnMowerParameter);
                    lawn = createLawn(perimeter, lawnMower);

                } else {
                    commands = data;
                    int[] lawnPerimeter = lawn.getPerimeter();
                    resultlawnMower = this.lawnService.moveLawnMower(lawnPerimeter, lawnMower, commands);
                    this.lawnMowerService.print(resultlawnMower);
                }
                count++;
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private LawnMower createLawnMower(String lawnMowerParameter) {
        String[] parameters = lawnMowerParameter.split(" ");
        int xPosition = Integer.parseInt(parameters[0]);
        int yPosition = Integer.parseInt(parameters[1]);
        Direction direction = Direction.fromValue(parameters[2]);
        return new LawnMower(xPosition, yPosition, direction);
    }

    private Lawn createLawn(String perimeter, LawnMower lawnMower) {
        String[] dimensions = perimeter.split(" ");

        int xAxis = Integer.parseInt(dimensions[0]);
        int yAxis = Integer.parseInt(dimensions[1]);

        return new Lawn(new int[]{xAxis, yAxis}, lawnMower);
    }
}

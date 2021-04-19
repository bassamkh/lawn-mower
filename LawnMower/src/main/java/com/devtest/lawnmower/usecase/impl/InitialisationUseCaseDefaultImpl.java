package com.devtest.lawnmower.usecase.impl;

import com.devtest.lawnmower.model.Lawn;
import com.devtest.lawnmower.model.LawnMower;
import com.devtest.lawnmower.model.enums.Direction;
import com.devtest.lawnmower.usecase.LawnMowerUseCase;
import com.devtest.lawnmower.usecase.LawnUseCase;
import com.devtest.lawnmower.usecase.InitialisationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Bassam El Khoury
 */
@Component
@RequiredArgsConstructor
public class InitialisationUseCaseDefaultImpl implements InitialisationUseCase {

    private final LawnUseCase lawnUseCase;
    private final LawnMowerUseCase lawnMowerUseCase;

    @Override
    public List readFromFileAndCompute(String filePath) throws FileNotFoundException {
        int count = 0;
        String perimeter = "";
        List<String> finalPosition = new ArrayList();
        Lawn lawn = null;

        try {
            File file = new File(filePath);
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                perimeter = mapPerimeter(count, data, perimeter);
                lawn = mapLawn(count, data, perimeter, lawn);
                finalPosition = setFinalPosition(count, data, lawn, finalPosition);
                count++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            throw e;
        }
        return finalPosition;
    }

    private String mapPerimeter(int count, String data, String perimeter) {
        if (count == 0) {
            //first line is the perimeter of the lawn line
            return data;
        }
        return perimeter;
    }

    private Lawn mapLawn(int count, String data, String perimeter, Lawn lawn) {
        if (count % 2 == 1) {
            //This is the initial position of the lawnmower line
            LawnMower lawnMower = createLawnMower(data);
            lawn = createLawn(perimeter, lawnMower);
        }
        return lawn;
    }

    private List<String> setFinalPosition(int count, String commands, Lawn lawn, List<String> finalPosition) {
        if (count != 0 && count % 2 == 0) {
            //This is the list of commands line
            int[] lawnPerimeter = lawn.getPerimeter();
            LawnMower resultLawnMower = this.lawnUseCase.moveLawnMower(lawnPerimeter, lawn.getLawnMower(), commands);
            finalPosition.add(this.lawnMowerUseCase
                    .returnLawnMowerPositionAndDirection(resultLawnMower));
            return finalPosition;
        }
        return finalPosition;
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

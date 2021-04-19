package com.devtest.lawnmower.usecase.impl;

import com.devtest.lawnmower.model.LawnMower;
import com.devtest.lawnmower.model.enums.Direction;
import com.devtest.lawnmower.model.enums.Rotation;
import com.devtest.lawnmower.usecase.LawnMowerUseCase;
import com.devtest.lawnmower.usecase.LawnUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Bassam El Khoury
 */
@Component
@RequiredArgsConstructor
public class LawnUseCaseDefaultImpl implements LawnUseCase {

    private final LawnMowerUseCase lawnMowerUseCase;

    @Override
    public LawnMower moveLawnMower(int[] perimeter, LawnMower lawnMower, String commands) {
        String[] commandList = commands.split("");
        for (String command : commandList) {
            if (this.checkIfRotation(command)) {
                Rotation rotationCommand = Rotation.fromValue(command);
                Direction newDirection = lawnMowerUseCase.rotate(lawnMower.getDirection(), rotationCommand);
                lawnMower.setDirection(newDirection);
            } else {
                lawnMower = this.advance(perimeter, lawnMower);
            }
        }
        return lawnMower;
    }

    private LawnMower advance(int[] perimeter, LawnMower lawnMower) {
        int xPosition = lawnMower.getPosition()[0];
        int yPosition = lawnMower.getPosition()[1];
        Direction direction = lawnMower.getDirection();

        if (direction.equals(Direction.EAST) || direction.equals(Direction.WEST)) {
            xPosition = this.calculatePosition(perimeter[0], xPosition, direction);
            lawnMower.setPosition(new int[]{xPosition, yPosition});
        } else {
            yPosition = this.calculatePosition(perimeter[1], yPosition, direction);
            lawnMower.setPosition(new int[]{xPosition, yPosition});
        }
        return lawnMower;
    }

    private int calculatePosition(int perimeter, int position, Direction direction) {
        int newPosition = position + direction.getMovement();
        if (newPosition < 0 || newPosition > perimeter + 1) {
            return position;
        } else {
            return newPosition;
        }
    }

    private boolean checkIfRotation(String command) {
        Rotation[] availableRotations = Rotation.values();
        boolean isRotation = false;
        for (Rotation rotation : availableRotations) {
            if (rotation.getType().equalsIgnoreCase(command)) {
                isRotation = true;
                break;
            }
        }
        return isRotation;
    }

}

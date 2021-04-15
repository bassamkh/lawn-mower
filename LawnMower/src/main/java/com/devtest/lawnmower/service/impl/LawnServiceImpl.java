package com.devtest.lawnmower.service.impl;

import com.devtest.lawnmower.model.LawnMower;
import com.devtest.lawnmower.model.enums.Direction;
import com.devtest.lawnmower.model.enums.Rotation;
import com.devtest.lawnmower.service.LawnMowerService;
import com.devtest.lawnmower.service.LawnService;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Bassam El Khoury
 */
@RequiredArgsConstructor
public class LawnServiceImpl implements LawnService {

    private final LawnMowerService lawnMowerService;

    @Override
    public LawnMower moveLawnMower(int[] perimeter, LawnMower lawnMower, List<String> commands) {
        for (String command : commands) {
            if (this.checkIfRotation(command)) {
                Rotation rotationCommand = Rotation.fromValue(command);
                Direction newDirection = lawnMowerService.rotate(lawnMower.getDirection(), rotationCommand);
                lawnMower.setDirection(newDirection);
            } else {
                this.advance(perimeter, lawnMower);
            }
        }
        return lawnMower;
    }

    private void advance(int[] perimeter, LawnMower lawnMower) {
        int xPosition = lawnMower.getPostion()[0];
        int yPosition = lawnMower.getPostion()[1];
        Direction direction = lawnMower.getDirection();

        if (direction.equals(Direction.EAST) || direction.equals(Direction.WEST)) {
            xPosition = this.calculatePosition(perimeter[0], yPosition, direction);
            lawnMower.setPostion(new int[]{xPosition, yPosition});
        } else {
            yPosition = this.calculatePosition(perimeter[1], xPosition, direction);
            lawnMower.setPostion(new int[]{xPosition, yPosition});
        }
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

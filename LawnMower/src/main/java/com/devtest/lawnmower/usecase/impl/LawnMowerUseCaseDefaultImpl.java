package com.devtest.lawnmower.usecase.impl;

import com.devtest.lawnmower.model.LawnMower;
import com.devtest.lawnmower.model.enums.Direction;
import com.devtest.lawnmower.model.enums.Rotation;
import com.devtest.lawnmower.usecase.LawnMowerUseCase;
import org.springframework.stereotype.Component;

/**
 * @author Bassam El Khoury
 */
@Component
public class LawnMowerUseCaseDefaultImpl implements LawnMowerUseCase {

    /**
     * {@inheritDoc}
     */
    @Override
    public Direction rotate(Direction direction, Rotation rotation) {
        Direction newDirection = null;
        switch (rotation) {
            case DROITE:
                newDirection = direction.getRight();
                break;
            case GAUCHE:
                newDirection = direction.getLeft();
                break;
        }
        return newDirection;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String returnLawnMowerPositionAndDirection(LawnMower lawnMower) {

        return lawnMower.getPosition()[0] +
                " " +
                lawnMower.getPosition()[1] +
                " " +
                lawnMower.getDirection().getType();
    }

}

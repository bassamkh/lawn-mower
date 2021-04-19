package com.devtest.lawnmower.usecase;

import com.devtest.lawnmower.model.LawnMower;
import com.devtest.lawnmower.model.enums.Direction;
import com.devtest.lawnmower.model.enums.Rotation;

/**
 * @author Bassam El Khoury
 */
public interface LawnMowerUseCase {
    /**
     * Rotates the Lawnmower to its desired direction
     *
     * @param direction current direction that the lawnmower is facing.
     * @param rotation  rotation that will be executed.
     * @return The new direction of the lawnmower after rotation.
     */
    Direction rotate(Direction direction, Rotation rotation);

    /**
     * Takes the Lawn mower object and return its parameters as a string.
     *
     * @param lawnMower Final lawn mower with the a new position
     * @return the new position in string.
     */
    String returnLawnMowerPositionAndDirection(LawnMower lawnMower);

}

package com.devtest.lawnmower.service;

import com.devtest.lawnmower.model.enums.Direction;
import com.devtest.lawnmower.model.enums.Rotation;

/**
 * @author Bassam El Khoury
 */
public interface LawnMowerService {
    /**
     * Rotates the Lawnmower to its desired direction
     *
     * @param direction current direction that the lawnmower is facing.
     * @param rotation  rotation that will be executed.
     * @return The new direction of the lawnmower after rotation.
     */
    Direction rotate(Direction direction, Rotation rotation);
}

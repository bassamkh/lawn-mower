package com.devtest.lawnmower.service.impl;

import com.devtest.lawnmower.model.enums.Direction;
import com.devtest.lawnmower.model.enums.Rotation;
import com.devtest.lawnmower.service.LawnMowerService;
import org.springframework.stereotype.Service;

/**
 * @author Bassam El Khoury
 */
@Service
public class LawnMowerServiceImpl implements LawnMowerService {

    /**
     * {@inheritDoc}
     */
    @Override
    public Direction rotate(Direction direction, Rotation rotation) {
        Direction newDirection;
        switch (rotation) {
            case DROITE:
                newDirection = direction.getRight();
                break;
            case GAUCHE:
                newDirection = direction.getLeft();
                break;
            default:
                newDirection = null;
                break;
        }
        return newDirection;
    }

}

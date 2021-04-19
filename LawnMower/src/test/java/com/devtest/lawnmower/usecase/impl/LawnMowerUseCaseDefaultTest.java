package com.devtest.lawnmower.usecase.impl;

import com.devtest.lawnmower.model.enums.Direction;
import com.devtest.lawnmower.model.enums.Rotation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author Bassam El Khoury
 */
@RunWith(MockitoJUnitRunner.class)
public class LawnMowerUseCaseDefaultTest {

    @InjectMocks
    private LawnMowerUseCaseDefaultImpl lawnMowerUseCase;

    @Test
    public void whenRotateLeftFromNorth_isOk() {
        Direction result = lawnMowerUseCase.rotate(Direction.NORTH, Rotation.GAUCHE);

        Assert.assertEquals(Direction.WEST, result);
    }

    @Test
    public void whenRotateLeft_isOk() {
        Direction result = lawnMowerUseCase.rotate(Direction.WEST, Rotation.GAUCHE);

        Assert.assertEquals(Direction.SOUTH, result);
    }

    @Test
    public void whenRotateRightFromWest_isOk() {
        Direction result = lawnMowerUseCase.rotate(Direction.WEST, Rotation.DROITE);

        Assert.assertEquals(Direction.NORTH, result);
    }

    @Test
    public void whenRotateRightFrom_isOk() {
        Direction result = lawnMowerUseCase.rotate(Direction.EAST, Rotation.DROITE);

        Assert.assertEquals(Direction.SOUTH, result);
    }
}

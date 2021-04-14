package com.devtest.LawnMower.service.impl;

import com.devtest.LawnMower.model.enums.Direction;
import com.devtest.LawnMower.model.enums.Rotation;
import com.devtest.LawnMower.service.LawnMowerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author Bassam El Khoury
 */
@RunWith(MockitoJUnitRunner.class)
public class LawnMowerServiceTest {

    LawnMowerService lawnMowerService;

    @Before
    public void setup() {
        lawnMowerService = new LawnMowerServiceImpl();
    }

    @Test
    public void whenRotateLeftFromNorth_isOk(){
        Direction result = lawnMowerService.rotate(Direction.NORTH, Rotation.GAUCHE);

        Assert.assertEquals(Direction.WEST, result);
    }

    @Test
    public void whenRotateLeft_isOk(){
        Direction result = lawnMowerService.rotate(Direction.WEST, Rotation.GAUCHE);

        Assert.assertEquals(Direction.SOUTH, result);
    }

    @Test
    public void whenRotateRightFromWest_isOk(){
        Direction result = lawnMowerService.rotate(Direction.WEST, Rotation.DROITE);

        Assert.assertEquals(Direction.NORTH, result);
    }

    @Test
    public void whenRotateRightFrom_isOk(){
        Direction result = lawnMowerService.rotate(Direction.EAST, Rotation.DROITE);

        Assert.assertEquals(Direction.SOUTH, result);
    }
}
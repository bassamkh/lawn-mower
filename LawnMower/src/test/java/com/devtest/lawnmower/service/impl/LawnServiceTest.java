package com.devtest.lawnmower.service.impl;

import com.devtest.lawnmower.model.LawnMower;
import com.devtest.lawnmower.model.enums.Direction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author Bassam El Khoury
 */
@RunWith(MockitoJUnitRunner.class)
public class LawnServiceTest {

    @InjectMocks
    private LawnServiceImpl lawnService;

    private LawnMower lawnMower;
    private String command;
    private int[] perimeter;

    @Before
    public void setup() {
        this.perimeter = new int[]{5,5};
        this.command = "A";
        this.lawnMower = new LawnMower(1,2, Direction.NORTH);
    }

    @Test
    public void whenMoveLawnMower_advanceFromNorth_isOk() {

        LawnMower result = lawnService.moveLawnMower(this.perimeter,this.lawnMower, this.command);
        LawnMower expectedLawnMower = new LawnMower(1,3,Direction.NORTH);

        Assert.assertNotNull(result);
        Assert.assertEquals(expectedLawnMower.getDirection(), result.getDirection());
        Assert.assertEquals(expectedLawnMower.getPosition()[0], result.getPosition()[0]);
        Assert.assertEquals(expectedLawnMower.getPosition()[1], result.getPosition()[1]);
        Assert.assertEquals(expectedLawnMower, result);
    }

    @Test
    public void whenMoveLawnMower_advanceFromEast_isOk() {
        this.lawnMower.setDirection(Direction.EAST);
        LawnMower result = lawnService.moveLawnMower(this.perimeter,this.lawnMower, this.command);
        LawnMower expectedLawnMower = new LawnMower(2,2,Direction.EAST);

        Assert.assertNotNull(result);
        Assert.assertEquals(expectedLawnMower.getDirection(), result.getDirection());
        Assert.assertEquals(expectedLawnMower.getPosition()[0], result.getPosition()[0]);
        Assert.assertEquals(expectedLawnMower.getPosition()[1], result.getPosition()[1]);
        Assert.assertEquals(expectedLawnMower, result);
    }

    @Test
    public void whenMoveLawnMower_advanceFromSouth_isOk() {
        this.lawnMower.setDirection(Direction.SOUTH);
        LawnMower result = lawnService.moveLawnMower(this.perimeter,this.lawnMower, this.command);
        LawnMower expectedLawnMower = new LawnMower(1,1,Direction.SOUTH);

        Assert.assertNotNull(result);
        Assert.assertEquals(expectedLawnMower.getDirection(), result.getDirection());
        Assert.assertEquals(expectedLawnMower.getPosition()[0], result.getPosition()[0]);
        Assert.assertEquals(expectedLawnMower.getPosition()[1], result.getPosition()[1]);
        Assert.assertEquals(expectedLawnMower, result);
    }

    @Test
    public void whenMoveLawnMower_advanceFromWest_isOk() {
        this.lawnMower.setDirection(Direction.WEST);
        LawnMower result = lawnService.moveLawnMower(this.perimeter,this.lawnMower, this.command);
        LawnMower expectedLawnMower = new LawnMower(0,2,Direction.WEST);

        Assert.assertNotNull(result);
        Assert.assertEquals(expectedLawnMower.getDirection(), result.getDirection());
        Assert.assertEquals(expectedLawnMower.getPosition()[0], result.getPosition()[0]);
        Assert.assertEquals(expectedLawnMower.getPosition()[1], result.getPosition()[1]);
        Assert.assertEquals(expectedLawnMower, result);
    }

    @Test
    public void whenMoveLawnMower_advanceFromNorth_isOutOfBound() {
        this.lawnMower.setPosition(new int[]{1,6});
        LawnMower result = lawnService.moveLawnMower(this.perimeter,this.lawnMower, this.command);
        LawnMower expectedLawnMower = new LawnMower(1,6,Direction.NORTH);

        Assert.assertNotNull(result);
        Assert.assertEquals(expectedLawnMower.getDirection(), result.getDirection());
        Assert.assertEquals(expectedLawnMower.getPosition()[0], result.getPosition()[0]);
        Assert.assertEquals(expectedLawnMower.getPosition()[1], result.getPosition()[1]);
        Assert.assertEquals(expectedLawnMower, result);
    }

    @Test
    public void whenMoveLawnMower_advanceFromEast_isOutOfBound() {
        this.lawnMower.setDirection(Direction.EAST);
        this.lawnMower.setPosition(new int[]{6,1});
        LawnMower result = lawnService.moveLawnMower(this.perimeter,this.lawnMower, this.command);
        LawnMower expectedLawnMower = new LawnMower(6,1,Direction.EAST);

        Assert.assertNotNull(result);
        Assert.assertEquals(expectedLawnMower.getDirection(), result.getDirection());
        Assert.assertEquals(expectedLawnMower.getPosition()[0], result.getPosition()[0]);
        Assert.assertEquals(expectedLawnMower.getPosition()[1], result.getPosition()[1]);
        Assert.assertEquals(expectedLawnMower, result);
    }

    @Test
    public void whenMoveLawnMower_advanceFromSouth_isOutOfBound() {
        this.lawnMower.setDirection(Direction.SOUTH);
        this.lawnMower.setPosition(new int[]{6,0});
        LawnMower result = lawnService.moveLawnMower(this.perimeter,this.lawnMower, this.command);
        LawnMower expectedLawnMower = new LawnMower(6,0,Direction.SOUTH);

        Assert.assertNotNull(result);
        Assert.assertEquals(expectedLawnMower.getDirection(), result.getDirection());
        Assert.assertEquals(expectedLawnMower.getPosition()[0], result.getPosition()[0]);
        Assert.assertEquals(expectedLawnMower.getPosition()[1], result.getPosition()[1]);
        Assert.assertEquals(expectedLawnMower, result);
    }

    @Test
    public void whenMoveLawnMower_advanceFromWest_isOutOfBound() {
        this.lawnMower.setDirection(Direction.WEST);
        this.lawnMower.setPosition(new int[]{0,0});
        LawnMower result = lawnService.moveLawnMower(this.perimeter,this.lawnMower, this.command);
        LawnMower expectedLawnMower = new LawnMower(0,0,Direction.WEST);

        Assert.assertNotNull(result);
        Assert.assertEquals(expectedLawnMower.getDirection(), result.getDirection());
        Assert.assertEquals(expectedLawnMower.getPosition()[0], result.getPosition()[0]);
        Assert.assertEquals(expectedLawnMower.getPosition()[1], result.getPosition()[1]);
        Assert.assertEquals(expectedLawnMower, result);
    }

}

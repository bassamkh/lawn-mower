package com.devtest.LawnMower.model;

import com.devtest.LawnMower.model.enums.Direction;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Bassam El Khoury
 */
@Getter
@Setter
public class LawnMower {
    private int[] postion;
    private Direction direction;

    public LawnMower(int xPosition, int yPosition, Direction direction) {
        this.postion = new int[] {xPosition, yPosition};
        this.direction = direction;
    }

}

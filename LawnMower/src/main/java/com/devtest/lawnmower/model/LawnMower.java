package com.devtest.lawnmower.model;

import com.devtest.lawnmower.model.enums.Direction;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Bassam El Khoury
 */
@Getter
@Setter
@EqualsAndHashCode
public class LawnMower {
    private int[] position;
    private Direction direction;

    public LawnMower(int xPosition, int yPosition, Direction direction) {
        this.position = new int[]{xPosition, yPosition};
        this.direction = direction;
    }

}

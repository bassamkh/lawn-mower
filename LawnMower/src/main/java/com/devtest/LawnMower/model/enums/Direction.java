package com.devtest.LawnMower.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author Bassam El Khoury
 */
@Getter
@AllArgsConstructor
public enum Direction {
    NORTH("N",0,1),
    SOUTH("S",2,-1),
    EAST("E",1,1),
    WEST("W",3,-1);

    private String Type;
    private final int order;
    private final int movement;

    public Direction getRight(){
        if(this.equals(Direction.WEST))
            return NORTH;
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.order == this.order + 1)
                .findFirst()
                .orElse(null);
    }

    public Direction getLeft(){
        if(this.equals(Direction.NORTH))
            return WEST;
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.order == this.order - 1)
                .findFirst()
                .orElse(null);
    }

}

package com.devtest.LawnMower.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum Direction {
    N(1),S(3),E(2),W(4);

    private final int order;

    public List<Direction> getAvaliableDirections(){
        return Arrays.stream(Direction.values())
                .sorted(Comparator.comparingInt(Direction::getOrder))
                .collect(Collectors.toList());
    }

}

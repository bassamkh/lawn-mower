package com.devtest.LawnMower.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Lawn {
    private int[][]perimeter;
    private List<LawnMower> lawnMowers;
}

package com.devtest.LawnMower.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Bassam El Khoury
 */
@Getter
@Setter
@AllArgsConstructor
public class Lawn {
    private int[]perimeter;
    private List<LawnMower> lawnMowers;
}

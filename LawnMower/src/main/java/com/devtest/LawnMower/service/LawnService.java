package com.devtest.LawnMower.service;

import com.devtest.LawnMower.model.LawnMower;

import java.util.List;

/**
 * @author Bassam El Khoury
 */
public interface LawnService {

    /**
     *
     * @param perimeter perimeter of the Lawn
     * @param lawnMower the lawnmower that will be moving on the lawm
     * @param commands the commands gived for the lawnmower to follow
     * @return the new position and direction of the lawnmower after executing the commands
     */
    LawnMower moveLawnMower(int[] perimeter, LawnMower lawnMower, List<String> commands);
}

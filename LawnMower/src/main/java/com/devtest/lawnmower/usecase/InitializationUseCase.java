package com.devtest.lawnmower.usecase;

import java.util.List;

/**
 * @author Bassam El Khoury
 */
public interface InitializationUseCase {
    /**
     * Reads input from file and runs all the business logic to print
     * the final position and direction of the lawnmower.
     */
    List run();
}

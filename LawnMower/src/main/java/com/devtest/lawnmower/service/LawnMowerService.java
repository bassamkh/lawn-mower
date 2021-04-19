package com.devtest.lawnmower.service;

import com.devtest.lawnmower.usecase.InitialisationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author Bassam El Khoury
 */
@Service
@Configurable
@RequiredArgsConstructor
public class LawnMowerService {

    public static final String TEXT_FILE_PATH = "src/main/resources/TextFile";

    private final InitialisationUseCase initialisationUseCase;

    public void executeLawnMowerProgram() throws FileNotFoundException {

        List result = this.initialisationUseCase.readFromFileAndCompute(TEXT_FILE_PATH);
        result.stream().forEach(System.out::println);
    }
}

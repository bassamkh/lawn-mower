package com.devtest.lawnmower.usecase.impl;

import com.devtest.lawnmower.model.LawnMower;
import com.devtest.lawnmower.model.enums.Direction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author Bassam El Khoury
 */
@RunWith(MockitoJUnitRunner.class)
public class InitialisationUseCaseDefaultTest {

    @InjectMocks
    private InitialisationUseCaseDefaultImpl initializationUseCaseDefault;

    @Mock
    private LawnUseCaseDefaultImpl lawnUseCase;

    @Mock
    private LawnMowerUseCaseDefaultImpl lawnMowerUseCase;

    private final String testFilePath = "src/test/java/resources/TestFile";
    private final String emptyTestFilePath = "src/test/java/resources/EmptyFileTest";

    @Test(expected = IOException.class)
    public void whenRun_fileNotFound() throws IOException {
        String path = "ddd";
        initializationUseCaseDefault.readFromFileAndCompute(path);
    }

    @Test
    public void whenRun_FileFound() throws FileNotFoundException {
        LawnMower lawnMower = new LawnMower(0, 2, Direction.WEST);
        List<String> finalPosition = new ArrayList(Collections.singleton("0 2 W"));
        when(this.lawnUseCase.moveLawnMower(any(), any(), any())).thenReturn(lawnMower);
        when(this.lawnMowerUseCase.returnLawnMowerPositionAndDirection(lawnMower)).thenReturn(finalPosition.get(0));
        List list = initializationUseCaseDefault.readFromFileAndCompute(testFilePath);
        Assert.assertNotNull(list);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(finalPosition, list);

    }

    @Test
    public void whenRun_EmptyFile() throws FileNotFoundException {
        List list = initializationUseCaseDefault.readFromFileAndCompute(emptyTestFilePath);
        Assert.assertTrue(list.isEmpty());

    }
}

package com.techreturners.cinnamon_cinemas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CinemaTest {

    @Test
    public void checkEmptyStringReturnTest(){
        //Arrange
        Cinema cinemaApp = new Cinema(3,5);

        //Act
        String result = cinemaApp.allocateSeats(0);

        //Assert
        Assertions.assertEquals(" ", result);
    }

    @Test
    public void checkIfRowsAndColumnsRightTest(){
        //Arrange
        Cinema cinemaApp = new Cinema(3,5);

        //Act
        int rows = cinemaApp.getRows();
        int cols = cinemaApp.getColumns();

        //Assert
        Assertions.assertEquals(3, rows);
        Assertions.assertEquals(5, cols);
    }

    @Test
    public void checkAllocateSeatFirstTest(){
        //Arrange
        Cinema cinemaApp = new Cinema(3,5);
        int userInput = 2;

        //Act
        String result = cinemaApp.allocateSeats(userInput);

        //Assert
        Assertions.assertEquals("Allocated", result);
    }

    @Test
    public void checkIfSeatGridArrayInitializedtoEmptyTest(){
        //Arrange
        Cinema cinemaApp = new Cinema(3,5);
        String[][] actualStringArr = new String[3][5];
        String[][] expectedStringArr = {{"0", "0", "0", "0", "0"},
                                        {"0", "0", "0", "0", "0"},
                                        {"0", "0", "0", "0", "0"}
                                        };
        //Assert
        Assertions.assertArrayEquals(expectedStringArr,
                                        cinemaApp.initializeSeatsGrid(actualStringArr),
                                "Assertion failed as the two array values didn’t match");
    }
}

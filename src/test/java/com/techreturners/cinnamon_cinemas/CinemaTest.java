package com.techreturners.cinnamon_cinemas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CinemaTest {

    @Test
    public void checkEmptyStringReturnTest(){
        //Arrange
        Cinema cinemaApp = new Cinema(3,5);

        //Act
        String expectedResult = cinemaApp.allocateSeats();

        //Assert
        Assertions.assertEquals(" ", expectedResult);
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
}

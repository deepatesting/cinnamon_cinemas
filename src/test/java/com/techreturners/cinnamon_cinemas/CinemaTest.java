package com.techreturners.cinnamon_cinemas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CinemaTest {

    @Test
    public void checkFirstTest(){
        //Arrange
        Cinema cinemaApp = new Cinema();

        //Act
        String expectedResult = cinemaApp.allocateSeats();

        //Assert
        Assertions.assertEquals("Allocated", expectedResult);
    }

}

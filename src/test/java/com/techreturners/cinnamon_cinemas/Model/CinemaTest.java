package com.techreturners.cinnamon_cinemas.Model;

import com.techreturners.cinnamon_cinemas.Model.Cinema;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class CinemaTest {

    Cinema cinemaApp;
    String[][] actualStringArr;
    String result = " ";
    int row = 3;
    int col = 5;

    @BeforeEach
    public void testSetUp(){
        actualStringArr = new String[row][col];
        cinemaApp = new Cinema(row, col);

        cinemaApp.initializeSeatsGrid(actualStringArr);
    }

    @DisplayName("Check for return empty string - first test")
    @Disabled
    @Test
    public void checkEmptyStringReturnTest(){
        //Act
        result = cinemaApp.allocateSeats(actualStringArr,0);

        //Assert
        Assertions.assertEquals(" ", result);
    }

    @DisplayName("Check if rows and columns number right")
    @Test
    public void checkIfRowsAndColumnsRightTest(){
        //Arrange
        int rows = 0;
        int cols = 0;

        //Act
        rows = cinemaApp.getRows();
        cols = cinemaApp.getColumns();

        //Assert
        Assertions.assertEquals(3, rows);
        Assertions.assertEquals(5, cols);
    }

    @DisplayName("Check if success after allocation")
    @Test
    public void checkAllocateSeatTestSuccess(){
        //Arrange
        int userInput = 2;

        //Act
        result = cinemaApp.allocateSeats(actualStringArr, userInput);

        //Assert
        Assertions.assertEquals("Allocated", result);
    }

    @DisplayName("Check if SeatGrid Array Initialized to 0(Empty)")
    @Test
    public void checkIfSeatGridArrayInitializedToEmptyTest(){
        //Arrange
        String[][] expectedStringArr = {{"0", "0", "0", "0", "0"},
                                        {"0", "0", "0", "0", "0"},
                                        {"0", "0", "0", "0", "0"}
                                        };
        //Assert
        //cinemaApp.initializeSeatsGrid(actualStringArr);
        Assertions.assertArrayEquals(expectedStringArr,
                cinemaApp.initializeSeatsGrid(actualStringArr),
                                "Assertion failed as the two array values did n’t match");
    }

    @DisplayName("Check if Cinema Theatre has open spaces")
    @Test
    public void checkIfCinemaHasOpenSeats(){
        //Arrange
        String[][] inputStrArr = {{"X", "X", "X", "X", "X"},
                                        {"X", "X", "X", "X", "X"},
                                        {"X", "X", "X","0", "0",}
                                        };
        Assertions.assertTrue(cinemaApp.hasOpenSeats(inputStrArr));
    }

    @DisplayName("Check if success after allocation for user input in range")
    @Test
    public void checkAllocateSeatTestInput3(){
        //Arrange
        int userInput = 3;

        //Act
        result = cinemaApp.allocateSeats(actualStringArr, userInput);

        //Assert
        Assertions.assertEquals("Allocated", result);
    }

    @DisplayName("Check if user input value not within range")
    @ParameterizedTest
    @CsvSource(value = {"0","-1","4"})
    public void checkAllocateSeatTestInput4Fail(int userInput){
        //Act
        result = cinemaApp.allocateSeats(actualStringArr, userInput);

        //Assert
        Assertions.assertEquals("Not valid input request", result);
    }

    @ParameterizedTest
    @CsvSource(value = {"3, 5",
                        "2, 4"
                        }, delimiter = ',')
    public void checkForMoreSeatsAllocated(int randomInput, int times){

        for(int i=0; i<times; i++)
            result = cinemaApp.allocateSeats(actualStringArr, randomInput);
        Assertions.assertEquals("Allocated", result);

    }

    @ParameterizedTest
    @CsvSource(value = {"3, 6",
                        "2, 9"
                        })
    public void checkForNotEnoughSpace(int randomInput, int times){

        for(int i=1; i<=times; i++)
            result = cinemaApp.allocateSeats(actualStringArr, randomInput);
        Assertions.assertEquals("Not enough space left!", result);

    }
}

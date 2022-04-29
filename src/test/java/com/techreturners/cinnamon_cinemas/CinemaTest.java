package com.techreturners.cinnamon_cinemas;

import org.junit.jupiter.api.*;


public class CinemaTest {

    Cinema cinemaApp;
    String[][] actualStringArr;
    String result;

    @BeforeEach
    public void testSetUp(){
        cinemaApp = new Cinema(3,5);
        actualStringArr = new String[3][5];
    }

    @DisplayName("Check for return empty string - first test")
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
        Assertions.assertArrayEquals(expectedStringArr,
                                        cinemaApp.initializeSeatsGrid(actualStringArr),
                                "Assertion failed as the two array values didn’t match");
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

    @DisplayName("Check for return empty if user input value not within range")
    @Test
    public void checkAllocateSeatTestInput4Fail(){
        //Arrange
        int userInput = 4;

        //Act
        result = cinemaApp.allocateSeats(actualStringArr, userInput);

        //Assert
        Assertions.assertEquals(" ", result);
    }
}

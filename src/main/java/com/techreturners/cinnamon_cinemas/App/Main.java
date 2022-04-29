package com.techreturners.cinnamon_cinemas.App;

import com.techreturners.cinnamon_cinemas.Model.Cinema;

import java.util.Scanner;

public class Main {

    final int ROW = 3;
    final int COL = 5;
    private Scanner inputScanner;
    private String[][] seatAllocArray = new String[ROW][COL];
    private Cinema cinema;

    public void gridDisplay(String[][] seatAllocArray) {

        String[] ROWARRY = cinema.getROWS();

        System.out.println();
        System.out.println("   1   2   3   4   5  ");
        for (int i = 0; i < seatAllocArray.length; i++) {
            System.out.println("----------------------");
            for (int j = 0; j < seatAllocArray[i].length; j++) {
                if(j==0)
                    System.out.print(ROWARRY[i] + "| ");
                if(seatAllocArray[i][j].equals("0"))
                    System.out.printf("%s", "0");
                else
                    System.out.printf("%s", seatAllocArray[i][j]);
                if (j < seatAllocArray[i].length - 1) {
                    System.out.print(" | ");
                }
                if(j==(seatAllocArray[i].length - 1))
                    System.out.print(" |");
            }
            System.out.println();
        }
        System.out.println("----------------------\n");
    }

    public void seatAllocation() {

        String yesOrNo = "Y";
        int inputNum = 0;

        inputScanner = new Scanner(System.in);

        System.out.println("\n****Welcome to Cinnamon Cinemas Theatre****");
        System.out.println("\nSeats are available for you to book now.");
        System.out.print("\nDo you like to make a booking enter 'Y', otherwise enter 'N':");
        yesOrNo = inputScanner.next();

        if(yesOrNo.equals("Y")) {

            //Call cinema class and initialize the array
            cinema = new Cinema(ROW,COL);
            seatAllocArray = cinema.initializeSeatsGrid(seatAllocArray);

            //Display grid before allocation
            gridDisplay(seatAllocArray);

            do{
                System.out.print("Now enter number of seats between 1 and 3: ");
                inputNum = inputScanner.nextInt();

                if((inputNum >= 1) && (inputNum <=3)) {

                    //Seats allocation if seats available
                    String msg = cinema.allocateSeats(seatAllocArray, inputNum);
                    System.out.println(msg);

                    //Display grid after allocation
                    gridDisplay(seatAllocArray);
                }
                else
                    System.out.println("Oops, you entered number out of range. Try again!!");

            } while(cinema.hasOpenSeats(seatAllocArray));

            if(!cinema.hasOpenSeats(seatAllocArray))
                System.out.println("!!Full!! No seats left.");

        } else
            System.out.println("\nThank you. Visit us again!!");
    }

    public static void main(String[] args) {
        Main userInput = new Main();
        userInput.seatAllocation();
    }
}

package com.techreturners.cinnamon_cinemas.Model;

public class Cinema {

    private int rows = 0;
    private int columns = 0;
    private final static String EMPTY_SEAT = "0";
    private final String[] ROWS = {"A", "B", "C"};
    private final String[] COLS = {"1", "2", "3", "4", "5"};
    private String[][] seatsGrid;

    public Cinema(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.seatsGrid = new String[rows][columns];
    }

    public int getColumns() {
        return columns;
    }

    public String[] getROWS() {
        return ROWS;
    }

    public String[] getCOLS() {
        return COLS;
    }

    public int getRows() {
        return rows;
    }

    public String[][] getSeatsGrid() {
        return seatsGrid;
    }

    public void setSeatsGrid(String[][] seatsGrid) {
        this.seatsGrid = seatsGrid;
    }

    public boolean hasOpenSeats(String[][] seatsGrid){

        for(int row = 0 ; row < seatsGrid.length; row++)
            for(int col = 0; col < seatsGrid[row].length; col++)
                if(seatsGrid[row][col].equals(EMPTY_SEAT))
                    return true;
        return false;
    }

    public String[][] initializeSeatsGrid(String[][] seatsGrid){

        for(int row = 0 ; row < seatsGrid.length; row++)
            for(int col = 0; col < seatsGrid[row].length; col++)
                seatsGrid[row][col] = EMPTY_SEAT;
        return seatsGrid;
    }

    public String allocateSeats(String[][] seatsGrid, int numSeats){

        if((numSeats >= 1) && (numSeats <=3)) {
            if(hasOpenSeats(seatsGrid)) {
                    for(int row = 0 ; row < seatsGrid.length; row++)
                        for(int col = 0; col < seatsGrid[row].length; col++)
                            if(seatsGrid[row][col].equals("0") && (numSeats > 0)) {
                                seatsGrid[row][col] = "X";
                                numSeats--;
                            }
                    setSeatsGrid(seatsGrid);
                return "Allocated";
            }
            else
                return "Not enough space left!";
        } else
            return "Not valid input request";
    }

}

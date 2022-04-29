package com.techreturners.cinnamon_cinemas;

public class Cinema {

    private int rows = 0;
    private int columns = 0;
    private final static String[] ROWS = {"A", "B", "C"};
    private final static String[] COLS = {"1", "2", "3", "4", "5"};
    private String[][] seatsGrid;

    Cinema(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.seatsGrid = new String[rows][columns];
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public String[][] getSeatsGrid() {
        return seatsGrid;
    }

    public String allocateSeats(){
        return " ";
    }
}

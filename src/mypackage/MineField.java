package mypackage;


/**
 * @author Steven Omegna
 * @version Spring 2021
 *
 */
public class MineField {
    /*
     * Bounds for field
     */
    public static int LOWER_BOUNDS = 0;
    public static int UPPER_BOUNDS = 100;

    /**
     * Field to hold mines hints.
     */
    private int[][] myField;
    /**
     * Rows of the minefield.
     */
    private int myRows;
    /**
     * Columns of the minefield
     */
    private int myColumns;


    /**
     * Default constructor
     */
    public MineField() {
        myField = new int[10][10];
        myRows = 10;
        myColumns = 10;
    }
    /**
     * Constructor that takes in 2 parameters and sets up the field.
     * @param theRows int o
     * @param theColumns
     */
    public MineField(final int theRows, final int theColumns) {
        checkBounds(theRows);
        checkBounds(theColumns);
        myField = new int[theRows][theColumns];
        myRows = theRows;
        myColumns = theColumns;
    }

    /**
     * Getter for rows of the minefield.
     * @return int the number of rows
     */
    public int getMyRows() {
        return myRows;
    }

    /**
     * Getter for columns of the minefield.
     * @return int the number of columns
     */
    public int getMyColumns() {
        return myColumns;
    }


    /**
     * Setter to set the field and clear it, initializes the array size.
     * @param theRows int number of rows
     * @param theColumns int number of columns
     */
    public void setField(final int theRows, final int theColumns) {
        checkBounds(theRows);
        checkBounds(theColumns);
        clearField();
        myField = new int[theRows][theColumns];
    }
    /**
     * This method places a mine in the field and updates all spaces around.
     * the mine.
     * @param theRow int row to place the mine
     * @param theColumn int the coloumn to place the mine
     */
    public void setMine(final int theRow, final int theColumn) {
        myField[theRow][theColumn] = -1;
        updateField(theRow, theColumn);
    }
    /**
     * This method checks if the spot is inside the mine field
     * @param theRow int row to check
     * @param theColumn int column to check
     * @return
     */
    public boolean checkBounds(final int theRow, final int theColumn) {

        return  theRow < myRows
                && theColumn < myColumns
                && theRow >= 0
                && theColumn >= 0;
    }

    /**
     * This method prints the field.
     */
    public void printField() {
        int x = 0;
        for (int i=0;i<myRows;i++) {
            for (int j=0;j<myColumns;j++) {
                x = myField[i][j];
                if (x == -1) {
                    System.out.print('*');
                } else {
                    System.out.print(x);
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    private void updateField(final int theRow, final int theColumn) {

        for (int i=-1;i<=1;i++) {
            for (int j=-1;j<=1;j++) {
                if (checkBounds(i + theRow, j + theColumn)
                        && myField[i + theRow][j + theColumn] >= 0) {

                    ++myField[theRow+i][theColumn+j];
                }
            }
        }

    }

    private void clearField() {
        for (int i=0;i<myRows-1;i++) {
            for (int j=0;j<myColumns-1;j++) {
                myField[i][j] = 0;
            }
        }
    }

    private  void checkBounds(final int theBound) {
        if (theBound < LOWER_BOUNDS || theBound > UPPER_BOUNDS ) {
            throw new IllegalArgumentException("Please enter a valid playing field 0 - 100");
        }
    }


}
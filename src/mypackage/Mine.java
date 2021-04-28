package mypackage;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * @author Steven Omegna
 * @version Spring 2021
 *
 * This is the main controler for the minefield, it processes the
 * input from a field and outputs hints to the console.
 */
public class Mine {


    public static void main(String[] args) {

        MineField myField = new MineField();
        LinkedList<MineField> myList = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        int rowCount = 0;
        boolean isDone = false;
        String temp;
        while (isDone == false){
            temp = sc.next();

            if(temp.charAt(0) != '*' && temp.charAt(0) != '.') {
                myList.add(myField);
                rowCount = 0;
                int row = Integer.parseInt(temp);
                temp = sc.next();
                int column = Integer.parseInt(temp);
                myField = new MineField(row, column);

                if (row == 0 && column == 0) {
                    myField.printField();
                    isDone = true;
                }
                myField.setField(row, column);
            }

            if(temp.charAt(0) == '*' || temp.charAt(0) == '.' ) {

                for (int i = 0; i <= temp.length()-1;i++) {
                    if (temp.charAt(i) == '*' ) {
                        myField.setMine(rowCount, i);
                    }
                }
                rowCount++;
            }

        }
        for (int i = 1;i < myList.size();i++) {
            System.out.println("Field #" + i + ":");
            myList.get(i).printField();
        }

        sc.close();
    }

}
package com.keyin2;

import java.util.ArrayList;
import java.util.Arrays;

public class MovieTheatre {

    public static void main(String [] args) {

       // make the inital arraylist for theatre
       ArrayList<ArrayList<Boolean>> MovieSeats = new ArrayList<>();

       // make each row of the theatre (4 rows of 6)
       ArrayList<Boolean> row1 = new ArrayList<>();
       row1.add(false);
       row1.add(false);
       row1.add(false);
       row1.add(false);
       row1.add(false);
       row1.add(false);

       ArrayList<Boolean> row2 = new ArrayList<>();
       row2.add(false);
       row2.add(false);
       row2.add(false);
       row2.add(false);
       row2.add(false);
       row2.add(false);

       ArrayList<Boolean> row3 = new ArrayList<>();
       row3.add(false);
       row3.add(false);
       row3.add(false);
       row3.add(false);
       row3.add(false);
       row3.add(false);

       ArrayList<Boolean> row4 = new ArrayList<>();
       row4.add(false);
       row4.add(false);
       row4.add(false);
       row4.add(false);
       row4.add(false);
       row4.add(false);

       //could had used for loop to fill rows (afterthought)

       //add rows to MovieSeats
       MovieSeats.add(row1);
       MovieSeats.add(row2);
       MovieSeats.add(row3);
       MovieSeats.add(row4);

      printSeatingChart(MovieSeats);

      reserveSeat(MovieSeats, 2, 5);
      reserveSeat(MovieSeats, 2, 5);
      reserveSeat(MovieSeats,3,3);
      reserveSeat(MovieSeats, 1,1);
      reserveSeat(MovieSeats, 0, 4);

      printSeatingChart(MovieSeats);

      cancelSeat(MovieSeats,2, 5);
      cancelSeat(MovieSeats, 0, 4);

      printSeatingChart(MovieSeats);


    }


    //Method to display seating chart
   public static void printSeatingChart(ArrayList<ArrayList<Boolean>> MovieSeats){

      for (int i = 0; i < MovieSeats.size(); i++) {
         for (int j = 0; j < MovieSeats.get(i).size(); j++) {
            if (MovieSeats.get(i).get(j) == false) {
               System.out.print("0 ");
            } else {
               System.out.print("X ");  // 'X' represents a reserved seat
            }
         }
         System.out.println();  // Move to the next line after each row
      }

   }

   //method to reserve a seat
   public static boolean reserveSeat(ArrayList<ArrayList<Boolean>> MovieSeats, int row, int seat) {
      // check if row or seat is negative number
      if (row >= 0 && row < MovieSeats.size() && seat >= 0 && seat < MovieSeats.get(row).size()) {
         //then check satus of seat, if reserved already or not
         if (MovieSeats.get(row).get(seat) == false) {
            MovieSeats.get(row).set(seat, true);
            System.out.println("Seat reserved at row " + row + ", seat " + seat);
            return true;
         } else {
            System.out.println("Seat at row " + row + ", seat " + seat + " is already reserved.");
         }
      } else {
         System.out.println("Invalid row or seat number.");
      }
      return false;


   }

   public static boolean cancelSeat(ArrayList<ArrayList<Boolean>> MovieSeats, int row, int seat){
      //check if negative
      if (row >= 0 && row < MovieSeats.size() && seat >= 0 && seat < MovieSeats.get(row).size()) {
         // Check if seat is true
         if (MovieSeats.get(row).get(seat) == true) {
            MovieSeats.get(row).set(seat, false);
            System.out.println("Seat canceled at row " + row + ", seat " + seat);
            return true;
         } else {
            System.out.println("Seat at row " + row + ", seat " + seat + " is not reserved.");
         }
      } else {
         System.out.println("Invalid row or seat number.");
      }
      return false;
   }
}

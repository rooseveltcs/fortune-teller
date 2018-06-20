import java.util.*;

public class FortuneTeller {
   private String color;
   private int number;
   
   public FortuneTeller(String colorChoice, int numberChoice, ArrayList<String> colors, ArrayList<Integer> numbers1, ArrayList<Integer> numbers2, ArrayList<Integer> current, Scanner console, int stage, ArrayList<String> finalFortunes) {
      //if it's a color
      if (!colorChoice.equals("")) {
         //gives error message until user types valid color
         while (!(colors.contains(colorChoice.toUpperCase()))) {
            System.out.println("This is not one of the options. Please choose one of the colors on the Fortune Teller");
            colorChoice = console.next();
         }
         color = colorChoice;
         moveBy(color.length(), numbers1, numbers2, current);
      //if it's a number
      } else { 
         //gives error message until user types valid number
         while (!(current.contains(numberChoice))) {
            System.out.println("This is not one of the options. Please type (not spell) one of the numbers on the Fortune Teller.");
            numberChoice = console.nextInt();
         }
         number = numberChoice;
         //if last stage, send to something else (not moveBy)
         if (stage != 4) {
            moveBy(number, numbers1, numbers2, current);
         } else {
            finalFortune(number, finalFortunes);
         }
      }
   }
   
   public ArrayList<Integer> moveBy(int move, ArrayList<Integer> numbers1, ArrayList<Integer> numbers2, ArrayList<Integer> current) {
      if (move % 2 == 0) {
         if (current.size() != 4) {
            current.clear();
            current.addAll(numbers1);
         }         
      } else {
         if (current.equals(numbers2)) {
            current.clear();
            current.addAll(numbers1);
         } else {
            current.clear();
            current.addAll(numbers2);
         }
      }
      return current; 
   } 

   public void finalFortune(int flap, ArrayList<String> finalFortunes) {
      System.out.println(finalFortunes.get(flap - 1));
   }
}
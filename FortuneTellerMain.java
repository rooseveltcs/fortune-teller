import java.util.*;

public class FortuneTellerMain {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      
      //list of colors
      ArrayList<String> colors = new ArrayList<String>();
      colors.add("GREEN");
      colors.add("RED");
      colors.add("YELLOW");
      colors.add("BLUE");
      
      //starting numbers (even)
      ArrayList<Integer> numbers1 = new ArrayList<Integer>();
      numbers1.add(1);
      numbers1.add(5);
      numbers1.add(3);
      numbers1.add(8);
      
      //non-starting numbers (odd)
      ArrayList<Integer> numbers2 = new ArrayList<Integer>();
      numbers2.add(4);
      numbers2.add(2);
      numbers2.add(6);
      numbers2.add(7);
      
      //fortunes
      ArrayList<String> finalFortunes = new ArrayList<String>();
      finalFortunes.addAll(colors);
      finalFortunes.addAll(colors);
      finalFortunes.set(0, "An adventure awaits.");
      finalFortunes.add(1, "You're about to strike gold.");
      finalFortunes.set(2, "You will overcome an obstacle.");
      finalFortunes.set(3, "You're almost upon a crossroad.");
      finalFortunes.set(4, "You will discover something about yourself.");
      finalFortunes.set(5, "You will reach an important milestone.");
      finalFortunes.set(6, "Tomorrow's gonna be your lucky day.");
      finalFortunes.set(7, "You will find a special someone.");
      
      //current array
      ArrayList<Integer> current = new ArrayList<Integer>();
      
   
      //prints introduction
      System.out.println("Users beware. Click to find out your fortune if you dare.");
      
      //GRAPHICS
      //CLICKY THING
      
      //GRAPHICS
      
      //first choice
      System.out.print("Choose a color: ");
      String color = console.next();
      FortuneTeller choice1 = new FortuneTeller(color, 0, colors, numbers1, numbers2, current, console, 1, finalFortunes);
      
      //second choice
      for (int i = 2; i < 5; i++) {
         System.out.print("Choose a number: ");
         int number = console.nextInt();
         FortuneTeller choice = new FortuneTeller("", number, colors, numbers1, numbers2, current, console, i, finalFortunes);      
      }
   }
}
import java.awt.*;
import java.util.*;

public class FortuneTellerMain {
   public static final int PANELSIZE = 400;
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(PANELSIZE, PANELSIZE);
      Graphics g = panel.getGraphics();
      Scanner console = new Scanner(System.in);
      
      Polygon flap1 = new Polygon();
      Polygon flap2 = new Polygon();
      Polygon flap3 = new Polygon();
      Polygon flap4 = new Polygon();
      Polygon midd = new Polygon();
      
      ArrayList<Polygon> pol = new ArrayList<Polygon>();
      pol.add(flap1);
      pol.add(flap2);
      pol.add(flap3);
      pol.add(flap4);
      
      ArrayList<Integer> sign =  new ArrayList<Integer>();
      sign.add(-1);
      sign.add(-1);
      sign.add(1);
      sign.add(-1);
      sign.add(1);
      sign.add(1); 
      sign.add(-1);
      sign.add(1);
      
      ArrayList<Color> col = new ArrayList<Color>();
      col.add(Color.GREEN);
      col.add(Color.RED);
      col.add(Color.YELLOW);
      col.add(Color.BLUE);
      
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
      System.out.println("Users beware. Find out your fortune if you dare.");
      
      //color choice      
      PositionGraphics.drawOriginal(panel, g, pol, col, sign, PANELSIZE);

      //first choice
      System.out.print("Choose a color: ");
      String color = console.next();
      FortuneTeller choice1 = new FortuneTeller(color, 0, colors, numbers1, numbers2, current, console, 1, finalFortunes);
      //pos 0: original position. pos 1: vertical position. pos 2: horizontal position.
      int pos = 0;
      int j = 0;
      int number = color.length();
      while (j < number) {
         PositionGraphics.drawOriginal(panel, g, pol, col, sign, PANELSIZE);
         PositionGraphics.drawThirdVertical(panel, g, pol, col, sign, PANELSIZE);
         PositionGraphics.drawTwoThirdsVertical(panel, g, pol, col, sign, PANELSIZE, midd, 700);
         PositionGraphics.drawVertical(panel, g, pol, col, sign, PANELSIZE, midd);
         j++;
         pos = 1;
         if (j < number) {
            PositionGraphics.drawTwoThirdsVertical(panel, g, pol, col, sign, PANELSIZE, midd, 1200);
            PositionGraphics.drawThirdVertical(panel, g, pol, col, sign, PANELSIZE);
            PositionGraphics.drawOriginal(panel, g, pol, col, sign, PANELSIZE);
            PositionGraphics.drawThirdHorizontal(panel, g, pol, col, sign, PANELSIZE, 700);
            PositionGraphics.drawHorizontal(panel, g, pol, col, sign, PANELSIZE, midd);
            j++;
            pos = 2;
         }
         if (j < number) {
            PositionGraphics.drawThirdHorizontal(panel, g, pol, col, sign, PANELSIZE, 1200);            
         }
      } 
      int x = 7;
      int m = 1;
      for (int k = 0; k < 4; k=k+2) {
         int numm = current.get(k);
         String numbers = ("" + numm + "");
         g.drawString(numbers, PANELSIZE/2+x, PANELSIZE/2+20);
         numm = current.get(k+m);
         numbers = ("" + numm + "");
         g.drawString(numbers, PANELSIZE/2+x, PANELSIZE/2-10);
         x = -15;
      }  
      
      //second choice
      for (int i = 2; i < 5; i++) {
         System.out.print("Choose a number: ");
         number = console.nextInt();         
         FortuneTeller choice = new FortuneTeller("", number, colors, numbers1, numbers2, current, console, i, finalFortunes);  
         j = 0; 
         if (i != 4) {   
            while (j < number) {
               if (pos == 0) {
                  PositionGraphics.drawThirdVertical(panel, g, pol, col, sign, PANELSIZE);
                  PositionGraphics.drawTwoThirdsVertical(panel, g, pol, col, sign, PANELSIZE, midd, 700);
                  PositionGraphics.drawVertical(panel, g, pol, col, sign, PANELSIZE, midd);
                  j++;
                  pos = 1;
               } else if (pos == 1) {
                  PositionGraphics.drawTwoThirdsVertical(panel, g, pol, col, sign, PANELSIZE, midd, 1200);
                  PositionGraphics.drawThirdVertical(panel, g, pol, col, sign, PANELSIZE);
                  PositionGraphics.drawOriginal(panel, g, pol, col, sign, PANELSIZE);
                  PositionGraphics.drawThirdHorizontal(panel, g, pol, col, sign, PANELSIZE, 700);
                  PositionGraphics.drawHorizontal(panel, g, pol, col, sign, PANELSIZE, midd);
                  j++;
                  pos = 2;
               } else {
                  PositionGraphics.drawThirdHorizontal(panel, g, pol, col, sign, PANELSIZE, 1200); 
                  PositionGraphics.drawOriginal(panel, g, pol, col, sign, PANELSIZE);
                  PositionGraphics.drawThirdVertical(panel, g, pol, col, sign, PANELSIZE);
                  PositionGraphics.drawTwoThirdsVertical(panel, g, pol, col, sign, PANELSIZE, midd, 700);
                  PositionGraphics.drawVertical(panel, g, pol, col, sign, PANELSIZE, midd);  
                  j++;
                  pos = 1;
               }
            } 
            x = 7;
            m = 1;
            for (int k = 0; k < 4; k=k+2) {
               int numm = current.get(k);
               String numbers = ("" + numm + "");
               g.drawString(numbers, PANELSIZE/2+x, PANELSIZE/2+20);
               numm = current.get(k+m);
               numbers = ("" + numm + "");
               g.drawString(numbers, PANELSIZE/2+x, PANELSIZE/2-10);
               x = -15;
            }  
         } else {
            panel.setBackground(Color.BLACK);
            panel.sleep(700);
            g.fillRect(0, 0, PANELSIZE, PANELSIZE);
         }
      }
   }
}
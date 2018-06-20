import java.awt.*;
import java.util.*;

//includes all graphics; vertical, horizontal, and original positions
public class PositionGraphics {     
   public static void drawOriginal(DrawingPanel panel, Graphics g, ArrayList<Polygon> pol, ArrayList<Color> col, ArrayList<Integer> sign, int panelsize) {
      panel.setBackground(Color.BLACK);
      panel.sleep(700);
      g.fillRect(0, 0, panelsize, panelsize);
      int benchmark1 = panelsize*50/160;
      int j = 0;
      for (int i = 0; i < 4; i++) {
         if (j >= 2) {
            benchmark1 = panelsize*52/160;
         }
         (pol.get(i)).reset();
         g.setColor(col.get(i));
         (pol.get(i)).addPoint(panelsize/2 + sign.get(i+j)*benchmark1, panelsize/2 + sign.get(i+1+j)*panelsize*50/160);
         (pol.get(i)).addPoint(panelsize/2 + sign.get(i+j)*panelsize*42/160, panelsize/2 + sign.get(i+1+j)*panelsize*1/160);
         (pol.get(i)).addPoint(panelsize/2, panelsize/2);
         (pol.get(i)).addPoint(panelsize/2 + sign.get(i+j)*panelsize*1/160, panelsize/2 + sign.get(i+1+j)*panelsize*40/160);
         g.fillPolygon(pol.get(i));
         g.setColor(Color.BLACK);
         g.drawLine(panelsize/2, panelsize/2, panelsize/2 + sign.get(i+j)*benchmark1, panelsize/2 + sign.get(i+1+j)*panelsize*50/160);
         j++;
      }
   }
   
   //draws fortune teller that is one third vertical
   public static void drawThirdVertical(DrawingPanel panel, Graphics g, ArrayList<Polygon> pol, ArrayList<Color> col, ArrayList<Integer> sign, int panelsize) {
      int j = 0;
      panel.sleep(700);
      g.fillRect(0, 0, panelsize, panelsize);
      g.setColor(Color.GRAY);
      g.fillRect(panelsize/2 - panelsize*35/160, panelsize/2 - panelsize*20/160, panelsize*350/400/2, panelsize*200/400/2);
      for (int i = 0; i < 4; i++) {
         (pol.get(i)).reset();
         g.setColor(col.get(i));
         (pol.get(i)).addPoint(panelsize/2 + sign.get(i+j)*panelsize*60/160, panelsize/2 + sign.get(i+1+j)*panelsize*40/160);
         (pol.get(i)).addPoint(panelsize/2 + sign.get(i+j)*panelsize*35/160, panelsize/2 + sign.get(i+1+j)*panelsize*1/160);
         (pol.get(i)).addPoint(panelsize/2, panelsize/2 + sign.get(i+1+j)*panelsize*20/160);
         (pol.get(i)).addPoint(panelsize/2 + sign.get(i+j)*panelsize*2/160, panelsize/2 + sign.get(i+1+j)*panelsize*45/160);
         g.fillPolygon(pol.get(i));
         g.setColor(Color.BLACK);
         g.drawLine(panelsize/2, panelsize/2 + sign.get(i+1+j)*panelsize*20/160, panelsize/2 + sign.get(i+j)*panelsize*60/160, panelsize/2 + sign.get(i+1+j)*panelsize*40/160);
         j++;
      }
      g.setColor(Color.BLACK);
      for (int s = -1; s < 2; s=s+2) {
         g.drawLine(panelsize/2 + s*panelsize*35/160, panelsize/2, panelsize/2, panelsize/2);
         g.drawLine(panelsize/2, panelsize/2 +s*panelsize*50/160, panelsize/2, panelsize/2);
      }
   }
   
   //draws fortune teller that is two thirds vertical
   public static void drawTwoThirdsVertical(DrawingPanel panel, Graphics g, ArrayList<Polygon> pol, ArrayList<Color> col, ArrayList<Integer> sign, int panelsize, Polygon midd, int sleeping) {
      int j = 0; 
      //so it lingers on the Vertical longer
      panel.sleep(sleeping);
      g.fillRect(0, 0, panelsize, panelsize);
      midd.reset();
      for (int i = 0; i < 4; i++) {
         (pol.get(i)).reset();
         if (i == 0) {
            for (int s = -1; s < 2; s=s+2) {
               midd.addPoint(panelsize/2, panelsize/2 + s*panelsize*50/160);
               midd.addPoint(panelsize/2 + s*panelsize*20/160, panelsize/2);
            }
            g.setColor(Color.GRAY);
            g.fillPolygon(midd);
         }
         g.setColor(col.get(i));
         //outside:
         (pol.get(i)).addPoint(panelsize/2 + sign.get(i+j)*panelsize*45/160, panelsize/2 + sign.get(i+1+j)*panelsize*40/160);
         //inner outside
         (pol.get(i)).addPoint(panelsize/2 + sign.get(i+j)*panelsize*20/160, panelsize/2);
         //middle:
         (pol.get(i)).addPoint(panelsize/2 + sign.get(i+j)*panelsize*2/160, panelsize/2 + sign.get(i+1+j)*panelsize*30/160);
         //inside
         (pol.get(i)).addPoint(panelsize/2, panelsize/2 + sign.get(i+1+j)*panelsize*50/160);
         g.fillPolygon(pol.get(i));
         g.setColor(Color.BLACK);
         g.drawLine(panelsize/2 + sign.get(i+j)*panelsize*2/160, panelsize/2 + sign.get(i+1+j)*panelsize*30/160, panelsize/2 + sign.get(i+j)*panelsize*45/160, panelsize/2 + sign.get(i+1+j)*panelsize*40/160);
         j++;
      }
      g.setColor(Color.BLACK);
      for (int s = -1; s < 2; s=s+2) {
         g.drawLine(panelsize/2 + s*panelsize*20/160, panelsize/2, panelsize/2-3, panelsize/2+8);
         g.drawLine(panelsize/2, panelsize/2 +s*panelsize*50/160, panelsize/2-4, panelsize/2);
      }
   }
   
   //draws fortune teller that is completely vertical
   public static void drawVertical(DrawingPanel panel, Graphics g, ArrayList<Polygon> pol, ArrayList<Color> col, ArrayList<Integer> sign, int panelsize, Polygon midd) {
      int j = 0; 
      panel.sleep(700);
      g.fillRect(0, 0, panelsize, panelsize);
      midd.reset();
      for (int i = 0; i < 4; i++) {
         (pol.get(i)).reset();
         g.setColor(col.get(i));
         (pol.get(i)).addPoint(panelsize/2 + sign.get(i+j)*panelsize*30/160, panelsize/2 + sign.get(i+1+j)*panelsize*20/160);
         (pol.get(i)).addPoint(panelsize/2 + sign.get(i+j)*panelsize*20/160, panelsize/2);
         //no middle
         (pol.get(i)).addPoint(panelsize/2, panelsize/2 + sign.get(i+1+j)*panelsize*50/160);
         g.fillPolygon(pol.get(i));
         if (i >= 2) {
            g.setColor(Color.GRAY);
            midd.addPoint(panelsize/2 + sign.get(i)*panelsize*20/160, panelsize/2);
            midd.addPoint(panelsize/2, panelsize/2 + sign.get(i)*panelsize*50/160);
         }
         j++;
      }
      g.fillPolygon(midd);
      g.setColor(Color.BLACK);
      for (int s = -1; s < 2; s=s+2) {
         g.drawLine(panelsize/2 + s*panelsize*20/160, panelsize/2, panelsize/2-3, panelsize/2+4);
         g.drawLine(panelsize/2, panelsize/2 +s*panelsize*50/160, panelsize/2-4, panelsize/2);
      }
   }
   
   //draws fortune teller that is one third horizontal
   public static void drawThirdHorizontal(DrawingPanel panel, Graphics g, ArrayList<Polygon> pol, ArrayList<Color> col, ArrayList<Integer> sign, int panelsize, int sleeping) {
      int j = 0;
      panel.sleep(sleeping);
      g.fillRect(0, 0, panelsize, panelsize);
      g.setColor(Color.GRAY);
      g.fillRect(panelsize/2 - panelsize*21/160, panelsize/2 - panelsize*35/160, panelsize*210/400/2, panelsize*350/400/2);
      for (int i = 0; i < 4; i++) {
         (pol.get(i)).reset();
         g.setColor(col.get(i));
         (pol.get(i)).addPoint(panelsize/2 + sign.get(i+j)*panelsize*40/160, panelsize/2 + sign.get(i+1+j)*panelsize*40/160);
         (pol.get(i)).addPoint(panelsize/2, panelsize/2 + sign.get(i+1+j)*panelsize*35/160);
         (pol.get(i)).addPoint(panelsize/2 + sign.get(i+j)*panelsize*21/160, panelsize/2 + sign.get(i+1+j)*panelsize*1/160);
         (pol.get(i)).addPoint(panelsize/2 + sign.get(i+j)*panelsize*35/160, panelsize/2);
         g.fillPolygon(pol.get(i));
         g.setColor(Color.BLACK);
         g.drawLine(panelsize/2 + sign.get(i+j)*panelsize*21/160, panelsize/2 + sign.get(i+1+j)*panelsize*1/160, panelsize/2 + sign.get(i+j)*panelsize*40/160, panelsize/2 + sign.get(i+1+j)*panelsize*40/160);
         j++;
      }
      g.setColor(Color.BLACK);
      for (int s = -1; s < 2; s=s+2) {
         g.drawLine(panelsize/2 + panelsize + s*panelsize*35/160, panelsize/2, panelsize/2 - s*panelsize*35/160, panelsize/2);
         g.drawLine(panelsize/2, panelsize/2 + s*panelsize*50/160, panelsize/2, panelsize/2);
      }
   }
  
   //draws fortune teller that is completely horizontal
   public static void drawHorizontal(DrawingPanel panel, Graphics g, ArrayList<Polygon> pol, ArrayList<Color> col, ArrayList<Integer> sign, int panelsize, Polygon midd) {
      int j = 0; 
      panel.sleep(700);
      g.fillRect(0, 0, panelsize, panelsize);
      midd.reset();
      for (int i = 0; i < 4; i++) {
         (pol.get(i)).reset();
         g.setColor(col.get(i));
         (pol.get(i)).addPoint(panelsize/2 + sign.get(i+j)*panelsize*20/160, panelsize/2 + sign.get(i+1+j)*panelsize*30/160);
         (pol.get(i)).addPoint(panelsize/2, panelsize/2 + sign.get(i+1+j)*panelsize*20/160);
         //no middle
         (pol.get(i)).addPoint(panelsize/2 + sign.get(i+j)*panelsize*50/160, panelsize/2);
         g.fillPolygon(pol.get(i));
         if (i >= 2) {
            g.setColor(Color.GRAY);
            midd.addPoint(panelsize/2, panelsize/2 + sign.get(i)*panelsize*20/160);
            midd.addPoint(panelsize/2 + sign.get(i)*panelsize*50/160, panelsize/2);
         }
         j++;
      }
      g.fillPolygon(midd);
      g.setColor(Color.BLACK);
      for (int s = -1; s < 2; s=s+2) {
         g.drawLine(panelsize/2 + s*panelsize*50/160, panelsize/2, panelsize/2, panelsize/2);
         g.drawLine(panelsize/2, panelsize/2 +s*panelsize*50/160, panelsize/2, panelsize/2);
      }
   }
}


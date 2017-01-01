import java.util.*;
import java.io.*;


public class E {
     
     private static String inputFile = "e.in";
     private static String outputFile = "e.test";
     private static String answerFile = "e.out";
     
     private static int w;
     private static int h;
     private static int startx;
     private static int starty;
     private static int endx;
     private static int endy;
     private static int numWalls;
     private static Equation[] walls;
     private static double INFINITY = 999999999; 
     
     public static String[][] board;
     
     private class Equation {
          public int x1;
          public int y1;
          public int x2;
          public int y2;
          public double m;
          public double b;
          public Equation(int x1, int y1, int x2, int y2) {
               this.x1 = x1;
               this.y1 = y1;
               this.x2 = x2;
               this.y2 = y2;
               if (x1 == x2)
                    m = INFINITY;
               else
                    m = (double) (y2 - y1) / (x2 - x1);
               b = y1 - (m * x1);               
          }
          public void print() {
               System.out.println("******Equation******");
               System.out.println("Point 1: (" + x1 + ", " + y1 + ")");
               System.out.println("Point 2: (" + x2 + ", " + y2 + ")");
               System.out.println("y = " + "(" + m + " * x) + " + b);
               System.out.println("******END EQUATION******");          
          }
     }
     
     private class Visit {
          public int x;
          public int y;
          public int vx;
          public int vy;
          public Visit(int x, int y, int vx, int vy) {
               this.x = x;
               this.y = y;
               this.vx = vx;
               this.vy = vy;
          }
     }
     
     
     public Boolean legalMove(int x1, int y1, int x2, int y2) {
          Equation eq = new Equation(x1, y1, x2, y2);
          for (int i=0; i<numWalls; i++) {
               if (intersection(eq, walls[i]))
                    return false;
          }
          return true;
     }
     
     public Boolean intersection(Equation eq1, Equation eq2) {
          if (eq1.m == eq2.m)
               return false;
          double b1 = eq1.b; double m1 = eq1.m;
          double b2 = eq2.b; double m2 = eq2.m;
          
          
          
          
          
          double x = (double) (b2 - b1) / (m1 - m2);
          double y = m1 * (double) ( (double) (b2 - b1) / (m1 - m2) ) + b1;
          
          int xleft1  = least(eq1.x1, eq1.x2);
          int xright1 = most (eq1.x1, eq1.x2);
          int yup1    = least(eq1.y1, eq1.y2);
          int ydown1  = most (eq1.y1, eq1.y2);
          
          int xleft2  = least(eq2.x1, eq2.x2);
          int xright2 = most (eq2.x1, eq2.x2);
          int yup2    = least(eq2.y1, eq2.y2);
          int ydown2  = most (eq2.y1, eq2.y2);
          
          return 
               x >= xleft1 && x >= xleft2 &&
               x <= xright1 && x <= xright2 &&
               y >= ydown1 && y >= ydown2 &&
               y <= yup1 && y <= yup2;
     }
     
     public int least(int a, int b) {
          if (a < b)
               return a;
          return b;
     }
     
     public int most(int a, int b) {
          if (a > b)
               return a;
          return b;
     }
     
     public Boolean offGrid(int x, int y) {
          return !(x >= 0 && x < w && y >= 0 && y < h);
     }
     
     public int stepsToFinish(int x, int y, int vx, int vy, Visit[][] visited) {
         // System.out.println(x + " " + y + " " + vx + " " + vy);
          if (x == endx && y == endy && vx == 0 && vy == 0) 
               return 0;
          if (offGrid(x, y))
               return 1000000;
          
          int left  = 1000000;
          int right = 1000000;
          int up    = 1000000;
          int down  = 1000000;
          int nochange = 1000000;
          
          if (visited[x][y] != null && visited[x][y].x == x && visited[x][y].y == y && visited[x][y].vx == vx && visited[x][y].vy == vy)
               return 10000000;
          
          visited[x][y] = new Visit(x, y, vx, vy);
          
          if (legalMove(x, y, x + vx - 1, y + vy))
               left = 1 + stepsToFinish(x + vx - 1, y + vy, vx - 1, vy, visited);
          if (legalMove(x, y, x + vx, y + vy - 1))
               up = 1 + stepsToFinish(x + vx, y + vy - 1, vx, vy - 1, visited);
          if (legalMove(x, y, x + vx + 1, y + vy))
               right = 1 + stepsToFinish(x + vx + 1, y + vy, vx + 1, vy, visited);
          if (legalMove(x, y, x + vx, y + vy + 1))
               down = 1 + stepsToFinish(x + vx, y + vy + 1, vx, vy + 1, visited);
          if (legalMove(x, y, x + vx, y + vy) && !(vx == 0 && vy == 0))
               nochange = 1 + stepsToFinish(x + vx, y + vy, vx, vy, visited);
          
          return least(left, least(right, least(up, least(down, nochange))));
     }
     
     
     public  void main() {
          
          try {
               Scanner s = new Scanner(new File(inputFile));
               clearFile();
               
               while (s.hasNextLine()) {
              ///      System.out.println("=============New Case============================================================");
                    
                    w = s.nextInt();
                    h = s.nextInt();
                    
                    startx = s.nextInt();
                    starty = s.nextInt();
                    
                    endx = s.nextInt();
                    endy = s.nextInt();
                    
                    numWalls = s.nextInt();
                    walls = new Equation[numWalls];
                    for (int i=0; i<numWalls; i++) {
                         walls[i] = new Equation(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());                         
                    }
                    System.out.println("Case Answer: " + stepsToFinish(startx, starty, 0, 0, new Visit[w][h]));
                    
              }              
          }
          catch (java.io.FileNotFoundException e) {  }
          catch (java.util.NoSuchElementException e) { ; }
          
          //judge();
     }
     
     public static void writeLine(String line) {               try {               FileWriter out = new FileWriter(outputFile, true);               out.write(line + "\n");               out.close();          }          catch(java.io.IOException e) {   }               }     public static void clearFile() {          File file = new File(outputFile);          file.delete();       }
     public static void judge() {         judger.judge(outputFile, answerFile);    }
     
}
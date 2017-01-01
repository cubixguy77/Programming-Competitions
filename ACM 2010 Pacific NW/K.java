import java.util.*;
import java.io.*;


public class K {
     
     private static String inputFile = "k.in";
     private static String outputFile = "k.test";
     private static String answerFile = "k.out";
     
     private  point[] mines;
     private  point[] zombies;
     
     private class point {
          int x;
          int y;
          public point(int x, int y) {
               this.x = x;
               this.y = y;
          }          
     }
     
     public  int sqdist(point p1, point p2) {
          return ( abs((p1.x - p2.x)) * abs((p1.x - p2.x)) ) + ( abs((p1.y - p2.y)) * abs((p1.y - p2.y)) );
     }
     public  double dist(point p1, point p2) {
          return Math.sqrt(sqdist(p1, p2));
     }
     public void printzombies() {
          System.out.println("===============start==============");
          for (int z=0; z<zombies.length; z++)
               printPoint(zombies[z]);
          System.out.println("===============end=============================");
     }
     public void printPoint(point p) {
          System.out.println("(" + p.x + ", " + p.y + ")");
     }
     
     public  int abs(int x) {
          if (x < 0) 
               return x * -1;
          return x;
     }
     
     public  point[] addPoint(point[] points, point p) {
          if (points[points.length - 1] != null) {
               points = addRoom(points);
               points[points.length - 1] = p;
          }
          else
               points[points.length - 1] = p;
          return points;
     }
     
     public  point[] addRoom(point[] points) {
          point[] newarray = new point[points.length + 1];
          for (int i=0; i<points.length; i++)
               newarray[i] = points[i];
          return newarray;
     }
     
     public String  getResult() {
          
          double max = 0.0;
          for (int m=0; m<mines.length; m++) {
               for (int z=0; z<zombies.length; z++) {
                    double distance = dist(mines[m], zombies[z]);
                 //   System.out.println("Distance between (" + mines[m].x + ", " + mines[m].y + ") and (" + zombies[z].x + ", " + zombies[z].y + ") is " + distance + ".");
                    if (distance > max)
                         max = distance;
               }
          }
          return getAnswer(0, max);
          //System.out.println(max);     
          //writeLine(max + "");
     }
     
     public Boolean killsAll(double radius) {
        //  System.out.println("KIlls All? " + radius);
          Boolean[] dead = new Boolean[zombies.length];
          int numdead = 0;
          for (int i=0; i<dead.length; i++)
               dead[i] = false;
          
          for (int m=0; m<mines.length; m++) {
               for (int z=0; z<zombies.length; z++) {
                    double distance = dist(mines[m], zombies[z]);
                 //   System.out.println("Distance between (" + mines[m].x + ", " + mines[m].y + ") and (" + zombies[z].x + ", " + zombies[z].y + ") is " + distance + ".");
                    if (radius >= distance && !dead[z]) {
                         dead[z] = true;
                         numdead++;
                       //  System.out.println("dead: (" + zombies[z].x + ", " + zombies[z].y + ")");
                    }
                    if (numdead >= zombies.length)
                         return true;
               }
          }
        
          return false;
       
     }
          
     
     public  String getAnswer(double start, double end) {
        //  System.out.println("Trying " + start + " " + end);
          if (start >= end || (end - start <= .000001))
              return  start + "";
          
          double mid = (start + end) / 2;
          
          if (killsAll(mid))
               return getAnswer(start, mid);
          return getAnswer(mid, end);
     }
          
              
     
     
     
     public void main() {
          
          try {
               Scanner s = new Scanner(new File(inputFile));
               clearFile();
               
               int numcases = Integer.parseInt(s.nextLine());
               
               while (s.hasNextLine()) {
                    int numcols = s.nextInt();
                    int numrows = s.nextInt();
                    s.nextLine();
                    
                    mines = new point[1];
                    zombies = new point[1];
                    
                    for (int row=0; row<numrows; row++) {
                         String line = s.nextLine();
                         for (int col=0; col<numcols; col++) {
                              char c = (char) line.charAt(col);
                              if (c == 'M')
                                   mines = addPoint(mines, new point(col, row));
                              else if (c == 'Z')
                                   zombies = addPoint(zombies, new point(col, row));
                              else
                                   ;
                         }
                    }
                   // printzombies();
                    writeLine(getAnswer(0, dist( new point(0,0), new point(numcols-1, numrows-1)  )));
               }
          }
          
          catch (java.io.FileNotFoundException e) { System.out.println("sht"); }
          catch (java.util.NoSuchElementException e) { System.out.println("fuck"); }
          
          judge();
     }
     
     public static void writeLine(String line) {               try {               FileWriter out = new FileWriter(outputFile, true);               out.write(line + "\n");               out.close();          }          catch(java.io.IOException e) {   }               }     public static void clearFile() {          File file = new File(outputFile);          file.delete();       }
     public static void judge() {         judger.judge(outputFile, answerFile);    }
     
}
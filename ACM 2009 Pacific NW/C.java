import java.util.*;
import java.io.*;
import java.text.*;

class Main {
     
     private static String inputFile = "a.in";
     private static String outputFile = "a.test";
     private static String answerFile = "a.out";
     
     public static void format(double value ) {
          System.out.format("%.2f%n", value);
     }
     
     public static double dist(double x1, double y1, double z1, double x2, double y2, double z2) {
          double dx = x1 - x2;
          double dy = y1 - y2;
          double dz = z1 - z2;
          
          double dx2 = Math.pow(dx, 2);
          double dy2 = Math.pow(dy, 2);
          double dz2 = Math.pow(dz, 2);
          
          double sum = dx2 + dy2 + dz2;
          
          double result = Math.sqrt(sum);
          return result;
     }
     
     public static void main(String[] asddf) {
          
          try {
               Scanner s = new Scanner(System.in);
               s.nextLine();
               while (s.hasNextLine()) {
                    String depart = s.nextLine();
                    double x1 = s.nextDouble();
                    double y1 = s.nextDouble();
                    double z1 = s.nextDouble(); s.nextLine();
                    
                    String dest = s.nextLine();
                    double x2 = s.nextDouble();
                    double y2 = s.nextDouble();
                    double z2 = s.nextDouble(); s.nextLine();
                    
                    
                    System.out.print(depart + " to " + dest + ": ");
                    format(dist(x1, y1, z1, x2, y2, z2));
                    
               }               
          }
          
          catch (java.util.NoSuchElementException e) { System.out.println("HSUDF"); }
          
     }
}
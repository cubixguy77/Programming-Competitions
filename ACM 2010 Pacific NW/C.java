import java.util.*;
import java.io.*;


public class C {
     
     private static String inputFile = "c.in";
     private static String outputFile = "c.test";
     private static String answerFile = "c.out";
     
     public static double get(int a, int b, int c) {
          return (double) ( (double) Math.pow((double) a / b, 3) + (double) Math.pow((double) c / b, 3) );
     }
     
     public static String run(int n) {
          for (int a=0; a<100; a++) {
               for (int b=1; b<100; b++) {
                    for (int c=a; c<100; c++) {
                         if (get(a,b,c) == n)
                              return n + " " + a + " " + b + " " + c;
                    }
               }
          }
          return n + " not found";
     }
     
     public static void main(String[] asdf) {
          
          try {
               Scanner s = new Scanner(new File(inputFile));
               clearFile();
               
               int numcases = Integer.parseInt(s.nextLine());
               
               while (s.hasNextLine()) {
                    int n = s.nextInt();
                    System.out.println(run(n));                    
               }
          }
          
          catch (java.io.FileNotFoundException e) {  }
          catch (java.util.NoSuchElementException e) { ; }
          
          //judge();
     }
     
     public static void writeLine(String line) {               try {               FileWriter out = new FileWriter(outputFile, true);               out.write(line + "\n");               out.close();          }          catch(java.io.IOException e) {   }               }     public static void clearFile() {          File file = new File(outputFile);          file.delete();       }
     public static void judge() {         judger.judge(outputFile, answerFile);    }
     
}
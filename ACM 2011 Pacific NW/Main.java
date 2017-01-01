import java.util.*;
import java.io.*;


class Main {
     
     private static String inputFile = "a.in";
     private static String outputFile = "a.test";
     private static String answerFile = "a.out";
     
     
     public static int getNumG(String string) {          
          int num = 0;
          for (int i=0; i<string.length(); i++) {
               if (string.charAt(i) == 'g' || string.charAt(i) == 'G')
                    num++;
          }
          return num;
     }
     
     public static int getNumB(String string) {          
          int num = 0;
          for (int i=0; i<string.length(); i++) {
               if (string.charAt(i) == 'b' || string.charAt(i) == 'B')
                    num++;
          }
          return num;
     }
     
     public static void go() {
          try {
               Scanner s = new Scanner(System.in);
             //  clearFile();
               String useless = s.nextLine();
               while (s.hasNextLine()) {
                    
                    String name = s.nextLine();
                    int numG = getNumG(name);
                    int numB = getNumB(name);
                    
                    String result = "";
                    if (numG > numB)
                         result = "GOOD";
                    else if (numG == numB)
                         result = "NEUTRAL";
                    else
                         result = "A BADDY";
                    
                    System.out.println(name + " is " + result);
               }
               
          }
     //     catch (java.io.FileNotFoundException e) {  }
          catch (java.util.NoSuchElementException e) { ; }
          
     }
     
     public static void main(String[] args) {
          
          Main a = new Main();
          a.go();
          
     //     judge();
     }
        
}
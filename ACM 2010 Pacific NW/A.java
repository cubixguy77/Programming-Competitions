import java.util.*;
import java.io.*;


class A {
     
     private static String inputFile = "a.in";
     private static String outputFile = "a.test";
     private static String answerFile = "a.out";

     
         public static void main(String[] args) {
          
          try {
               //Scanner s = new Scanner(new File(inputFile));
               Scanner s = new Scanner(System.in);
              // clearFile();
               while (s.hasNextLine()) {
                   int numRules = Integer.parseInt(s.nextLine());
                   String[] rules = new String[numRules + 1];
                   for (int i=1; i<=numRules; i++) {                        
                        rules[i] = s.nextLine();
                   }
                   int numLookups = s.nextInt();
                   for (int i=0; i<numLookups; i++) {
                        int rule = s.nextInt();
                        if (rule < 1 || rule > numRules || rules[rule] == null)
                             System.out.println("Rule " + rule + ": No such rule");
                             //writeLine("Rule " + rule + ": No such rule");
                        else
                             System.out.println("Rule " + rule + ": " + rules[rule]);
                             //writeLine("Rule " + rule + ": " + rules[rule]);
                   }
                   
               }          
          }
         // catch (java.io.FileNotFoundException e) { System.out.println("ERRORRR"); }
          catch (java.util.NoSuchElementException e) { System.out.println("ERORROROR"); }
          catch (java.lang.NumberFormatException e) {}
          
        // judge();
     }
     

}
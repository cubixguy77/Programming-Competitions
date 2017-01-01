import java.util.*;
import java.io.*;


public class A {
     
     private static String inputFile = "a.in";
     private static String outputFile = "out.all";
     private static String answerFile = "a.out";
     
     public static int getCharVal(char c) {
          switch (c) {
               case 'I': return 1;
               case 'V': return 5;
               case 'X': return 10;
               case 'L': return 50;
               case 'C': return 100;
               case 'D': return 500;
               case 'M': return 1000;
               default: return -1;
          }
     }
     
     public static int getQuick(int n) {
          switch (n) {
               case 4: return 'I';
               case 9: return 'V';
               case 49: return 'X';
               case 99: return 'L';
               case 499: return 'C';
               case 500: return 'D';
               case 1000: return 'M';
               default: return '~';
          }
     }
     
     
     
     public static char getIntVal(int n) {
          switch (n) {
               case 1: return 'I';
               case 5: return 'V';
               case 10: return 'X';
               case 50: return 'L';
               case 100: return 'C';
               case 500: return 'D';
               case 1000: return 'M';
               default: return '~';
          }
     }
     
     public static Boolean isPure(int n) {
          return n == 1 || n == 5 || n == 10 || n == 50 || n == 100 || n == 500 || n == 1000; 
     }
          
     public static int doubleCharVal(String s) {
          return getCharVal(s.charAt(1)) - getCharVal(s.charAt(0));
     }
     
     public static String getRoman(int n) {
          if (isPure(n))
               return Character.toString(getIntVal(n));
          else if (n % 2 == 0 && isPure(n / 2))
               return Character.toString(getIntVal(n/2)) + Character.toString(getIntVal(n/2));
          else if (n % 3 == 0 && isPure(3 * n))
               return Character.toString(getIntVal(n/3)) + Character.toString(getIntVal(n/3))  + Character.toString(getIntVal(n/3));
          return "";
     }
          
     
     public static int getVal(String s) {
          if (s.length() == 0)
               return 0;
          else if (s.length() == 1)
               return getCharVal(s.charAt(0));
          else {
               if (getCharVal(s.charAt(0)) < getCharVal(s.charAt(1)))
                    return doubleCharVal(s) + getVal(s.substring(2, s.length()));               
          }
          return getCharVal(s.charAt(0)) + getVal(s.substring(1, s.length()));        
     }
     
     
     
     public static void main(String[] asddf) {
          
          try {
               Scanner s = new Scanner(new File(inputFile));
               clearFile();
               
               while (s.hasNext()) {
                    String name = s.next();                
                    
               }               
          }
          
          catch (java.io.FileNotFoundException e) { ; }
          catch (java.util.NoSuchElementException e) { ; }
          
          //judge();
     }
     
     public static void writeLine(String line) {               try {               FileWriter out = new FileWriter(outputFile, true);               out.write(line + "\n");               out.close();          }          catch(java.io.IOException e) {   }               }     public static void clearFile() {          File file = new File(outputFile);          file.delete();       }
     public static void judge() {         judger.judge(outputFile, answerFile);    }
     
}
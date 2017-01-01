import java.util.*;
import java.io.*;


public class H {
     
     private static String inputFile = "h.in";
     private static String outputFile = "h.test";
     private static String answerFile = "h.out";

     
     public static Boolean getBool(String string) {
          if (string.equals("t"))
               return true;
          else if (string.equals("f"))
               return false;
          else if (string.equals("!t"))
               return false;
          else if (string.equals("!f"))
               return true;
          else
               return null;
     }
     
     public static Boolean eval(String string) {
          String ex1 = getEx1(string);
          String ex2 = getEx2(string);
          String op  = getOp (string);
          
          Boolean b1 = getBool(ex1);
          Boolean b2 = getBool(ex2);
          
          if (b1 == null)
               b1 = eval(ex1);
          if (b2 == null)
               b2 = eval(ex2);
          
          if (b1 != null && b2 != null) {
               
               if (op.equals("|"))
                    return b1 || b2;
               else if (op.equals("|!"))
                    return b1 || !(b2);
               else if (op.equals("&"))
                    return b1 && b2;
               else if (op.equals("!&"))
                    return b1 && !(b2);
               else
                    return null;               
          }
     }
     
     public static String getEx1(String input) {
          input = input.substring(1, input.length() - 1);
          if (
     }
     public static String getEx2(String input) {
          input = input.substring(1, input.length() - 1);
     }
     
     public static String getOp(String input) {
          
     }
     
     
     
     public static void main(String[] args) {
          
          try {
               Scanner s = new Scanner(new File(inputFile));
               clearFile();
               
               int numLines = Integer.parseInt(s.nextLine());
               
               while (s.hasNextLine()) {
                    int h = s.nextInt();
                    int w = s.nextInt();
                    
               }              
          }
          catch (java.io.FileNotFoundException e) {  }
          catch (java.util.NoSuchElementException e) { ; }
          
          //judge();
     }
     
     public static void writeLine(String line) {               try {               FileWriter out = new FileWriter(outputFile, true);               out.write(line + "\n");               out.close();          }          catch(java.io.IOException e) {   }               }     public static void clearFile() {          File file = new File(outputFile);          file.delete();       }
     public static void judge() {         judger.judge(outputFile, answerFile);    }
     
     }
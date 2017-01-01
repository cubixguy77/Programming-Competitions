import java.util.*;
import java.io.*;


public class J {
     
     private static String inputFile = "j.in";
     private static String outputFile = "j.test";
     private static String answerFile = "j.out";

     private static int[] nums;

     
     
     
     public static void main(String[] args) {
          
          try {
               Scanner s = new Scanner(new File(inputFile));
               clearFile();
               while (s.hasNextLine()) {
                    int numpairs = s.nextInt();
                    nums = new int[numpairs * 2];
                    
                    for (int i=0; i<numpairs; i++)
                         nums[i] = s.nextInt();
                    
                    

               }
               
               

          }
          catch (java.io.FileNotFoundException e) {  }
          catch (java.util.NoSuchElementException e) { ; }
          
          judge();
     }
     
     public static void writeLine(String line) {               try {               FileWriter out = new FileWriter(outputFile, true);               out.write(line + "\n");               out.close();          }          catch(java.io.IOException e) {   }               }     public static void clearFile() {          File file = new File(outputFile);          file.delete();       }
     public static void judge() {         judger.judge(outputFile, answerFile);    }
 
}
import java.util.*;
import java.io.*;


public class C {
     
     private static String inputFile = "a.in";
     private static String outputFile = "a.test";
     private static String answerFile = "a.out";
     
     
     public static String[] nums = {"000", "002", "004", "006", "030", "032", "034", "036", "040", "042", "044", "046", "050", "052", "054", "056", "060", "062", "064", "066" }; 
     public static String[] nums2 = {"2", "4", "6", "30", "32", "34", "36", "40", "42", "44", "46", "50", "52", "54", "56", "60", "62", "64", "66" }; 
     
     public static String get(int num, int trip) {
          if (num <= 19)
               return nums[num - 1];
          else if (trip == 
          else
               return get(num % 19, trip + 1) + "," + get(num / 19, trip + 1);
     }
     
     public static String san(String result) {
          while (result.charAt(0) == '0')
               result = result.substring(1, result.length());
          return result;
     }
     
     public static void main(String[] asddf) {
          
          try {
               Scanner s = new Scanner(System.in);
               clearFile();
               
               while (s.hasNext()) {
                    int num = s.nextInt();                
                    if (num <= 19)
                         System.out.println(san(nums[num - 1]));
                    else {
                         System.out.println(san(get(num)));
                    }
               }               
          }
          
          //catch (java.io.FileNotFoundException e) {  }
          catch (java.util.NoSuchElementException e) { ; }
          
          //judge();
     }
     
     public static void writeLine(String line) {               try {               FileWriter out = new FileWriter(outputFile, true);               out.write(line + "\n");               out.close();          }          catch(java.io.IOException e) {   }               }     public static void clearFile() {          File file = new File(outputFile);          file.delete();       }
     public static void judge() {         judger.judge(outputFile, answerFile);    }
     
}
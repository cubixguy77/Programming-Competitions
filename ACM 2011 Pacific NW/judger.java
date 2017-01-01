import java.util.*;
import java.io.*;


public class judger {
     
     public static void judge(String fileA, String fileB) {
          System.out.println("Number of errors: " + getNumDifferences(fileA, fileB));
     }
     
     public static int getNumDifferences(String fileA, String fileB) {
          int diff = 0;
          int i = 0;
          try {
               Scanner a = new Scanner(new File(fileA));
               Scanner b = new Scanner(new File(fileB));
               
               while (b.hasNextLine()) {
                    i++;
                    if (!(a.nextLine().equals(b.nextLine())))
                         diff++;
               }
          }
          catch (java.io.FileNotFoundException e) {  System.out.println("File not found");  }
          catch (java.util.NoSuchElementException e) { ; }
          
          System.out.println("Checked " + i + " lines.");
          return diff;
     }
}
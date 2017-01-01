import java.util.*;
import java.io.*;


public class G {
     
     private static String inputFile = "g.in";
     private static String outputFile = "g.test";
     private static String answerFile = "g.out";
     
     static int a;
     static int m;
     static int s;
     
     public static  double r(int a, int m, int sin) {
          double val = sin % (m / (double) m);
          s = ((a * sin) + 1) % m;
          return val;
     }
     
     public static int ceiling(double d) {
          return (int) Math.ceil(d);
     }
     
     public static char[] getConversions() {
          char[] array = new char[125];
          for (int c=0; c<array.length; c++) {
               if (c < 32 || c > 124)
                    array[c] = (char) c;
               else
                    array[c] = (char) ((( (c-32) + ceiling(95 - (int) (r(a,m,s) * 95)) ) % 95) + 32);
          }
          return array;
     }
     
     public static void print(char[] array) {
         for (int i=0; i<array.length; i++)
              System.out.println("Index: " + i + "   " + array[i]);
     }
     
     public static char getChar(char c, char[] array) {
          for (int i=32; i<=124; i++) {
               if (array[i] == c)
                    return (char) i;
          }
          return c;
     }
     
     public static String getOutput(String input, char[] array) {
          String output = "";
          for (int i=0; i<input.length(); i++) {
               char c = input.charAt(i);
               output += getChar(c, array);
          }
          return output;
     }
     
         public static void main(String[] args) {
          
          try {
               Scanner sc = new Scanner(new File(inputFile));
               clearFile();
              
               a = sc.nextInt();
               m = sc.nextInt();
               s = sc.nextInt();
               
            //   System.out.println("****************** " + a + " " + m + " " + s +  " ************************************************************");
               
               char[] array = getConversions();
               print(array);
               sc.nextLine();
               while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                System.out.println("Outputting for line: " + line);
                    System.out.println(getOutput(line, array));
                  //  writeLine(getOutput(sc.nextLine(), array));
               }
                   
                         
          }
          catch (java.io.FileNotFoundException e) {  }
          catch (java.util.NoSuchElementException e) { ; }
          
          //judge();
     }
     
     public static void writeLine(String line) {               try {               FileWriter out = new FileWriter(outputFile, true);               out.write(line + "\n");               out.close();          }          catch(java.io.IOException e) {   }               }     public static void clearFile() {          File file = new File(outputFile);          file.delete();       }
     public static void judge() {         judger.judge(outputFile, answerFile);    }
 
}
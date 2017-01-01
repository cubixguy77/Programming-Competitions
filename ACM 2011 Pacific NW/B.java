import java.util.*;
import java.io.*;


public class B {
     
     private static String inputFile = "h.in";
     private static String outputFile = "h.test";
     private static String answerFile = "h.out";
     
     private static float a;
     private static float b;
     private static float c;
     private static float d;
     private static float m;
     private static float t;     
     
     
     public static float litersExpended(float v) {
          return m * (float) ((a * (v * v * v)) + (b*(v * v)) + (c * v) + d);
     }
          
     public static float getBaseline() {
          float v = (float) .000001;
          while (litersExpended(v) < t)
               v *= (float) 2.0;
          return v / (float) 2.0;
     }
     
     public static float round(float val) {
          return (float) (((int) (val * (float) 100.0)) / (float) 100.0);    
     }
     
     public static String getBestV(float lower, float upper) {
         // System.out.println(lower + " " + upper);
          float middle = (lower + upper) / (float) 2.0;
          if (litersExpended(middle) < t && (t - litersExpended(middle)) <= .01)
               return removezeros(round(middle));
          
          if (litersExpended(middle) > t)
               return getBestV(lower, middle);
          else
               return getBestV(middle, upper);
     }
     
     public static String removezeros(float val) {
          String string = "" + val;
          int i=0;
          while (string.charAt(i) == '0')
               string = string.substring(1, string.length());
          if (string.charAt(string.length() - 2) == '.')
               string += "0";
          if (string.charAt(string.length() - 2) != '.')
               string = string.substring(0, string.indexOf('.') + 3);
          return string;
     }
     
     public static float add(float val) {
          int n = (int) (val * 100);
          n++;
          return (float) n / 100;
     }
     
     public static float sub(float val) {
          int n = (int) (val * 100);
          n--;
          return (float) n / 100;
     }
     
     public static void main(String[] args) {
          
          try {
               Scanner s = new Scanner(new File(inputFile));
               clearFile();
             
               while (s.hasNextLine()) {
                    
                     a = s.nextFloat();
                     b = s.nextFloat();
                     c = s.nextFloat();
                     d = s.nextFloat();
                     m = s.nextFloat();
                     t = s.nextFloat();
                    
                    float v = (float) .000000001;
                    v = getBaseline();
                    v = Float.valueOf(getBestV(v, (float) (v * v)).trim()).floatValue();
                    
                    while (litersExpended(v) < t) {
                         v = add(v);
                         System.out.println("Trying out: " + v);
                    }
                    if (litersExpended(v) > t)
                         v = sub(v);
                    
                         System.out.println("**********************************Solution: " + removezeros(v));                         
                         writeLine("" + removezeros(v));                    
               }
               
          }
          catch (java.io.FileNotFoundException e) {  }
          catch (java.util.NoSuchElementException e) { ; }
          
          judge();
     }
     
     public static void writeLine(String line) {               try {               FileWriter out = new FileWriter(outputFile, true);               out.write(line + "\n");               out.close();          }          catch(java.io.IOException e) {   }               }     public static void clearFile() {          File file = new File(outputFile);          file.delete();       }
     public static void judge() {         judger.judge(outputFile, answerFile);    }
     
}
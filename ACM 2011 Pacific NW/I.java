import java.util.*;
import java.io.*;


public class I {
     
     private static String inputFile = "i.in";
     private static String outputFile = "i.test";
     private static String answerFile = "i.out";

     private static int w;
     private static int h;
     public static String[][] board;
     public static String startPoints;
     
     public static int getRow(int index) {
          return (index-1) / w; 
     }
     
     public static int getCol(int index) { 
          return (index - 1) % w;
     }
     
     public static String getEndPoint(String start) {
          return getNextPoint(start);
     }
     
     public static int getNum(String string) {
          return Integer.parseInt(string.substring(0, string.length() - 1));
     }
     
     public static String getString(String string) {
          return string.substring(string.length() - 1, string.length());
     }
     
     public static char getChar(String string) {
          return string.charAt(string.length() - 1);
     }
     
     public static String getNextPoint(String start) {
          
          
          int i = getNum(start);
          char spot = getChar(start);
          
          String poss = board[getRow(i)][getCol(i)];
          StringTokenizer st = new StringTokenizer(poss);
          String cur = "booger";
          while (st.hasMoreTokens()) {
               cur = st.nextToken();
               if (cur.contains(spot + "")) { 
                 //   System.out.println("We have reason to believe that " + start + " is connected to " + i + getNextSpot(spot, cur));
                    break;
               }
          }
          
          char nextspot = getNextSpot(spot, cur);
          if (isTerminalPoint("" + i + nextspot))
               return "" + i + nextspot;
          
          int nextindex = getNextIndex(i, nextspot);
          nextspot = convert(nextspot);
          
          String nextPoint = "" + nextindex + nextspot;

          return getNextPoint(nextPoint);
     }
     
     public static char getNextSpot(char spot, String pair) {
          if (pair.charAt(0) == spot)
               return (pair.charAt(1));
          return (pair.charAt(0));
     }
     
     public static char convert(char x) {
          switch (x) {
               case 'A': return 'F';
               case 'B': return 'E';
               case 'C': return 'H';
               case 'D': return 'G';
               case 'E': return 'B';
               case 'F': return 'A';
               case 'G': return 'D';
               case 'H': return 'C';
               default: return '*';
          }               
     }
     
     public static int getNextIndex(int i, char nextspot) {
          int result = -1;
          
          if (nextspot == 'A' || nextspot == 'B')
               result = i - w;
          else if (nextspot == 'C' || nextspot == 'D')
               result = i + 1;
          else if (nextspot == 'E' || nextspot == 'F')
               result = i + w;
          else if (nextspot == 'G' || nextspot == 'H')
               result = i - 1;
          else
               return -1;
          
          if (result < 1 || result > (h*w))
               return -1;
          return result;          
     }
     
     public static Boolean isTerminalPoint(String point) {
         // System.out.println("*****************Checking for terminal Point*********** " + point);
          int i = getNum(point);
          char spot = getChar(point);
               
          if ( (getRow(i) == 0 && (spot == 'A' || spot == 'B')) || (getRow(i) == h-1 && (spot == 'E' || spot == 'F')) ||
               (getCol(i) == 0 && (spot == 'G' || spot == 'H')) || (getCol(i) == w-1 && (spot == 'C' || spot == 'D')) )
               return true;
          return false;          
     }
     
     public static void main(String[] args) {
          
          try {
               Scanner s = new Scanner(new File(inputFile));
               clearFile();
               
               int boardnum = 1;
               
               while (s.hasNextLine()) {
                    
                   h = s.nextInt();
                   w = s.nextInt();
                                      
                   if (h == 0 && w == 0)
                        break;
                   
                   board = new String[h][w];
                   String line;
                   line = s.nextLine();
                   while (s.hasNextLine()) {
                        line = s.nextLine();
                        if (line.equals("0"))
                             break;
                        
                        StringTokenizer st = new StringTokenizer(line);
                        int index = Integer.parseInt(st.nextToken());
                        board[getRow(index)][getCol(index)] = line.substring(line.indexOf(' ') + 1, line.length());
                   }
                   startPoints = s.nextLine();
                   
                   
                   writeLine("Board " + boardnum + ":"); boardnum++;
                   
                   StringTokenizer st = new StringTokenizer(startPoints);
                   while (st.hasMoreTokens()) {
                        String cur = st.nextToken();
                        String result = getEndPoint(cur);
                        
                        writeLine(cur + " is connected to " + result);
                   }
                   
                   writeLine("");
               }               
          }
          catch (java.io.FileNotFoundException e) { System.out.println("File not founded"); }
          catch (java.util.NoSuchElementException e) { ; }
          
          judge();
     }
     
     public static void writeLine(String line) {               try {               FileWriter out = new FileWriter(outputFile, true);               out.write(line + "\n");               out.close();          }          catch(java.io.IOException e) {   }               }     public static void clearFile() {          File file = new File(outputFile);          file.delete();       }
     public static void judge() {         judger.judge(outputFile, answerFile);    }
 
}
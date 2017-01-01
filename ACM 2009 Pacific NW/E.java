import java.util.*;
import java.io.*;


public class E {
     
     private static String inputFile = "a.in";
     private static String outputFile = "a.test";
     private static String answerFile = "a.out";
     
     private static char[][] b;
     
     
     
     
     public static Boolean isValid(int row, int col) {
          char[][] me     = place(b, row, col, 'O');
          char[][] wookie = place(b, row, col, 'X');
          
          if (win(me,    row, col, '0')) { 
               System.out.println("I would win by choosing : " + row + " " + col);
               return false;
          }
          if(win(wookie, row, col, 'X')) {
               System.out.println("wookie would win by choosing : " + row + " " + col);
               return false;
          }
          return true;
     }
     
     public static char[][] place(char[][] board, int newrow, int newcol, char c) {
          char[][] temp = new char[5][5];
          for (int row=0; row<5; row++) {
               for (int col=0; col<5; col++) {
                    temp[row][col] = board[row][col];                    
               }
          }
          temp[newrow][newcol] = c;
          return temp;
     }
     
     public static Boolean win(char[][] board, int row, int col, char c) {
          return rowWin(board, row, col, c) || colWin(board, row, col, c) || diag(board, row, col, c) || diagRev(board, row, col, c);                   
     }
     
     public static Boolean rowWin(char[][] board, int row, int col, char c) {
       //   System.out.println("-------------- Checking Row " + c + " ---------------");
       //   System.out.println("Checking: " + row + " " + col);
          for (int x0=col-3; x0<=col; x0++) {
        //       System.out.println("++++++++ " + x0 + " +++++++++");
               String xxxx = "";
               for (int f=0; f<4; f++) {
                  //  System.out.print(xxxx + " ");
                    try { 
                         xxxx += board[row][x0 + f];
                         if (xxxx.equals("" + c + c + c + c))
                              return true;
                    } catch (ArrayIndexOutOfBoundsException e) {}
               }
        //       System.out.println("");
          }
          return false;
     }
     
     public static Boolean colWin(char[][] board, int row, int col, char c) {

          for (int x0=row-3; x0<=row; x0++) {
               String xxxx = "";
               for (int f=0; f<4; f++) {
                    try { 
                         xxxx += board[x0 + f][col];
                         if (xxxx.equals("" + c + c + c + c))
                              return true;
                    } catch (ArrayIndexOutOfBoundsException e) {}
               }
          }
          return false;
     }
     
     
     public static Boolean diag(char[][] board, int row, int col, char c) {
          int x0 = col - 3;
          int y0 = row - 3;
          for (int i=0; i<4; i++) {
               String xxxx = "";
               for (int f=0; f<4; f++) {
                    try { 
                         xxxx += board[y0+f][x0+f];
                         if (xxxx.equals("" + c + c + c + c))
                              return true;
                    } catch (ArrayIndexOutOfBoundsException e) {}
               }
               x0++;
               y0++;
          }
          return false;
     }
     
     public static Boolean diagRev(char[][] board, int row, int col, char c) {
          int x0 = col + 3;
          int y0 = row + 3;
          for (int i=0; i<4; i++) {
               String xxxx = "";
               for (int f=0; f<4; f++) {
                    System.out.print("(" + y0 + ", " + x0 + ") "); 
                    try { 
                         xxxx += board[y0-f][x0-f];
                         if (xxxx.equals("" + c + c + c + c))
                              return true;
                    } catch (ArrayIndexOutOfBoundsException e) {}
                    System.out.println("");
               }
               
               x0--;
               y0--;
          }
          return false;
     }
     
     
     public static void main(String[] asddf) {
          
          try {
               Scanner s = new Scanner(System.in);
               
               b = new char[5][5];
               for (int row=0; row<5; row++) {
                    for (int col=0; col<5; col++)
                         b[row][col] = ' ';
               }
               
               Boolean done = false;
               while (!done) {
                   for (int row=0; row<5; row++) {
                        for (int col=0; col<5; col++) {
                             char c = s.next().charAt(0);
                             b[row][col] = c;
                             System.out.print(c + " ");
                        }
                        System.out.println("");                    
                   }
               
                   for (int row=0; row<5; row++) {
                        for (int col=0; col<5; col++) {
                             if (b[row][col] == '*' && isValid(row, col)) {
                                  System.out.println(("" + ((5 * row) + col + 1)));
                                  break;
                             }
                        }
                   }
                   
                   
               }
          }
          
          catch (java.util.NoSuchElementException e) { ; }          
     }
}
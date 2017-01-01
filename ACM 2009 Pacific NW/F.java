import java.util.*;
import java.io.*;


class F {
     
     private static String inputFile = "a.in";
     private static String outputFile = "a.test";
     
     private static int[][] b;
     private static int max;
     private static int size;
     
     public static void print(int[][] a) {
          System.out.println("+++++++++++++++++++");
          for (int i=0; i<size; i++) {
               for (int j=0; j<size; j++) {
                    System.out.print(a[i][j] + " ");
               }
               System.out.println("");
          }
          System.out.println("===================");
     }
     
     public static void printVector(int[][] a) {
          for (int row=0; row<size; row++) {
               for (int col=0; col<size; col++) {
                    if (a[row][col] != 0) {
                         String out = "";
                         if (row == 0)
                              out = "" + col;
                         else if (col >= 100)
                        
                              
                         System.out.print(col);
                         if (row != max)
                              System.out.print(" ");
                    }
               }
          }
          System.out.println("");
     }
     
     
     public static int[][] get90(int[][] in) {
          int[][] temp = new int[size][size];
          for (int col=0; col<size; col++) {
               for (int row=max; row>=0; row--) 
                    temp[col][max - row] = in[row][col];
          }
          return temp;
     }
     
     public static int[][] getVert() {
          int[][] temp = new int[size][size];
          for (int row=0; row<size; row++) {
               for (int col=0; col<size; col++) 
                    temp[max - row][col] = b[row][col];
          }
          return temp;
     }
     
     public static int[][] getWhore() {
          int[][] temp = new int[size][size];
          for (int row=0; row<size; row++) {
               for (int col=0; col<size; col++) 
                    temp[row][max - col] = b[row][col];
          }
          return temp;
     }
     
     public static int[][] getDiag(int[][] in) {
          int[][] temp = new int[size][size];
          for (int row=0; row<size; row++) {
               for (int col=0; col<size; col++) 
                    temp[col][row] = in[row][col];
          }
          return temp;
     }
     
     public static void go() {
          try {
               Scanner s = new Scanner(System.in);
               while (s.hasNextLine()) {
                    
                    
                    size = s.nextInt();
                    if (size > 0) {
                         
                         
                         
                         
                         
                         b = new int[size][size];
                         max = size - 1;
                         
                         for (int i=0; i<size; i++) {
                              for (int j=0; j<size; j++)
                                   b[i][j] = 0;
                         }
                         for (int row=0; row<size; row++) {                              
                              b[row][s.nextInt()] = row + 1;
                         }
                         s.nextLine();
                         
                   //      print(getVert());
                    //     print(getWhore());
                         
                         printVector(b);
                         printVector(get90(b));
                         printVector(get90(get90(b)));
                         printVector(get90(get90(get90(b))));
                         
                         printVector(getWhore());
                         printVector(getDiag(get90(get90(b))));
                         printVector(getVert());
                         printVector(getDiag(b));
                         System.out.println("");
                    }
               }
               
          }
     //     catch (java.io.FileNotFoundException e) {  }
          catch (java.util.NoSuchElementException e) { ; }
          
     }
     
     public static void main(String[] args) {
          
          Main a = new Main();
          F.go();
     }
        
}
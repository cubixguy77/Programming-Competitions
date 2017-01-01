import java.util.*;
import java.io.*;


public class I {
     
     private static String inputFile = "a.in";
     private static String outputFile = "a.test";
     private static String answerFile = "a.out";
     
     public static PriorityQueue<ruler> maps;
     
     public static ruler r;
     
     
     public static class ruler {
          public  ruler() {}
          public String name;
          public int yearStart;
          public int yearEnd;
          public int monthStart;
          public int monthEnd;
     }
     
     public static void addNew(String name, int yearStart, int yearEnd, int monthStart, int monthEnd) {
          r = new ruler();
          r.name = name;
          r.yearStart = yearStart;
          r.yearEnd = yearEnd;
          r.monthStart = monthStart;
          r.monthEnd = monthEnd;
          maps.add(r);
     }
     
     public static void print(int year) {
          PriorityQueue<ruler> temp = new PriorityQueue<ruler> (maps);
          
          System.out.print("Galactic year " + year + ": ");
          
          
          String string = "";
          while (temp.size() > 0) {
               ruler r = temp.remove();
               if (year >= r.yearStart && year <= r.yearEnd)
                    string += r.name + ", ";
          }
          if (string.equals(""))
               System.out.println("None");
          else if (!string.contains(","))
               System.out.println(string);     
          else
               System.out.println(string.substring(0, string.length() - 2));
          
     }
     
     public static void main(String[] asddf) {
          
          
          
          try {
               Scanner s = new Scanner(System.in);
               int num = s.nextInt();s.nextLine();
               
               
               
               maps = new PriorityQueue<ruler>(num, new Comparator<ruler>() {
                    public int compare(ruler ruler1, ruler ruler2) {
                         if (ruler1.yearStart > ruler2.yearStart)
                              return 1;
                         if (ruler1.yearStart < ruler2.yearStart)
                              return -1;
                         if (ruler1.monthStart > ruler2.monthStart)
                              return 1;
                         if (ruler1.monthStart > ruler2.monthStart)
                              return -1;
                         return 0;
                    }
               });
               
               
               
               for (int i=0; i<num; i++) {
                    String name = s.nextLine();
                    
                    String start = s.next();
                    String end = s.next(); s.nextLine();
                    
                    int yearStart = (int) Double.parseDouble(start);
                    int yearEnd = (int) Double.parseDouble(end);
                    
                    int monthStart = Character.getNumericValue(start.charAt(start.length() - 1));
                    int monthEnd   = Character.getNumericValue(end.charAt(end.length() - 1)); 
                    
                    addNew(name, yearStart, yearEnd, monthStart, monthEnd);
               }
               s.nextLine();
               while(s.hasNextLine()) {
                   int year = s.nextInt();s.nextLine();
                    print(year);
               }
          }
          
          catch (java.util.NoSuchElementException e) { ; }
          
     }

}
package March;

public class color {

     public int coloredCells(int n) {
          int L = 0;
          int R = n - 1;
          return 1 + 4L * n * (n - 1) / 2;
     }

     public static void main(String[] args) {

     }
}
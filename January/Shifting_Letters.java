package January;

public class Shifting_Letters {
     private char shift(char a, int n) {
          int i = a - 'a';
          i = (i + n) % 26;
          if (i < 0)
               i += 26;
          return (char) ('a' + i);
     }

     public String shiftingLetters(String s, int[][] shifts) {
          int n = s.length();
          int[] totShift = new int[n + 1];

          for (int[] shift : shifts) {
               if (shift[2] == 0) {
                    totShift[shift[0]]--;
                    totShift[shift[1] + 1]++;
               } else {
                    totShift[shift[0]]++;
                    totShift[shift[1] + 1]--;
               }
          }

          for (int i = 1; i < totShift.length; i++) {
               totShift[i] += totShift[i - 1];
          }

          StringBuilder result = new StringBuilder(s);
          for (int i = 0; i < n; i++) {
               result.setCharAt(i, shift(s.charAt(i), totShift[i]));
          }

          return result.toString();
     }

     public static void main(String[] args) {

     }
}
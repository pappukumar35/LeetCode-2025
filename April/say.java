package April;

public class say {
     public String countAndSay(int n) {
          if (n == 1)
               return "1";
          // recursion..
          String s = countAndSay(n - 1);// 21
          int count = 0;
          StringBuilder res = new StringBuilder();
          for (int i = 0; i < s.length(); i++) {
               count++;
               if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                    res.append(count);
                    res.append(s.charAt(i));
                    count = 0;
               }
          }
          return res.toString();
     }

     public static void main(String[] args) {

     }
}
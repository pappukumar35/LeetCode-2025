package April;

public class count2 {
     static final long MOD = 1_000_000_007;

     long modExp(long base, long exp, long mod) {
          long result = 1;
          base %= mod;
          while (exp > 0) {
               if ((exp & 1) == 1)
                    result = (result * base) % mod;
               base = (base * base) % mod;
               exp >>= 1;
          }
          return result;
     }

     public int countGoodNumbers(long n) {
          long evens = (n + 1) / 2;
          long odds = n / 2;
          long evenPart = modExp(5, evens, MOD);
          long oddPart = modExp(4, odds, MOD);
          return (int) ((evenPart * oddPart) % MOD);
     }

     public static void main(String args[]) {

     }
}
package june;

public class count {
     public int countGoodArrays(int n, int m, int k) {
          if (fact[0] == 0)
               fact[0] = 1;
          long res = m * fastExp(m - 1, n - 1 - k) % MOD * combination(n - 1, n - 1 - k) % MOD;
          return (int) res;
     }

     int MOD = 1_000_000_007;
     static long[] inverse = new long[100001];
     static int[] fact = new int[100001];

     private long fastExp(int base, int exp) {
          long result = 1;
          long mult = base;
          while (exp > 0) {
               if ((exp & 1) == 1)
                    result = result * mult % MOD;
               mult = mult * mult % MOD;
               exp /= 2;
          }
          return result;
     }

     private long combination(int total, int select) {
          return (long) factorial(total) * modInv(factorial(total - select)) % MOD * modInv(factorial(select)) % MOD;
     }

     private long factorial(int n) {
          if (fact[n] != 0)
               return fact[n];
          return fact[n] = (int) (factorial(n - 1) * n % MOD);
     }

     private long modInv(long x) {
          if (x == 1)
               return x;
          return MOD - MOD / x * modInv(MOD % x) % MOD;
     }

     public static void main(String[] args) {

     }
}
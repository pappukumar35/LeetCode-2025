package April;

public class find {
     public long factorial(int num) {
          long result = 1;
          for (int i = 1; i <= num; i++) {
               result *= i; // Multiply from 1 to num (like 1 * 2 * 3 * ... * num)
          }
          return result; // Return the final factorial value
     }

     // 🌀 This function recursively generates all palindromic numbers of length 'n'
     public void generatePalindromes(char[] currentNumber, int index, List<String> validPalindromes, int k) {
          // Base case: if we've filled the entire number from both ends
          if (index >= (currentNumber.length + 1) / 2) {
               String palindrome = new String(currentNumber); // Convert char[] to string
               // ✅ Only keep this number if it's divisible by k
               if (Long.parseLong(palindrome) % k == 0) {
                    validPalindromes.add(palindrome);
               }
               return;
          }

          // ⚠️ Try placing '0' at this index (but not in the first position)
          if (index != 0) {
               currentNumber[index] = '0';
               currentNumber[currentNumber.length - 1 - index] = '0'; // Mirror placement
               generatePalindromes(currentNumber, index + 1, validPalindromes, k); // Move to next index
          }

          // 🔁 Try placing digits from '1' to '9' at current index (mirrored on both
          // sides)
          for (char c = '1'; c <= '9'; c++) {
               currentNumber[index] = c;
               currentNumber[currentNumber.length - 1 - index] = c; // Mirror the digit
               generatePalindromes(currentNumber, index + 1, validPalindromes, k); // Recurse deeper
          }
     }

     // 🎯 This is the main function that returns the final answer
     public long countGoodIntegers(int n, int k) {
          List<String> validPalindromes = new ArrayList<>(); // Stores all valid palindromes
          char[] basePalindrome = new char[n]; // Initial base: all zero characters
          Arrays.fill(basePalindrome, '0'); // Fill it with '0's
          generatePalindromes(basePalindrome, 0, validPalindromes, k); // Start building palindromes

          Set<String> uniquePatterns = new HashSet<>(); // Store unique frequency patterns

          // 🧮 For each valid palindrome, generate a "frequency pattern" string
          for (String palindrome : validPalindromes) {
               int[] freq = new int[10]; // Array to count digits 0 to 9
               for (char ch : palindrome.toCharArray()) {
                    freq[ch - '0']++; // Increase count for digit
               }

               // 🧵 Convert frequency into a pattern string (like a hash)
               StringBuilder pattern = new StringBuilder();
               for (int f : freq) {
                    pattern.append((char) ('a' + f)); // Convert frequency number to a letter
               }

               uniquePatterns.add(pattern.toString()); // Add the pattern to the set (no duplicates)
          }

          long totalPermutations = factorial(n); // Total permutations of n digits
          long totalValidPermutations = 0; // We'll accumulate the final answer here

          // 🔍 For each unique digit pattern, calculate how many valid permutations it
          // can make
          for (String pattern : uniquePatterns) {
               long permutations = totalPermutations;

               // 🧩 Divide by factorials of repeated digits to handle duplicates (like
               // permutations with repeated elements)
               for (char ch : pattern.toCharArray()) {
                    permutations /= factorial(ch - 'a'); // Convert char back to count (reverse of earlier encoding)
               }

               // ⚠️ Remove permutations that start with 0 — they are not valid integers
               if (pattern.charAt(0) != 'a') { // Means we have leading zeros
                    int zeroCount = pattern.charAt(0) - 'a' - 1; // Remove 1 zero from front
                    long invalidPerms = factorial(n - 1); // First digit can't be 0, fix it and permute rest

                    // 🔄 Again, remove duplicates due to repeated digits (excluding the leading
                    // zero)
                    for (int j = 1; j < pattern.length(); j++) {
                         invalidPerms /= factorial(pattern.charAt(j) - 'a');
                    }

                    invalidPerms /= factorial(zeroCount); // Adjust for leading zero count
                    permutations -= invalidPerms; // Subtract invalid ones
               }

               totalValidPermutations += permutations; // Add valid permutations to total
          }

          return totalValidPermutations; // Return final answer
     }

     public static void main(String args[]) {

     }
}
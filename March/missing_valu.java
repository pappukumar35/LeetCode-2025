package March;

public class missing_value {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length, repeated = -1;
        int[] freq = new int[n * n + 1];

        for (int[] row : grid) {
            for (int num : row) {
                if (freq[num] == 1) {
                    repeated = num;
                }
                freq[num]++;
            }
        }

        for (int i = 1; i <= n * n; i++) {
            if (freq[i] == 0) {
                return new int[] { repeated, i };
            }
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {

    }
}
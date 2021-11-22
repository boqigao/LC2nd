package string;

public class LC299 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getHint("1807", "7810"));
    }
    static class Solution {
        public String getHint(String secret, String guess) {
            int bull = 0;
            int cow = 0;
            char[] secretChars = secret.toCharArray();
            char[] guessChars = guess.toCharArray();

            for (int i = 0; i < secretChars.length; i++) {
                if (secretChars[i] == guessChars[i]) {
                    bull++;
                    secretChars[i] = 'a';
                    guessChars[i] = 'b';
                }
            }

            int[] secretDigits = new int[10];
            int[] guessDigits = new int[10];
            for (int i = 0; i < secretChars.length; i++) {
                if (secretChars[i] >= '0' && secretChars[i] <= '9') {
                    secretDigits[secretChars[i] - '0']++;
                }

                if (guessChars[i] >= '0' && guessChars[i] <= '9') {
                    guessDigits[guessChars[i] - '0']++;
                }
            }
            for (int i = 0; i < 10; i++) {
                cow += Math.min(secretDigits[i], guessDigits[i]);
            }


            return bull+"A"+cow+"B";
        }
    }
}

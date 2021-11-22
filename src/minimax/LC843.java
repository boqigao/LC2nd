package minimax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC843 {

    class Solution {

        class Master {
            Master() {

            }

            public int guess(String s) {
                return 0;
            }
        }
        public void findSecretWord(String[] wordlist, Master master) {

            List<String> list = Arrays.asList(wordlist);
            for (int k = 0; k < 10; k++) {
                String candidate = chooseWord(list);
                int n = master.guess(candidate);
                if (n == 6) {
                    return;
                }
                List<String> tmp = new ArrayList<>();
                for (String word : list) {
                    if (match(word, candidate) == n) {
                        list.add(word);
                    }
                }
                list = tmp;
            }
        }

        private String chooseWord(List<String> words){
            int n = words.size();
            int[][] memory = new int[n][7];

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int dist = match(words.get(i), words.get(j));
                    memory[i][dist]++;
                    memory[j][dist]++;
                }
            }

            int min = n, mini = 0;
            for (int i =0; i < n; i++) {
                int max = 0;
                for (int j = 0; j < 7; j++) {
                    if (memory[i][j] > max) {
                        max = memory[i][j];
                    }
                }
                if (max < min) {
                    min = max;
                    mini = i;
                }
            }
            return (String) words.get(mini);
        }

        private int match (String candidate, String compare) {
            int m = 0;
            for (int i = 0; i < candidate.length(); i++) {
                if (candidate.charAt(i) == compare.charAt(i)) {
                    m++;
                }
            }
            return m;
        }
    }


}




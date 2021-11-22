package trick;

import java.sql.Struct;

public class LC681 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.nextClosestTime("22:59"));
    }
    static class Solution {
        public String nextClosestTime(String time) {
            int[] digit = new int[]{
                    time.charAt(0) - 48, time.charAt(1) - 48,
                    time.charAt(3) - 48, time.charAt(4) - 48
            };


            int curTime = (digit[0] * 10 + digit[1]) * 60 + digit[2] * 10
                    + digit[3];

            boolean[] current = new boolean[10];
            for (int i = 0; i < 4; i++) {
                current[digit[i]] = true;
            }

            for (int i = 1; i <= 60 * 24; i++) {
                int targetTime = 0;
                if ((curTime + i) > 60 * 24) {
                    targetTime = curTime + i - 60 * 24;
                } else {
                    targetTime = curTime + i;
                }
                if (canForm(targetTime, current)) {
                    return toTime(targetTime);
                }
            }
            return "";
        }

        private String toTime(int targetTime) {
            int targetHour = targetTime / 60;
            String strTarHour = targetHour + "";
            if (targetHour < 10) {
                strTarHour = "0" + strTarHour;
            }
            int targetMinute = targetTime % 60;
            String strTarMinute = targetMinute + "";
            if (targetMinute < 10) {
                strTarMinute = "0" + targetMinute;
            }

            return strTarHour + ":" + strTarMinute;
        }
        
        private boolean canForm(int targetTime, boolean[] current) {

            int targetHour = targetTime / 60;
            String strTarHour = targetHour + "";
            if (targetHour < 10) {
                strTarHour = "0" + strTarHour;
            }
            int targetMinute = targetTime % 60;
            String strTarMinute = targetMinute + "";
            if (targetMinute < 10) {
                strTarMinute = "0" + targetMinute;
            }
            
            boolean[] bucket = new boolean[10];
            bucket[strTarHour.charAt(0) - 48] = true;
            bucket[strTarHour.charAt(1) - 48] = true;
            bucket[strTarMinute.charAt(0) - 48] = true;
            bucket[strTarMinute.charAt(1) - 48] = true;

            for (int i = 0; i < 10; i++) {
                if (bucket[i] && !current[i] ) {
                    return false;
                }
            }
            return true;
        }
    }
}

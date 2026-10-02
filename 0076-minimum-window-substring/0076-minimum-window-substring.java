class Solution {
    public String minWindow(String s, String t) {

        int[] freq = new int[128];

        // Required frequency of characters in t
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }

        int l = 0;
        int r = 0;

        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (r < s.length()) {

            char ch = s.charAt(r);

            // Current character required hai
            if (freq[ch] > 0) {
                required--;
            }

            freq[ch]--;
            r++;

            // Window valid hai
            while (required == 0) {

                // Minimum window update
                if (r - l < minLen) {
                    minLen = r - l;
                    start = l;
                }

                char leftChar = s.charAt(l);

                freq[leftChar]++;

                // Agar frequency positive ho gayi,
                // matlab ye character window se remove hone ke baad
                // required ho gaya
                if (freq[leftChar] > 0) {
                    required++;
                }

                l++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}
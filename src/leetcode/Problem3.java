package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s) || s.isEmpty()) return 0;
        int max = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(j - i, max);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}


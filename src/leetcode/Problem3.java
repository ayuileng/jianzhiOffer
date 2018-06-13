package leetcode;

import java.util.HashSet;

public class Problem3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s) || s.isEmpty()) return 0;
        int max = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        //i是滑动窗口的左边界，j是滑动窗口的右边界
        int i=0;int j=0;
        while(i<s.length() && j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max = Math.max(max,j-i);
            }else{
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


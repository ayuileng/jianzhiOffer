package leetcode;

public class Problem5 {
    //暴力解法
    public static String longestPalindrome(String s) {
        int max = Integer.MIN_VALUE;
        String result = "";
        if (s == null || "".equals(s) || s.isEmpty()) return "";
        if(s.length() == 1) return s;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isPalindrome(sub)) {
                    if(sub.length()>max){
                        max = sub.length();
                        result = sub;
                    }
                }
            }
        }
        return result;

    }

    private static boolean isPalindrome(String s) {
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }


    public static String longestPalindrome1(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];

        return null;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
}

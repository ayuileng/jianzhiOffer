package jianzhioffer;

public class Problem5 {
    public static String replaceSpace(StringBuffer str) {
        char[] arr = str.toString().toCharArray();
        int count = 0;
        for (char c : arr) {
            if (c == ' '){
                count++;
            }
        }
        char[] res = new char[arr.length+2*count];
        int index1 = arr.length-1;
        int index2 = res.length-1;
        while (index1 >= 0 ){
            if(arr[index1] != ' '){
                res[index2] = arr[index1];
                index1--;
                index2--;
            }else{
                res[index2] = '0';
                index2--;
                res[index2] = '2';
                index2--;
                res[index2] = '%';
                index1--;
                index2--;
            }
        }
        return String.valueOf(res);
    }

}

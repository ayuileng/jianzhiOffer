package jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;

public class Problem38 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str == null || "".equals(str) || str.isEmpty()) return result;
        char[] arr = str.toCharArray();
        permutation(arr,0,result);
        Collections.sort(result);
        return result;
    }

    private void permutation(char[] arr, int index, ArrayList<String> result) {
        if(index == arr.length-1){
            result.add(String.valueOf(arr));
        }
        for(int i = index;i<arr.length;i++){
            if(index != i && arr[i] == arr[index]){
                continue;
            }
            swap(arr,index,i);
            permutation(arr,index+1,result);
            swap(arr,index,i);

        }
    }

    private void swap(char[] arr ,int i,int j){
        char temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new Problem38().Permutation("abcd");
        for (String s : list) {
            System.out.println(s);
        }
    }

}

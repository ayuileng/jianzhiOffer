package jianzhioffer;

public class Problem11 {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int start = 0;
        int end = array.length - 1;
        if (array[start] < array[end]) {
            return array[start];
        }
        while (start < end-1) {
            int mid = start + (end - start) / 2;
            if(array[mid] == array[start]&& array[start] == array[end]){
                return tranvers(array,start,end);
            }
            if(array[mid]>=array[start]){
                start = mid;
            }else if(array[mid]<=array[end]){
                end = mid;
            }
        }
        return array[end];
    }

    private int tranvers(int[] array, int start, int end) {
        int res = array[start];
        for (int i = start+1; i <= end; i++) {
            res = Math.min(res,array[i]);
        }
        return res;
    }


}

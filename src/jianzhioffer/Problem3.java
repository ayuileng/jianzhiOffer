package jianzhioffer;

public class Problem3 {
    public boolean duplicate(int numbers[]) {
        if (numbers == null || numbers.length == 0) return false;
        for (int i = 0; i < numbers.length; i++) {
            while (i != numbers[i]){
                if(numbers[i] == numbers[numbers[i]]){
                    return true;
                }
                int tmp = numbers[i];
                numbers[i] = numbers[tmp];
                numbers[tmp] = tmp;

            }
        }
        return false;
    }
}

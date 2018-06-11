package jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;

public class Problem45 {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        ArrayList<String> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(String.valueOf(number));
        }
        Collections.sort(list, (o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return Integer.valueOf(s1).compareTo(Integer.valueOf(s2));
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();

    }


}

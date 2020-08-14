package Interview.QAX;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/8/1 16:09
 * @Title&Description: 数字的全排列
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test02 {
    public static void main(String[] args) {
        int[] digit = {1,1,2};
        System.out.println(reletive_7(digit));
    }

    public static int reletive_7 (int[] digit) {
        if (digit == null || digit.length < 1){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        int[] isUsed = new int[digit.length];
        process(digit, "", list, isUsed);
        int num = 0;
        for (int temp : list){
            if (temp % 7 == 0){
                num++;
            }
        }
        return num;
    }

    public static void process(int[] digit, String path, List<Integer> list, int[] isUsed){
        if (path.length() == digit.length){
            list.add(Integer.valueOf(path));
            return;
        }
        for (int i=0; i<digit.length; i++){
            if (isUsed[i] == 0){
                isUsed[i] = 1;
                process(digit, path + String.valueOf(digit[i]), list, isUsed);
                isUsed[i] = 0;
            }
        }
    }
}

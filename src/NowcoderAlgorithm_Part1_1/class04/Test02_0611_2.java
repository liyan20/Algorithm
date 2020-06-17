package NowcoderAlgorithm_Part1_1.class04;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xianz
 * @Date: 2020/6/11 20:10
 * @Title&Description: 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解
 * 例如：
 * 给出的数组为 {2, 7, 11, 15},目标值为9
 * 输出 ndex1=1, index2=2
 * 输入
 * [3,2,4],6
 * 输出
 * [2,3]
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test02_0611_2 {
    public static void main(String[] args) {

    }

    public int[] twoSum (int[] numbers, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int index1 = 0, index2 = 0;
        for (int i=0; i<numbers.length; i++){
            map.put(numbers[i], i);
        }
        for (int i=0; i<numbers.length; i++){
            int temp = target - numbers[i];
            //这个地方的判断条件要注意，要防止等于当前的index的情况
            if (map.containsKey(temp) && map.get(temp) != i){
                index1 = i;
                index2 = map.get(temp);
                break;
            }
        }
        //这题的index是从1开始的
        return new int[] {index1+1, index2+1};
    }
}

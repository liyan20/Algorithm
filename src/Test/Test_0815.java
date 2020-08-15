package Test;

import java.util.ArrayList;
import java.util.*;

/**
 * @Author: xianz
 * @Date: 2020/8/15 09:47
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test_0815 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.sort(list, (Integer o1, Integer o2) ->{
            return o1 - o2;
        });
    }
}

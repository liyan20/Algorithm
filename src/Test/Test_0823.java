package Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/8/23 17:49
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Test_0823 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        System.out.println(list.getClass() == list1.getClass());
        System.out.println(list.getClass() + "-" + list1.getClass());
    }

}

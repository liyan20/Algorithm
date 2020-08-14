package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/8/10 10:50
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class TestOver02 extends TestOverLoad {
    @Override
    public int getPow(int a, int b) {
        return super.getPow(a, b);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1 - o2;
            }
        });
    }


}

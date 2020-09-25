package MultyThreads.Atomic;



/**
 * @Author: xianz
 * @Date: 2020/9/8 23:37
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.concurrent.atomic.AtomicInteger;
public class AtomicIntegerDemo02 {

    public static void main(String[] args) {
        AtomicInteger atomic = new AtomicInteger(0);

        //对变量进行加上指定的数字的操作，类似于i+=n
        //这个是get在前add在后，就是先输出变量值在对其进行加法操作
        System.out.println(atomic.getAndAdd(1));

        //这个是先增加再get，就是先对变量+1然后返回，类似++i的操作
        System.out.println(atomic.incrementAndGet());

        //获取对象当前的值
        System.out.println(atomic.get());
    }

}

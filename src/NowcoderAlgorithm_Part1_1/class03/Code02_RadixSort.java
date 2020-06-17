package NowcoderAlgorithm_Part1_1.class03;



/**
 * @Author: xianz
 * @Date: 2020/5/31 14:30
 * @Title&Description: 基数排序
 * 所有的数据必须是十进制的。根据从个位数到十位数到百位数分别排序，同时保存上一位数排序的相对顺序
 * 因为是十进制，使用10个桶，这个桶是队列。使用队列先进先出的特性，来维持同一位数上的上一位数的相对顺序
 * 比如22，24，27，在排10位的时候都是2，但是个位数不一样，因为第一波是按照个位数排序是2，4，7的顺序
 * 所以用队列，进入的顺序是22，24，27，出来的时候也是22，24，27，先进先出。
 * @Analysis: 总体思想是对位数从个位到十位到百位等等进行处理，按照当前位的数值放入桶中，而如果是有多个数组的
 * 当前位是同一个数，那么就按照上一位处理后的顺序来放置。比如22，23，27。十位都是2，上一位是按照2，3，7放置
 * 在处理十位的时候，也要按照22，23，27来放置
 * @ThinkingSteps:
 * @TimeConsuming:
 */

public class Code02_RadixSort {
    public static void main(String[] args) {
        int[] arr = {5,7,3,45,67,87,3,54,23,75,126,34,178,90,100,201};
        radixSort(arr, 0, arr.length-1, maxBit(arr));
        for(int temp : arr){
            System.out.print(temp + " ,");
        }
    }

    public static void radixSort(int[] arr, int L, int R, int digit){
        final int radix = 10;
        int i = 0;
        int j = 0;
        //bucket是辅助空间，用来存放排序的结果
        //digit是最大数有多少位
        int[] bucket = new int[R - L + 1];
        for (int d = 1; d <= digit; d++){
            int[] count = new int[radix];

            //这一步是计算每个数在d位上面的词频统计
            for(i=L; i<=R; i++){
                j = getDigit(arr[i], d);
                count[j]++;
            }
            //这一步，在count[i]里面保存了，小于等于i的数总共有多少
            for (i=1; i<radix; i++){
                count[i] += count[i-1];
            }
            //这一步比较难。主要的思想是对原数组从右往左遍历，看当前数的d位数是几，找count对应的值，
            // count里面代表的是小于等于i的个数。然后在这个个数的范围内，将数组里面的数放在这个范围的最后一个。
            //同时count[i]-1，下次再遇到同样的当前位的数值的时候，就在前面的范围内放置就行了
            //这样的好处是，因为是从右往左遍历，而每次针对上一位的处理都是对上一位排好序的，所以从右往左对上一位是
            //从大到小的顺序，而基数排序要保证上一次处理的相对顺序不变，所以从右到左遍历，也从右到左放。
            //这样就能保证，在当前d位上面是一样的数，他们的顺序是按照d-1位的顺序来的。
            //至于为什么不从左到右，因为从左到右你不知道放在哪。比如目前小于等于2的有6个，数组里面数的顺序是22，32
            // 从左到右遇到第一个22，你不知道放哪，放在第一个，不行，这样后面要是有是11的怎么办，放在第5位，也不行，
            //因为这样后面遇到32的时候只能往左边放了，这样就改变了上一次处理的相对顺序了。
            //所以从右往左放，既保证了在整个辅助桶的顺序，也保证了同一个当前位的数组的时候，在上一位处理中的相对位置。
            //每放一个数，对应的count[i]就减一，代表有一个数被放过了
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i=L,j=0; i<=R&&j<bucket.length; i++,j++){
                arr[i] = bucket[j];
            }
        }
    }

    public static int maxBit(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int temp : arr){
            max = Math.max(max, temp);
        }
        int maxbit = 0;
        while (max != 0){
            maxbit++;
            max /= 10;
        }
        return maxbit;
    }

    //这个是获得当前数x的第d位的值
    public static int getDigit(int x, int d){
        return x / ((int)Math.pow(10, d-1)) % 10;
    }

}

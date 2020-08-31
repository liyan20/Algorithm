package Collections;

/**
 * @Author: xianz
 * @Date: 2020/8/26 19:13
 * @Title&Description: 华为笔试第一题2020.08.26
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class CodeHW0826 {
    public static void main(String[] args) {
        int[] arr = {1,2};
        solution(arr);
    }

    public static void solution(int[] arr){
        String[] strArr = new String[arr.length];
        for (int i=0; i<arr.length; i++){
            strArr[i] = toRealDigit(arr[i]);
            strArr[i] = process1(strArr[i]);
        }

        //先得到最后一个数的前两位
        String sLast = strArr[strArr.length-1];
        String highTwoBit = sLast.substring(30, 32);

        //新建一个字符串数组来保存结果
        String[] strRes = new String[arr.length];
        strRes[0] = highTwoBit + strArr[0].substring(0,30);

        for (int i=0; i+1<arr.length; i++){
            String newStr2 = strArr[i].substring(30, 32) + strArr[i+1].substring(0,30);
            strRes[i+1] = newStr2;
        }

        long[] res = new long[arr.length];
        for (int i=0; i<strRes.length; i++){
            res[i] = Long.valueOf(strRes[i], 2);
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<res.length; i++){
            sb.append(res[i]);
            if (i != res.length-1){
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    //生成32位2进制字符串，不足32位的补0
    public static String toRealDigit(int n){
        String s = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < 32){
            sb.insert(0, 0);
        }
        return sb.toString();
    }

    //两两位交换，返回二进制字符串
    public static String process1(String s){
        char[] arr = s.toCharArray();
        for (int i=0; i + 1 < arr.length; i += 2){
            swap(arr, i, i+1);
        }
        //使用Integer按照二进制转
        return String.valueOf(arr);
    }

    public static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

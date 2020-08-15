package Interview.MEITUAN;

/**
 * @Author: xianz
 * @Date: 2020/8/15 16:21
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test02_0815 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = Integer.valueOf(sc.nextLine());
            String[] arr = new String[n];
            for (int i=0; i<n; i++){
                arr[i] = sc.nextLine();
            }
            System.out.println(solution(arr));

        }
    }

//    public static void main(String[] args) {
//        String[] arr = {"beijing beijing"};
//        String[] arr2 = {"beijing nanjing", "nanjing guangzhou",
//                "guangzhou shanghai", "shanghai beijing", "fuzhou beijing", "beijing fuzhou"};
//        System.out.println(solution(arr));
//    }

    public static int solution(String[] arr){
        if (arr == null || arr.length < 1){
            return 0;
        }
        int num = 0;
        String from = arr[0].split(" ")[0];
        String to;
        for (int i=1; i<arr.length; i++){
            to = arr[i].split(" ")[1];
            if (to.equals(from)){
                num++;
                if (i == arr.length-1){
                    break;
                }else {
                    from = arr[i + 1].split(" ")[0];
                }
            }
        }
        return num;
    }
}

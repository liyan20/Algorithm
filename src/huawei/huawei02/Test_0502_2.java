package huawei.huawei02;

/**
 * @Author: xianz
 * @Date: 2020/5/2 09:21
 * @Title: 蛇形矩阵
 * @Description:
 * @InputDescription:
 * @OuputDescription:
 * @TimeConsuming: 25min
 */
import java.util.Scanner;
public class Test_0502_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            Solution(num);
        }
    }

    public static void Solution(int num){
        for(int i=0; i<num; i++){
            StringBuilder sb = new StringBuilder();
            int start = (i*i+i+2)/2;
            int temp = start;
            for(int j=i; j<num-1; j++){
                temp += j + 2;
                sb.append(temp + " ");
            }
            sb.insert(0, start+" ");
            System.out.println(sb.toString());
        }
    }
}

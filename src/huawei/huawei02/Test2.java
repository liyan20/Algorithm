package huawei.huawei02;

/**
 * @Author: xianz
 * @Date: 2020/5/3 11:51
 * @Title:
 * @Description:
 * @InputDescription:
 * @OuputDescription:
 * @Analysis:
 * @TimeConsuming:
 */

public class Test2 {
    public static void main(String[] args) {
        int num = 40;
        long startTime = System.currentTimeMillis();
        for(int i=0;i<num;i++){
            System.out.println(i+"-"+fab(i));
        }
        System.out.println(fab(39));
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }

    public static int fab(int n){
        if(n == 0 || n == 1){
            return n;
        }else{
            return fab(n-1)+fab(n-2);
        }
    }

}

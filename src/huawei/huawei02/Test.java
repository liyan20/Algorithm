package huawei.huawei02;

/**
 * @Author: xianz
 * @Date: 2020/5/2 15:24
 * @Title:
 * @Description:
 * @InputDescription:
 * @OuputDescription:
 * @Analysis
 * @TimeConsuming:
 */
import java.util.*;
public class Test {
    public static void main(String[] args) {
//        int i = 0xa;
        String a = "a";
        char cha = 'a';
        Long l = (long)9999;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int i=0;
        for(i=0;i<5;++i){
            if(i == 3){
                break;
            }
            System.out.print(i);
        }
        System.out.println();
        System.out.println(i);

//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            System.out.println(sc.nextInt());
//            System.out.println(sc.nextInt());
//            sc.nextLine();
////            System.out.println(sc.nextLine());
//            System.out.println(sc.nextLine());
//        }

        List<Integer> temp = new ArrayList<>();
        temp = list.subList(3,4);
//        System.out.println(temp);
//        System.out.println(Integer.toBinaryString('我'));
//        System.out.println((int)(long)l);
//
//        System.out.println(Integer.toBinaryString(193));
//        System.out.println(Integer.valueOf("11111111",2));
//        System.out.println((char)('a'+1));
//        System.out.println((int)cha);
//        System.out.println(Integer.valueOf(cha));
//        System.out.println(Integer.valueOf(""+cha,16));
//        StringBuilder sb = new StringBuilder(Integer.toBinaryString(16));
//        System.out.println(sb);
////        System.out.println(sb.deleteCharAt(0));
//        System.out.println(sb.delete(0,1));
//        System.out.println(sb.toString());
////        System.out.println(i);
////        System.out.println("0x"+'a');
//        System.out.println("1".toUpperCase());
//        System.out.println(Integer.valueOf("0010",2));
//        System.out.println(Integer.valueOf(a,16));
////        String a = "abc";
//        System.out.println(a.toUpperCase());
//        System.out.println(Integer.toHexString(i));
    }
}

package huawei.huawei02;

/**
 * @Author: xianz
 * @Date: 2020/5/2 14:08
 * @Title: 查找兄弟单词
 * @Description:
 * @InputDescription: 先输入字典中单词的个数，再输入n个单词作为字典单词。
 * 输入一个单词，查找其在字典中兄弟单词的个数，再输入数字n 3 abc bca cab abc 1
 * @OuputDescription: 根据输入，输出查找到的兄弟单词的个数
 * @Analysis: 输入单词组成字典，对字典排序。然后输入的是要找的单词的第n个兄弟单词，我们要输出兄弟单词的个数，然后输出第n个兄弟单词
 * @TimeConsuming: 1h23min
 */
import java.util.*;
public class Test_0502_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            List<String> list = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            int n = sc.nextInt();
            for(int i=0; i<n; i++){
                list.add(sc.next());
            }
            String target = sc.next();
            int index = sc.nextInt();
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.length() == 0 && o2.length() == 0){
                        return 0;
                    }
                    if(o1.equals(o2)){
                        return 0;
                    }
                    int min = Math.min(o1.length(), o2.length());
                    if(o1.substring(0, min).equals(o2.substring(0, min))){
                        return o1.length()-o2.length();
                    }else{
                        int temp = -1;
                        for(int i=0;i<min;i++){
                            if(o1.charAt(i)!=o2.charAt(i)){
                                temp = i;
                                break;
                            }
                        }
                        return o1.charAt(temp) - o2.charAt(temp);
                    }
                }
            });
            for(int i=0; i<list.size(); i++){
                if(isBrother(list.get(i), target)){
                    list2.add(list.get(i));
                }
            }
            System.out.println(list2.size());
            if(index>=1 && index<=list2.size()){
                System.out.println(list2.get(index-1));
            }
        }
    }

    public static boolean isBrother(String str1, String str2){
        if(str1.equals(str2)){
            return false;
        }
        char[] chalist1 = str1.toCharArray();
        char[] chalist2 = str2.toCharArray();
        Arrays.sort(chalist1);
        Arrays.sort(chalist2);
        if(Arrays.equals(chalist1, chalist2)){
            return true;
        }else{
            return false;
        }
    }

}

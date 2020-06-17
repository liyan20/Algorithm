package huawei.huawei01;

/**
 * @Author: xianz
 * @Date: 2020/4/25 16:12
 * @Title: 合并表记录
 * @Description: 数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * @InputDescription: 先输入键值对的个数，然后输入成对的index和value值，以空格隔开
 * @OuputDescription: 输出合并后的键值对（多行）
 */
import java.util.*;
public class Test_0425_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            Map<Integer,Integer> map = new TreeMap<>();
            int n = sc.nextInt();
            for(int i=0;i<n;i++){
                int index = sc.nextInt();
                int value = sc.nextInt();
                if(map.get(index) == null){
                    map.put(index, value);
                }else{
                    value += map.get(index);
                    map.put(index, value);
                }
            }
            for(Iterator<Integer> iter = map.keySet().iterator(); iter.hasNext();){
                Integer temp = iter.next();
                System.out.println(temp+" "+ map.get(temp));
            }
        }
    }
}

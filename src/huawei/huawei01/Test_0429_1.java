package huawei.huawei01;

/**
 * @Author: xianz
 * @Date: 2020/4/29 08:57
 * @Title: 数据分类处理 page2
 * @Description:
 * @InputDescription:
 * @OuputDescription:
 */
import java.util.*;
public class Test_0429_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            StringBuilder sb = new StringBuilder();
            int numI = sc.nextInt();
            List<String> listI = new ArrayList<>();
            for(int i=0;i<numI;i++){
                listI.add(sc.next());
            }
            int numR = sc.nextInt();
            Set<Integer> setR = new TreeSet<>();
            for(int i=0;i<numR;i++){
                setR.add(sc.nextInt());
            }
            for(Iterator<Integer> iter = setR.iterator(); iter.hasNext();){
                StringBuilder sbR = new StringBuilder();
                int num = 0;
                int tempR = iter.next();
//                System.out.println(tempR);
                for(int i=0; i<listI.size(); i++){
                    String tempI = listI.get(i);
                    if(tempI.contains(String.valueOf(tempR))){
                        sbR.append(i+" ");
                        sbR.append(tempI+" ");
                        num++;
                    }
                }
                if(num!=0){
                    sbR.insert(0, num+" ");
                    sbR.insert(0, tempR+" ");
                }
                sb.append(sbR);
            }
            int len = sb.toString().split(" ").length;
            sb.insert(0, len+" ");
            System.out.println(sb.toString());
        }
    }
}

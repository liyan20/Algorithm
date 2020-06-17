package huawei.huawei03;

/**
 * @Author: xianz
 * @Date: 2020/5/4 07:53
 * @Title: 称砝码
 * @Description:
 * @Analysis: 1.设w1,w2,w3，数量分别是2，3，4个。所以就有（1）0,w1,2w1;（2）0,w2,2w2,3w2;（3）0,w3,2w3,3w3,4w3这几种情况，
 * 每一个小部分代表当前重量的砝码的可能总重量（0个，1个，2个。。n个），然后每个砝码列表里面顺序选1个就行。
 * 可以先不算总为0的情况，最后加进去，用hashset去掉重复的就行
 * @ThinkingSteps: 修正：1.上面的方法在针对选i个的时候，要从n个砝码里面选i个出来，这个复杂度过高。
 * 修正：看别人的做法，是第一个砝码的多种重量放入set，然后是下一个砝码多种可能重量。
 *
 * ！！！这里面比较重要的是根据的是 <目前已有的重量> ，用这些重量的每一个加上下一个砝码的所有可能的重量，
 * 以重量为根据，而不是以砝码的多种排列组合为依据.
 * 所以说这个三重循环，第一个是遍历到第几个砝码，第二个是当前的set里面的重量，第三个是当前砝码的所有可能重量
 * @TimeConsuming: 65min
 */
import java.util.*;
public class Test_0504_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            List<Integer> weightList = new ArrayList<>();
            List<Integer> numList = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            int num = sc.nextInt();
            for(int i=0; i<num; i++){
                weightList.add(sc.nextInt());
            }
            for(int i=0; i<num; i++){
                numList.add(sc.nextInt());
            }
            set.add(0);
            for(int i=0;i<num;i++){    //i循环是选择第几个砝码，依次放入set
                List<Integer> currentList = new ArrayList<>(set);
                for(int j=0;j<currentList.size();j++){     //j循环是当前set里面的所有的重量，因为set无法用index遍历所以换成List
                    for(int k=1;k<=numList.get(i);k++){    //k循环是当前砝码的可能重量，全部加到set目前所有的数值上面
                        set.add(currentList.get(j) + weightList.get(i)*k);   //因为是要计算所有当前的set重量，所以用了无序的HashSet也没事
                    }
                }
            }
            System.out.println(set.size());
        }
    }
}

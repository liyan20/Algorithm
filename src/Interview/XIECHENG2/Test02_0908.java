package Interview.XIECHENG2;



/**
 * @Author: xianz
 * @Date: 2020/9/8 19:24
 * @Title&Description:
1. 背景: 订单系统的业务逻辑处理，通过采用工作流的方式进行处理，基于面向配置编程以利于后续扩展与维护.
2. 要求: 当前需要根据工作流的配置解析和找出所有工作流路径, 可能存在循环依赖路径.
3. 说明: 空格隔开的字符串每一个字母都代表一个节点. 比如a bc e, 表示a的下一个节点为b或者c， 输出为:abe, ace.
4. 举例: 有3个分支，
输入,
a bc df gh
输出如下， 结果输出根据单个字符的下标index排序:  Comparator.naturalOrder().
abdg
abdh
abfg
abfh
acdg
acdh
acfg
acfh
 * @Summary:
 * 输入工作流程配置(可能存在循环依赖路径)
 * 输出描述
 * 找出所有的路径, 正常路径与循环依赖路径,  并且必须标识出循环依赖路径(后缀为--circular dependency),
 * 当前实例题仅为2个分支场景. 3个或3个以上分支请见上面举例
 * 样例输入
 * a bc d eag f
 * 样例输出
 * abdef
 * abdaf--circular dependency
 * abdgf
 * acdef
 * acdaf--circular dependency
 * acdgf
 * @TimeConsuming:
 */

import java.util.*;

public class Test02_0908 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            solution(s);
        }
    }

    public static void solution(String s){
        String[] strArr = s.split(" ");
        List<String> lists = new ArrayList<>();
        process(0, strArr, "", lists);
        for (int i=0; i<lists.size(); i++){
            String cur = lists.get(i);
            if (isCycle(cur)){
                System.out.println(cur + "--circular dependency");
            }else {
                System.out.println(cur);
            }
        }
    }

    public static void process(int index, String[] strArr, String path, List<String> lists){
        //base case
        if (index == strArr.length){
            lists.add(path);
            return;
        }
        for (int i=0; i<strArr[index].length(); i++){
            String newPath = path + strArr[index].charAt(i);
            process(index+1, strArr, newPath, lists);
        }
    }

    public static boolean isCycle(String s){
        Set<Character> set = new HashSet<>();
        for (int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if (set.contains(cur)){
                return true;
            }else {
                set.add(cur);
            }
        }
        return false;
    }

}

package Test;

import java.util.List;

/**
 * @Author: xianz
 * @Date: 2020/6/3 14:30
 * @Title&Description: 要根据时间来判断，同一时间如果出现了多次要加起来
 * @Analysis:
 * @ThinkingSteps:
 * @TimeConsuming:
 */
import java.util.*;
public class Interview_Huawei_0603 {
    public static void main(String[] args) {
        List<String> line = new ArrayList<>();
        List<String> list = new ArrayList<>();
        line.add("200117 AA");
        line.add("200117 BH");
        line.add("200117 AA");
        line.add("200144 BH");
        line.add("200144 FF");
        line.add("200144 CCCC");
        Solution(line, list);
        System.out.println("Input: ");
        for(int i=0;i<line.size();i++){
            System.out.println(line.get(i));
        }
        System.out.println();
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public static void Solution(List<String> line, List<String> list){
        if (line.size() == 0){
            return ;
        }
        //inputStr保存时间流字符串的顺序
        List<String> valList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
//        Map<String,Integer> mapName = new LinkedHashMap<>();
        for (int i=0; i<line.size(); i++){
            String temp = line.get(i);
            String namestr = temp.split(" ")[0];
            String valstr = temp.split(" ")[1];
            if(!valList.contains(valstr)){
                valList.add(valstr);
            }
            if (!map.containsKey(valstr)){
                map.put(valstr, 0);
            }
            if(!nameList.contains(namestr)){
                nameList.add(namestr);
            }
        }
        StringBuilder sb1 = new StringBuilder();
        sb1.append("TIME ");
        for (int i=0;i<valList.size();i++){
            sb1.append(valList.get(i)+" ");
        }
        sb1.deleteCharAt(sb1.length()-1);
        list.add(sb1.toString());

        for (int j=0;j<nameList.size();j++){
            String curname = nameList.get(j).split(" ")[0];
            StringBuilder sb = new StringBuilder();
            sb.append(curname + " ");
            for (int i=0; i<line.size();i++){
                if (line.get(i).split(" ")[0].equals(curname)){
                    map.put(line.get(i).split(" ")[1], map.get(line.get(i).split(" ")[1])+1);
                }
            }
            for (int k=0;k<valList.size();k++){
                String temp = valList.get(k);
                sb.append(map.get(temp) + " ");
            }
            putZero(valList, map);
            sb.deleteCharAt(sb.length()-1);
            list.add(sb.toString());
        }
    }
    public static void putZero(List<String> list, Map<String,Integer> map){
        for (int i=0;i<list.size();i++){
            map.put(list.get(i), 0);
        }
    }
}

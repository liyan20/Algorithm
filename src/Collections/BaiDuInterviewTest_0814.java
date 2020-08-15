package Collections;


/**
 * @Author: xianz
 * @Date: 2020/8/14 14:24
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.ArrayList;
import java.util.List;
public class BaiDuInterviewTest_0814 {
    public static void main(String[] args) {
        List<Character> listAll = new ArrayList<>();
        char[] arr = {'a', 'a', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'd', 'd', 'd'};
        for (int i=0; i<arr.length; i++){
            listAll.add(arr[i]);
        }
        System.out.println(listAll);
        List<List<Character>> solutionList = solution(listAll);
        List<Character> res = new ArrayList<>();
        for (int i=0; i<solutionList.size(); i++){
            List<Character> temp = solutionList.get(i);
            for (int j=0; j<temp.size(); j++){
                res.add(temp.get(j));
            }
        }

        System.out.println(solutionList);
        System.out.println(res);
    }

    public static List<List<Character>> solution(List<Character> listAll){
        List<List<Character>> res = new ArrayList<>();
        int size = listAll.size();
        while (size > 0){
            List<Character> list = new ArrayList<>();
            char cur = getFirst(listAll);
            list.add(cur);
            size--;
            for (int i=0; i<listAll.size(); i++){
                if (listAll.get(i) == '0'){
                    continue;
                }
                if (listAll.get(i) != cur){
                    list.add(listAll.get(i));
                    cur = listAll.get(i);
                    listAll.set(i, '0');
                    size--;
                }
            }
            res.add(list);
        }
        return res;
    }

    public static char getFirst(List<Character> listAll){
        for (int i=0; i<listAll.size(); i++){
            if (listAll.get(i) != '0'){
                char cur = listAll.get(i);
                listAll.set(i, '0');
                return cur;
            }
        }
        return '0';
    }
}

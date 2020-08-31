package Leetcode.Search_DynamicPrograming;

/**
 * @Author: xianz
 * @Date: 2020/8/29 17:32
 * @Title&Description: ["hot","dot","dog","lot","log","cog"]
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Code127_LadderLength_0829 {

    public static void main(String[] args) {
        String beginWord = "teach";
        String endWord = "place";
        List<String> wordList = new ArrayList<>();
        String[] arr = {"peale","wilts","place","fetch","purer","pooch","peace","poach","berra","teach","rheum","peach"};
        transfer(arr, wordList);
        System.out.println(ladderLength(beginWord, endWord, wordList));

    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int levelNum = 1;
        Deque<String> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[wordList.size()];
        Arrays.fill(isVisited, false);
        queue.offerLast(beginWord);
        while(!queue.isEmpty()){
            //这个levelNum和二叉树的层序遍历非常的像，就是一个东西，代表当前到第几层了。
            levelNum++;
            int size = queue.size();

            //这边非常的重要，是BFS的精髓，每次都要把当前层全部处理完再处理下一层。
            //并且这边是因为要考虑已经遇到过的情况，不可以重复搜索。
            //比如两个字符串都可以转化成新的字符串，在这里面这条路就只会出现一次。
            while (size > 0){
                //取出当前的进行搜索下面的可以转换的，如果正好转化成endWord了，就直接返回就行
                //如果不是要求的字符串，加进去。
                //因为是BFS所以返回的都是最短路径
                String cur = queue.pollFirst();
                for(int i=0; i<wordList.size(); i++){
                    //如果访问过直接continue
                    if(isVisited[i]){
                        continue;
                    }
                    String word = wordList.get(i);
                    if(isValid(cur, word)){
                        if(endWord.equals(word)){
                            return levelNum;
                        }else{
                            queue.offerLast(word);
                            isVisited[i] = true;
                        }
                    }
                }
                size--;
            }
        }
        //没有在上面返回的话，levelNum已经没有意义了，说明没找到，直接返回就行了。
        return 0;
    }

    //判断两个字符串是否可以只改变一个字符得到，方法是判断是否有且只有一位不同
    public static boolean isValid(String s1, String s2){
        int num = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                num++;
            }
        }
        return num == 1;
    }

    //将数组转成List的，无用
    public static void transfer(String[] arr, List<String> list){
        for (int i=0; i<arr.length; i++){
            list.add(arr[i]);
        }
    }

}

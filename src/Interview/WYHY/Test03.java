package Interview.WYHY;

/**
 * @Author: xianz
 * @Date: 2020/8/12 21:01
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int T = sc.nextInt();
            for (int t=0; t<T; t++){
                List<Info> list = new ArrayList<>();
                int N = sc.nextInt();
                for (int i=0; i<N; i++){
                    int time = sc.nextInt();
                    int id = sc.nextInt();
                    int status = sc.nextInt();
                    Info newInfo = new Info(time, id, status);
                    list.add(newInfo);
                }
                System.out.println(solution(list));
            }
        }
    }

//    public static void main(String[] args) {
//
//    }

    public static int solution(List<Info> list){
        Deque<Info> stack = new ArrayDeque<>();
        for (int i=0; i<list.size(); i++){
            Info curInfo = list.get(i);
            if (curInfo.status == 0){
                stack.offerFirst(curInfo);
            }
            if ((curInfo.id == stack.peekFirst().id) && curInfo.status == 1){
                Info poll = stack.pollFirst();
                curInfo.timeCost = curInfo.time - poll.time;
                poll.timeCost = curInfo.timeCost;
                addTime(stack, curInfo.timeCost);
            }
        }
        int maxTime = Integer.MIN_VALUE;
        int minId = 0;
        for (Info info : list){
            if (info.timeCost > maxTime){
                maxTime = info.timeCost;
                minId = info.id;
            }else if (info.timeCost == maxTime){
                minId = Math.min(minId, info.id);
            }
        }
        return minId;
    }

    public static void addTime(Deque<Info> stack, int timeCost){
        Deque<Info> dummy = new ArrayDeque<>();
        while (!stack.isEmpty()){
            Info curInfo = stack.pollFirst();
            curInfo.time += timeCost;
            dummy.offerFirst(curInfo);
        }
        while (!dummy.isEmpty()){
            stack.offerFirst(dummy.pollFirst());
        }
    }

    public static class Info{
        int time;
        int id;
        int status;
        int timeCost;
        public Info(int time, int id, int status) {
            this.time = time;
            this.id = id;
            this.status = status;
        }
    }
}

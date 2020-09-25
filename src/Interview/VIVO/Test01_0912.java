package Interview.VIVO;

/**
 * @Author: xianz
 * @Date: 2020/9/12 20:41
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test01_0912 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = Integer.valueOf(sc.nextLine());
            String pos = sc.nextLine();
            String[] arr = new String[n];
            for (int i=0; i<n; i++){
                arr[i] = sc.nextLine();
            }
            System.out.println(solution(pos, arr));
        }
    }

    public static int solution(String pos, String[] arr){
        //获取坐标和matrix矩阵
        String[] posArr = pos.split(" ");
        int x1 = Integer.valueOf(posArr[0]);
        int x2 = Integer.valueOf(posArr[1]);
        int y1 = Integer.valueOf(posArr[2]);
        int y2 = Integer.valueOf(posArr[3]);
        char[][] matrix = new char[arr.length][arr.length];
        for (int i=0; i<matrix.length; i++){
            String cur = arr[i];  //第i行
            for (int j=0; j<matrix[0].length; j++){
                matrix[i][j] = cur.charAt(j);
            }
        }
        int[][] isVisited = new int[matrix.length][matrix[0].length];
        List<Integer> list = new ArrayList<>();
        process(x1, y1, x2, y2, 0, list, matrix, isVisited);
        int min = Integer.MAX_VALUE;
        for (int i=0; i<list.size(); i++){
            min = Math.min(min, list.get(i));
        }
        return min;
    }

    public static void process(int i, int j, int x2, int y2, int path, List<Integer> list, char[][] matrix, int[][] isVisited){
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == '#' ||
                matrix[i][j] == '@' || isVisited[i][j] == 1){
            return;
        }
        if (i == x2 && j == y2){
            list.add(path);
            return;
        }

        isVisited[i][j] = 1;
        process(i+1, j, x2, y2, path+1, list, matrix, isVisited);
        process(i, j+1, x2, y2, path+1, list, matrix, isVisited);
        process(i-1, j, x2, y2, path+1, list, matrix, isVisited);
        process(i, j-1, x2, y2, path+1, list, matrix, isVisited);
    }

//    public static void process(int i, int j, int x2, int y2, int path, char[][] matrix, int[][] isVisited){
//        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == '#' ||
//                matrix[i][j] == '@' || isVisited[i][j] == 1){
//            return -1;
//        }
//        if (i == x2 && j == y2){
//            return 0;
//        }
//        isVisited[i][j] = 1;
//        int next1 = process(i+1, j, x2, y2, matrix, isVisited);
//        int next2 = process(i, j+1, x2, y2, matrix, isVisited);
//        int next3 = process(i-1, j, x2, y2, matrix, isVisited);
//        int next4 = process(i, j-1, x2, y2, matrix, isVisited);
//
//        next1 = next1 == -1 ? Integer.MAX_VALUE : next1;
//        next2 = next2 == -1 ? Integer.MAX_VALUE : next2;
//        next3 = next3 == -1 ? Integer.MAX_VALUE : next3;
//        next4 = next4 == -1 ? Integer.MAX_VALUE : next4;
//
//        int res = Math.min(Math.min(Math.min(next1, next2), next3), next4);
//        return  res == Integer.MAX_VALUE ? 0 : res + 1;
//    }
}

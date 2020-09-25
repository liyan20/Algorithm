package Interview.QUSHIKEJI;

/**
 * @Author: xianz
 * @Date: 2020/9/12 19:36
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */

import java.util.*;
public class Test01_0912 {

    public static void main(String[] args) {
        input();
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            solution(arr[0], arr[1]);
        }
    }

    public static void solution(String inOrder, String posOrder){
        TreeNode root = process(inOrder, posOrder, 0, inOrder.length()-1, 0, posOrder.length()-1);
        List<Character> list = new ArrayList<>();
        preOrder(root, list);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<list.size(); i++){
            sb.append(list.get(i));
        }
        System.out.println(sb.toString());
    }

    public static void preOrder(TreeNode root, List<Character> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    public static TreeNode process(String inOrder, String posOrder, int inLeft, int inRight, int posLeft, int posRight){
        if (posLeft == posRight){
            return new TreeNode(posOrder.charAt(posLeft));
        }
        if (inLeft > inRight || posLeft > posRight){
            return null;
        }
        TreeNode root = new TreeNode(posOrder.charAt(posRight));
        int inorderRootIndex = getInorderIndex(inOrder, root, inLeft, inRight);

        int leftSize = inorderRootIndex - inLeft;
        int rightSize = inRight - inorderRootIndex;
        TreeNode leftTree = process(inOrder, posOrder, inLeft, inorderRootIndex-1, posLeft, posLeft+leftSize-1);
        TreeNode rightTree = process(inOrder, posOrder, inorderRootIndex+1, inRight, posLeft+leftSize, posRight-1);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }

    public static int getInorderIndex(String inOrder, TreeNode root, int left, int right){
        for (int i=left; i<=right; i++){
            if (inOrder.charAt(i) == root.val){
                return i;
            }
        }
        return left;
    }

    public static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
}

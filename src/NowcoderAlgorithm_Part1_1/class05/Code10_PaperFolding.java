package NowcoderAlgorithm_Part1_1.class05;

/**
 * @Author: xianz
 * @Date: 2020/6/10 09:07
 * @Title&Description: 折纸问题。就是一张纸向上对折，再向上对折，看折痕的顺序是往哪个方向。
 * 经过验证，第一次的折痕是凹的。之后第二次的折痕是上凹下凸，再对折，是在第二次的折痕上面上凹下凸
 * 完全打印折痕的化，得到的结果是相当于这个二叉树的中序遍历
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Code10_PaperFolding {
    public static void main(String[] args) {
        printAllFolds(6);
    }

    public static void printAllFolds(int N) {
        printProcess(1, N, true);
    }

    public static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, true);
        System.out.println(down ? "凹 " : "凸 ");
        printProcess(i + 1, N, false);
    }
}

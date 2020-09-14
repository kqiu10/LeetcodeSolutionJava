package Stack;
/**
 * Description: 单个递归，可以转换成while得迭代；
 * Package Name : Stack;
 * File name : StackIteration;
 * Creator: Kane;
 * Date: 7/22/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 */
public class StackIteration {
    public static int sum;
    public static void sumOfN(int num) {
        if (num == 0) {
            return;
        }
        sum += num;
        sumOfN(num - 1);
    }
    public static int sumOfN2(int num) {
        if (num == 0) {
            return 0;
        }
        return num + sumOfN2(num - 1);
    }

    public static void main(String[] args) {
        sumOfN(5);
        System.out.println(sum);

    }
}

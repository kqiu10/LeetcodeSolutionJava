package Random随机.RejectionSampling;
/**
 * Package Name : Random随机.RejectionSampling;
 * File name : ImplementRand10UsingRand7470;
 * Creator: Kane;
 * Date: 8/21/20
 */

/**
 * Time complexity:O(1);
 * Space complexity: O(1);
 * Description:
 * rand(n) -> rand(2n)  : rand(2n) = n *( rand(n) - 1) + rand(n) - 1;
 * rand(k*n) -> rand(n)  : rand(K * n) % n + 1;
 */
public class ImplementRand10UsingRand7470 {
    public int rand10() {
        int res = 40;
        while (res >= 40) {
            res = 7 * (rand7() - 1) + rand7() - 1;

        }
        return res % 10 + 1;
    }

    private int rand7() {
        return 0;
    }

}

package ArrayList数组.实现题;

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity:O(n^2);
 * Space complexity: O(n^2);
 * Description: TODO
 */
public class PascalTriangle118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            list.add(0,1);
            for (int j =1;j < list.size() - 1; j++) {
                list.set(j , list.get(j) + list.get(j+1));
            }
            res.add(new ArrayList<>(list));
        }
        return res;

    }

    public static void main(String[] args) {
        generate(5);
    }
}

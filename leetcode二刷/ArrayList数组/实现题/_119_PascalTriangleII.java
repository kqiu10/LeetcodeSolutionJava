package ArrayList数组.实现题;

import java.util.ArrayList;
import java.util.List;
/**
 * Time complexity:O(n^2);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _119_PascalTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < rowIndex+1; i++) {
            list.add(0,1);
            for(int j = 1; j < list.size()-1; j++ ) {
                list.set(j, list.get(j)+list.get(j+1));
            }
        }
        return list;
    }
    public static void main(String[] args){
        System.out.println(getRow(5));
    }


    
}

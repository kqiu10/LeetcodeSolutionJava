package Random随机.实现题;
/**
 * Package Name : Random随机.实现题;
 * File name : RandomPointinNonoverlappingRectangles497;
 * Creator: Kane;
 * Date: 8/20/20
 */

import java.util.Random;
import java.util.TreeMap;

/**
 * Time complexity:O(n); map.ceiling key cost logn time complexity
 * Space complexity: O(n + m);
 * Description: we need TreeMap if we both need accumulation sum and sort
 */
public class RandomPointinNonoverlappingRectangles497 {
    TreeMap<Integer, Integer> map;
    int[][] rects;
    Random random;
    int area;

    public RandomPointinNonoverlappingRectangles497(int[][] rects) {
        map = new TreeMap<>();
        this.rects = rects;
        random = new Random();
        area = 0;
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            int cur = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            area += cur;
            map.put(area, i);
        }

    }

    public int[] pick() {
        int rnd = map.ceilingKey(random.nextInt(area) + 1);
        int index = map.get(rnd);
        int[] rect = rects[index];
        int x = rect[0] + random.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + random.nextInt(rect[3] - rect[1] + 1);
        return new int[]{x, y};

    }
}

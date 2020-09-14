package src.shape.Square;
/**
 * Package Name : src.shape.Square;
 * File name : Square2;
 * Creator: Kane;
 * Date: 9/14/20
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class Square2 {
    public int countSquare(List<Point> list) {
        if (list.size() == 0) return 0;
        int res = 0;
        HashMap<String, List<Point[]>> core = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Point node1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Point node2 = list.get(j);
                long dis = (node1.x - node2.x) * (node1.x - node2.x) + (node1.y - node2.y) * (node1.y - node2.y);
                double centerX = (double)(node1.x + node2.x) / 2;
                double centerY = (double)(node1.y + node2.y) / 2;
                String info =+ dis + "+" + centerX + "+" + centerY;
                core.computeIfAbsent(info, k -> new ArrayList<>());
                core.get(info).add(new Point[]{node1, node2});
            }
        }
        for (String key : core.keySet()) {
            if (core.get(key).size() > 1) {
                List<Point[]> square = core.get(key);
                for (int i = 0; i < square.size(); i++) {
                    for (int j = i + 1; j < square.size(); j++) {
                        Point node1 = square.get(i)[0];
                        Point node2 = square.get(j)[0];
                        Point node3 = square.get(j)[1];
                        long len1 = (node2.x - node1.x) * (node2.x - node1.x) + (node2.y - node1.y) * (node2.y - node1.y);
                        long len2 = (node3.x - node1.x) * (node3.x - node1.x) + (node3.y - node1.y) * (node3.y - node1.y);
                        if (len1 == len2) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}

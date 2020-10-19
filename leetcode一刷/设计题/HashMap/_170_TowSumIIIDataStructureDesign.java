package 设计题.HashMap;
/**
 * Date: 10/18/20
 * Question Description
 Design a data structure that accepts a stream of integers and checks if it has a pair of integers that sum up to a particular value.

 Implement the TwoSum class:

 TwoSum() Initializes the TwoSum object, with an empty array initially.
 void add(int number) Adds number to the data structure.
 boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value, otherwise, it returns false.


 Example 1:

 Input
 ["TwoSum", "add", "add", "add", "find", "find"]
 [[], [1], [3], [5], [4], [7]]
 Output
 [null, null, null, null, true, false]

 Explanation
 TwoSum twoSum = new TwoSum();
 twoSum.add(1);   // [] --> [1]
 twoSum.add(3);   // [1] --> [1,3]
 twoSum.add(5);   // [1,3] --> [1,3,5]
 twoSum.find(4);  // 1 + 3 = 4, return true
 twoSum.find(7);  // No two integers sum up to 7, return false
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description:

 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _170_TowSumIIIDataStructureDesign {
    /** Initialize your data structure here. */
    List<Integer> list;
    HashMap<Integer, Integer> map;
    public _170_TowSumIIIDataStructureDesign() {
        list = new ArrayList<>();
        map = new HashMap<>();

    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
       if (!map.containsKey(number)) {
           map.put(number, 1);
           list.add(number);
       } else {
           map.put(number, map.get(number) + 1);
       }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Integer num1 : list) {
            int num2 = value - num1;
            if ((num1 == num2 && map.get(num1) > 1 || (num1 != num2 && map.containsKey(num2)))) {
                return true;
            }
        }
        return false;

    }
}

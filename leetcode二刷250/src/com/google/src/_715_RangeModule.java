package com.google.src;
/**
 * Date: 4/20/21
 * Question Description:
 * A Range Module is a module that tracks ranges of numbers. Your task is to design and implement
 * the following interfaces in an efficient manner.
 *
 * addRange(int left, int right) Adds the half-open interval [left, right), tracking every real
 * number in that interval. Adding an interval that partially overlaps with currently tracked
 * numbers should add any numbers in the interval [left, right) that are not already tracked.
 * queryRange(int left, int right) Returns true if and only if every real number in the interval
 * [left, right) is currently being tracked.
 * removeRange(int left, int right) Stops tracking every real number currently being tracked in
 * the interval [left, right).

 * <p>
 * Examples:
 * Example 1:
 * addRange(10, 20): null
 * removeRange(14, 16): null
 * queryRange(10, 14): true (Every number in [10, 14) is being tracked)
 * queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
 * queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove
 * operation)
 */

import java.util.TreeMap;

/**
 * Time Complexity: O(mlogn)
 * Space Complexity: O(mlogn)
 */
public class _715_RangeModule {
    TreeMap<Integer, Integer> intervals;
    public _715_RangeModule() {
        intervals = new TreeMap<>();

    }
    public void addRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);
        if (start != null && intervals.get(start) >= left) {
            left = start;
        }
        if (end != null && intervals.get(end) > right) {
            right = intervals.get(end);
        }
        intervals.put(left, right);
        intervals.subMap(left, false, right, true).clear();
    }

    public boolean queryRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        if (start == null) return false;
        return intervals.get(start) >= right;


    }

    public void removeRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);

        if (end != null && intervals.get(end) > right) {
            intervals.put(right, intervals.get(end));
        }
        if (start != null && intervals.get(start) > left) {
            intervals.put(start, left);
        }
        intervals.subMap(left, true, right, false).clear();
    }
}

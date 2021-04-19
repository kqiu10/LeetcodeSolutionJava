package com.google.src;
/**
 * Date: 4/19/21
 * Question Description:
 * mplement a SnapshotArray that supports the following interface:
 *
 * SnapshotArray(int length) initializes an array-like data structure with the given length.
 * Initially, each element equals 0.
 * void set(index, val) sets the element at the given index to be equal to val.
 * int snap() takes a snapshot of the array and returns the snap_id: the total number of times we
 * called snap() minus 1.
 * int get(index, snap_id) returns the value at the given index, at the time we took the snapshot
 * with the given snap_id
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: ["SnapshotArray","set","snap","set","get"]
 * [[3],[0,5],[],[0,6],[0,0]]
 * Output: [null,null,0,null,5]
 * Explanation:
 * SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
 * snapshotArr.set(0,5);  // Set array[0] = 5
 * snapshotArr.snap();  // Take a snapshot, return snap_id = 0
 * snapshotArr.set(0,6);
 * snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
 */

import java.util.TreeMap;

/**
 * Time Complexity: O(logn)
 * Space Complexity: O(n)
 *
 * n is the number of set called
 */
public class _1146_SnapshotArray {
    TreeMap<Integer, Integer>[] map;
    int snap = 0;
    public _1146_SnapshotArray(int length) {
        map = new TreeMap[length];
        for (int i = 0; i < map.length; i++) {
            map[i] = new TreeMap<>();
            map[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        map[index].put(snap, val);
    }

    public int snap() {
        return snap++;
    }

    public int get(int index, int snapid) {
        return map[index].floorEntry(snapid).getValue();
    }
}

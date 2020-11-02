package String字符串.实现题;
/**
 * Package Name : String字符串.实现题;
 * File name : _551_StudentAttendanceRecordI;
 * Creator: Kane;
 * Date: 8/31/20
 */

/**
 * You are given a string representing an attendance record for a student. The record only
 * contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A'
 * (absent) or more than two continuous 'L' (late).
 *
 * You need to return whether the student could be rewarded according to his attendance record.
 *
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 *
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _551_StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int count = 0;
        for(int i = 0;i < s.length() && count < 2; i++)
            if(s.charAt(i) == 'A') count++;
        return count < 2 && s.indexOf("LLL") < 0;
    }
}

package leetcode.Mathmatics数学题;
/**
 * Description: TODO
 * Package Name : leetcode.Mathmatics数学题;
 * File name : AddBinary67;
 * Creator: Kane;
 * Date: 7/21/20
 */

import jdk.dynalink.beans.StaticClass;

import javax.swing.plaf.synth.SynthTextAreaUI;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Ex
 * a = "11"
 * b = "1"
 * return "100"
 * */
public class _67_AddBinary {
    public static String _67_addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int reminder = 0;
        while (i >=0 || j >= 0) {
            int sum = reminder;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 2);
            reminder = sum / 2;
        }
        if (reminder != 0) {
            sb.append(reminder);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        _67_addBinary("101","1");
    }
}

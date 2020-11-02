package Stack栈.压栈匹配;
/**
 * Package Name : Stack栈.压栈匹配;
 * File name : _388_LongestAbsoluteFilePath;
 * Creator: Kane;
 * Date: 8/25/20
 */

import java.util.Stack;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description:
 * "/t"只占一个字符长度所有len + 1
 * Ex "/t/t".length() = 2
 * 文件末尾不用"/"所以我们判断是否含有"."判断len是否需要减一
 */
public class _388_LongestAbsoluteFilePath {
    public static int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            while (level + 1 < stack.size()) {
                stack.pop();
            }
            int len = stack.peek() + s.length() - level + 1;
            stack.push(len);
            if (s.contains(".")) {
                res = Math.max(res, len - 1);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
        System.out.println("\t".length());
    }
}

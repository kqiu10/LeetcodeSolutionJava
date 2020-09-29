package Stack栈.压栈匹配;
/**
 * Package Name : Stack栈.压栈匹配;
 * File name : _71_SimplifyPath;
 * Creator: Kane;
 * Date: 8/25/20
 */

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to
 * the canonical path.
 *
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double
 * period .. moves the directory up a level.
 *
 * Note that the returned canonical path must always begin with a slash /, and there must be only
 * a single slash / between two directory names. The last directory name (if it exists) must not
 * end with a trailing /. Also, the canonical path must be the shortest string representing the
 * absolute path.
 *
 *
 *
 * Example 1:
 *
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * Example 2:
 *
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the
 * highest level you can go.
 *
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _71_SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/+");
        for (String s : paths) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.equals(".") && !s.equals("")) {
                stack.push(s);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        if (res.length() == 0) {
            return "/";
        }
        return res;

    }
}

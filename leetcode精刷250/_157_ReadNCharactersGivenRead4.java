/**
 * Date: 11/18/20
 * Question Description
 Given a file and assume that you can only read the file using a given method read4, implement a method to read n characters.
 Method read4:

 The API read4 reads 4 consecutive characters from the file, then writes those characters into the buffer array buf4.

 The return value is the number of actual characters read.

 Note that read4() has its own file pointer, much like FILE *fp in C.
 */

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _157_ReadNCharactersGivenRead4 {
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int index = 0;
        while (true) {
            int count = read4(temp);
            count = Math.min(count, n - index);
            for (int i = 0; i < count; i++) {
                buf[index++] = temp[i];
            }
            if (index == n || count < 4) return index;
        }
    }

    private int read4(char[] temp) {
        return 0;
    }
}

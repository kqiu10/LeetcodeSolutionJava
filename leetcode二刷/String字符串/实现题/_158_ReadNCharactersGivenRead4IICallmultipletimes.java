package String字符串.实现题;
/**
 * Package Name : String字符串.实现题;
 * File name : _158_ReadNCharactersGivenRead4IICallmultipletimes;
 * Creator: Kane;
 * Date: 9/1/20
 */

/**
 * Given a file and assume that you can only read the file using a given method read4, implement
 * a method read to read n characters. Your method read may be called multiple times.
 *
 *
 *
 * Method read4:
 *
 * The API read4 reads 4 consecutive characters from the file, then writes those characters into
 * the buffer array buf.
 *
 * The return value is the number of actual characters read.
 *
 * Note that read4() has its own file pointer, much like FILE *fp in C.
 *
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _158_ReadNCharactersGivenRead4IICallmultipletimes {
        private int count = 0;
        private int pointer = 0;
        private char[] temp = new char[4];
        public int read(char[] buf, int n) {
            /**
             * @param buf Destination buffer
             * @param n   Number of characters to read
             * @return    The number of actual characters read
             */
            int index = 0;
            while (index < n) {
                if (pointer == 0) {
                    count = read4(temp);
                }
                if (count == 0) break;
                while (index < n && pointer < count) {
                    buf[index++] = temp[pointer++];
                }
                if (pointer == count) pointer = 0;

            }
            return index;

        }

    private int read4(char[] temp) {
        return 0;
    }

}

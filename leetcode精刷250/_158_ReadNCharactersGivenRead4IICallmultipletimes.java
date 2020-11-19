/**
 * Date: 11/18/20
 * Question Description
 Given a file and assume that you can only read the file using a given method read4, implement a method read to read n characters. Your method read may be called multiple times.
 Method read4:

 The API read4 reads 4 consecutive characters from the file, then writes those characters into the buffer array buf4.

 The return value is the number of actual characters read.

 Note that read4() has its own file pointer, much like FILE *fp in C.

 Definition of read4:

 Parameter:  char[] buf4
 Returns:    int

 Note: buf4[] is destination not source, the results from read4 will be copied to buf4[]
 Below is a high level example of how read4 works:
 File file("abcde"); // File is "abcde", initially file pointer (fp) points to 'a'
 char[] buf4 = new char[4]; // Create buffer with enough space to store characters
 read4(buf4); // read4 returns 4. Now buf4 = "abcd", fp points to 'e'
 read4(buf4); // read4 returns 1. Now buf4 = "e", fp points to end of file
 read4(buf4); // read4 returns 0. Now buf4 = "", fp points to end of file
 */

/**
 * Description:
 *
 跟157比不一样的是会怎样处理还没读完的值。比如"abcdef"，
 157读两遍n=2的话是, "ab", "ef"，这里被跳过的就是"cd"，
 因为每次调用read4这个函数，它都会把指针指向下一组4个字符的开头。
 例如字符串为“abcdefg”,读一遍2再读一遍3，
 结果不是"ab", "abc"，而是会得出"ab", "efg"， 上一组4字符没读完的"cd"就被跳过了

 * count : read4能读取几个数
 * pointer : temp读到了哪，下一循环的起始位置
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _158_ReadNCharactersGivenRead4IICallmultipletimes {
    private int count = 0;
    private int pointer = 0;
    private char[] temp = new char[4];
    public int read(char[] buf, int n) {
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

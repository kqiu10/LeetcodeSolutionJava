package com.google.src;
/**
 * Date: 4/19/21
 * Question Description:
 * Given a rows x cols screen and a sentence represented as a list of strings, return the number
 * of times the given sentence can be fitted on the screen.
 *
 * The order of words in the sentence must remain unchanged, and a word cannot be split into two
 * lines. A single space must separate two consecutive words in a line.
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: sentence = ["hello","world"], rows = 2, cols = 8
 * Output: 1
 * Explanation:
 * hello---
 * world---
 * The character '-' signifies an empty space on the screen.
 * Example 2:
 *
 * Input: sentence = ["a", "bcd", "e"], rows = 3, cols = 6
 * Output: 2
 * Explanation:
 * a-bcd-
 * e-a---
 * bcd-e-
 * The character '-' signifies an empty space on the screen.
 * Example 3:
 *
 * Input: sentence = ["i","had","apple","pie"], rows = 4, cols = 5
 * Output: 1
 * Explanation:
 * i-had
 * apple
 * pie-i
 * had--
 * The character '-' signifies an empty space on the screen.
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _418_SentenceScreenFitting {
        public int wordsTyping(String[] sentence, int rows, int cols) {
            String str = String.join(" ", sentence) + " ";
            int start = 0;
            int len = str.length();
            for (int i = 0; i < rows; i++) {
                start += cols;
                if (str.charAt(start % len) == ' ') {
                    start++;
                } else {
                    while (start > 0 && str.charAt((start - 1) % len) != ' ') {
                        start--;
                    }
                }
            }
            return start / len;
        }
}

package src; /**
 * Date: 11/28/20
 * Question Description
 Convert a non-negative integer num to its English words representation.
 Example 1:

 Input: num = 123
 Output: "One Hundred Twenty Three"
 Example 2:

 Input: num = 12345
 Output: "Twelve Thousand Three Hundred Forty Five"
 Example 3:

 Input: num = 1234567
 Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 Example 4:

 Input: num = 1234567891
 Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */

/**
 * Description:
  12345 -> "Twelve Thousand Three Hundred Forty Five"
            i = 0 res = ""
            helper(345) : Three Hundred
              helper(45) : Forty
                 helper(5) : Five
            num = 12
            res = Twelve Thousand
 * Time complexity:O(n);
 * Space complexity: O(1);


 */
public class _273_IntegertoEnglishWords {
    String[] less20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thos = new String[]{"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String res = "";
        int i = 0;
         while (num > 0) {
             if (num % 1000 != 0) {
                 res = helper(num % 1000) + thos[i] + " " + res;
             }
             num /= 1000;
             i++;
         }
         return res.trim();
    }
    private String helper(int num) {
        if (num == 0) return "";
        else if (num < 20) {
            return less20[num % 20] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            return less20[num / 100] + "Hundred" + helper(num % 100);
        }
    }
}

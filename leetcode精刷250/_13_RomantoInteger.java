/**
 * Date: 11/2/20
 * Question Description
 */

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class _13_RomantoInteger {
    public int romanToInt(String s) {
        if (s.length() == 0 || s == null) return 0;
        int sum = isNumber(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (isNumber(s.charAt(i)) > isNumber(s.charAt(i - 1))) {
                sum += isNumber(s.charAt(i)) - 2 *isNumber(s.charAt(i - 1));
            } else {
                sum += isNumber(s.charAt(i));
            }
        }
        return sum;

    }
    private int isNumber(char c) {
        int num = 0;
        switch(c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        return num;
    }
}

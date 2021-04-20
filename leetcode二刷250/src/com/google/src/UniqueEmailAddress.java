package com.google.src;
/**
 * Date: 4/20/21
 * Question Description:
 * Every valid email consists of a local name and a domain name, separated by the '@' sign.
 * Besides lowercase letters, the email may contain one or more '.' or '+'.
 *
 * For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the
 * domain name.
 * If you add periods '.' between some characters in the local name part of an email address,
 * mail sent there will be forwarded to the same address without dots in the local name. Note
 * that this rule does not apply to domain names.
 *
 * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
 * If you add a plus '+' in the local name, everything after the first plus sign will be ignored.
 * This allows certain emails to be filtered. Note that this rule does not apply to domain names.
 *
 * For example, "m.y+name@email.com" will be forwarded to "my@email.com".
 * It is possible to use both of these rules at the same time.
 *
 * Given an array of strings emails where we send one email to each email[i], return the number
 * of different addresses that actually receive mails.
 * <p>
 * Examples:
 *
 * Example 1:
 *
 * Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com",
 * "testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
 * Example 2:
 *
 * Input: emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
 * Output: 3
 */

import java.util.HashSet;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class UniqueEmailAddress {
    public int numUniqueEmails(String[] emails) {
        int res = 0;
        HashSet<String> set = new HashSet<>();
        for (String email : emails) {
            String pure = pureString(email);
            if (set.add(pure)) res++;
        }
        return res;
    }
    private String pureString(String email) {
        StringBuilder sb = new StringBuilder();
        String localName = email.split("@")[0];
        String domainName = email.split("@")[1];
        for (int i = 0; i < localName.length(); i++) {
            if (localName.charAt(i) == '.') continue;
            else if (localName.charAt(i) == '+') break;
            else {
                sb.append(localName.charAt(i));
            }
        }
        return sb.append("@").append(domainName).toString();
    }

}

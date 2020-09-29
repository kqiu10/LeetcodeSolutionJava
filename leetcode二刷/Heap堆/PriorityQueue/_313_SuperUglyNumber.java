package Heap堆.PriorityQueue;
/**
 * Package Name : Heap堆.PriorityQueue;
 * File name : _313_SuperUglyNumber;
 * Creator: Kane;
 * Date: 9/11/20
 */

import java.util.PriorityQueue;

/**
 * Write a program to find the nth super ugly number.
 *
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list
 * primes of size k.
 *
 * Example:
 *
 *
 * Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
 * super ugly numbers given primes = [2,7,13,19] of size 4.
 *
 * Time complexity:O(nlogk);
 * Space complexity: O(n);
 * Description:
 * Input: n = 12, primes = [2,7,13,19]
 * [1,2,4,7,8,13,14,16,19,26,28,32]
 * pq :
 * 2 1 2 -> 4 2 2
 * 7 1 7 -> 14 2 7
 * 13 1 13 -> 26 2 13
 * 19 1 19 -> 38 2 19
 *
 * res = 1 2 4 7 8 13
 */
public class _313_SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;
        PriorityQueue<Num> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (int i = 0; i < primes.length; i++) {
            pq.add(new Num(primes[i], 1, primes[i]));
        }
        for (int i = 1; i < n; i++) {
            res[i] = pq.peek().val;
            while (pq.peek().val == res[i]) {
                Num next = pq.poll();
                pq.add(new Num(next.prime * res[next.index], next.index + 1, next.prime));
            }
        }
        return res[n - 1];


    }
    private class Num {
        int val;
        int prime;
        int index;

        public Num(int val, int index, int prime) {
            this.val = val;
            this.prime = prime;
            this.index = index;
        }
    }
}

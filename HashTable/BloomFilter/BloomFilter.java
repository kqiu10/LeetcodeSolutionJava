package BloomFilter;
/**
 * Package Name : BloomFilter;
 * File name : BloomFilter;
 * Creator: Kane;
 * Date: 9/10/20
 */

import java.util.BitSet;

/**
 * Description: TODO
 */
public class BloomFilter {
    private static final int default_size = 1 << 25;

    private BitSet bits = new BitSet(default_size);

    private static final int[] seeds = new int[]{5, 7, 11, 13, 37, 61};

    private HashFunction[] functions = new HashFunction[seeds.length];

    public static class HashFunction{
        private int capacity;
        private int seed;

        public HashFunction(int capacity, int seed) {
            this.capacity = capacity;
            this.seed = seed;
        }
        public int hash(String value) {
            int res = 0;
            for (int i = 0; i < value.length(); i++) {
                res = seed * res + value.charAt(i);
            }
            return (capacity - 1) & res;
        }
    }
    public BloomFilter() {
        for (int i = 0; i < seeds.length; i++) {
            functions[i] = new HashFunction(default_size, seeds[i]);
        }
    }
    public void add(String value) {
        for (HashFunction function : functions) {
            bits.set(function.hash(value), true);
        }
    }

}

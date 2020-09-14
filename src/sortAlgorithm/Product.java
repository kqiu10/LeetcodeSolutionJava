package sortAlgorithm;
/**
 * Description: TODO
 * Package Name : sortAlgorithm;
 * File name : Product;
 * Creator: Kane;
 * Date: 7/18/20
 */

import java.util.Comparator;

/**
 * Best Time complexity: O();
 * Worst Time complexity: O();
 * Average Time complexity:O();
 * Space complexity: O();
 */
public class Product implements Comparable<Product>{
    private int prize;
    private int sale;

    public Product(int prize, int sale) {
        this.prize = prize;
        this.sale = sale;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prize=" + prize +
                ", sale=" + sale +
                '}';
    }

    @Override
    public int compareTo(Product o) {
       if (this.getSale() == o.getSale()) {
           return this.getPrize() - o.getPrize();
       } else {
           return this.getSale() - o.getSale();
       }
    }
}
class ProductCompare implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getSale() - o2.getSale();
    }
}

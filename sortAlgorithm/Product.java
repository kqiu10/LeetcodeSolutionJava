package sortAlgorithm;
/**
 * Description: TODO
 * Package Name : sortAlgorithm;
 * File name : Product;
 * Creator: Kane;
 * Date: 7/18/20
 */

/**
 * Best Time complexity: O();
 * Worst Time complexity: O();
 * Average Time complexity:O();
 * Space complexity: O();
 */
public class Product {
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
}

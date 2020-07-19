package sortAlgorithm;
/**
 * Description: TODO
 * Package Name : sortAlgorithm;
 * File name : StableSort;
 * Creator: Kane;
 * Date: 7/18/20
 */

import java.util.Arrays;

/**
 * Best Time complexity: O();
 * Worst Time complexity: O();
 * Average Time complexity:O();
 * Space complexity: O();
 */
public class StableSort {
        public static void bubbleSort(Product[] products) {
            for (int i = 0; i < products.length - 1; i++) {
                for (int j = products.length - 1; j >i; j--) {
                    if (products[j].getPrize() < products[j-1].getPrize()) {
                        Product temp = products[j];
                        products[j] = products[j-1];
                        products[j-1] = temp;
                    }
                }
            }
            for (int i = 0; i < products.length - 1; i++) {
                for (int j = products.length - 1; j >i; j--) {
                    if (products[j].getSale() < products[j-1].getSale()) {
                        Product temp = products[j];
                        products[j] = products[j-1];
                        products[j-1] = temp;
                    }
                }
            }
        }
    public static void bubbleSortUnStable(Product[] products) {
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = products.length - 1; j >i; j--) {
                if (products[j].getPrize() < products[j-1].getPrize()) {
                    Product temp = products[j];
                    products[j] = products[j-1];
                    products[j-1] = temp;
                }
            }
        }
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = products.length - 1; j >i; j--) {
                if (products[j].getSale() <= products[j-1].getSale()) {
                    Product temp = products[j];
                    products[j] = products[j-1];
                    products[j-1] = temp;
                }
            }
        }
    }
    public static void bubbleSortWithComparator(Product[] products) {
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = products.length - 1; j >i; j--) {
                if (products[j].compareTo(products[j-1]) < 0) {
                    Product temp = products[j];
                    products[j] = products[j-1];
                    products[j-1] = temp;
                }
            }
        }
    }

        public static void main(String[] args) {
            Product product1 = new Product(3,10);
            Product product2 = new Product(1,9);
            Product product3 = new Product(0,9);
            Product product4 = new Product(2,9);
            Product[] products = new Product[]{product1, product2, product3, product4};
           bubbleSort(products);
//           bubbleSortUnStable(products);
            for (Product product : products) {
                System.out.println(product.toString());

            }

        }
}

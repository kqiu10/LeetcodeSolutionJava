package Random随机.RejectionSampling;
/**
 * Package Name : Random随机.RejectionSampling;
 * File name : GenerateRandomPointinaCircle;
 * Creator: Kane;
 * Date: 8/21/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class GenerateRandomPointinaCircle478 {
    double rad;
    double xc;
    double yc;

    public GenerateRandomPointinaCircle478(double radius, double x_center, double y_center) {
        rad = radius;
        xc = x_center;
        yc = y_center;
    }

    public double[] randPoint() {
        double x0 = xc - rad;
        double y0 = yc - rad;
        while (true) {
            double xg = x0 + Math.random() * rad * 2;
            double yg = y0 + Math.random() * rad * 2;
            if (Math.pow((xg - xc), 2) + Math.pow((yg - yc), 2) <= rad * rad) return new double[]{xg, yg};
        }

    }

    public static void main(String[] args) {
        System.out.println(16 & 15);
    }
}

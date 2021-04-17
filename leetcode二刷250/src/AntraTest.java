/**
 * Date: 4/16/21
 * Question Description:
 * <p>
 * Examples:
 */

import java.util.HashMap;

/**
 * Time Complexity: O()
 * Space Complexity: O()
 */
public class AntraTest {
    private int name;

    public AntraTest(int name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AntraTest antraTest = (AntraTest) o;

        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {
        AntraTest t1 = new AntraTest(5);
        AntraTest t2 = new AntraTest(4);
        AntraTest t3 = new AntraTest(3);
        AntraTest t4 = new AntraTest(2);
        HashMap<AntraTest, String> map = new HashMap<>();
        map.put(t1, "2");
        map.put(t2, "3");
        map.put(t3, "4");
        System.out.println(map.size());
    }
}

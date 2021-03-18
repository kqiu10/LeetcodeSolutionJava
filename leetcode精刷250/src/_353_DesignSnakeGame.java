package src; /**
 * Date: 12/5/20
 * Question Description
 Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.

 The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

 You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.

 Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

 When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

 Example:

 Given width = 3, height = 2, and food = [[1,2],[0,1]].

 Snake snake = new Snake(width, height, food);

 Initially the snake appears at position (0,0) and the food at (1,2).

 |S| | |
 | | |F|

 snake.move("R"); -> Returns 0

 | |S| |
 | | |F|

 snake.move("D"); -> Returns 0

 | | | |
 | |S|F|

 snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

 | |F| |
 | |S|S|

 snake.move("U"); -> Returns 1

 | |F|S|
 | | |S|

 snake.move("L"); -> Returns 2 (Snake eats the second food)

 | |S|S|
 | | |S|

 snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 */

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class _353_DesignSnakeGame {
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    HashSet<Integer> set; //位置
    Deque<Integer> deque;
    int score;
    int foodIndex;
    int width;
    int height;
    int[][] food;
    public _353_DesignSnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        set = new HashSet<>();
        deque = new LinkedList<>();
        score = 0;
        foodIndex = 0;
        set.add(0);
        deque.offerLast(0);
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if (score == -1) {
            return -1;
        }
        int rowHead = deque.peekFirst() / width;
        int colHead = deque.peekFirst() % width;
        switch(direction) {
            case "U" : rowHead--;
                break;
            case "D" : rowHead++;
                break;
            case "L" : colHead--;
                break;
            default : colHead++;
        }
        int head = rowHead * width + colHead;
        set.remove(deque.peekLast());
        if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
            return score = -1;
        }
        set.add(head);
        deque.offerFirst(head);
        if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
            foodIndex++;
            ++score;
            set.add(deque.peekLast());
            return score;
        }
        deque.pollLast();
        return score;

    }
}

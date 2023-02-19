package info.pragmaticdeveloper.dsa.stack;

import java.util.Stack;

public class StoneWall {
    public int countBlockTypeNeeded(int[] height) {
        Stack<Integer> block = new Stack<>();
        int count = 0;
        for (int i = 0; i < height.length; i++) {
            if (block.isEmpty()) {
                block.push(height[i]);
                count++;
            } else {
                if (block.peek() < height[i]) {
                    block.push(height[i]);
                    count++;
                } else if (block.peek() > height[i]) {
                    while (!block.isEmpty() && block.peek() > height[i]) {
                        block.pop();
                    }

                    if (block.isEmpty() || block.peek() != height[i]) {
                        count++;
                        block.push(height[i]);
                    }
                }
            }
        }
        return count;
    }
}

package info.pragmaticdeveloper.dsa.stack;

public class AliveFishPredictor {

    public int countAliveFish(int[] size, int[] movement) {
        Stack<Integer> stack = new Stack<>();

        int eatenFishCount = 0;
        for (int i = 0; i < size.length; i++) {
            if (movement[i] == 1) {
                stack.push(size[i]);
            } else {
                while (!stack.isEmpty()) {
                    if (!stack.isEmpty()) {
                        if (stack.peek() > size[i]) {
                            eatenFishCount++;
                            break;
                        }

                        if (stack.peek() < size[i]) {
                            stack.pop();
                            eatenFishCount++;
                        }
                    }
                }
            }
        }
        return size.length - eatenFishCount;
    }
}

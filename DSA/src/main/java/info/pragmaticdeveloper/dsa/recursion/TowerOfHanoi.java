package info.pragmaticdeveloper.dsa.recursion;

public class TowerOfHanoi {
    public void moveDisk(int n, char src, char intermediate, char dest) {
        if (n == 0) {
            return;
        }
        moveDisk(n - 1, src, dest, intermediate);
        System.out.printf("Moving %d from %s to %s%n", n, src, dest);
        moveDisk(n - 1, intermediate, src, dest);
    }
}

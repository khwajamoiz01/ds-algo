package geeks.array;

//https://www.geeksforgeeks.org/find-minimum-moves-reach-target-infinite-line/
public class MinMovesRequiredToTarget {

    int minMoves(int target) {
        target = Math.abs(target);
        int sum = 0, step = 0;

        while (sum < target || (sum - target) % 2
                != 0) {
            step++;
            sum += step;
        }
        return step;
    }
}

import java.util.*;

public class map {
    final static int GRID_SIZE = 6;
    static char[][] grid;

    public static void main(String[] args) {
        grid = new char[GRID_SIZE][GRID_SIZE];

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = 'o';
            }
        }
        // method to input spaces(path) into grid array
        HashMap<Integer, int[]> mazes = new HashMap();
        int[] p1 = { 1, 4, 2, 4, 2, 3, 2, 2, 3, 2, 4, 2, 4, 3, 5, 3, 6, 3 };
        mazes.put(1, p1);
        // p1 = {};
        // mazes.put(2, p1);
        // p1 = {};
        // mazes.put(3, p1);
        // p1 = {};
        // mazes.put(4, p1);

        // randomize the maze
        int mazeNum = 1 + (int) (Math.random() * (((mazes.size() - 1) - 1) + 1));
        // Queue<Integer> path = new LinkedList();
        // for (int i : mazes.get(mazeNum)) {
        // path.offer(i);
        // }
        Knight user = new Knight(mazes.get(mazeNum));
        makeMaze(mazes.get(mazeNum));
        printMaze(user);
        // printing out the maze

    }

    public static void makeMaze(int[] path) {
        // while (!path.isEmpty()) {
        // grid[path.poll() - 1][path.poll() - 1] = ' ';
        // }
        for (int i = 1; i < path.length; i += 2) {
            grid[path[i - 1] - 1][path[i]] = ' ';
        }

    }

    public static void printMaze(Knight user) {
        grid[user.x][user.y] = user.symbol;
        System.out.println();
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

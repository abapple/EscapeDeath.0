import java.util.*;
public class map {
    final static int NUM_OF_STEPS = 10;
	final static int GRID_SIZE = 6; 
    static char[][] grid;
    public static void main(String[]args){
        grid = new char[GRID_SIZE][GRID_SIZE];
		
		for(int i = 0; i < GRID_SIZE ; i++){
			for (int j = 0; j < GRID_SIZE ; j++){
				grid[i][j] = 'o';
			}
		}
        //method to input spaces(path) into grid array
        HashMap<Integer, Queue<Integer>> mazes = new HashMap();
        Queue<Integer> path = new LinkedList();
        int[] p1 = {1, 4, 2, 4, 2, 3, 2, 2, 3, 2, 4, 2, 4, 3, 5, 3, 6, 3};
        for(int i : p1){
            path.offer(i);
        }
        mazes.put(1, path);
        makeMaze(mazes);
        //printing out the maze
        System.out.println();
		for(int i = 0; i < GRID_SIZE; i++){
			for (int j = 0; j < GRID_SIZE ; j++)
			{
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
    }
    public static void makeMaze(HashMap<Integer, Queue<Integer>> map){
        //randomize the maze
        int mazeNum = 1+ (int) (Math.random() * ((3 - 1) + 1));;
        Queue<Integer> path = map.get(mazeNum);
        while(!path.isEmpty()){
                grid[path.poll()-1][path.poll()-1]= ' ';
        }
        }
        
}

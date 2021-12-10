import java.util.*;

public class Knight {
    public int x;
    public int y;
    public char symbol;
    /**
     * Constructor to initialize starting coordinates
     * according to given path
     * and starting symbol.
     * @param p - path Knight plays on
     */
    Knight(int[] p) {
        x = p[0] - 1;
        y = p[1] - 1;
        symbol = 'K';
    }
    /**
     * Checks to see if Knight can move in given
     * direction. Changes coordinates if possible
     * @param dir  - desired char direction to move
     * @param grid - the plane Knight must move on
     * @return true if Knight can move, false if cannot
     */
    public boolean move(char dir, char[][] grid) {
        int temX;
        int temY;
        //tells which direction knight is moving
        switch (dir) {
            case 'd':
            case 'D': {
                temX = x + 1;
                if (temX == -1 || temX == 7) {
                    //if moving out of bounds of grid
                    System.out.println("You can't venture here knight - the path does not exist!");
                    return false;
                }
                if (grid[temX][y] == 'o') {
                    //if trying to access wall space
                    System.out.println("That is a wall, cannot go there.");
                    return false;
                } else {
                    x = temX;
                }
                break;
            }
            case 'u':
            case 'U': {
                temX = x - 1;
                if (temX == -1 || temX == 7) {
                    System.out.println("You can't venture here knight - the path does not exist!");
                    return false;
                }
                if (grid[temX][y] == 'o') {
                    System.out.println("That is a wall, cannot go there.");
                    return false;
                } else {
                    x = temX;
                }
                break;
            }
            case 'l':
            case 'L': {
                temY = y - 1;
                if (temY == -1 || temY == 7) {
                    System.out.println("You can't venture here knight - the path does not exist!");
                    return false;
                }
                if (grid[x][temY] == 'o') {
                    System.out.println("That is a wall, cannot go there.");
                    return false;
                } else {
                    y = temY;
                }
                break;
            }
            case 'r':
            case 'R': {
                temY = y + 1;
                if (temY == -1 || temY == 7) {
                    System.out.println("You can't venture here knight - the path does not exist!");
                    return false;
                }
                if (grid[x][temY] == 'o') {
                    System.out.println("That is a wall, cannot go there.");
                    return false;
                } else {
                    y = temY;
                }
                break;
            }
            default: {
                System.out.println("Invalid");
                return false;
            }
        }
        return true;
    }
}

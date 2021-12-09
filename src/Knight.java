import java.util.*;

public class Knight {
    public int x;
    public int y;
    public char symbol;

    Knight(int[] p) {
        x = p[0] - 1;
        y = p[1] - 1;
        symbol = 'K';
    }

    public boolean move(char dir, char[][] grid) {
        int temX;
        int temY;
        switch (dir) {
            case 'd':
            case 'D': {
                temX = x + 1;
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

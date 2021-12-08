import java.util.*;
 public class Knight {
    public int x;
    public int y;
    public char symbol;
    Knight(int[] p){
        x = p[0]-1;
        y = p[1];
        symbol = 'K';
    }
    public boolean move(char dir, char[][] grid){
        int temX;
        int temY;
        switch(dir){
            case 'u':{
                temX = x+1;
                if(grid[temX][y] == 'o'){
                    System.out.println("That is a wall, cannot go there.");
                    return false;
                }else{
                    x = temX;
                }
                break;
            }
            case 'd':{
                temX = x-1;
                if(grid[temX][y] == 'o'){
                    System.out.println("That is a wall, cannot go there.");
                    return false;
                }else{
                    x = temX;
                }
                break;
            }
            case 'l':{
                temY = y+1;
                if(grid[x][temY] == 'o'){
                    System.out.println("That is a wall, cannot go there.");
                    return false;
                }else{
                    y = temY;
                }
                break;
            }
            case 'r':{
                temY = y+1;
                if(grid[x][temY] == 'o'){
                    System.out.println("That is a wall, cannot go there.");
                    return false;
                }else{
                    y = temY;
                }
                break;
            }
            default:{
                System.out.println("Invalid");
                return false;
            }
        }
        return false;
    }
}

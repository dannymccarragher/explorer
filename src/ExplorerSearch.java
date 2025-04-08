import java.util.ArrayList;
import java.util.List;

public class ExplorerSearch {

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following nunbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    public static int reachableArea(int[][] island) {
        // Implement your method here!
        // Please also make more test cases
        // I STRONGLY RECOMMEND testing some helpers you might make too
        return -1;

        
    }

    public static int reachableAreaHelper(int[][] island, int[]current, boolean[][] visited){
        int curR = current[0];
        int curC = current[1];

        // base case
        if(visited[curR][curC]){
            return 0;
        }

        visited[curR][curC] = true;

        List<int[]> moves = possibleMoves(island, current);

        int totalArea = 0;

        for(int[] move : moves){
            reachableAreaHelper(island, move, visited);
            totalArea++;

        }

        return totalArea;
    }


    public static List<int[]> possibleMoves(int[][] island, int[]current){
        int curR = current[0];
        int curC = current[1];

        List<int[]> moves = new ArrayList<>();

//        int[][] island = {
//                {1, 1, 1, 3, 1, 1},
//                {0, 2, 0, 1, 0, 1},
//                {1, 1, 1, 1, 3, 3},
//                {3, 1, 2, 1, 3, 1},
//                {1, 1, 1, 2, 1, 1},
//        };


        //UP
        int newR = curR - 1;
        int newC = curC;

        if(newR >= 0 && island[newR][newC] != 2 && island[newR][newC] != 3){
            moves.add(new int[] {newR, newC});
        }

        //DOWN

        newR = curR + 1;
        newC = curC;

        if(newR < island.length && island[newR][newC] != 2 && island[newR][newC] != 3 ){
            moves.add(new int[] {newR, newC});
        }

        //LEFT

        newR = curR;
        newC = curC - 1;

        if(newC >= 0 && island[newR][newC] != 2 && island[newR][newC] != 3){
            moves.add(new int[] {newR, newC});
        }

        //RIGHT

        newR = curR;
        newC = curC + 1;

        if(curC < island[0].length && island[newR][newC] != 2 && island[newR][newC] != 3){
            moves.add(new int[] {newR, newC});
        }

        return moves;


    }


    // find the starting location of the explorer.
    // if explorer not found, throw exception.
    public static int[] explorerLocation(int[][] island){
        for(int row = 0; row < island.length; row++){
            for(int col = 0; col < island[row].length; col++){
                if(island[row][col] == 0){
                    return new int[] {row , col};
                }
            }
        }

        throw new IllegalArgumentException("No Explorer Found");

    }
}

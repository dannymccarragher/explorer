import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    // Add more tests here!

    @Test
    public void testExplorerLocation_validInput(){
        int[][] island = {
                {1,1,1,3,1,1},
                {3,2,3,1,3,1},
                {1,1,1,1,3,3},
                {3,1,2,1,0,1},
                {1,1,1,2,1,1},
        };

        int[] location = {3, 4};
        int[] actual = ExplorerSearch.explorerLocation(island);

        assertArrayEquals(location, actual);

    }

    @Test
    public void testExplorerLocation_NoExplorer() {
        int[][] island = {
                {1,1,1,3,1,1},
                {3,2,3,1,3,1},
                {1,1,1,1,3,3},
                {3,1,2,1,3,1},
                {1,1,1,2,1,1},
        };

        assertThrows(IllegalArgumentException.class, () -> {
            ExplorerSearch.explorerLocation(island);
        });
    }

    @Test
    public void testExplorerLocation_MultipleExplorers() {
        int[][] island = {
                {1, 1, 1, 3, 1, 1},
                {0, 2, 0, 1, 0, 1},
                {1, 1, 1, 1, 3, 3},
                {3, 1, 2, 1, 3, 1},
                {1, 1, 1, 2, 1, 1},
        };

        // It should return the first explorer that is found
        int[] location = {1, 0};
        int[] actual = ExplorerSearch.explorerLocation(island);

        assertArrayEquals(location, actual);
    }

    @Test
    public void testPossibleMoves_simpleCase() {
        int[][] island = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        // starts at middle of the matrix
        int[] explorerLocation = ExplorerSearch.explorerLocation(island);

        List<int[]> moves = ExplorerSearch.possibleMoves(island, explorerLocation);

        assertEquals(4, moves.size());
    }

    @Test public void testPossibleMoves_NoUpMove() {
        int[][] island = {
                {0, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

        int[] location = ExplorerSearch.explorerLocation(island);
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);
        assertEquals(2, moves.size());
    }

    @Test public void testPossibleMoves_NoDownMove() {
        int[][] island = {
                {1, 1, 1},
                {1, 1, 1},
                {0, 1, 1}
        };

        int[] location = ExplorerSearch.explorerLocation(island);
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);
        assertEquals(2, moves.size());
    }

    @Test
    public void testPossibleMoves_NoMoves(){
        int[][] island = {
                {2, 3, 3},
                {2, 0, 3},
                {0, 2, 1}
        };

        int[] location = ExplorerSearch.explorerLocation(island);
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);
        assertEquals(0, moves.size());
    }




    // Come up with varied cases
}

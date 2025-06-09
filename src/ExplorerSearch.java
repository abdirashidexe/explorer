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
        int[] start = explorerLocation(island);

        boolean[][] visited = new boolean[island.length][island[0].length];

        return reachableArea(island, start, visited);
    }

    // plan:
    // 1. find explorer start location [done]
    // 2. make possible moves for the explorer [done]
    // 3. make helper method that uses possible moves
    // 4. call helper method in original method

    public static int reachableArea(int[][] island, int[] current, boolean[][] visited)
    {
        int curC = current[0];
        int curR = current[1];

        // if current spot visited
        if (visited[curR][curC])
        {
            return 0;
        }

        // if 2 or 3 (water or mountain), return 0
        if (island[curR][curC] == 2 || island[curR][curC] == 3)
        {
            return 0;
        }

        // mark current as visited
        visited[curR][curC] = true;
        int total = 0;

        // if starting (0) or walkable (1), add to total
        if (island[curR][curC] == 0 || island[curR][curC] == 1)
        {
            total += 1;
        }

        List<int[]> neighbors = possibleMoves(island, current);

        for (int[] neighbor : neighbors)
        {
            int currentTotal = reachableArea(island, neighbor, visited);
            total += currentTotal;
        }

        return total;
    }

    public static List<int[]> possibleMoves(int[][] island, int[] current)
    {
        List<int[]> moves = new ArrayList<>();

        int curR = current[0];
        int curC = current[1];

        // up
        int newR = curR - 1;
        int newC = curC;
        if (newR >= 0 && island[newR][newC] != 2 && island[newR][newC] != 3)
        {
            moves.add(new int[]{newR, newC});
        }

        // down
        newR = curR + 1;
        newC = curC;

        if (newR < island.length && island[newR][newC] != 2 && island[newR][newC] != 3)

        // left
        newR = curR;
        newC = curC -1;

        if (newC >= 0 && island[newR][newC] != 2 && island[newR][newC] != 3)
        {
            moves.add(new int[]{newR, newC});
        }

        // right
        newR = curR;
        newC = curC + 1;

        if (newC < island[newR].length && island[newR][newC] != 2 && island[newR][newC] != 3)
        {
            moves.add(new int[]{newR, newC});
        }

        return moves;
    }

    public static int[] explorerLocation(int[][] island)
    {
        for (int r = 0; r < island.length; r++)
        {
            for (int c = 0; c < island[r].length; c++)
            {
                if (island[r][c] == 0)
                {
                    int[] explorer = new int[]{r, c};
                    return explorer;
                }
            }
        }
        throw new IllegalArgumentException("No explorer found");
    }
}

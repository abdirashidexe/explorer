import static org.junit.Assert.*;
import org.junit.Test;

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
    // Come up with varied cases
    @Test
    public void testReachableArea_noExplorer() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,1},
            {1,1,1,2,1,1},
        };

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ExplorerSearch.explorerLocation(island);
        });

        assertEquals("No explorer found", exception.getMessage());
    }

    @Test
    public void testReachableArea_MajorityUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,2,3,1},
            {1,1,3,1,3,3},
            {3,1,2,1,0,2},
            {1,1,1,2,2,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(3, actual);
    }

    @Test
    public void testReachableArea_AFewUnreachable() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {3,3,2,1,0,1},
            {1,1,2,1,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(24, actual);
    }

    @Test
    public void testReachableArea_OneUnreachable() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {3,1,1,1,0,1},
            {1,2,1,1,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(27, actual);
    }

    @Test
    public void testReachableArea_NoUnreachable_NoMountainsAndWater() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,0,1},
            {1,1,1,1,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(30, actual);
    }

    @Test
    public void testReachableArea_EntirelyUnreachable() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,2,1},
            {3,1,1,2,0,3},
            {1,2,1,1,3,3},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_2Explorers_BothAreInEachOthersPaths() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {0,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    @Test
    public void testReachableArea_2Explorers_OneIsBlockedOff() {
        int[][] island = {
            {1,1,0,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(3, actual);
    }
}

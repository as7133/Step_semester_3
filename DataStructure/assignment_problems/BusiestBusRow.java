package DataStructure.assignment_problems;

public class BusiestBusRow {

    static void busiestRow(int[][] grid) {

        int maxRow = 0;
        int maxTotal = 0;

        for (int i = 0; i < grid.length; i++) {

            int sum = 0;

            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
            }

            if (sum > maxTotal) {
                maxTotal = sum;
                maxRow = i;
            }
        }

        System.out.println("Row " + maxRow + ", Total " + maxTotal);
    }

    public static void main(String[] args) {

        int[][] grid = {
                {2, 0, 1},
                {3, 3, 1},
                {1, 1, 1}
        };

        busiestRow(grid);
    }
}

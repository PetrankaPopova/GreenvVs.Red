import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    /**
     * The Solution class calls countGreenOcc counting the occurrence of the green
     * color after n generations
     *
     * @author Petranka Popova
     * @version 1.0
     * @since 23-07-2020
     */


        Set<Integer> greenChangers;
        Set<Integer> redChangers;

        public Solution() {
            greenChangers = new HashSet<>();
            greenChangers.add(0);
            greenChangers.add(1);
            greenChangers.add(4);
            greenChangers.add(5);
            greenChangers.add(7);
            greenChangers.add(8);

            redChangers = new HashSet<>();
            redChangers.add(3);
            redChangers.add(6);
        }

        /**
         * This method is used to count the occurrence of the green cells after n
         * generations of the listed grid.
         *
         * @param grid This is grid containing the cells with different colors
         * @param x1   This is the target column of the grid
         * @param y1   This is the target row of the grid
         * @param n    This is the number of generations
         * @return int This returns the count of the green occurrence for the target
         *         cell x1 y1.
         */
        public int countGreenOcc(int[][] grid, int x1, int y1, int n) {
            int greenOcc = 0;

            if (grid[y1][x1] == 1) {
                greenOcc++;
            }

            for (int i = 0; i < n; i++) {
                grid = nextGeneration(grid);
                if (grid[y1][x1] == 1) {
                    greenOcc++;
                }
            }

            return greenOcc;
        }

        /**
         * This method is used to define a new color for each cell for one generation
         *
         * @param grid This is grid containing the cells with different colors
         * @return int[][] This returns the updated grid after one generation.
         */
        private int[][] nextGeneration(int[][] grid) {
            List<Cell> nextGeneration = new ArrayList<>();

            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    int current = grid[row][col];
                    int greenNeighbours = getGreenNeighbours(grid, row, col);
                    int newColor = current;

                    if (current == 1 && greenChangers.contains(greenNeighbours)) {
                        newColor = 0;
                    }

                    if (current == 0 && redChangers.contains(greenNeighbours)) {
                        newColor = 1;
                    }

                    Cell newCell = new Cell(row, col, newColor);
                    nextGeneration.add(newCell);
                }
            }
            return updateGrid(grid, nextGeneration);
        }

        /**
         * This method is used to update the existing grid with the new generated colors
         *
         * @param grid           This is grid containing the cells with different colors
         * @param nextGeneration This is list with the new colors for each cell
         * @return int[][] This returns the updated grid after this generation.
         */
        private int[][] updateGrid(int[][] grid, List<Cell> nextGeneration) {
            int i = 0;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    grid[row][col] = nextGeneration.get(i++).getColor();
                }
            }
            return grid;
        }

        /**
         * This method is used to check all 8 neighbors for green color
         *
         * @param grid This is grid containing the cells with different colors
         * @param row  This is the row of the checked cell
         * @param col  This is the column of the checked cell
         * @return int This returns the count of green neighbors for cell under this
         *         row/column.
         */
        private int getGreenNeighbours(int[][] grid, int row, int col) {
            int rows = grid.length;
            int cols = grid[0].length;
            int greesNeighbours = 0;

            if (row - 1 >= 0 && grid[row - 1][col] == 1)
                greesNeighbours++;
            if (col + 1 < cols && row - 1 >= 0 && grid[row - 1][col + 1] == 1)
                greesNeighbours++;
            if (col + 1 < cols && grid[row][col + 1] == 1)
                greesNeighbours++;
            if (col + 1 < cols && row + 1 < rows && grid[row + 1][col + 1] == 1)
                greesNeighbours++;
            if (row + 1 < rows && grid[row + 1][col] == 1)
                greesNeighbours++;
            if (row + 1 < rows && col - 1 >= 0 && grid[row + 1][col - 1] == 1)
                greesNeighbours++;
            if (col - 1 >= 0 && grid[row][col - 1] == 1)
                greesNeighbours++;
            if (row - 1 >= 0 && col - 1 >= 0 && grid[row - 1][col - 1] == 1)
                greesNeighbours++;

            return greesNeighbours;
        }

        public static void main(String[] args) {
            Solution mySolution = new Solution();
            int result = mySolution.countGreenOcc(new int[][] { { 0, 0, 0 }, { 1, 1, 1 }, { 0, 0, 0 } }, 1, 0, 10);
//		int result = mySolution.countGreenOcc(new int[][] { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 0, 1, 0, 0 }, {1, 0, 1, 0} }, 2, 2, 15);
            System.out.println(result);
        }

    }


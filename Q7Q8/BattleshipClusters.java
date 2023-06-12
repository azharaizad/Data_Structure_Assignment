package Q7Q8;
import java.util.Scanner;

public class BattleshipClusters {
    public static int findClusters(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        int clusterCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    clusterCount++;
                    dfs(matrix, i, j);
                }
            }
        }

        return clusterCount;
    }

    private static void dfs(int[][] matrix, int row, int col) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || matrix[row][col] == 0) {
            return;
        }

        matrix[row][col] = 0; // Mark current position as visited

        // Explore adjacent positions
        dfs(matrix, row - 1, col); // Up
        dfs(matrix, row + 1, col); // Down
        dfs(matrix, row, col - 1); // Left
        dfs(matrix, row, col + 1); // Right
        dfs(matrix, row - 1, col - 1); // Diagonal: Up-Left
        dfs(matrix, row - 1, col + 1); // Diagonal: Up-Right
        dfs(matrix, row + 1, col - 1); // Diagonal: Down-Left
        dfs(matrix, row + 1, col + 1); // Diagonal: Down-Right
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter the matrix (each row separated by spaces):");
        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            String rowStr = scanner.nextLine();
            String[] elements = rowStr.split(" ");
            int cols = elements.length;
            matrix[i] = new int[cols];

            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(elements[j]);
            }
        }

        scanner.close();

        int clusterCount = findClusters(matrix);
        System.out.println(clusterCount + " cluster");
    }
}
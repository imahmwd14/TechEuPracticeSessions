package codeWarsSolutions;

public class Solution {
    public static String diagonal(int[][] matrix) {

        int principal = calcPrincipal(matrix, 0);
        int secondary = calcSecondary(matrix, 0, matrix.length - 1);

        return (principal > secondary) ?
                "Principal Diagonal win!" :
                ((principal == secondary) ?
                        "Draw!" :
                        "Secondary Diagonal win!");
    }

    private static int calcSecondary(int[][] matrix, int x, int y) {
        return (y > -1) ?
                (matrix[x][y] + calcSecondary(matrix, x + 1, y - 1)) :
                0;
    }

    private static int calcPrincipal(int[][] matrix, int index) {
        return (index < matrix.length) ?
                (matrix[index][index++] + calcPrincipal(matrix, index)) :
                0;
    }
}
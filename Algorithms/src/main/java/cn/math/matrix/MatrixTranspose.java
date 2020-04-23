package cn.math.matrix;

/**
 * 实现矩阵转置
 *
 * @author QuLei
 */
public class MatrixTranspose {
    public static void main(String[] args) {

        int[][] matrix = new int[3][4];
        int k = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = k++;
            }
        }
        int[][] transposedMatrix = transpose(matrix);
        System.out.println("输出原矩阵：");
        print(matrix);
        System.out.println("-----------------");
        System.out.println("转置后的矩阵：");
        print(transposedMatrix);
    }

    /**
     * 转置矩阵
     *
     * @param matrix 待转置矩阵
     * @return 转置后的矩阵
     */
    private static int[][] transpose(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    /**
     * 打印数组
     *
     * @param matrix 待打印数组
     */
    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}

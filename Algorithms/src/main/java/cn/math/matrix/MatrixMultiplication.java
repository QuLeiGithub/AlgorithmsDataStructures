package cn.math.matrix;

/**
 * 实现矩阵相乘
 *
 * @author TaoistQu
 */
public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] matrix1 = {{2, 7}, {1, 8}};
        int[][] matrix2 = {{2, 8}, {1, 3}};
        int[][] milt = multiply(matrix1, matrix2);
        for (int i = 0; i < milt.length; i++) {
            for (int j = 0; j < milt[0].length; j++) {
                System.out.print(milt[i][j] + "\t");
            }
            System.out.println();
        }

    }

    /**
     * 实现两矩阵相乘
     *
     * @param matrix1
     * @param matrix2
     * @return
     */
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        //这里为了实现数学上的问题，简化了对矩阵合法性的判断
        if (matrix1[0].length != matrix2.length) {
            throw new RuntimeException("不满足矩阵乘法基本要求！！！");
        }
        int row = matrix1.length;
        int col = matrix2[0].length;
        int[][] result = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < matrix2.length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
}

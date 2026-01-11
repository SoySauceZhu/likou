public class Solution48 {
    public void rotate(int[][] matrix) {

        int n = (matrix.length + 1) / 2;

        for (int i = 0; i < n; i++) {
            rotateLayer(matrix, i);
        }
    }

    private void rotateLayer(int[][] matrix, int layer) {
        /*
            Pealing an onion, this is one of the layer
         */


        int n = matrix.length;

        int originRow = layer;

        for (int originCol = layer; originCol < n - layer - 1; originCol++) {

            int buffer = matrix[originCol][n - originRow - 1];

            matrix[originCol][n - originRow - 1] = matrix[originRow][originCol];
            matrix[originRow][originCol] = matrix[n - originCol - 1][originRow];
            matrix[n - originCol - 1][originRow] = matrix[n - originRow - 1][n - originCol - 1];
            matrix[n - originRow - 1][n - originCol - 1] = buffer;
        }
    }

    public static void main(String[] args) {
            Solution48 s = new Solution48();

            int[][] m1 = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            s.rotate(m1);
            printMatrix(m1);

            int[][] m2 = {
                    {5, 1, 9, 11},
                    {2, 4, 8, 10},
                    {13, 3, 6, 7},
                    {15, 14, 12, 16}
            };
            s.rotate(m2);
            printMatrix(m2);
        }

        private static void printMatrix(int[][] matrix) {
            for (int[] row : matrix) {
                System.out.println(java.util.Arrays.toString(row));
            }
            System.out.println();
        }
}

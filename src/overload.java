class Matrix {
    private double[][] data;

    public Matrix(double[][] data) {
        this.data = data;
    }

    public Matrix add(Matrix other) {
        int rows = data.length;
        int cols = data[0].length;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix multiply(Matrix other) {
        int rows = data.length;
        int cols = other.data[0].length;
        int sumLength = other.data.length;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < sumLength; k++) {
                    result[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] row : data) {
            for (double val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

public class overload {
    public static void main(String[] args){

    }
}

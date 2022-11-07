import java.text.DecimalFormat;

public class Matrix {
    private double[][] matrixData;
    private int nRow;
    private int mCol;
    private DecimalFormat format = new DecimalFormat("0.#");

    public Matrix(){}

    public Matrix(double[][] data) {
        this.matrixData = data;
        this.nRow = this.matrixData.length;
        this.mCol = this.matrixData[0].length;
    }

    public void setMatrix(double[][] data){
        this.matrixData = data;
        this.nRow = this.matrixData.length;
        this.mCol = this.matrixData[0].length;
    }

    public int getRowDimension() {
        return this.matrixData == null ? 0 : this.matrixData.length;
    }

    public int getColDimension() {
        return this.matrixData == null ? 0 : this.matrixData[0].length;
    }

    public Matrix multiplyMatrix(Matrix matrix2){
        int nRows = this.getRowDimension();
        int nCols = matrix2.getColDimension();

        if (nRows != nCols){
            System.out.println("Not same dimension");
            return new Matrix();
        }

        double[][] outData = new double[nRows][nCols];

        for(int row = 0; row < nRows; ++row) {
            double[] dataRow = this.matrixData[row];
            double[] outDataRow = outData[row];

            for(int col = 0; col < nCols; ++col) {
                double sum = 0.0;

                for(int i = 0; i < nCols; ++i) {
                    sum += dataRow[i] * matrix2.matrixData[i][col];
                }

                outDataRow[col] = sum;
            }
        }

        return new Matrix(outData);
    }

    public void mult(double value){
        for (int i = 0; i < this.getRowDimension(); i++) {
            for (int j = 0; j < this.getColDimension(); j++) {
                this.matrixData[i][j] = this.matrixData[i][j]*value;
            }
    }}

    public void printMatrix(){
        for (int i = 0; i < this.getRowDimension(); i++) {
            for (int j = 0; j < this.getColDimension(); j++) {
                System.out.print(format.format(this.matrixData[i][j]) + " ");
            }
            System.out.println();
        }}

    @Override
    public String toString() {
        for (int i = 0; i < this.getRowDimension(); i++) {
            for (int j = 0; j < this.getColDimension(); j++) {
                System.out.print(format.format(this.matrixData[i][j]) + " ");
            }
            System.out.println();
        }
        return "";
    }
}

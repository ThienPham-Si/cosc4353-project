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
            return new Matrix(this.matrixData);
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



    public Matrix addMatrix(Matrix matrix2){
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
                outDataRow[col] = dataRow[col] + matrix2.matrixData[row][col];
            }
        }

        return new Matrix(outData);
    }

    public Matrix tranpose(){
        int nRows = this.getRowDimension();
        int nCols = this.getColDimension();

        double[][] outData = new double[nCols][nRows];

        for(int row = 0; row < nRows; ++row) {
            double[] dataRow = this.matrixData[row];

            for(int col = 0; col < nCols; ++col) {
                outData[col][row] = dataRow[col];
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

    public String shape(){
        return "(" + this.getRowDimension() + ", " + this.getColDimension() + ")";
    }

    public void setElement(int row, int col, double value){
        this.matrixData[row][col] = value;
    }

    public void deleteRow(int row){
        double[][] newData = new double[this.getRowDimension()-1][this.getColDimension()];
        int count = 0;
        for (int i = 0; i < this.getRowDimension(); i++) {
            if (i != row){
                newData[count] = this.matrixData[i];
                count++;
            }
        }
        this.matrixData = newData;
    }

    public void deleteCol(int col){
        double[][] newData = new double[this.getRowDimension()][this.getColDimension()-1];
        for (int i = 0; i < this.getRowDimension(); i++) {
            int count = 0;
            for (int j = 0; j < this.getColDimension(); j++) {
                if (j != col){
                    newData[i][count] = this.matrixData[i][j];
                    count++;
                }
            }
        }
        this.matrixData = newData;
    }

    public void insertRow(int row, double[] data){
        double[][] newData = new double[this.getRowDimension()+1][this.getColDimension()];
        int count = 0;
        for (int i = 0; i < this.getRowDimension()+1; i++) {
            if (i != row){
                newData[i] = this.matrixData[count];
                count++;
            } else {
                newData[i] = data;
            }
        }
        this.matrixData = newData;
    }

    public void inserCol(int col, double[] data){
        double[][] newData = new double[this.getRowDimension()][this.getColDimension()+1];
        for (int i = 0; i < this.getRowDimension(); i++) {
            int count = 0;
            for (int j = 0; j < this.getColDimension()+1; j++) {
                if (j != col){
                    newData[i][j] = this.matrixData[i][count];
                    count++;
                } else {
                    newData[i][j] = data[i];
                }
            }
        }
        this.matrixData = newData;
    }

    public double linearCombination(double[] data){
        double sum = 0;
        for (int i = 0; i < this.getRowDimension(); i++) {
            sum += this.matrixData[i][0]*data[i];
        }
        return sum;
    }

    public int matrixRank(){
        int rank = 0;
        Matrix temp = this;
        for (int i = 0; i < this.getRowDimension(); i++) {
            if (temp.matrixData[i][i] == 0){
                for (int j = i+1; j < this.getRowDimension(); j++) {
                    if (temp.matrixData[j][i] != 0){
                        temp.swapRow(i, j);
                        rank++;
                        break;
                    }
                }
            }
            if (temp.matrixData[i][i] != 0){
                for (int j = i+1; j < this.getRowDimension(); j++) {
                    double mult = temp.matrixData[j][i]/temp.matrixData[i][i];
                    for (int k = 0; k < this.getColDimension(); k++) {
                        temp.matrixData[j][k] -= mult*temp.matrixData[i][k];
                    }
                }
            }
        }
        for (int i = 0; i < this.getRowDimension(); i++) {
            if (temp.matrixData[i][i] != 0){
                rank++;
            }
        }
        return rank;
    }

    public void swapRow(int row1, int row2){
        double[] temp = this.matrixData[row1];
        this.matrixData[row1] = this.matrixData[row2];
        this.matrixData[row2] = temp;
    }

    public double[][] eigenValues(){
        double[][] eigenValues = new double[this.getRowDimension()][2];
        for (int i = 0; i < this.getRowDimension(); i++) {
            eigenValues[i][0] = this.matrixData[i][i];
            eigenValues[i][1] = 1;
        }
        for (int i = 0; i < this.getRowDimension(); i++) {
            for (int j = 0; j < this.getRowDimension(); j++) {
                System.out.print(format.format(this.matrixData[i][j]) + " ");
            }
        }
        return eigenValues;
    }

    public double[][] eigenVectors(){
        double[][] eigenVectors = new double[this.getRowDimension()][this.getColDimension()];
        for (int i = 0; i < this.getRowDimension(); i++) {
            eigenVectors[i][i] = 1;
        }
        for (int i = 0; i < this.getRowDimension(); i++) {
            for (int j = 0; j < this.getColDimension(); j++) {                    
                System.out.print(format.format(eigenVectors[i][j]) + " ");
            }
        }
        return eigenVectors;
    }

    public double[][] inverse(){
        double[][] inverse = new double[this.getRowDimension()][this.getColDimension()];
        for (int i = 0; i < this.getRowDimension(); i++) {
            inverse[i][i] = 1/this.matrixData[i][i];
        }
        return inverse;
    }


    public double[][] getMatrixData() {
        return matrixData;
    }

    public void setMatrixData(double[][] matrixData) {
        this.matrixData = matrixData;
    }

    public int getnRow() {
        return nRow;
    }

    public void setnRow(int nRow) {
        this.nRow = nRow;
    }

    public int getmCol() {
        return mCol;
    }

    public void setmCol(int mCol) {
        this.mCol = mCol;
    }

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
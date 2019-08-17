/*
 * Immutable class for Sparse Matrix Operations
 * Methods inbuilt are 
 * 		sparse - parameterised Constructor First
 * 		sparse - parameterised Constructor Second
 * 		convertToSparse - convert normal matrix to sparse
 * 		getMatrix - converts sparse matrix to normal matrix
 * 		transpose - does transpose of sparse matrix
 * 		symmetric - checks for if sparse matrix is symmetric or not
 * 		addMatrix - adds two sparse matrix
 * 		add - adds two sparse matrix
 * 		multiplyMatrix - multiplies two sparse matrix
 */	
package Problem1;
final class sparse {
	private final int[][] matrix;
	private final int matrixRow;
	private final int matrixColumn;
	private int[][] multiplicationProduct;
	private int indexFirst=0 , indexSecond=0 , indexThird=0;
	/*
	 * @param null
	 * @return null
	 */
	sparse(int matrix[][]){
		this.matrix=convertToSparse(matrix);
		this.matrixRow=matrix.length;
		this.matrixColumn=matrix[0].length;
	}
	/*
	 * @param null
	 * @return null
	 */
	sparse(int [][]matrix,int matrixRow,int matrixColumn){
		this.matrix=matrix;
		this.matrixRow=matrixRow;
		this.matrixColumn=matrixColumn;
	}
	/*
	 * @param int double dimensional matrix
	 * @return int double dimensional matrix
	 */
	public int[][] convertToSparse(int[][] matrix) {
		int counter=0;
		for(int indexFirst=0;indexFirst<matrix.length;indexFirst++) {
			for(int indexSecond=0;indexSecond<matrix[0].length;indexSecond++) {
				if(matrix[indexFirst][indexSecond]!=0) {
					counter++;
				}
			}
		}
		//initialising final matrix
		int finalSparseMatrix[][]=new int[counter+1][3];
		finalSparseMatrix[0][0]=matrix.length;
		finalSparseMatrix[0][1]=matrix[0].length;
		finalSparseMatrix[0][2]=counter;
		counter=1;
		for(int indexFirst=0;indexFirst<matrix.length;indexFirst++) {
			for(int indexSecond=0;indexSecond<matrix[0].length;indexSecond++) {
				if(matrix[indexFirst][indexSecond]!=0) {
					finalSparseMatrix[counter][0]=indexFirst;
					finalSparseMatrix[counter][1]=indexSecond;
					finalSparseMatrix[counter][2]=matrix[indexFirst][indexSecond];
					counter++;
				}
			}
		}
		return finalSparseMatrix;
	}
	/*
	 * @param null
	 * @return int double dimensional array
	 */
	public int[][] getMatrix() {
		int finalMatrix[][]=new int[matrix[0][0]][matrix[0][1]];
		for(int indexFirst=0;indexFirst<finalMatrix.length;indexFirst++) {
			for(int indexSecond=0;indexSecond<finalMatrix[0].length;indexSecond++) {
				finalMatrix[indexFirst][indexSecond]=0;
			}
		}
		for(int indexFirst=1;indexFirst<matrix.length;indexFirst++) {
			finalMatrix[matrix[indexFirst][0]][matrix[indexFirst][1]]=matrix[indexFirst][2];
		}
		return finalMatrix;
	}
	/*
	 * @param null
	 * @return sparse type transpose
	 */
	public sparse transpose() {
		int transpose[][]=new int[matrix.length][3];
		for(int indexValueFirst=0;indexValueFirst<matrix.length;indexValueFirst++) {
				transpose[indexValueFirst][1]=matrix[indexValueFirst][0];
				transpose[indexValueFirst][0]=matrix[indexValueFirst][1];
				transpose[indexValueFirst][2]=matrix[indexValueFirst][2];
		}
		return new sparse(transpose,transpose[0][0],transpose[0][1]);
	}
	/*
	 * @param null
	 * @return boolean true if matrix is symmetrical
	 * @return boolean false if matrix is not symmetrical
	 */
	public boolean symmetric(){
		sparse transpose=transpose();
		int counter=0;
		for(int indexValueFirst=0;indexValueFirst<matrix.length;indexValueFirst++) {
			for(int indexValueSecond=0;indexValueSecond<transpose.matrix.length;indexValueSecond++) {
				if(matrix[indexValueFirst][0]==transpose.matrix[indexValueSecond][0] && matrix[indexValueFirst][1]==transpose.matrix[indexValueSecond][1] && matrix[indexValueFirst][2]==transpose.matrix[indexValueSecond][2]){
					counter++;
				}
			}
		}
		//checks for any difference between transpose and original matrix
		if(counter==matrix.length) {
			return true;
		}
		return false;
	}
	/*
	 * @param sparse type matrix
	 * @return sparse type sum
	 * @exception throws Arithmetic Exception
	 */
	public sparse addMatrix(sparse matrix2)throws ArithmeticException{
		if(this.matrix[0][0]!=matrix2.matrix[0][0] || this.matrix[0][1]!=matrix2.matrix[0][1])
			throw new ArithmeticException("Unable to add two different size Matrices");
		int result[][];
		if(matrix2.matrix.length>this.matrix.length) {
			result=add(matrix2,new sparse(this.matrix,this.matrix[0][0],this.matrix[0][1]));
		} 
		result=add(new sparse(this.matrix,this.matrix[0][0],this.matrix[0][1]),matrix2);
		return new sparse(result,result[0][0],result[0][1]);
	}
	/*
	 * @param sparse type matrix first
	 * @param sparse type matrix second
	 * @return sparse type sum of both matrix
	 */
	private int[][] add(sparse matrix1,sparse matrix2){
		int resultantMatrix[][]=new int[matrix1.matrix.length+matrix2.matrix.length][3];
		int flag=0,counter=0;
		for(int indexFirst=0;indexFirst<matrix1.matrix.length;indexFirst++) {
			for(int indexSecond=0;indexSecond<matrix2.matrix.length;indexSecond++) {
					if(matrix1.matrix[indexFirst][0]==matrix2.matrix[indexSecond][0] && matrix1.matrix[indexFirst][1]==matrix2.matrix[indexSecond][1]) {
						resultantMatrix[indexFirst][0]=matrix1.matrix[indexFirst][0];
						resultantMatrix[indexFirst][1]=matrix1.matrix[indexFirst][1];
						resultantMatrix[indexFirst][2]=matrix1.matrix[indexFirst][2]+matrix2.matrix[indexSecond][2];
						counter++;
						flag=1;
					}
			}
			if(flag==0) {
				resultantMatrix[indexFirst][0]=matrix1.matrix[indexFirst][0];
				resultantMatrix[indexFirst][1]=matrix1.matrix[indexFirst][1];
				resultantMatrix[indexFirst][2]=matrix1.matrix[indexFirst][2];
				counter++;
			}
			flag=0;
		}
		//Adding sparse Second Matrix left over elements to final matrix
		for(int indexFirst=0;indexFirst<matrix2.matrix.length;indexFirst++) {
			for(int indexSecond=0;indexSecond<matrix1.matrix.length;indexSecond++) {
					if(matrix2.matrix[indexFirst][0]==matrix1.matrix[indexSecond][0] && matrix2.matrix[indexFirst][1]==matrix1.matrix[indexSecond][1]) {
						flag=1;
					}
			}
			if(flag==0) {
				resultantMatrix[counter][0]=matrix2.matrix[indexFirst][0];
				resultantMatrix[counter][1]=matrix2.matrix[indexFirst][1];
				resultantMatrix[counter][2]=matrix2.matrix[indexFirst][2];
				counter++;
			}
			flag=0;
		}
		int count=0;
		//counting for total number of distinct sets
		for(int indexFirst=0;indexFirst<resultantMatrix.length;indexFirst++) {
			if(resultantMatrix[indexFirst][2]!=0)
				count++;
		}
		int result[][]=new int[count][3];
		//finally assigning it to final array and sending it back
		for(int indexFirst=0;indexFirst<result.length;indexFirst++) {
			for(int indexSecond=0;indexSecond<3;indexSecond++) {
				result[indexFirst][indexSecond]=resultantMatrix[indexFirst][indexSecond];
			}
		}
		return result;
	}
	/*
	 * @param sparse matrix second
	 * @return sparse type multiplication of both matrix 
	 * @exception throws Arithmetic Exception
	 */
	public sparse multiplyMatric(sparse secondMatrix)throws ArithmeticException {
		//input validation
		if(this.matrixColumn != secondMatrix.matrixRow){
			throw new ArithmeticException("Can't perform multiplication");
		}
		int[][] multiplyMatrix = new int[this.matrixRow][secondMatrix.matrixColumn];
		int sum = 0;
		int firstMatrixElement = 0;
		boolean firstMatrixElementFound = false;
		boolean secondMatrixElementFound = false;
		int secondMatrixElement = 0;
		//simply performing multiplication of two matrix with added two loops to check for 0 values
		for (int firstMatrixRowIndex = 0; firstMatrixRowIndex < this.matrixRow; firstMatrixRowIndex++) {
			for (int secondMatrixColumnIndex = 0; secondMatrixColumnIndex < secondMatrix.matrixColumn; secondMatrixColumnIndex++) {
				for (int firstMatrixColumnIndex = 0; firstMatrixColumnIndex < this.matrixColumn; firstMatrixColumnIndex++) {
					for (int rowIndex = 1; rowIndex < this.matrix.length; rowIndex++) {
						if (this.matrix[rowIndex][0] == firstMatrixRowIndex	&& this.matrix[rowIndex][1] == firstMatrixColumnIndex) {
							firstMatrixElement = this.matrix[rowIndex][2];
							firstMatrixElementFound = true;
							break;
						}
					}
					for (int rowIndex = 1; rowIndex < secondMatrix.matrix.length; rowIndex++) {
						if (secondMatrix.matrix[rowIndex][0] == firstMatrixColumnIndex &&secondMatrix.matrix[rowIndex][1] == secondMatrixColumnIndex) {
							secondMatrixElement = secondMatrix.matrix[rowIndex][2];
							secondMatrixElementFound = true;
							break;
						}
					}
					if (!firstMatrixElementFound) {
						firstMatrixElement = 0;
					}
					if (!secondMatrixElementFound) {
						secondMatrixElement = 0;
					}
					sum = sum + firstMatrixElement * secondMatrixElement;
					firstMatrixElementFound = false;
					secondMatrixElementFound = false;
				}
				multiplyMatrix[firstMatrixRowIndex][secondMatrixColumnIndex] = sum;
				sum = 0;
			}
		}
	return new sparse(multiplyMatrix);
	}
	public sparse multiplyMatrix(sparse secondMatrix) throws Exception { 
		int row1=this.matrixRow;
		int col1=this.matrixColumn;
		int row2=secondMatrix.matrixRow;
		int col2=secondMatrix.matrixColumn;
		if (row2 != col1) { 
		 throw new Exception ("Multiplication not possible because of Size "); 
		} 
		multiplicationProduct = new int[row1][col2]; 
		multiplyMatrixRecursively(row1, col1, this.getMatrix() , row2, col2, secondMatrix.getMatrix());
		return new sparse(this.multiplicationProduct);
	} 
	public void multiplyMatrixRecursively(int row1, int col1, int firstMatrix[][],int row2, int col2, int secondMatrix[][]) { 
		if (indexFirst >= row1) {
			return;
		} 
		if (indexSecond < col2) { 
			if (indexThird < col1) { 
				multiplicationProduct[indexFirst][indexSecond] += firstMatrix[indexFirst][indexThird] * secondMatrix[indexThird][indexSecond]; 
				indexThird++; 
				multiplyMatrixRecursively(row1, col1, firstMatrix, row2, col2, secondMatrix); 
			} 	
			indexThird = 0; 
			indexSecond++; 
			multiplyMatrixRecursively(row1, col1, firstMatrix, row2, col2, secondMatrix); 
		} 	
		indexSecond = 0; 
		indexFirst++; 
		multiplyMatrixRecursively(row1, col1, firstMatrix, row2, col2, secondMatrix); 
	} 
}
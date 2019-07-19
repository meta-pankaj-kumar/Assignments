/*
 * This class comprises of nQueen solution for any base i.e. base<=13
 * Methods
 * 		nQueen - returns true if solution is possible else false
 * 		nQueenSolver - returns Queen Matrix in String type
 */
package Queen;
public class queen {
	int base;
	int queenLocation[][]=new int[base][2];
	String board[][] = new String[base][base];
	int rowVal=0,colVal=0;
	int rowCounter=0;
	/*
	 * @param Integer Double dimensional board base
	 * @param int type start index of Row
	 * @param int dimension of board
	 * @return boolean value true if solution is possible
	 * @return boolean value false if solution is not possible
	 * Assumption board inputed should be blank
	 * Assumption base <=13
	 * Assumption row value should be 0
	 */
	public boolean nQueen(int board[][],int startRow,int dimensionOfMatrix)	{
		this.base=dimensionOfMatrix;
		//getting solved n queen problem 
		String solved[][]=nQueenSolver(base);
		//if solution is possible array will not contain any negative value
		if(solved[0][0]!="-1")	{
			return true;
		}
		return false;
	}
	/*
	 * @param int type base of board
	 * @return String double dimensional array containing nQueen solved Problem
	 * @return if solution not possible whole board will contain -1
	 * Assumption base <=13
	 */
	public String[][] nQueenSolver(int base) {
		board=boardInitializer(base);
		this.base=base;
		this.rowVal=0;
		this.colVal=0;
		solve();
		return board;
	}
	/*
	 * @param int type base of board
	 * @return String double dimensional array containing nQueen solved Problem
	 * @return if solution not possible whole board will contain -1
	 * Assumption base <=13
	 */
	private void solve() {
		if(rowVal<board.length && colVal<board.length)		{
			if(isPositionValidToPlaceQueen()==1)	{
				placeNewQueen();
				rowVal++;
				colVal=0;
				//recursively calling back itself
				solve();
			}
			colVal++;
			//recursively calling back itself
			solve();			
		}
		else	{
			if((rowVal<board.length && colVal==board.length)){
				rowVal=queenLocation[rowCounter-1][0];
				colVal=queenLocation[rowCounter-1][1];
				//performing backtracking
				if(backTrack()==1)	{
					rowVal=queenLocation[rowCounter][0];
					colVal=queenLocation[rowCounter][1];
					colVal++;
					//recursively calling back itself
					solve();
				}
			}
		}
	}
	/*
	 * @param null
	 * @return null
	 * Assumption base <=13
	 */
	private int backTrack()	{
		if((rowVal==0)&&(colVal==(board.length-1))) {
			//if placement not possible calling impossible 
			impossible();
			return -1;
		}
		else	{
			//removing placed queen
			removePlacedQueen();
			return 1;
		}
	}
	/*
	 * @param null
	 * @return null
	 * Assumption base <=13
	 */
	private void impossible()	{
		for(int indexFirst=0;indexFirst<board.length;indexFirst++) 	{
			for(int indexSecond=0;indexSecond<board.length;indexSecond++)	{
				//marking all positions to -1
				board[indexFirst][indexSecond]="-1";
			}
		}
	}
	/*
	 * @param null
	 * @return null
	 * Assumption base <=13
	 */
	private void removePlacedQueen()	{
		//removing row effect caused by queen to be removed
		for(int i=0;i<board.length;i++)	{
			if(board[i][colVal]!="Q")	{
				board[i][colVal]=Integer.toString((Integer.valueOf(board[i][colVal]))-1);
			}
		}
		//removing column effect caused by queen to be removed
		for(int indexFirst=0;indexFirst<board.length;indexFirst++)		{
			if(board[rowVal][indexFirst]!="Q")	{
				board[rowVal][indexFirst]=Integer.toString((Integer.valueOf(board[rowVal][indexFirst]))-1);
			}
		}
		//calling remove diagonal effect caused by queen to be removed
		removeDiagonalEffect();
		rowCounter--;
	}
	/*
	 * @param null
	 * @return null
	 * Assumption base <=13
	 */
	private void removeDiagonalEffect()	{
		blockOrReleaseDiagonalD1(-1);
		blockOrReleaseDiagonalD2(-1);
		blockOrReleaseDiagonalD3(-1);
		blockOrReleaseDiagonalD4(-1);
		//after removing all affected ares of queen to be removed removing queen
		board[rowVal][colVal]="0";
	}
	/*
	 * @param null
	 * @return null
	 * Assumption base <=13
	 */
	private void placeNewQueen()	{
		board[rowVal][colVal]="Q";
		queenLocation[rowCounter][0]=rowVal;
		queenLocation[rowCounter][1]=colVal;
		rowCounter++;
		//after placing Queen marking out the row areas affected by new queen 
		for(int indexFirst=0;indexFirst<board.length;indexFirst++)	{
			if(board[indexFirst][colVal]!="Q")	{
				board[indexFirst][colVal]=Integer.toString((Integer.valueOf(board[indexFirst][colVal]))+1);
			}
		}
		//after placing Queen marking out the column areas affected by new queen 
		for(int indexFirst=0;indexFirst<board.length;indexFirst++)		{
			if(board[rowVal][indexFirst]!="Q")	{
				board[rowVal][indexFirst]=Integer.toString((Integer.valueOf(board[rowVal][indexFirst]))+1);
			}
		}
		blockOrReleaseDiagonalD1(1);
		blockOrReleaseDiagonalD2(1);
		blockOrReleaseDiagonalD3(1);
		blockOrReleaseDiagonalD4(1);
	}
	/*
	 * @param int value 1 to mark an affected area
	 * @param int value -1 to remove an affected area
	 * @return null
	 * Assumption base <=13
	 */
	private void blockOrReleaseDiagonalD1(int value)	{
		while(rowVal>0 && colVal<board.length-1)	{
			rowVal--;
			colVal++;
			board[rowVal][colVal]=Integer.toString((Integer.valueOf(board[rowVal][colVal]))+value);
		}
		rowVal=queenLocation[rowCounter-1][0];
		colVal=queenLocation[rowCounter-1][1];		
	}
	/*
	 * @param int value 1 to mark an affected area
	 * @param int value -1 to remove an affected area
	 * @return null
	 * Assumption base <=13
	 */
	private void blockOrReleaseDiagonalD2(int value)	{
		while(rowVal>0 && colVal>0)		{
			rowVal--;
			colVal--;
			board[rowVal][colVal]=Integer.toString((Integer.valueOf(board[rowVal][colVal]))+value);
		}
		rowVal=queenLocation[rowCounter-1][0];
		colVal=queenLocation[rowCounter-1][1];
	}
	/*
	 * @param int value 1 to mark an affected area
	 * @param int value -1 to remove an affected area
	 * @return null
	 * Assumption base <=13
	 */
	private void blockOrReleaseDiagonalD3(int value)	{
		while(rowVal<board.length-1 && colVal>0)	{
			rowVal++;
			colVal--;
			board[rowVal][colVal]=Integer.toString((Integer.valueOf(board[rowVal][colVal]))+value);
		}
		rowVal=queenLocation[rowCounter-1][0];
		colVal=queenLocation[rowCounter-1][1];
	}	
	/*
	 * @param int value 1 to mark an affected area
	 * @param int value -1 to remove an affected area
	 * @return null
	 * Assumption base <=13
	 */
	private void blockOrReleaseDiagonalD4(int value)	{
		while(rowVal<board.length-1 && colVal<board.length-1)	{
			rowVal++;
			colVal++;
			board[rowVal][colVal]=Integer.toString((Integer.valueOf(board[rowVal][colVal]))+value);
		}
		rowVal=queenLocation[rowCounter-1][0];
		colVal=queenLocation[rowCounter-1][1];
	}
	/*
	 * @param null
	 * @return int 1 if queen can be placed at that position
	 * @return int -1 if queen can not be placed at that position
	 * Assumption base <=13
	 */
	private int isPositionValidToPlaceQueen()	{
		if(board[rowVal][colVal].equals("0"))		{
			return 1;
		}
		else {
			return -1;
		}
	}
	/*
	 * @param int value of board Size
	 * @return double dimensional String array board with "0" at all positions 
	 * Assumption base <=13
	 */	
	private String[][] boardInitializer(int n)	{
		String initialBoard[][]=new String[n][n];
		for(int indexFirst=0;indexFirst<n;indexFirst++)	{
			for(int indexSecond=0;indexSecond<n;indexSecond++)	{
				//initialising board with 0
				initialBoard[indexFirst][indexSecond]="0";
			}
		}
		queenLocation=queenLocationInitializer(n);
		return initialBoard;
	}
	/*
	 * @param int value of board size
	 * @return double dimensional int array with all initial locations of queen
	 * Assumption base <=13
	 */
	private int[][] queenLocationInitializer(int n)	{
		int initialIndexes[][]=new int[n][2];
		for(int indexFirst=0;indexFirst<n;indexFirst++)	{
			for(int indexSecond=0;indexSecond<2;indexSecond++){
				initialIndexes[indexFirst][indexSecond]=0;
			}
		}
		return initialIndexes;
	}
}

package AED.Assignment3;

import java.util.ArrayList;
import java.util.List;

/*Q7.
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
Example 1:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]*/
class SpiralOrder{
	
	public static void main(String [] args) {
		int[][] arr={
			{ 1, 2,3,},
			//{4, 9,5,},
			 //{ 7, 8,8},
		//	{ 1, 563487, -3 },
			//{4, 5, 6 ,5},
			//{ 7, 8, 9 ,6},
		};
		int [] values = spiralOrder(arr);
		for(int i=0;i<values.length;i++) {
			System.out.println(values[i]);
		}
	//	System.out.println(values);
	}
		
	

public static int[] spiralOrder(int[][] matrix) {

	if(matrix.length ==0)
		throw new IllegalArgumentException();
	int i;
	int row =0;
	int column =0;
	int last_row =matrix.length-1;
	int last_column = matrix[0].length-1;
	int [] arr = new int[matrix.length * matrix[0].length];
	;
	for(int l=0;l<matrix.length;l++) {
		if(matrix[l].length != matrix[0].length)
			throw new IllegalArgumentException();
	}
	List<Integer> list = new ArrayList<Integer>();
	while(row<=last_row && column<=last_column) {
	for( i=column;i<=last_column;i++) {
		//System.out.println(matrix[row][i]);
		list.add(matrix[row][i]);
		
		
	}
	row++;
	for(i=row;i<=last_row;i++) {
	//	System.out.println(matrix[i][last_column]);
		list.add(matrix[i][last_column]);

	}
	last_column--;
	if(row<=last_row) {
	for(i=last_column;i>=column;i--) {
		//System.out.println(matrix[last_row][i]);
		list.add(matrix[last_row][i]);
	}
	last_row--;
	if(column<=last_column) {
		for(i=last_row;i>=row;i--) {
		//	System.out.println(matrix[i][column]);
			list.add(matrix[i][column]);

		}
	}
	column++;
	}
	}
	for(int k=0;k<list.size();k++) {
		arr[k] = list.get(k);
	//	System.out.println(arr[k]);
	}
	return arr;
}
}
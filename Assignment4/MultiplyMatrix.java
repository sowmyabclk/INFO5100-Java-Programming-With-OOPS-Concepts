package AED.Assignment4;

public class MultiplyMatrix {
	
	private static int[][] multiply(int[][] mat1, int[][] mat2) throws Exception {
		if(mat1.length ==0 || mat2.length ==0)
			throw new Exception("matri1 or matrix2 is empty");
		if(mat1[0].length != mat2.length)
			throw new Exception("can not multiply");
		int res[][] =new int[mat1.length][mat2[0].length];
		int addedValues = 0;
		for(int i=0;i<mat1.length;i++) {
			for(int j=0;j<mat2[i].length;j++) {
				for(int k=0;k<mat1[i].length;k++) {
					 addedValues= addedValues + mat1[i][k]*mat2[k][j];
			}
				 res[i][j] = addedValues;
				 addedValues =0;
		}		
	}
		return res;
	}
	



public static void main(String [] args) throws Exception {
	int[][] mat1 = {{1,0,0},
			{-1,0,3}};
	int[][]mat2 = {{7,0,0},
			{0,0,0},
			{0,0,1}
			};
	int [][] values = multiply(mat1,mat2);
	for(int i=0;i<mat1.length;i++)
		{
			for(int j=0;j<mat2[i].length;j++) {
				System.out.print( values[i][j] + " " );
			}
			System.out.println();
		}
	
//	System.out.println(values);
}





	
}
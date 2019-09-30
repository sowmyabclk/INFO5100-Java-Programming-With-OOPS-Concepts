package AED.Assignment3;

/*Q8.
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
String convert(string s, int numRows);
Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I*/

public class zigzagPattern {
	
	public static void main(String[] args) {
		
		String  str = convert("PAYPALISHIRING",14);
		System.out.println("zigzag string is  " + str);
	}
	static String convert(String s, int numRows) {
		int length = s.length();
		if(numRows > length)
			throw new IllegalArgumentException("as the numRows > string_length no zigzag pattern can be derived from the string");
		if( numRows <=1 ) {
			return s;
		}
		
		char [] chars = new char[length];
		int count=0;
		int difference = 2 *numRows -2;
		for(int i=0;i<numRows;i++) {
			int midEle = difference- 2*i;
			for(int j=i;j<length;j+=difference) {
				chars[count] = s.charAt(j);
				count++;
				if(midEle >0 && midEle < difference && j+midEle<length) {
					chars[count] = s.charAt(j+midEle);
					count++;
				}
			}
			
		}
		return new  String(chars);
		
	}

}

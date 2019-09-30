package AED.Assignment3;

/*Q6. Given an input string , reverse the string word by word.
Example:
Input : “the sky is blue”
Output : “blue is sky the”
Assumptions:
A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.*/

public class ReverseString {
	public static void main(String [] args) {
		String str = "the sky is blue";
		reverseString(str);
		
	}
	
	public static void reverseString(String str) {
		if(str.length() ==0)
			System.out.println("no string to reverse");
		else {
		String out ="";
	int length=	str.split(" ").length;
	for(int i=length-1;i>=0;i--) {
		out += str.split(" ")[i]+" ";
		
		
	}
	 String reversedString = out.substring(0, out.length() - 1); 
		System.out.println("Reversed string is "+reversedString);
}
	}
}

package AED.Assignment7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Stack;

public class DecodeFile {




		public static void main(String[] args) throws Exception {
			File file = new File("EncodedFile.txt");
			if (file.exists() == false) {
				System.out.println("input file does not exist");
				return;
			}
			FileInputStream fis = new FileInputStream(file);
			String sentence = readFromStream(fis);
			String decodedString =  decodeString(sentence);
			writeIntoFile(decodedString);
			System.out.println(decodedString);
		//	InputStream is = System.in;

		}

		private static String readFromStream(FileInputStream fis) throws IOException {
			String str = "";
			while (true) {
				int x = fis.read();
				if (x == -1)
					break;
				char c = (char) x;
				str+=c;
				//System.out.print(c);
				
			}
			fis.close();
			return str;


		}
		public static void  writeIntoFile(String str) throws IOException {
		File file = new File("DecodedFile.txt");
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(str.getBytes());
		fos.close();
		}
		 public static String decodeString(String s){
			  Stack<Integer > stackNumber = new Stack<Integer>();
			  Stack<String> stackResult = new Stack<String>();
			  String resultSet = "";
			  int pointer=0;
			  
			  while(pointer < s.length()) {
				  
				  if(s.charAt(pointer)== ']') {
					  StringBuilder sb = new StringBuilder(stackResult.pop());
					  int number = stackNumber.pop();
					//  int count =0;
					  while((number>0)) {
					  sb.append(resultSet);
					  number--;
				  }
					  resultSet = sb.toString();
				  pointer++;
			  }
				  else if(s.charAt(pointer)=='[') {
					  stackResult.push(resultSet);
					  resultSet = "";
					  pointer++;
					  
				  }
				  else if(Character.isDigit(s.charAt(pointer))) {
					  int getNumber=0;
					  while(Character.isDigit(s.charAt(pointer))) {
						  getNumber = 10 * getNumber + (s.charAt(pointer) - '0');
						  pointer++;
					  }
					  stackNumber.push(getNumber);
				  }
				  else {
					  resultSet +=s.charAt(pointer);
					  pointer++;
				  }
			  }
			  return resultSet;
		  }

}

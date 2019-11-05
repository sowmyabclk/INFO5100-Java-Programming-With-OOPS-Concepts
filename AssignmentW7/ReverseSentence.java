package AED.Assignment7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Stack;


public class ReverseSentence {

	public static void main(String[] args) throws Exception {
		File file = new File("Sentence.txt");
		System.out.println("directory is "+file.getCanonicalPath());
		if (file.exists() == false) {
			System.out.println("input file does not exist");
			return;
		}
		BufferedReader br = new BufferedReader(new FileReader(file));
		while(br.readLine()!=null) {
		FileInputStream fis = new FileInputStream(file);
		String sentence = readFromStream(fis);
		String reversed =  reverseSentence(sentence.trim());
	writeIntoFile(reversed);
		System.out.println(reversed);
		}

	}
	//String reversed =  reverseString(sentence);
//	writeIntoFile(reversed);
//	System.out.println(reversed);
//	InputStream is = System.in;

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
	File file = new File("Reversed.txt");
	FileOutputStream fos = new FileOutputStream(file);
	fos.write(str.getBytes());
	fos.close();
	}
	
	public static String reverseSentence(String s) {
		Stack<String> stack = new Stack<String>();
		int ref =0;
		String str = "";
		StringBuilder sb = new StringBuilder();
	while(ref<s.length())		{
		if(s.charAt(ref)=='.') {
			stack.push(str);
			while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
			}
			str = "";
			sb.deleteCharAt(ref);
			sb.append(".");
			ref++;
		}
		
		else if(s.charAt(ref)==' ') {
		//	StringBuilder sb = new StringBuilder(str);
			
		//	str = sb.reverse().toString()+" ";
			stack.push(str);
			str="";
			ref++;
		}
		else if(s.charAt(ref)!='.' &&s.charAt(ref)== ' ' ) {
			 stack.push(str);
		 }
		else {
			str+=s.charAt(ref);
			ref++;
		}
	//	 
	    }
	stack.push(str).trim();
	while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
	 }
	return sb.toString();

	}
	

}

package AED.Assignment7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LineCounts {


	public static void main(String[] args) throws IOException {
		if(args.length == 0) {
			System.out.println("give a file name as input");
		}
	for(int i=0;i<args.length;i++) {
		System.out.print(args[i]+ ": ");
		lineCounts(args[i]);
	}
	}
public static void	lineCounts(String fileName){
		BufferedReader br;
		int count =0;


	try {	
	br = new BufferedReader(new FileReader(fileName));
	}
	catch(FileNotFoundException e ) {
		System.out.println("file does not exist");
		return;
	}
	try {
	
	while(br.readLine()!= null) {
		count = count+1;
	}
	}

	catch(IOException e) {
		e.printStackTrace();
	}
		catch(Exception e) {
			System.out.println("Something wrong with reading a file");
			return;
		}
		
		System.out.println("total lines "+count);	

		}
}



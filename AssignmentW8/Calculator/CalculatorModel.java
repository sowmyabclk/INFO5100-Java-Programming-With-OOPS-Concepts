package AED.Assignment8.Calculator;

public class CalculatorModel {

	private int result;
	public int getResult(int a , int b, String choice) {
		switch(choice) {
		case "+" : {
			result = a+b;
		}
			break;
		case "-" :{
			result = a-b;
			break;
		}
		case "*" :{
			result = a*b;
			break;
		}
		case "/":{
			result = a/b;
			break;
		}
		default: 
			System.out.println("enter the correct operation to perform");
			break;
		}
		return result;
		
	}
	
	public int getResult() {
		return result;
	}
	
	
}

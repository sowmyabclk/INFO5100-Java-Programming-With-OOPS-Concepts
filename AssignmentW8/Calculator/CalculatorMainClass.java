package AED.Assignment8.Calculator;

public class CalculatorMainClass {
	public static void main(String[] args) {
		
	
//	CalculatorView view = new CalculatorView();
//	CalculatorModel model = new CalculatorModel();
	CalculatorController controller = new CalculatorController(new CalculatorView(), new CalculatorModel());
	}


}

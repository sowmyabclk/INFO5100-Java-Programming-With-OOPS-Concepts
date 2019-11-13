package AED.Assignment8.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
	private CalculatorView theView;
	private CalculatorModel theModel;
	
	public CalculatorController(CalculatorView theView,CalculatorModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		this.theView.addListeners(new calculateListener());
	}
	
	class calculateListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int firstNumber=0;int secondNumber=0;
			try {
				firstNumber = theView.getFirstNumber();
		//	}
		//	catch(NumberFormatException ex) {
				//theView.displayErrorMssage("you need to enter digits in the first Number field");
		//	}
				
		//	try{
				secondNumber = theView.getSecondNumber();
		//	}
		//	catch(NumberFormatException ex) {
				//theView.displayErrorMssage("you need to enter digits in the Second Number field");
			//}
			
			String choice =  theView.getOptions();
			try {
			int result = theModel.getResult(firstNumber, secondNumber, choice);
			theView.setResult(result);
			}
			catch(ArithmeticException ex) {
				theView.displayErrorMssage("Can not divide the number "+theView.getFirstNumber() +  " by zero");
				theView.clearResult();
			}
			}
			catch(NumberFormatException ex) {
				theView.displayErrorMssage("you need to enter digits in the first Number and second Number fields");
				theView.clearResult();

			}

			
		}
		
	}
}

package AED.Assignment8.Calculator;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalculatorView extends BaseFrame {

	private JLabel firstLabel, secondLabel, operationLabel, resultLabel;
	private JTextField firstText, secondText,resultText;
	private JComboBox options;
	private JButton resultsButton;

	@Override
	public void create() {
		firstLabel = new JLabel("First Number");
		secondLabel = new JLabel("Second Number");
		operationLabel = new JLabel("Operation");
		resultLabel = new JLabel("Result: ");

		firstText = new JTextField(10);
		secondText = new JTextField(10);
		resultText = new JTextField(10);

		options = new JComboBox(new String[] { "+", "-", "*", "/" });

		resultsButton = new JButton("Calculate");
	}

	public void clearResult() {
		resultText.setText("");
	}

	@Override
	public void add(Container con) {
		GridLayout fl = new GridLayout(5, 1);
		con.setLayout(fl);
		addFirstNumber(con);
		addOperations(con);
		addSecondNumber(con);
		addCalculateButton(con);
		addResultsLabel(con);
	}
	

	public String getOptions() {
		return options.getSelectedItem().toString();
	}

	public void addSecondNumber(Container con) {
		addComponents(con, secondLabel, secondText);
	}

	public void addFirstNumber(Container con) {
		addComponents(con, firstLabel, firstText);
	}

	public void addOperations(Container con) {
		addComponents(con, operationLabel, options);
	}

	public void addCalculateButton(Container con) {
		JPanel panel = new JPanel();
		resultsButton.setFont(new Font("Monaco", Font.BOLD, 15));
	//	resultsButton.setFont(new Font("Monaco", Font.BOLD, 15));
		panel.add(resultsButton);
		con.add(panel);
	}
	
	private void addResultsLabel(Container con) {
		JPanel panel = new JPanel();
		resultLabel.setFont(new Font("Monaco", Font.PLAIN, 15));
		resultLabel.setFont(new Font("Monaco", Font.BOLD, 15));
		panel.add(resultLabel);
		resultText.setFont(new Font("Monaco", Font.BOLD, 15));
		resultText.setEditable(false);
		panel.add(resultText);
		con.add(panel);

	}


	public void addComponents(Container con, Component a, Component b) {
		JPanel panel = new JPanel();
		a.setFont(new Font("Monaco", Font.PLAIN, 15));
		panel.add(a);
		panel.add(b);
		b.setFont(new Font("Monaco", Font.PLAIN, 15));
		con.add(panel);
	}
	
	public int getFirstNumber() {
		return Integer.parseInt(firstText.getText());
	}
	public int getSecondNumber() {
		return Integer.parseInt(secondText.getText());

	}
	public void setResult(int result) {
		resultText.setText(Integer.toString(result));
	}

	@Override
	public void addListeners(ActionListener calculateListener) {
	resultsButton.addActionListener(calculateListener);
		
	}
	
	public void displayErrorMssage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	@Override
	public void addListeners() {
		// TODO Auto-generated method stub
		
	}
}

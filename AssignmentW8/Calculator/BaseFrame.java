package AED.Assignment8.Calculator;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public abstract class BaseFrame extends JFrame {

	public BaseFrame() {
		create();
		Container con = getContentPane();
		add(con);
		//addListeners( );
		makeItVisible();
	}

	public abstract void create();

	public abstract void add(Container con);

	public abstract void addListeners();

	public void makeItVisible() {
		setSize(600, 600);
		setVisible(true);
	}

	public abstract void addListeners(ActionListener e) ;
		
	

}

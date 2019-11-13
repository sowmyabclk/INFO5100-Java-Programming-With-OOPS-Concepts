package AED.Assignment8.StudentInformation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class StudInfo {
	/**
	* 
	*/
	static JButton btnAdd;
	static JTextField Id;
	static JTextField Fname;
	static JTextField Lname;
	static JComboBox gender;
	static JTextField age;
	static JTextField address;
	static DefaultTableModel model;

	public static void create() {

		JFrame jf = new JFrame("Student Information System");
		JTable table = new JTable();

		Object[] columns = { "Id", "First Name", "Last Name", "Gender", "Age", "Address" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
	

		table.setModel(model);

		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.black);
		Font font = new Font("", 1, 13);
		table.setFont(font);
		table.setRowHeight(30);
	
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(140, 20, 700, 200);

		jf.setLayout(null);

		jf.add(pane);
		jf.setSize(1000, 1000);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);

		Id = new JTextField();
		Fname = new JTextField();
		Lname = new JTextField();
		gender = new JComboBox(new String[] { "Male", "Female" });
		age = new JTextField();
		address = new JTextField();
		btnAdd = new JButton("Add");

		JLabel idLabel = new JLabel("ID");
		JLabel fLabel = new JLabel("First Name");
		JLabel SLabel = new JLabel("Second Name");
		JLabel genderLabel = new JLabel("Gender");
		JLabel ageLabel = new JLabel("Age");
		JLabel addressLabel = new JLabel("Address");
		idLabel.setBounds(380, 260, 50, 25);
		fLabel.setBounds(330, 290, 100, 25);
		SLabel.setBounds(315, 320, 100, 25);
		genderLabel.setBounds(350, 350, 100, 25);
		ageLabel.setBounds(370, 380, 100, 25);
		addressLabel.setBounds(345, 410, 100, 25);
		Id.setBounds(400, 260, 100, 25);
		Fname.setBounds(400, 290, 100, 25);
		Lname.setBounds(400, 320, 100, 25);
		gender.setBounds(400, 350, 100, 25);
		age.setBounds(400, 380, 100, 25);
		address.setBounds(400, 410, 100, 25);

		btnAdd.setBounds(400, 500, 100, 25);

		jf.add(idLabel);
		jf.add(fLabel);
		jf.add(SLabel);
		jf.add(genderLabel);
		jf.add(ageLabel);
		jf.add(addressLabel);

		jf.add(Id);
		jf.add(Fname);
		jf.add(Lname);
		jf.add(gender);
		jf.add(age);
		jf.add(address);

		jf.add(btnAdd);

		Object[] row = new Object[6];

		// button add row
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				row[0] = Id.getText();
				row[1] = Fname.getText();
				row[2] = Lname.getText();
				row[3] = gender.getSelectedItem().toString();
				row[4] = age.getText();
				row[5] = address.getText();

				// add row to the model
				model.addRow(row);
			}
		});

	}

	/*public static String getId() {
		return Id.getText();
	}

	public static String getFName() {
		return Fname.getText();
	}

	public static String getLName() {
		return Lname.getText();
	}

	public static String getGender() {
		return gender.getSelectedItem().toString();
	}

	public static String getage() {
		return age.getText();
	}

	public static String getAddress() {
		return address.getText();
	}

	public DefaultTableModel getModel() {
		return model;
	}

	static class addStudListener implements ActionListener {
		Object[] row = new Object[6];

		@Override
		public void actionPerformed(ActionEvent e) {
			// create an array of objects to set the row data

			row[0] = getId();
			row[1] = getFName();
			row[2] = getLName();
			row[3] = getGender();
			row[4] = getage();
			row[5] = getAddress();

			// add row to the model
			model.addRow(row);
		}

	}*/


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StudInfo.create();
			}
		});
	}
}

package Feature;

import Dictionary.Dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddSlang extends JFrame implements ActionListener {
	private final Dictionary Dictionary;
	private final JTextField slangField, definitionField;
	private final JButton backBtn, exitBtn, addBtn;
	private final JButton overwriteBtn, duplicateBtn, cancelBtn;
	private final JLabel notification, success;
	
	public AddSlang(Dictionary dictionary) {

		JLabel label = new JLabel();
		label.setBounds(100, 50, 300, 50);
		label.setText("Add new Slang");
		label.setFont(new Font("Auto Sans", Font.PLAIN, 40));
		label.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 70, 400, 400);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(true);
		
		JLabel container1 = new JLabel();
		container1.setText("Enter the new Slang: ");
		container1.setFont(new Font("Auto Sans", Font.PLAIN, 20));
		container1.setForeground(Color.BLACK);
		container1.setBounds(150, 0, 300, 50);
		
		slangField = new JTextField();
		slangField.setBounds(150, 40, 300, 40);
		slangField.setForeground(Color.BLACK);
		
		JLabel container2 = new JLabel();
		container2.setText("Input the Definition: ");
		container2.setFont(new Font("Auto Sans", Font.PLAIN, 20));
		container2.setForeground(Color.BLACK);
		container2.setBounds(150, 80, 300, 50);
		
		definitionField = new JTextField();
		definitionField.setBounds(150, 120, 300, 40);
		definitionField.setForeground(Color.BLACK);
		
		addBtn = new JButton("Add");
		addBtn.setFont(new Font("Auto Sans", Font.BOLD, 18));
		addBtn.setForeground(Color.BLACK);
		addBtn.setFocusable(false);
		addBtn.setBounds(250, 180, 100, 30);
		addBtn.addActionListener(this);
		
		notification = new JLabel();
		notification.setText("This Slang has already existed. Do you want to change?");
		notification.setBounds(110, 220, 400, 30);
		notification.setFont(new Font("Auto Sans", Font.PLAIN, 15));
		notification.setVisible(false);
		
		overwriteBtn = new JButton("Overwrite");
		overwriteBtn.setFocusable(false);
		overwriteBtn.setBounds(130, 250, 100, 30);
		overwriteBtn.setFont(new Font("Auto Sans", Font.PLAIN, 15));
		overwriteBtn.addActionListener(this);
		overwriteBtn.setVisible(false);
		
		duplicateBtn = new JButton("Duplicate");
		duplicateBtn.setFocusable(false);
		duplicateBtn.setBounds(250, 250, 100, 30);
		duplicateBtn.setFont(new Font("Auto Sans", Font.PLAIN, 15));
		duplicateBtn.addActionListener(this);
		duplicateBtn.setVisible(false);

		cancelBtn = new JButton("Cancel");
		cancelBtn.setFocusable(false);
		cancelBtn.setBounds(370, 250, 100, 30);
		cancelBtn.setFont(new Font("Auto Sans", Font.PLAIN, 15));
		cancelBtn.addActionListener(this);
		cancelBtn.setVisible(false);
		
		success = new JLabel();
		success.setText("Add successfully");
		success.setBounds(220, 300, 400, 30);
		success.setFont(new Font("Auto Sans", Font.PLAIN, 15));
		success.setVisible(false);
		
		panel.add(container1);
		panel.add(container2);
		panel.add(slangField);
		panel.add(definitionField);
		panel.add(addBtn);
		panel.add(notification);
		panel.add(success);
		panel.add(overwriteBtn);
		panel.add(duplicateBtn);
		panel.add(cancelBtn);
		
		backBtn = new JButton("Back");
		backBtn.setFocusable(false);
		backBtn.setBounds(50, 400, 100, 30);
		backBtn.setFont(new Font("Auto Sans", Font.BOLD, 18));
		backBtn.addActionListener(this);
		
		exitBtn = new JButton("Exit");
		exitBtn.setFocusable(false);
		exitBtn.setBounds(350, 400, 100, 30);
		exitBtn.setFont(new Font("Auto Sans", Font.BOLD, 18));
		exitBtn.addActionListener(this);

		JPanel panel2 = new JPanel();
		panel2.setBounds(50,0 , 100, 100);
		panel2.add(backBtn);
		panel2.add(exitBtn);

		Dimension size2 = new Dimension(600, 400);
		panel.setMaximumSize(size2);
		panel.setPreferredSize(size2);
		panel.setMinimumSize(size2);
		Container con = this.getContentPane();
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		con.add(Box.createRigidArea(new Dimension(0, 10)));
		con.add(label);
		con.add(Box.createRigidArea(new Dimension(0, 50)));
		con.add(panel);
		con.add(Box.createRigidArea(new Dimension(0, 100)));
		con.add(panel2);

		this.Dictionary = dictionary;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Add Slang");
		this.setVisible(true);
		this.setSize(700, 700);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.addWindowListener(new WindowAdapter() {
			@Override public void windowClosing(WindowEvent e) {
				Dictionary.updateData();
				Dictionary.updateHistory();
				super.windowClosing(e);
			}
		});
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backBtn) {
			this.dispose();
			new Interface2(this.Dictionary);
		} else if (e.getSource() == exitBtn) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} else if (e.getSource() == addBtn) {
			success.setVisible(false);
			String d = definitionField.getText();
			List<String> temp = new ArrayList<>(Arrays.asList(d.split(",")));
			temp.replaceAll(String::stripLeading);
			temp.replaceAll(String::stripTrailing);
			if (this.Dictionary.findBySlangWord(slangField.getText()) != null) {
				notification.setVisible(true);
				overwriteBtn.setVisible(true);
				duplicateBtn.setVisible(true);
				cancelBtn.setVisible(true);
			} else {
				this.Dictionary.addSlangWord(slangField.getText(), temp, "add");
				success.setVisible(true);
			}
		} else if (e.getSource() == overwriteBtn) {
			String d = definitionField.getText();
			List<String> temp = new ArrayList<>(Arrays.asList(d.split(",")));
			temp.replaceAll(String::stripLeading);
			temp.replaceAll(String::stripTrailing);
			this.Dictionary.addSlangWord(slangField.getText(), temp, "overwrite");
			success.setVisible(true);
			notification.setVisible(false);
			overwriteBtn.setVisible(false);
			duplicateBtn.setVisible(false);
			cancelBtn.setVisible(false);
		} else if (e.getSource() == duplicateBtn) {
			String d = definitionField.getText();
			List<String> temp = new ArrayList<>(Arrays.asList(d.split(",")));
			temp.replaceAll(String::stripLeading);
			temp.replaceAll(String::stripTrailing);
			this.Dictionary.addSlangWord(slangField.getText(), temp, "duplicate");
			success.setVisible(true);
			notification.setVisible(false);
			overwriteBtn.setVisible(false);
			duplicateBtn.setVisible(false);
			cancelBtn.setVisible(false);
		}
		else if(e.getSource() == cancelBtn){
			this.dispose();
			new AddSlang(this.Dictionary);
		}
	}
}

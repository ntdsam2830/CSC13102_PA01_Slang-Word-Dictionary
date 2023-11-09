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
	Dictionary Dictionary;
	JPanel panel;
	JTextField slangField, definitionField;
	JButton backBtn, exitBtn;
	JButton addBtn;
	JButton overwriteBtn, duplicateBtn;
	JLabel notification, success;
	
	public AddSlang(Dictionary dictionary) {
		this.Dictionary = dictionary;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Add Slang");
		this.setResizable(false);
        this.setSize(700, 700);
        this.setLocation(500, 200);
		
		JLabel label = new JLabel();
		label.setBounds(100, 20, 300, 50);
		label.setText("Add new slang");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setForeground(Color.BLACK);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		panel = new JPanel();
		panel.setBounds(50, 70, 400, 310);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(true);
		
		JLabel container1 = new JLabel();
		container1.setText("Enter the new Slang: ");
		container1.setForeground(Color.BLACK);
		container1.setBounds(50, 0, 300, 50);
		
		slangField = new JTextField();
		slangField.setBounds(50, 40, 300, 30);
		slangField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		slangField.setForeground(Color.BLACK);
		
		JLabel container2 = new JLabel();
		container2.setText("Input the Definition: ");
		container2.setForeground(Color.BLACK);
		container2.setBounds(50, 60, 300, 50);
		
		definitionField = new JTextField();
		definitionField.setBounds(50, 100, 300, 30);
		definitionField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		definitionField.setForeground(Color.BLACK);
		
		addBtn = new JButton("Add");
		addBtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		addBtn.setForeground(Color.BLACK);
		addBtn.setFocusable(false);
		addBtn.setBounds(150, 140, 100, 30);
		addBtn.addActionListener(this);
		
		notification = new JLabel();
		notification.setText("This Slang has already existed. Do you want to change?");
		notification.setBounds(30, 170, 400, 30);
		notification.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		notification.setVisible(false);
		
		overwriteBtn = new JButton("Overwrite");
		overwriteBtn.setFocusable(false);
		overwriteBtn.setBounds(50, 200, 100, 30);
		overwriteBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		overwriteBtn.addActionListener(this);
		overwriteBtn.setVisible(false);
		
		duplicateBtn = new JButton("Duplicate");
		duplicateBtn.setFocusable(false);
		duplicateBtn.setBounds(250, 200, 100, 30);
		duplicateBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		duplicateBtn.addActionListener(this);
		duplicateBtn.setVisible(false);
		
		success = new JLabel();
		success.setText("Add successfully");
		success.setBounds(150, 240, 400, 30);
		success.setFont(new Font("Times New Roman", Font.PLAIN, 15));
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
		
		backBtn = new JButton("Back");
		backBtn.setFocusable(false);
		backBtn.setBounds(50, 400, 100, 30);
		backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		backBtn.addActionListener(this);
		
		exitBtn = new JButton("Exit");
		exitBtn.setFocusable(false);
		exitBtn.setBounds(350, 400, 100, 30);
		exitBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		exitBtn.addActionListener(this);
		
		this.add(label);
		this.add(panel);
		this.add(backBtn);
		this.add(exitBtn);
		this.setSize(500, 500);
		this.setLayout(null);
		this.setVisible(true);
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
		}
	}
}

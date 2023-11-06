package Feature;

import Dictionary.Dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DeleteSlang extends JFrame implements ActionListener {
	private final Dictionary Dictionary;
	private final JButton backBtn, exitBtn;
	private final JTextField textField;
	private final JLabel question, notify1, notify2;
	private final JButton deleteBtn, yesBtn, noBtn;
	
	public DeleteSlang(Dictionary dictionary) {
		this.Dictionary = dictionary;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Delete Slang");
		this.setResizable(false);
		
		JLabel label = new JLabel();
		label.setBounds(100, 50, 300, 50);
		label.setText("Delete Slang");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setForeground(Color.BLACK);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 100, 400, 290);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(true);
		
		JLabel container = new JLabel();
		container.setText("Input the slang word you want to search");
		container.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		container.setForeground(Color.BLACK);
		container.setBounds(50, 10, 300, 50);
		
		textField = new JTextField();
		textField.setBounds(50, 60, 300, 30);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setForeground(Color.BLACK);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		deleteBtn.setForeground(Color.BLACK);
		deleteBtn.setFocusable(false);
		deleteBtn.setBounds(150, 100, 100, 30);
		deleteBtn.addActionListener(this);
		
		question = new JLabel();
		question.setBounds(110, 140, 300, 50);
		question.setText("Do you want to delete?");
		question.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		question.setForeground(Color.BLACK);
		
		yesBtn = new JButton("Yes");
		yesBtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		yesBtn.setForeground(Color.BLACK);
		yesBtn.setFocusable(false);
		yesBtn.setBounds(50, 200, 100, 30);
		yesBtn.addActionListener(this);
		
		noBtn = new JButton("No");
		noBtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		noBtn.setForeground(Color.BLACK);
		noBtn.setFocusable(false);
		noBtn.setBounds(250, 200, 100, 30);
		noBtn.addActionListener(this);
		
		question.setVisible(false);
		yesBtn.setVisible(false);
		noBtn.setVisible(false);
		
		notify1 = new JLabel();
		notify1.setBounds(130, 240, 300, 50);
		notify1.setText("Delete successfully.");
		notify1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		notify1.setForeground(Color.BLACK);
		notify1.setBackground(Color.DARK_GRAY);
		notify1.setVisible(false);
		
		notify2 = new JLabel();
		notify2.setBounds(110, 240, 300, 50);
		notify2.setText("The slang doesn't exist.");
		notify2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		notify2.setForeground(Color.BLACK);
		notify2.setBackground(Color.DARK_GRAY);
		notify2.setVisible(false);
		
		panel.add(container);
		panel.add(textField);
		panel.add(deleteBtn);
		panel.add(question);
		panel.add(yesBtn);
		panel.add(noBtn);
		panel.add(notify1);
		panel.add(notify2);
		
		backBtn = new JButton("Back");
		backBtn.setFocusable(false);
		backBtn.setBounds(50, 400, 100, 30);
		backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		backBtn.addActionListener(this);
		
		exitBtn = new JButton("Cancel");
		exitBtn.setFocusable(false);
		exitBtn.setBounds(350, 400, 100, 30);
		exitBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		exitBtn.addActionListener(this);
		
		this.add(backBtn);
		this.add(exitBtn);
		this.add(label);
		this.add(panel);
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
			new Interface(this.Dictionary);
		} else if (e.getSource() == exitBtn) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} else if (e.getSource() == deleteBtn) {
			question.setVisible(true);
			yesBtn.setVisible(true);
			noBtn.setVisible(true);
		} else if (e.getSource() == yesBtn) {
			boolean option = this.Dictionary.deleteSlang(textField.getText().toUpperCase());
			if (option) {
				notify1.setVisible(true);
				notify2.setVisible(false);
			} else {
				notify1.setVisible(false);
				notify2.setVisible(true);
			}
		} else if (e.getSource() == noBtn) {
			this.dispose();
			new Interface(this.Dictionary);
		}
	}
}

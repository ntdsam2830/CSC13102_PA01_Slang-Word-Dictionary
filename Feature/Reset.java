package Feature;

import Dictionary.Dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Reset extends JFrame implements ActionListener {
	private final Dictionary Dictionary;
	private final JButton backBtn, exitBtn;
	private final JButton resetBtn;
	private final JLabel notify;
	
	public Reset(Dictionary dictionary) {
		this.Dictionary = dictionary;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Reset");
		this.setResizable(false);
        this.setSize(700, 700);
        this.setLocation(500, 200);;
		
		JLabel label = new JLabel();
		label.setBounds(100, 50, 300, 50);
		label.setText("Reset Dictionary");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setForeground(Color.BLACK);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		JLabel question = new JLabel();
		question.setBounds(100, 150, 300, 50);
		question.setText("Do you want to reset?");
		question.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		question.setForeground(Color.BLACK);
		question.setHorizontalTextPosition(JLabel.CENTER);
		question.setVerticalTextPosition(JLabel.CENTER);
		question.setHorizontalAlignment(JLabel.CENTER);
		question.setVerticalAlignment(JLabel.CENTER);
		
		resetBtn = new JButton("Reset");
		resetBtn.setFocusable(false);
		resetBtn.setBounds(200, 200, 100, 30);
		resetBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		resetBtn.addActionListener(this);
		
		notify = new JLabel();
		notify.setBounds(100, 250, 300, 50);
		notify.setText("Reset successfully.");
		notify.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		notify.setForeground(Color.BLACK);
		notify.setHorizontalTextPosition(JLabel.CENTER);
		notify.setVerticalTextPosition(JLabel.CENTER);
		notify.setHorizontalAlignment(JLabel.CENTER);
		notify.setVerticalAlignment(JLabel.CENTER);
		notify.setVisible(false);
		
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
		this.add(resetBtn);
		this.add(label);
		this.add(question);
		this.add(notify);
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
			new Interface4(this.Dictionary);
		} else if (e.getSource() == exitBtn) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} else if (e.getSource() == resetBtn) {
			this.Dictionary.resetDictionary();
			notify.setVisible(true);
		}
	}
}
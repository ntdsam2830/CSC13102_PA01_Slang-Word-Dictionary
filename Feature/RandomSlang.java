package Feature;

import Dictionary.Dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RandomSlang extends JFrame implements ActionListener {
	private final Dictionary Dictionary;
	private final JButton backBtn, exitBtn;
	
	public RandomSlang(Dictionary dictionary) {
		this.Dictionary = dictionary;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Random Slang");
		this.setResizable(false);
        this.setSize(700, 700);
        this.setLocation(500, 200);
		
		JLabel label = new JLabel();
		label.setBounds(100, 50, 300, 50);
		label.setText("Here is your random Slang: ");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setForeground(Color.BLACK);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);

        JLabel label2 = new JLabel();
        label2.setBounds(100, 100, 300, 100);
        label2.setText(this.Dictionary.randomSlang());
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label2.setOpaque(true);
		label2.setBackground(Color.WHITE);
		label2.setForeground(Color.BLACK);
		label2.setHorizontalTextPosition(JLabel.CENTER);
		label2.setVerticalTextPosition(JLabel.CENTER);
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setVerticalAlignment(JLabel.CENTER);
		
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
        this.add(label2);
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
			new Interface1(this.Dictionary);
		} else if (e.getSource() == exitBtn) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} 
	}
}





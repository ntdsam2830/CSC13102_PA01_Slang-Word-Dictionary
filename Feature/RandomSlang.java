package Feature;

import Dictionary.Dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * GUI
 * Created by Thai Duong
 * Date 11/16/2022 - 3:39 PM
 * Description: ...
 */
public class RandomSlang extends JFrame implements ActionListener {
	private final Dictionary Dictionary;
	private final JButton backBtn, cancelBtn;
	private final JTextField word;
	private final JButton randomBtn;
	public RandomSlang(Dictionary dictionary) {
		this.Dictionary = dictionary;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Random Slang");
		this.setResizable(false);
		
		JLabel label = new JLabel();
		label.setBounds(100, 50, 300, 50);
		label.setText("Random Slang Word");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setForeground(Color.BLACK);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 100, 400, 160);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(true);
		
		JLabel container = new JLabel();
		container.setText("Press button \"Random\" to random slang");
		container.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		container.setForeground(Color.BLACK);
		container.setBounds(50, 10, 300, 50);
		
		randomBtn = new JButton("Random");
		randomBtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		randomBtn.setForeground(Color.BLACK);
		randomBtn.setFocusable(false);
		randomBtn.setBounds(150, 100, 100, 30);
		randomBtn.addActionListener(this);
		
		panel.add(randomBtn);
		panel.add(container);
		
		word = new JTextField();
		word.setForeground(Color.BLACK);
		word.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		word.setBounds(50, 280, 400, 30);
		word.setEditable(false);
		
		backBtn = new JButton("Back");
		backBtn.setFocusable(false);
		backBtn.setBounds(50, 400, 100, 30);
		backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		backBtn.addActionListener(this);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setFocusable(false);
		cancelBtn.setBounds(350, 400, 100, 30);
		cancelBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cancelBtn.addActionListener(this);
		
		this.add(label);
		this.add(backBtn);
		this.add(cancelBtn);
		this.add(word);
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
		} else if (e.getSource() == cancelBtn) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} else if (e.getSource() == randomBtn) {
			word.setText(this.Dictionary.randomSlang());
		}
	}
}
package Feature;

import Dictionary.Dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalTime;

// public class RandomSlang extends JFrame implements ActionListener {
// 	private final Dictionary Dictionary;
// 	private final JButton backBtn, exitBtn;
// 	private final JLabel word;
// 	public RandomSlang(Dictionary dictionary) {
// 		this.Dictionary = dictionary;
// 		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 		this.setTitle("Random Slang");
// 		this.setResizable(false);
		
// 		JLabel label = new JLabel();
// 		label.setBounds(100, 50, 300, 50);
// 		label.setText("Random Slang Word");
// 		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
// 		label.setForeground(Color.BLACK);
// 		label.setHorizontalTextPosition(JLabel.CENTER);
// 		label.setVerticalTextPosition(JLabel.CENTER);
// 		label.setHorizontalAlignment(JLabel.CENTER);
// 		label.setVerticalAlignment(JLabel.CENTER);
		
// 		JPanel panel = new JPanel();
// 		panel.setBounds(50, 100, 400, 160);
// 		panel.setLayout(null);
// 		panel.setBackground(Color.WHITE);
// 		panel.setOpaque(true);
		
// 		JLabel container = new JLabel();
// 		container.setText("Slang word of the Day: ");
//         // container.setText("Slang word of the Day: ");
// 		container.setFont(new Font("Times New Roman", Font.PLAIN, 18));
// 		container.setForeground(Color.BLACK);
// 		container.setBounds(50, 10, 300, 50);
		
// 		panel.add(container);
		
// 		backBtn = new JButton("Back");
// 		backBtn.setFocusable(false);
// 		backBtn.setBounds(50, 400, 100, 30);
// 		backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
// 		backBtn.addActionListener(this);
		
// 		exitBtn = new JButton("Cancel");
// 		exitBtn.setFocusable(false);
// 		exitBtn.setBounds(350, 400, 100, 30);
// 		exitBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
// 		exitBtn.addActionListener(this);

//         word = new JLabel();
// 		word.setForeground(Color.BLACK);
// 		word.setFont(new Font("Times New Roman", Font.PLAIN, 15));
// 		word.setBounds(50, 280, 400, 30);
//         LocalTime time1 = LocalTime.now();
//         LocalTime time2 = LocalTime.of(24, 0, 0);
//         if(time1.isAfter(time2)){
//             word.setText(this.Dictionary.randomSlang());
//         }

// 		this.add(label);
// 		this.add(backBtn);
// 		this.add(exitBtn);
// 		this.add(word);
// 		this.add(panel);
// 		this.setSize(500, 500);
// 		this.setLayout(null);
// 		this.setVisible(true);
// 		this.addWindowListener(new WindowAdapter() {
// 			@Override public void windowClosing(WindowEvent e) {
// 				Dictionary.updateData();
// 				Dictionary.updateHistory();
// 				super.windowClosing(e);
// 			}
// 		});
// 	}
	
// 	@Override public void actionPerformed(ActionEvent e) {
// 		if (e.getSource() == backBtn) {
// 			this.dispose();
// 			new Interface(this.Dictionary);
// 		} else if (e.getSource() == exitBtn) {
// 			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
// 	    }
//     }
// }

// import java.awt.Color;
// import java.awt.Container;
// import java.awt.Dimension;
// import java.awt.Font;
// import java.awt.Toolkit;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// import javax.swing.BorderFactory;
// import javax.swing.Box;
// import javax.swing.BoxLayout;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JPanel;

public class RandomSlang extends JFrame implements ActionListener {
    private final Dictionary Dictionary;
	private final JButton backBtn, exitBtn;

	public RandomSlang(Dictionary dictionary) {
		// Get Content
		Container con = this.getContentPane();

		// Title
		JPanel titlePanel = new JPanel();
		JLabel titleLabel = new JLabel("Slang of the Day: ");
		titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		titlePanel.add(titleLabel);
		titlePanel.setMaximumSize(new Dimension(700, 300));

		// Slang word
		String s = this.Dictionary.randomSlang();
//		System.out.println(s[0] + "\t" + s[1]);
		JPanel slangPanel = new JPanel();
		// JLabel slangLabel = new JLabel("Slang: :) \t Meaning: Happy");
		JLabel lb1 = new JLabel("Slang: \t");
		lb2 = new JLabel(s[0]);
		JLabel lb3 = new JLabel("\tMeaning: \t");
		lb4 = new JLabel(s[1]);
		lb1.setFont(new Font("Gill Sans MT", Font.PLAIN, 35));
		lb2.setFont(new Font("Gill Sans MT", Font.PLAIN, 35));
		lb3.setFont(new Font("Gill Sans MT", Font.PLAIN, 35));
		lb4.setFont(new Font("Gill Sans MT", Font.PLAIN, 35));
		// slangLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 35));
		slangPanel.add(lb1);
		slangPanel.add(lb2);
		slangPanel.add(lb3);
		slangPanel.add(lb4);

		// Bottom btnback btnRenew
	    exitBtn = new JButton("Reset");
		backBtn = new JButton("Back");
		exitBtn.addActionListener(this);
		backBtn.addActionListener(this);
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		buttonPane.add(Box.createHorizontalGlue());
		buttonPane.add(exitBtn);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPane.add(backBtn);

		// Setting con
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		con.add(titlePanel);
		con.add(Box.createRigidArea(new Dimension(0, 10)));
		con.add(slangPanel);
		con.add(Box.createRigidArea(new Dimension(0, 10)));
		con.add(buttonPane);
		// Setting JFrame
		this.setTitle("Ramdom Slangwords");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(700, 700);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == backBtn) {
			this.dispose();
			new Interface(this.Dictionary);
		} else if (e.getSource() == exitBtn) {
			String s =  this.Dictionary.randomSlang();
			lb2.setText(s[0]);
			lb4.setText(s[1]);
		}
	}

}

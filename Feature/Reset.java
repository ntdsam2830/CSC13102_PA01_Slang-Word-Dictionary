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
		this.setTitle("Edit Slang");
		this.setVisible(true);
		this.setSize(700, 700);
				
		JLabel question = new JLabel();
		question.setBounds(220, 150, 300, 50);
		question.setText("Do you want to reset?");
		question.setFont(new Font("Auto Sans", Font.PLAIN, 18));
		question.setForeground(Color.BLACK);

		JLabel label = new JLabel();
		label.setBounds(100, 50, 300, 50);
		label.setText("Reset Dictionary");
		label.setFont(new Font("Auto Sans", Font.PLAIN, 40));
		label.setForeground(Color.BLACK);
		label.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 70, 400, 400);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(true);
		
		resetBtn = new JButton("Reset");
		resetBtn.setFocusable(false);
		resetBtn.setBounds(250, 200, 100, 30);
		resetBtn.setFont(new Font("Auto Sans", Font.PLAIN, 15));
		resetBtn.addActionListener(this);
		
		notify = new JLabel();
		notify.setBounds(220, 250, 300, 50);
		notify.setText("Reset successfully.");
		notify.setFont(new Font("Auto Sans", Font.PLAIN, 18));
		notify.setForeground(Color.BLACK);
		notify.setAlignmentX(CENTER_ALIGNMENT);
		notify.setAlignmentY(CENTER_ALIGNMENT);
		notify.setVisible(false);

		panel.add(resetBtn);
		panel.add(notify);
		panel.add(question);
		
		backBtn = new JButton("Back");
		backBtn.setFocusable(false);
		backBtn.setFont(new Font("Auto Sans", Font.PLAIN, 15));
		backBtn.addActionListener(this);
		
		exitBtn = new JButton("Exit");
		exitBtn.setFocusable(false);
		exitBtn.setFont(new Font("Auto Sans", Font.PLAIN, 15));
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
			new Interface4(this.Dictionary);
		} else if (e.getSource() == exitBtn) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} else if (e.getSource() == resetBtn) {
			this.Dictionary.resetDictionary();
			notify.setVisible(true);
		}
	}
}
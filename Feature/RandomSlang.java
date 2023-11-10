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
		this.setVisible(true);
		this.setSize(700, 700);
		
		JLabel label = new JLabel();
		label.setBounds(100, 50, 300, 50);
		label.setText("Here is your random Slang: ");
		label.setFont(new Font("Auto Sans", Font.PLAIN, 40));
		label.setForeground(Color.BLACK);
		label.setAlignmentX(CENTER_ALIGNMENT);

		JPanel panel = new JPanel();
		panel.setBounds(50, 70, 400, 400);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(true);

        JLabel label2 = new JLabel();
        label2.setBounds(150, 100, 300, 100);
		label2.setFont(new Font("Auto Sans", Font.PLAIN, 20));
        label2.setText(this.Dictionary.randomSlang());
		label2.setOpaque(true);
		label2.setBackground(Color.WHITE);
		label2.setForeground(Color.BLACK);
		label2.setAlignmentX(CENTER_ALIGNMENT);

		panel.add(label2);
		
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
			new Interface1(this.Dictionary);
		} else if (e.getSource() == exitBtn) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} 
	}
}





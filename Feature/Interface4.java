package Feature;

import Dictionary.Dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Interface4 extends JFrame implements ActionListener {
	private final Dictionary Dictionary;
	private final JButton historyBtn,resetBtn;
	private final JButton backBtn,exitBtn;
	
	public Interface4(Dictionary dictionary) {
		
		JLabel label = new JLabel();
		label.setBounds(100, 50, 300, 50);
		label.setText("More Options");
		label.setFont(new Font("Auto Sans", Font.PLAIN, 40));
		label.setAlignmentX(CENTER_ALIGNMENT);
		
		historyBtn = new JButton("View History");
		historyBtn.setFont(new Font("Auto Sans", Font.BOLD, 18));
		historyBtn .setFocusable(false);
		historyBtn .addActionListener(this);
		
		resetBtn = new JButton("Reset Dictionary");
		resetBtn.setFont(new Font("Auto Sans", Font.BOLD, 18));
		resetBtn.setFocusable(false);
		resetBtn.addActionListener(this);

		exitBtn = new JButton("Exit");
		exitBtn.setFocusable(false);
		exitBtn.setFont(new Font("Auto Sans", Font.BOLD, 15));
		exitBtn.addActionListener(this);

        backBtn = new JButton("Back");
		backBtn.setFocusable(false);
		backBtn.setFont(new Font("Auto Sans", Font.BOLD, 15));
		backBtn.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2, 4, 3));
		panel.add(historyBtn);
		panel.add(resetBtn);
		JPanel panel2 = new JPanel();
		panel.setBounds(50,0 , 100, 100);
		panel2.add(backBtn);
        panel2.add(exitBtn);

		this.add(label);
		this.add(panel);
		this.add(panel2);
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

		Dimension size2 = new Dimension(400, 400);
		panel.setMaximumSize(size2);
		panel.setPreferredSize(size2);
		panel.setMinimumSize(size2);
		Container con = this.getContentPane();
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		con.add(Box.createRigidArea(new Dimension(0, 10)));
		con.add(label);
		con.add(Box.createRigidArea(new Dimension(0, 60)));
		con.add(panel);
        con.add(Box.createRigidArea(new Dimension(0, 100)));
		con.add(panel2);

		this.Dictionary = dictionary;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("More Options");
		this.setVisible(true);
		this.setSize(700, 700);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		if (historyBtn.equals(e.getSource())) {
			this.dispose();
			new ViewHistory(this.Dictionary);
		} else if (resetBtn.equals(e.getSource())) {
			this.dispose();
			new Reset(this.Dictionary);
        } else if (e.getSource()== backBtn) {
			this.dispose();
			new Interface(this.Dictionary);
		} else if (e.getSource() == exitBtn) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}
}
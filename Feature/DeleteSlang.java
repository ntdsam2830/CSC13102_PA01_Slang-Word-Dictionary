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
	private final JTextField textField;
	private final JLabel question, notify1, notify2;
	private final JButton deleteBtn, yesBtn, noBtn;
	private final JButton backBtn, exitBtn;
	
	public DeleteSlang(Dictionary dictionary) {

		JLabel label = new JLabel();
		label.setBounds(100, 50, 300, 50);
		label.setText("Delete Slang");
		label.setFont(new Font("Auto Sans", Font.PLAIN, 40));
		label.setAlignmentX(CENTER_ALIGNMENT);

		JPanel panel = new JPanel();
		panel.setBounds(50, 70, 400, 310);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(true);
		
		JLabel container1 = new JLabel();
		container1.setText("Input the Slang to Delete: ");
		container1.setFont(new Font("Auto Sans", Font.PLAIN, 20));
		container1.setForeground(Color.BLACK);
		container1.setBounds(150, 0, 300, 50);
		
		textField = new JTextField();
		textField.setBounds(150, 40, 300, 40);
		textField.setFont(new Font("Auto Sans", Font.PLAIN, 18));
		textField.setForeground(Color.BLACK);

		// JPanel panel = new JPanel();
		// panel.setBounds(50, 100, 400, 290);
		// panel.setLayout(null);
		// panel.setBackground(Color.WHITE);
		// panel.setOpaque(true);
		
		// JLabel container = new JLabel();
		// container.setText("Input the slang word you want to search");
		// container.setFont(new Font("Auto Sans", Font.PLAIN, 18));
		// container.setForeground(Color.BLACK);
		// container.setBounds(50, 10, 300, 50);
		
		// textField = new JTextField();
		// textField.setBounds(50, 60, 300, 30);
		// textField.setFont(new Font("Auto Sans", Font.PLAIN, 18));
		// textField.setForeground(Color.BLACK);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setFont(new Font("Auto Sans", Font.BOLD, 18));
		deleteBtn.setForeground(Color.BLACK);
		deleteBtn.setFocusable(false);
		deleteBtn.setBounds(250, 180, 100, 30);
		deleteBtn.addActionListener(this);
		
		question = new JLabel();
		question.setBounds(210, 220, 400, 30);
		question.setText("Do you want to delete?");
		question.setFont(new Font("Auto Sans", Font.PLAIN, 18));
		question.setForeground(Color.BLACK);
		
		yesBtn = new JButton("Yes");
		yesBtn.setFont(new Font("Auto Sans", Font.BOLD, 18));
		yesBtn.setForeground(Color.BLACK);
		yesBtn.setFocusable(false);
		yesBtn.setBounds(180, 250, 100, 30);
		yesBtn.addActionListener(this);
		
		noBtn = new JButton("No");
		noBtn.setFont(new Font("Auto Sans", Font.BOLD, 18));
		noBtn.setForeground(Color.BLACK);
		noBtn.setFocusable(false);
		noBtn.setBounds(300, 250, 100, 30);
		noBtn.addActionListener(this);
		
		question.setVisible(false);
		yesBtn.setVisible(false);
		noBtn.setVisible(false);
		
		notify1 = new JLabel();
		notify1.setBounds(230, 300, 200, 30);
		notify1.setText("Delete successfully.");
		notify1.setFont(new Font("Auto Sans", Font.PLAIN, 18));
		notify1.setForeground(Color.BLACK);
		notify1.setBackground(Color.DARK_GRAY);
		notify1.setVisible(false);
		
		notify2 = new JLabel();
		notify2.setBounds(130, 250, 200, 30);
		notify2.setText("The slang doesn't exist.");
		notify2.setFont(new Font("Auto Sans", Font.BOLD, 18));
		notify2.setForeground(Color.BLACK);
		notify2.setBackground(Color.DARK_GRAY);
		notify2.setVisible(false);
		
		panel.add(container1);
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
		backBtn.setFont(new Font("Auto Sans", Font.PLAIN, 15));
		backBtn.addActionListener(this);
		
		exitBtn = new JButton("Exit");
		exitBtn.setFocusable(false);
		exitBtn.setBounds(350, 400, 100, 30);
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

		this.Dictionary = dictionary;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Delete Slang");
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
		} else if (e.getSource() == deleteBtn) {
			question.setVisible(true);
			yesBtn.setVisible(true);
			noBtn.setVisible(true);
		} else if (e.getSource() == yesBtn) {
			boolean option = this.Dictionary.deleteSlang(textField.getText().toUpperCase());
			if (option) {
				notify1.setVisible(true);
				notify2.setVisible(false);
				yesBtn.setVisible(false);
				noBtn.setVisible(false);
				question.setVisible(false);
				deleteBtn.setVisible(false);
			} else {
				notify1.setVisible(false);
				notify2.setVisible(true);
				yesBtn.setVisible(false);
				noBtn.setVisible(false);
				question.setVisible(false);
				deleteBtn.setVisible(false);
			}
		} else if (e.getSource() == noBtn) {
				notify1.setVisible(false);
				notify2.setVisible(false);
				yesBtn.setVisible(false);
				noBtn.setVisible(false);
				question.setVisible(false);
				deleteBtn.setVisible(true);
		}
	}
}

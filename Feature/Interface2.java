package Feature;

import Dictionary.Dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Interface2 extends JFrame implements ActionListener {
	private final Dictionary Dictionary;
	private final JButton editSlang,addSlang,deleteSlang;
	private final JButton backBtn,exitBtn;
	
	public Interface2(Dictionary dictionary) {
		
		JLabel label = new JLabel();
		label.setBounds(100, 50, 300, 50);
		label.setText("Slang Dictionary");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		label.setAlignmentX(CENTER_ALIGNMENT);
		
		editSlang = new JButton("Edit Slang");
		editSlang .setFocusable(false);
		editSlang .addActionListener(this);
		
		addSlang = new JButton("Add Slang");
		addSlang.setFocusable(false);
		addSlang.addActionListener(this);
		
		// viewHistory = new JButton("View History");
		// viewHistory.setFocusable(false);
		// viewHistory.addActionListener(this);
		
		// addBtn = new JButton("Add Slang");
		// addBtn.setFocusable(false);
		// addBtn.addActionListener(this);
		
		deleteSlang = new JButton("Delete Slang");
		deleteSlang.setFocusable(false);
		deleteSlang.addActionListener(this);

		exitBtn = new JButton("Exit");
		exitBtn.setFocusable(false);
		exitBtn.addActionListener(this);

        backBtn = new JButton("Back");
		backBtn.setFocusable(false);
		backBtn.addActionListener(this);
		
		JPanel panel = new JPanel();
		// panel.setBounds(50, 0, 500, 100);
		panel.setLayout(new GridLayout(3, 1, 4, 3));
		panel.add(editSlang);
		panel.add(addSlang);
        panel.add(deleteSlang);
		// panel.add(editBtn);
		// panel.add(deleteBtn);
		// panel.add(resetBtn);
		// panel.add(randomBtn);
		// panel.add(slangGameBtn);
		// panel.add(definitionGameBtn);
		// panel.add(exitBtn);
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
		this.setTitle("Edit");
		this.setVisible(true);
		this.setSize(700, 700);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		// if (search.equals(e.getSource())) {
		// 	this.dispose();
		// 	new Interface1(this.Dictionary);
		if (editSlang.equals(e.getSource())) {
			this.dispose();
			new EditSlang(this.Dictionary);
		} else if (addSlang.equals(e.getSource())) {
			this.dispose();
			new AddSlang(this.Dictionary);
		} else if (deleteSlang.equals(e.getSource())) {
			this.dispose();
			new DeleteSlang(this.Dictionary);
		// } else if (editBtn.equals(e.getSource())) {
		// 	this.dispose();
		// 	new EditSlang(this.Dictionary);
		// } else if (deleteBtn.equals(e.getSource())) {
		// 	this.dispose();
		// 	new DeleteSlang(this.Dictionary);
		// } else if (randomBtn.equals(e.getSource())) {
		// 	this.dispose();
		// 	new RandomSlang(this.Dictionary);
		// } else if (resetBtn.equals(e.getSource())) {
		// 	this.dispose();
		// 	new Reset(this.Dictionary);
		// } else if (slangGameBtn.equals(e.getSource())) {
		// 	this.dispose();
		// 	new MiniGame(this.Dictionary);
		// } else if (definitionGameBtn.equals(e.getSource())) {
		// 	this.dispose();
		// 	new MiniGame2(this.Dictionary);
        } else if (e.getSource()== backBtn) {
			this.dispose();
			new Interface(this.Dictionary);
		} else if (e.getSource() == exitBtn) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}
}
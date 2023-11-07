package Feature;

import Dictionary.Dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Interface extends JFrame implements ActionListener {
	private final Dictionary Dictionary;
	private final JButton searchSlangBtn, searchDefinitionBtn, viewHistory;
	private final JButton addBtn, editBtn, deleteBtn;
	private final JButton resetBtn, randomBtn;
	private final JButton slangGameBtn, definitionGameBtn;
	private final JButton exitBtn;
	
	public Interface(Dictionary dictionary) {
		
		JLabel label = new JLabel();
		label.setBounds(100, 50, 300, 50);
		label.setText("Slang Dictionary");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		label.setAlignmentX(CENTER_ALIGNMENT);
		
		searchSlangBtn = new JButton("Search By Slang");
		searchSlangBtn.setFocusable(false);
		searchSlangBtn.addActionListener(this);
		
		searchDefinitionBtn = new JButton("Search By Definition");
		searchDefinitionBtn.setFocusable(false);
		searchDefinitionBtn.addActionListener(this);
		
		viewHistory = new JButton("View History");
		viewHistory.setFocusable(false);
		viewHistory.addActionListener(this);
		
		addBtn = new JButton("Add Slang");
		addBtn.setFocusable(false);
		addBtn.addActionListener(this);
		
		editBtn = new JButton("Edit Slang");
		editBtn.setFocusable(false);
		editBtn.addActionListener(this);
		
		deleteBtn = new JButton("Delete Slang");
		deleteBtn.setFocusable(false);
		deleteBtn.addActionListener(this);
		
		resetBtn = new JButton("Reset Dictionary");
		resetBtn.setFocusable(false);
		resetBtn.addActionListener(this);
		
		randomBtn = new JButton("Random Slang");
		randomBtn.setFocusable(false);
		randomBtn.addActionListener(this);
		
		slangGameBtn = new JButton("Mini Game (Slang)");
		slangGameBtn.setFocusable(false);
		slangGameBtn.addActionListener(this);
		
		definitionGameBtn = new JButton("Mini Game (Definition)");
		definitionGameBtn.setFocusable(false);
		definitionGameBtn.addActionListener(this);

		exitBtn = new JButton("Exit");
		exitBtn.setFocusable(false);
		exitBtn.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 130, 400, 250);
		panel.setLayout(new GridLayout(4, 4, 8, 8));
		panel.add(searchSlangBtn);
		panel.add(searchDefinitionBtn);
		panel.add(viewHistory);
		panel.add(addBtn);
		panel.add(editBtn);
		panel.add(deleteBtn);
		panel.add(resetBtn);
		panel.add(randomBtn);
		panel.add(slangGameBtn);
		panel.add(definitionGameBtn);
		panel.add(exitBtn);
		
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

		Dimension size2 = new Dimension(600, 500);
		panel.setMaximumSize(size2);
		panel.setPreferredSize(size2);
		panel.setMinimumSize(size2);
		Container con = this.getContentPane();
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		con.add(Box.createRigidArea(new Dimension(0, 10)));
		con.add(label);
		con.add(Box.createRigidArea(new Dimension(0, 30)));
		con.add(panel);

		this.Dictionary = dictionary;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Main Window");
		this.setVisible(true);
		this.setSize(700, 700);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		if (searchSlangBtn.equals(e.getSource())) {
			this.dispose();
			new SearchBySlang(this.Dictionary);
		} else if (searchDefinitionBtn.equals(e.getSource())) {
			this.dispose();
			new SearchByDefinition(this.Dictionary);
		} else if (viewHistory.equals(e.getSource())) {
			this.dispose();
			new ViewHistory(this.Dictionary);
		} else if (addBtn.equals(e.getSource())) {
			this.dispose();
			new AddSlang(this.Dictionary);
		} else if (editBtn.equals(e.getSource())) {
			this.dispose();
			new EditSlang(this.Dictionary);
		} else if (deleteBtn.equals(e.getSource())) {
			this.dispose();
			new DeleteSlang(this.Dictionary);
		} else if (randomBtn.equals(e.getSource())) {
			this.dispose();
			new RandomSlang(this.Dictionary);
		} else if (resetBtn.equals(e.getSource())) {
			this.dispose();
			new Reset(this.Dictionary);
		} else if (slangGameBtn.equals(e.getSource())) {
			this.dispose();
			new MiniGame(this.Dictionary);
		} else if (definitionGameBtn.equals(e.getSource())) {
			this.dispose();
			new MiniGame2(this.Dictionary);
		} else if (e.getSource() == exitBtn) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}
}
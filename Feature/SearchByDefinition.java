package Feature;

import Dictionary.Dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class SearchByDefinition extends JFrame implements ActionListener {
	private final Dictionary Dictionary;
	private final JButton searchBtn;
	private final JButton backBtn, exitBtn;
	private final JTextField textField;
	private final JList<String> list;
	
	public SearchByDefinition(Dictionary dictionary) {

		JLabel label = new JLabel();
		label.setBounds(100, 50, 300, 50);
		label.setText("Search Slang with Definition");
		label.setFont(new Font("Auto Sans", Font.PLAIN, 40));
		label.setForeground(Color.BLACK);
		label.setAlignmentX(CENTER_ALIGNMENT);

		JPanel panel = new JPanel();
		panel.setBounds(50, 100, 400, 160);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(true);
		
		JLabel container = new JLabel();
		container.setText("Enter the Definition you want to search");
		container.setFont(new Font("Auto Sans", Font.PLAIN, 18));
		container.setForeground(Color.BLACK);
		container.setBounds(150, 10, 400, 50);
		
		textField = new JTextField();
		textField.setBounds(150, 60, 300, 30);
		textField.setFont(new Font("Auto Sans", Font.PLAIN, 18));
		textField.setForeground(Color.BLACK);
		
		searchBtn = new JButton("Search");
		searchBtn.setFont(new Font("Auto Sans", Font.PLAIN, 18));
		searchBtn.setForeground(Color.BLACK);
		searchBtn.setFocusable(false);
		searchBtn.setBounds(250, 100, 100, 30);
		searchBtn.addActionListener(this);
		
		
		DefaultListModel<String> model = new DefaultListModel<>();
		list = new JList<>(model);
		list.setForeground(Color.BLACK);
		list.setFont(new Font("Auto Sans", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(100, 250, 400, 100);

		panel.add(container);
		panel.add(textField);
		panel.add(searchBtn);
		panel.add(scrollPane);
		
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
		this.setTitle("Search Slang");
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
			new Interface1(this.Dictionary);
		} else if (e.getSource() == exitBtn) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} else if (e.getSource() == searchBtn) {
			String word = textField.getText().replaceAll(" ", "");
			List<String> items = this.Dictionary.findByDefinition(word);
			if (items != null) {
				DefaultListModel<String> temp = new DefaultListModel<>();
				temp.addAll(items);
				list.setModel(temp);
			}else {
				DefaultListModel<String> temp = new DefaultListModel<>();
				temp.addElement(textField.getText() + " doesn't exist. Please try again!!!");
				list.setModel(temp);
			}
		}
	}
}

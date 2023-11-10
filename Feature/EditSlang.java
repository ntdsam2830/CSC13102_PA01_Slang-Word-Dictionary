package Feature;

import Dictionary.Dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class EditSlang extends JFrame implements ActionListener {
	private final Dictionary Dictionary;
	private final JList<String> definitionList;
	private final JTextField editSlang, editDefinition;
	private final JLabel definitionLabel, replaceLabel, addLabel, deleteLabel;
	private final JScrollPane scrollPane;
	private final JButton backBtn, exitBtn;
	private final JButton changeBtn, replaceBtn, deleteBtn, addBtn;
	private final JButton replaceConfirm, deleteConfirm, addConfirm;
	
	public EditSlang(Dictionary dictionary) {
		
		JLabel label = new JLabel();
		label.setBounds(100, 50, 300, 50);
		label.setText("Edit Slang");
		label.setFont(new Font("Auto Sans", Font.PLAIN, 40));
		label.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 150, 400, 400);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(true);
		
		JLabel container1 = new JLabel();
		container1.setText("Input the Slang to Edit: ");
		container1.setFont(new Font("Auto Sans", Font.PLAIN, 20));
		container1.setForeground(Color.BLACK);
		container1.setBounds(150, 0, 300, 50);
		
		editSlang = new JTextField();
		editSlang.setBounds(150, 40, 300, 40);
		editSlang.setFont(new Font("Auto Sans", Font.PLAIN, 18));
		editSlang.setForeground(Color.BLACK);
		
		changeBtn = new JButton("Change Slang");
		changeBtn.setBounds(50, 100, 150, 30);
		changeBtn.setFont(new Font("Auto Sans", Font.PLAIN, 15));
		changeBtn.setFocusable(false);
		changeBtn.addActionListener(this);
		
		replaceBtn = new JButton("Replace");
		replaceBtn.setBounds(210, 100, 100, 30);
		replaceBtn.setFont(new Font("Auto Sans", Font.PLAIN, 15));
		replaceBtn.setFocusable(false);
		replaceBtn.addActionListener(this);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(320, 100, 100, 30);
		deleteBtn.setFont(new Font("Auto Sans", Font.PLAIN, 15));
		deleteBtn.setFocusable(false);
		deleteBtn.addActionListener(this);
		
		addBtn = new JButton("Add");
		addBtn.setBounds(430, 100, 100, 30);
		addBtn.setFont(new Font("Auto Sans", Font.PLAIN, 15));
		addBtn.setFocusable(false);
		addBtn.addActionListener(this);
		
		definitionLabel = new JLabel();
		definitionLabel.setVisible(false);
		definitionLabel.setBounds(150, 110, 300, 80);
		definitionLabel.setFont(new Font("Auto Sans", Font.BOLD, 15));
		
		DefaultListModel<String> model = new DefaultListModel<>();
		definitionList = new JList<>(model);
		definitionList.setForeground(Color.BLACK);
		definitionList.setFont(new Font("Auto Sans", Font.PLAIN, 15));
		
		scrollPane = new JScrollPane(definitionList);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(150, 170, 300, 100);
		scrollPane.setVisible(false);
		
		replaceLabel = new JLabel();
		replaceLabel.setText("Enter the Definition you want to replace:");
		replaceLabel.setFont(new Font("Auto Sans", Font.BOLD, 15));
		replaceLabel.setBounds(150, 270, 300, 40);
		replaceLabel.setVisible(false);
		
		editDefinition = new JTextField();
		editDefinition.setBounds(150, 320, 300, 30);
		editDefinition.setVisible(false);
		
		replaceConfirm = new JButton("Replace");
		replaceConfirm.setBounds(230, 360, 120, 30);
		replaceConfirm.setVisible(false);
		replaceConfirm.addActionListener(this);
		replaceConfirm.setFocusable(false);
		
		deleteConfirm = new JButton("Delete");
		deleteConfirm.setBounds(230, 360, 120, 30);
		deleteConfirm.setVisible(false);
		deleteConfirm.setFocusable(false);
		deleteConfirm.addActionListener(this);
		
		addLabel = new JLabel();
		addLabel.setText("Enter the Definition you want to add:");
		addLabel.setFont(new Font("Auto Sans", Font.BOLD, 15));
		addLabel.setBounds(150, 270, 300, 40);
		addLabel.setVisible(false);
		
		addConfirm = new JButton("Add");
		addConfirm.setBounds(230, 360, 120, 30);
		addConfirm.setVisible(false);
		addConfirm.setFocusable(false);
		addConfirm.addActionListener(this);
		
		deleteLabel = new JLabel();
		deleteLabel.setText("This Slang only has 1 definition. Cannot delete.");
		deleteLabel.setFont(new Font("Auto Sans", Font.BOLD, 15));
		deleteLabel.setBounds(120, 300, 400, 30);
		deleteLabel.setVisible(false);
		
		panel.add(container1);
		panel.add(editSlang);
		panel.add(editDefinition);
		panel.add(changeBtn);
		panel.add(replaceBtn);
		panel.add(deleteBtn);
		panel.add(addBtn);
		panel.add(definitionLabel);
		panel.add(scrollPane);
		panel.add(replaceLabel);
		panel.add(replaceConfirm);
		panel.add(deleteConfirm);
		panel.add(addLabel);
		panel.add(addConfirm);
		panel.add(deleteLabel);
		
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
		this.setTitle("Edit Slang");
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
		} else if (e.getSource() == changeBtn) {
			editSlang.setEditable(true);
			definitionLabel.setVisible(false);
			scrollPane.setVisible(false);
			replaceLabel.setVisible(false);
			editDefinition.setVisible(false);
			replaceConfirm.setVisible(false);
			deleteConfirm.setVisible(false);
			addLabel.setVisible(false);
			addConfirm.setVisible(false);
			deleteLabel.setVisible(false);
		} else if (e.getSource() == replaceBtn) {
			definitionLabel.setText("Definition of: " +
											editSlang.getText());
			editSlang.setEditable(false);
			definitionLabel.setVisible(true);
			scrollPane.setVisible(true);
			replaceLabel.setVisible(true);
			editDefinition.setVisible(true);
			replaceConfirm.setVisible(true);
			deleteConfirm.setVisible(false);
			addLabel.setVisible(false);
			addConfirm.setVisible(false);
			deleteLabel.setVisible(false);
			List<String> items = this.Dictionary.getDefinition(editSlang.getText());
			if (items != null) {
				DefaultListModel<String> temp = new DefaultListModel<>();
				temp.addAll(items);
				definitionList.setModel(temp);
			}
		} else if (e.getSource() == replaceConfirm) {
			this.Dictionary.editSlang(
					  editSlang.getText(),
					  definitionList.getSelectedValue(),
					  editDefinition.getText(),
					  "replace"
			);
			List<String> items = this.Dictionary.getDefinition(editSlang.getText());
			if (items != null) {
				DefaultListModel<String> temp = new DefaultListModel<>();
				temp.addAll(items);
				definitionList.setModel(temp);
			}
		} else if (e.getSource() == deleteBtn) {
			definitionLabel.setText("Definition of: " +
											editSlang.getText());
			editSlang.setEditable(false);
			definitionLabel.setVisible(true);
			scrollPane.setVisible(true);
			replaceLabel.setVisible(false);
			editDefinition.setVisible(false);
			replaceConfirm.setVisible(false);
			deleteConfirm.setVisible(true);
			addLabel.setVisible(false);
			addConfirm.setVisible(false);
			deleteLabel.setVisible(false);
			List<String> items = this.Dictionary.getDefinition(editSlang.getText());
			if (items != null) {
				DefaultListModel<String> temp = new DefaultListModel<>();
				temp.addAll(items);
				definitionList.setModel(temp);
			}
		} else if (e.getSource() == deleteConfirm) {
			if (definitionList.getModel().getSize() == 1) {
				deleteLabel.setVisible(true);
			} else {
				this.Dictionary.editSlang(
						  editSlang.getText(),
						  definitionList.getSelectedValue(),
						  "",
						  "delete"
				);
				deleteLabel.setVisible(false);
			}
			List<String> items = this.Dictionary.getDefinition(editSlang.getText());
			if (items != null) {
				DefaultListModel<String> temp = new DefaultListModel<>();
				temp.addAll(items);
				definitionList.setModel(temp);
			}
		} else if (e.getSource() == addBtn) {
			editSlang.setEditable(false);
			definitionLabel.setText("Current Definition of: " +
											editSlang.getText());
			scrollPane.setVisible(true);
			replaceLabel.setVisible(false);
			editDefinition.setVisible(true);
			replaceConfirm.setVisible(false);
			deleteConfirm.setVisible(false);
			addLabel.setVisible(true);
			addConfirm.setVisible(true);
			deleteLabel.setVisible(false);
			List<String> items = this.Dictionary.getDefinition(editSlang.getText());
			if (items != null) {
				DefaultListModel<String> temp = new DefaultListModel<>();
				temp.addAll(items);
				definitionList.setModel(temp);
			}
		} else if (e.getSource() == addConfirm) {
			this.Dictionary.editSlang(
					  editSlang.getText(),
					  "",
					  editDefinition.getText(),
					  "add"
			);
			List<String> items = this.Dictionary.getDefinition(editSlang.getText());
			if (items != null) {
				DefaultListModel<String> temp = new DefaultListModel<>();
				temp.addAll(items);
				definitionList.setModel(temp);
			}
		}
	}
}

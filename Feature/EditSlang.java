package Feature;

import Dictionary.Dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

/**
 * GUI
 * Created by Thai Duong
 * Date 11/16/2022 - 3:38 PM
 * Description: ...
 */
public class EditSlang extends JFrame implements ActionListener {
	private final Dictionary Dictionary;
	private final JButton backBtn, exitBtn;
	private final JButton changeBtn, replaceBtn, deleteBtn, addBtn;
	private final JButton replaceConfirm, deleteConfirm, addConfirm;
	private final JList<String> definitionList;
	private final JTextField editSlang, editDefinition;
	private final JLabel definitionLabel, replaceLabel, addLabel, deleteLabel;
	private final JScrollPane scrollPane;
	
	public EditSlang(Dictionary dictionary) {
		this.Dictionary = dictionary;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Edit Slang");
		this.setResizable(false);
		
		JLabel label = new JLabel();
		label.setBounds(100, 0, 300, 50);
		label.setText("Edit Slang Word");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setForeground(Color.BLACK);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 50, 400, 340);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(true);
		
		JLabel slangLabel = new JLabel();
		slangLabel.setText("Input slang:");
		slangLabel.setBounds(120, 5, 70, 30);
		
		editSlang = new JTextField();
		editSlang.setBounds(210, 5, 70, 30);
		
		changeBtn = new JButton("Edit");
		changeBtn.setBounds(16, 40, 80, 30);
		changeBtn.setFocusable(false);
		changeBtn.addActionListener(this);
		
		replaceBtn = new JButton("Replace");
		replaceBtn.setBounds(112, 40, 80, 30);
		replaceBtn.setFocusable(false);
		replaceBtn.addActionListener(this);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(208, 40, 80, 30);
		deleteBtn.setFocusable(false);
		deleteBtn.addActionListener(this);
		
		addBtn = new JButton("Add");
		addBtn.setBounds(304, 40, 80, 30);
		addBtn.setFocusable(false);
		addBtn.addActionListener(this);
		
		// Replace Option
		definitionLabel = new JLabel();
		definitionLabel.setVisible(false);
		
		DefaultListModel<String> model = new DefaultListModel<>();
		definitionList = new JList<>(model);
		definitionList.setForeground(Color.BLACK);
		definitionList.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		scrollPane = new JScrollPane(definitionList);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 120, 300, 100);
		scrollPane.setVisible(false);
		
		replaceLabel = new JLabel();
		replaceLabel.setText("Input definition you want to replace:");
		replaceLabel.setBounds(50, 220, 300, 30);
		replaceLabel.setVisible(false);
		
		editDefinition = new JTextField();
		editDefinition.setBounds(50, 250, 300, 30);
		editDefinition.setVisible(false);
		
		replaceConfirm = new JButton("Replace now");
		replaceConfirm.setBounds(140, 290, 120, 30);
		replaceConfirm.setVisible(false);
		replaceConfirm.addActionListener(this);
		replaceConfirm.setFocusable(false);
		
		// Delete Option
		deleteConfirm = new JButton("Delete now");
		deleteConfirm.setBounds(140, 290, 120, 30);
		deleteConfirm.setVisible(false);
		deleteConfirm.setFocusable(false);
		deleteConfirm.addActionListener(this);
		
		// Add Option
		addLabel = new JLabel();
		addLabel.setText("Input definition you want to add:");
		addLabel.setBounds(50, 220, 300, 30);
		addLabel.setVisible(false);
		
		addConfirm = new JButton("Add now");
		addConfirm.setBounds(140, 290, 120, 30);
		addConfirm.setVisible(false);
		addConfirm.setFocusable(false);
		addConfirm.addActionListener(this);
		
		deleteLabel = new JLabel();
		deleteLabel.setText("This slang only have 1 definition. Can't delete.");
		deleteLabel.setBounds(70, 250, 300, 30);
		deleteLabel.setVisible(false);
		
		panel.add(slangLabel);
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
		backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		backBtn.addActionListener(this);
		
		exitBtn = new JButton("Exit");
		exitBtn.setFocusable(false);
		exitBtn.setBounds(350, 400, 100, 30);
		exitBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		exitBtn.addActionListener(this);
		
		this.add(label);
		this.add(panel);
		this.add(backBtn);
		this.add(exitBtn);
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
			definitionLabel.setText("Definitions of " +
											editSlang.getText() +
											". Click the word you want to edit.");
			definitionLabel.setBounds(50, 80, 350, 30);
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
			definitionLabel.setText("Definitions of " +
											editSlang.getText() +
											". Click the word you want to edit.");
			definitionLabel.setBounds(50, 80, 350, 30);
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
			definitionLabel.setVisible(false);
			scrollPane.setVisible(true);
			replaceLabel.setVisible(false);
			editDefinition.setVisible(true);
			replaceConfirm.setVisible(false);
			deleteConfirm.setVisible(false);
			addLabel.setVisible(true);
			addConfirm.setVisible(true);
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

package Feature;

import Dictionary.Dictionary;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
// import javax.swing.event.listSelectionEvent;
// import javax.swing.event.listSelectionMode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchBySlang extends JFrame implements ActionListener {
	private final Dictionary Dictionary;
	private final List<String> Suggest;
	private final JButton backBtn, exitBtn;
	private final JTextField textField;
	private final JList<String> list;
	
	public SearchBySlang(Dictionary dictionary) {
		this.Dictionary = dictionary;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Search Definition");
		this.setResizable(false);
        this.setSize(700, 700);
        this.setLocation(500, 200);
		
		JLabel label = new JLabel();
		label.setBounds(100, 50, 300, 50);
		label.setText("Search Definition of Slang");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setForeground(Color.BLACK);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 100, 400, 50);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(true);
		
		JLabel container = new JLabel();
		container.setText("Enter Slang: ");
		container.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		container.setForeground(Color.BLACK);
		container.setBounds(5, 10, 300, 20);
		
		textField = new JTextField();
		textField.setBounds(100, 10, 300, 30);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setForeground(Color.BLACK);
		
		// searchBtn = new JButton("Search");
		// searchBtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		// searchBtn.setForeground(Color.BLACK);
		// searchBtn.setFocusable(false);
		// searchBtn.setBounds(150, 100, 100, 30);
		// searchBtn.addActionListener(this);
		
		panel.add(container);
		panel.add(textField);
		// panel.add(searchBtn);

		JList<String> suggestList = new JList<>();
		suggestList.setSelectionMode(listSelectionMode.SINGLE_SELECTION);
	
		DefaultListModel<String> suggestion = new DefaultListModel<>();
		list = new JList<>(suggest);
		list.setForeground(Color.BLACK);
		list.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 180, 200, 220);

		JScrollPane scrollPane2 = new JScrollPane(scrollPane);
		scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane2.setBounds(50, 200, 200, 200);
		
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
		this.add(scrollPane);
		this.add(scrollPane2);
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
			new Interface1(this.Dictionary);
		} else if (e.getSource() == exitBtn) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}
		textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                DefaultListModel<String> listSuggest = new DefaultListModel<>();
				if (textField.getText().length() > 0) {
                    listSuggest.clear();
					Suggest = Dictionary.findBySlangWord(textField.getText());
                    for () {
                        listSuggest.addElement(entry.getKey());
                    }
                    list.setModel(listSuggest);
                } else {
                    listSuggest.clear();
                }
            }

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException("Unimplemented method 'removeUpdate'");
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException("Unimplemented method 'changedUpdate'");
			}

            // @Override
            // public void removeUpdate(DocumentEvent e) {
            //     if (input.getText().length() > 0) {
            //         listSuggest.clear();
            //         suggest = mainDictionary.searchBySlang(input.getText());
            //         for (Map.Entry<String, Set<String>> entry : suggest.getDictionary().entrySet()) {
            //             listSuggest.addElement(entry.getKey());
            //         }
            //         suggestList.setModel(listSuggest);
            //     } else {
            //         listSuggest.clear();
            //     }
            // }

            // @Override
            // public void changedUpdate(DocumentEvent e) {
            //     if (input.getText().length() > 0) {
            //         listSuggest.clear();
            //         suggest = mainDictionary.searchBySlang(input.getText());
            //         for (Map.Entry<String, Set<String>> entry : suggest.getDictionary().entrySet()) {
            //             listSuggest.addElement(entry.getKey());
            //         }
            //         suggestList.setModel(listSuggest);
            //     } else {
            //         listSuggest.clear();
            //     }
            // }
        // });
		// } else if (e.getSource() == searchBtn) {
		// 	String word = textField.getText().replaceAll(" ", "");
		// 	List<String> items = this.Dictionary.findBySlangWord(word);
		// 	if (items != null) {
		// 		DefaultListModel<String> temp = new DefaultListModel<>();
		// 		temp.addAll(items);
		// 		list.setModel(temp);
		// 	} else {
		// 		DefaultListModel<String> temp = new DefaultListModel<>();
		// 		temp.addElement(textField.getText() + " doesn't exist.Please try again!!!");
		// 		list.setModel(temp);
		// 	}
		// }
	});
}
}




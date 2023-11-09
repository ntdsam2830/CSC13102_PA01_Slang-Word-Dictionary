package Feature;

import Dictionary.Dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

public class MiniGame2 extends JFrame implements ActionListener {
	private final Dictionary Dictionary;
	private final JButton backBtn, exitBtn;
	private final JButton aBtn, bBtn, cBtn, dBtn,checkBtn, nextBtn;
	private final JLabel correct, wrong;
	private final JTextField answerField;
	private final String gameAnswer;
	
	public MiniGame2(Dictionary dictionary) {
		this.Dictionary = dictionary;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Edit Slang");
		this.setVisible(true);
		this.setSize(700, 700);

		JLabel label = new JLabel();
		label.setBounds(100, 50, 300, 50);
		label.setText("Mini Game Slang Word");
		label.setFont(new Font("Auto Sans", Font.PLAIN, 40));
		label.setForeground(Color.BLACK);
		label.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 70, 400, 400);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(true);
		
		JLabel question = new JLabel();
		question.setText("What is the Definition of: ");
		question.setFont(new Font("Auto Sans", Font.PLAIN, 18));
		question.setBounds(200, 10, 250, 30);
		
		JTextField word = new JTextField();
		word.setEditable(false);
		word.setBounds(200, 40, 200, 50);
		
		aBtn = new JButton();
		aBtn.setBounds(100, 120, 200, 40);
		aBtn.setFocusable(false);
		aBtn.addActionListener(this);
		
		bBtn = new JButton();
		bBtn.setBounds(320, 120, 200, 40);
		bBtn.setFocusable(false);
		bBtn.addActionListener(this);
		
		cBtn = new JButton();
		cBtn.setBounds(100, 170, 200, 40);
		cBtn.setFocusable(false);
		cBtn.addActionListener(this);
		
		dBtn = new JButton();
		dBtn.setBounds(320, 170, 200, 40);
		dBtn.setFocusable(false);
		dBtn.addActionListener(this);
		
		JLabel answer = new JLabel();
		answer.setText("Your answer: ");
		answer.setBounds(110, 240, 80, 30);
		
		answerField = new JTextField();
		answerField.setEditable(false);
		answerField.setBounds(200, 240, 250, 30);
		
		checkBtn = new JButton("Check");
		checkBtn.setBounds(470, 240, 90, 30);
		checkBtn.setFocusable(false);
		checkBtn.addActionListener(this);
		
		correct = new JLabel();
		correct.setText("Well done !!!");
		correct.setBounds(200, 280, 100, 30);
		correct.setVisible(false);
		
		wrong = new JLabel();
		wrong.setText("Incorrect. Please try again!!!");
		wrong.setFont(new Font("Auto Sans", Font.PLAIN, 15));
		wrong.setBounds(200, 280, 200, 30);
		wrong.setVisible(false);
		
		nextBtn = new JButton("Next");
		nextBtn.setFocusable(false);
		nextBtn.setBounds(290, 280, 120, 30);
		nextBtn.setVisible(false);
		nextBtn.addActionListener(this);
		
		String data = this.Dictionary.slangGameB();
		String[] item = data.split("`");
		word.setText(item[0]);
		gameAnswer = item[1];
		Random random = new Random();
		List<String> chosen = new ArrayList<>(Arrays.asList(item[2].split("\\|")));
		String word1 = chosen.get(random.nextInt(chosen.size()));
		aBtn.setText(word1);
		chosen.remove(word1);
		
		String word2 = chosen.get(random.nextInt(chosen.size()));
		bBtn.setText(word2);
		chosen.remove(word2);
		
		String word3 = chosen.get(random.nextInt(chosen.size()));
		cBtn.setText(word3);
		chosen.remove(word3);
		
		dBtn.setText(chosen.get(0));
		
		panel.add(aBtn);
		panel.add(bBtn);
		panel.add(cBtn);
		panel.add(dBtn);
		panel.add(question);
		panel.add(word);
		panel.add(checkBtn);
		panel.add(correct);
		panel.add(wrong);
		panel.add(nextBtn);
		panel.add(answerField);
		panel.add(answer);
		
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
			new Interface3(this.Dictionary);
		} else if (e.getSource() == exitBtn) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} else if (e.getSource() == aBtn) {
			answerField.setText(aBtn.getText());
		} else if (e.getSource() == bBtn) {
			answerField.setText(bBtn.getText());
		} else if (e.getSource() == cBtn) {
			answerField.setText(cBtn.getText());
		} else if (e.getSource() == dBtn) {
			answerField.setText(dBtn.getText());
		} else if (e.getSource() == checkBtn) {
			if (Objects.equals(answerField.getText(), gameAnswer)) {
				correct.setVisible(true);
				nextBtn.setVisible(true);
				wrong.setVisible(false);
			} else {
				correct.setVisible(false);
				nextBtn.setVisible(false);
				wrong.setVisible(true);
			}
		} else if (e.getSource() == nextBtn) {
			this.dispose();
			new MiniGame2(this.Dictionary);
		}
	}
}

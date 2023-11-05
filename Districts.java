import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Districts implements ActionListener {
  String[] wards = { "Bến Nghé", "Cô Giang", "Bến Thành", "Cầu Kho", "Đa Kao" };
  JList<String> list = new JList<>(wards);

  public Districts() {
    String[] districts = { "District 1", "District 2", "District 3", "District 4", "District 5" };

    JFrame f = new JFrame("Slang Dictionary");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JComboBox comboBox = new JComboBox(districts);
    comboBox.addActionListener(this);

    JLabel label = new JLabel("Choose district", null, 0);
    JLabel label1 = new JLabel("Choose district", null, 0);
    JLabel label2 = new JLabel("Choose district", null, 0);
    JLabel label3 = new JLabel("Choose district", null, 0);
    

    JButton okButton = new JButton("OK");
    okButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        System.out.println("OK");
      }
    });

    JButton cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        System.out.println("Cancelled");
      }
    });

    Container c = f.getContentPane();
    JPanel comboPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    comboPanel.add(label);
    comboPanel.add(comboBox);
    c.add(comboPanel, BorderLayout.NORTH);

    c.add(new JScrollPane(list), BorderLayout.CENTER);

    buttonPanel.add(okButton);
    buttonPanel.add(cancelButton);
    c.add(buttonPanel, BorderLayout.SOUTH);

    f.pack();
    f.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    JComboBox cb = (JComboBox) e.getSource();
    String wardList = (String) cb.getSelectedItem();
    update(wardList);
  }

  protected void update(String name) {
    if (name == "District 1") {
      String[] wards = { "Bến Nghé", "Cô Giang", "Bến Thành", "Cầu Kho", "Đa Kao" };
      list.setListData(wards);
    } else if (name == "District 2") {
      String[] wards = { "An Khánh", "An Lợi Đông", "An Phú", "Bình An", "Bình Khánh" };
      list.setListData(wards);
    } else if (name == "District 3") {
      String[] wards = { "Phường 1", "Phường 2", "Phường 3", "Phường 4", "Phường 5" };
      list.setListData(wards);
    } else if (name == "District 4") {
      String[] wards = { "Phường 1", "Phường 2", "Phường 3", "Phường 4", "Phường 6" };
      list.setListData(wards);
    } else if (name == "District 5") {
      String[] wards = { "Phường 1", "Phường 2", "Phường 3", "Phường 4", "Phường 5" };
      list.setListData(wards);
    }
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Districts();
      }
    });
  }
}
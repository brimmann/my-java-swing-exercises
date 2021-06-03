import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboBoxDemo {
    String timepeices[] = {"Hourglass", "Analog", "Digital", "Stopwatch"};
    JComboBoxDemo(){
        JFrame jfrm = new JFrame("JComboBoxDemo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(400, 250);

        JComboBox<String> jcb = new JComboBox<String>(timepeices);
        jfrm.add(jcb);

        JLabel jlab = new JLabel(new ImageIcon("D:/Hourglass.png"));
        jfrm.add(jlab);

        jcb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String) jcb.getSelectedItem();
                jlab.setIcon(new ImageIcon("D:/" + s + ".png"));
            }
        });

        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JComboBoxDemo();
            }
        });
    }
}

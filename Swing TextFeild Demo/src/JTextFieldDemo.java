import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTextFieldDemo {
    public JTextFieldDemo() throws Exception{
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame jfrm = new JFrame("JTextFieldDemo");
        jfrm.setLayout(new BorderLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(260, 120);

        JTextField jtf = new JTextField(15);
        jtf.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jfrm.add(jtf, BorderLayout.NORTH);

        JLabel jlab = new JLabel();
        jfrm.add(jlab, BorderLayout.CENTER);

        jtf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlab.setText(jtf.getText());
            }
        });

        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    new JTextFieldDemo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

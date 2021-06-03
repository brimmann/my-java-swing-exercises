import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.MetalIconFactory;

public class JButtonDemo implements ActionListener{
    JLabel jlab;

    public JButtonDemo(){
        JFrame jfrm = new JFrame("JButtonDemo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(500, 450);

        //ImageIcon hourglass = new ImageIcon("D:/gh.png");
        JButton jb = new JButton("Hourglass");
        jb.setActionCommand("Hourglass");
        jb.addActionListener(this);
        jfrm.add(jb);

        ImageIcon analog = new ImageIcon("D:/c.png");
        jb = new JButton("Analog");
        jb.setActionCommand("Analog Clock");
        jb.addActionListener(this);
        jfrm.add(jb);

        ImageIcon digital = new ImageIcon("D:/t.png");
        jb = new JButton("Digital");
        jb.setActionCommand("Digital Clock");
        jb.addActionListener(this);
        jfrm.add(jb);

        ImageIcon stopwatch = new ImageIcon("D:/s.png");
        jb = new JButton("Stopwatch");
        jb.setActionCommand("Stopwatch");
        jb.addActionListener(this);
        jfrm.add(jb);

        jlab = new JLabel("Choose a Timepiece");
        jfrm.add(jlab);

        jfrm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jlab.setText("you selected " + e.getActionCommand());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JButtonDemo();
            }
        });
    }
}

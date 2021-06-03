import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class EventDemo {
    JLabel jlab;
    EventDemo(){
        NimbusLookAndFeel n = new NimbusLookAndFeel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


        JFrame jfrm = new JFrame("An Event Example");
        jfrm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfrm.setLayout(new FlowLayout());

        jfrm.setSize(220, 90);

        JButton jbtnAlph = new JButton("Alpha");
        //jbtnAlph.setDefaultCapable(false);
        //System.out.println(jbtnAlph.isDefaultButton());
        JButton jbtnBeta = new JButton("Beta");
        //jbtnBeta.setDefaultCapable(false);

        jbtnAlph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlab.setText("Alpha was pressed.");
            }
        });

        jbtnBeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlab.setText("Beta was pressed.");
            }
        });

        jfrm.add(jbtnAlph);
        jfrm.add(jbtnBeta);

        jlab = new JLabel("Press a button");

        jfrm.add(jlab);

        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EventDemo();
            }
        });
    }
}

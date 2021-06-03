import javax.swing.*;
import java.awt.*;

public class SwingDemo {
    SwingDemo(){
        JFrame jfrm = new JFrame("A Simple Swing Application");

        jfrm.setSize(275, 100);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a text-based label.
        JLabel jlab = new JLabel("Swing means powerful GUIs.", JLabel.CENTER);

        //Add the label to the content pane.
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingDemo();
            }
        });
    }
}

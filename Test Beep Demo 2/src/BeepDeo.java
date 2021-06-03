import javax.swing.*;
import java.awt.*;

public class BeepDeo extends JFrame {
    JButton btn;

    BeepDeo(){
        setTitle("Beep Demo");
        setSize(200, 200);
        btn = new JButton("Beep");
        JButton btn2 = new JButton("Bee2");
        getContentPane().add(btn);
        getContentPane().add(btn2);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BeepDeo();
            }
        });
    }
}



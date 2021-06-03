import java.awt.*;
import java.awt.event.*;
public class CheckboxDemo extends Frame implements ItemListener {
    String msg = "";
    Checkbox windows, android, solaris, mac;

    public CheckboxDemo(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        windows = new Checkbox("Windows", true);
        android = new Checkbox("Android");
        solaris = new Checkbox("Solaris");
        mac = new Checkbox("Mac OS");

        add(windows);
        add(android);
        add(solaris);
        add(mac);

        windows.addItemListener(this);
        android.addItemListener(this);
        solaris.addItemListener(this);
        solaris.addItemListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        msg = "Current state: ";
        g.drawString(msg, 20, 120);
        msg = " Windows: " + windows.getState();
        g.drawString(msg, 20, 140);
        msg = " Android: " + android.getState();
        g.drawString(msg, 20, 160);
        msg = " Solaris: " + solaris.getState();
        g.drawString(msg, 20, 180);
        msg = " Mac OS: " + mac.getState();
        g.drawString(msg, 20, 200);
    }

    public static void main(String[] args) {
        CheckboxDemo appWin = new CheckboxDemo();

        appWin.setSize(new Dimension(240, 220));
        appWin.setTitle("CheckboxDemo");
        appWin.setVisible(true);

    }
}

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.Flow;

public class ButtonLookAndFeel extends Frame {
    Button a;
    Button b;
    Label l;
    ButtonLookAndFeel(){
        a = new Button("Alpha");
        b = new Button("Beta");
        l = new Label("");
        setLayout(new FlowLayout());
        add(a);
        add(b);
        add(l);

        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setText("Alpha was pressed.");
            }
        });

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setText("Beta was pressed.");
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        ButtonLookAndFeel appWin = new ButtonLookAndFeel();
        appWin.setSize((appWin.a.getSize().width + appWin.b.getSize().width) + 10, (appWin.a.getHeight() + appWin.l.getHeight()) + 70);
        appWin.setTitle("Button Look and Feel Demo");
        appWin.setVisible(true);
    }
}

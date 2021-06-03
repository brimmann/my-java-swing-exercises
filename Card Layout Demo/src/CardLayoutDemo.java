import java.awt.*;
import java.awt.event.*;

public class CardLayoutDemo extends Frame{
    Checkbox windows10, windows7, windows8, android, solaris, mac;
    Panel osCards;
    CardLayout cardLayout;
    Button win, other;
    public CardLayoutDemo(){
        setLayout(new FlowLayout());

        win = new Button("Windows");
        other = new Button("Other");

        add(win);
        add(other);
        cardLayout = new CardLayout();
        osCards = new Panel();
        osCards.setLayout(cardLayout);

        windows7 = new Checkbox("Windows 7", true);
        windows8 = new Checkbox("Windows 8");
        windows10 = new Checkbox("Windows 10");
        android = new Checkbox("Android");
        solaris = new Checkbox("Solaris");
        mac = new Checkbox("Mac OS");

        Panel winPan = new Panel();
        winPan.add(windows7);
        winPan.add(windows8);
        winPan.add(windows10);

        Panel otherPan = new Panel();
        System.out.println(otherPan.getLayout());
        otherPan.add(android);
        otherPan.add(solaris);
        otherPan.add(mac);

        osCards.add(winPan, "Windows");
        osCards.add(otherPan, "Other");

        add(osCards);

        win.addActionListener((ae) -> cardLayout.show(osCards, "Windows"));
        other.addActionListener((ae) -> cardLayout.show(osCards,"Other"));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                cardLayout.next(osCards);
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
        CardLayoutDemo appWin = new CardLayoutDemo();
        appWin.setResizable(false);
        appWin.setSize(new Dimension(300, 220));
        appWin.setTitle("CardLayoutDemo");
        appWin.setVisible(true);
    }
}

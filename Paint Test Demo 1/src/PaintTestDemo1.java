import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PaintTestDemo1 extends Frame{
    String msg = "";
    Label label;
    int i;
    public PaintTestDemo1()
    {
        i = 0;
        label = new Label("Default-" + i);
        add(label, BorderLayout.SOUTH);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                i++;

                msg = "Mouse Clicked-" + i;
                //label.setText("Now Mouse Clicked");

                repaint();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 40, 40);
        Graphics lg = label.getGraphics();

    }

    public static void main(String args[])
    {
        PaintTestDemo1 paintTestDemo1 = new PaintTestDemo1();
        paintTestDemo1.setSize(400, 400);
        paintTestDemo1.setVisible(true);
    }
}

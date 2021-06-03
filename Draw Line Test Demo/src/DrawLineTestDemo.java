import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class DrawLineTestDemo extends JFrame {
    int mx, my;
    DrawLineTestDemo(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mx = e.getX();
                my = e.getY();
                repaint();
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);

            }
        });


    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        g.drawString("(" + mx + ", " + my + ")", mx-50, my);
        /*g.drawLine(0, 0, getWidth(), getHeight());
        g.setClip(0, 0, 400, 400);*/
    }

    public static void main(String[] args) {
        DrawLineTestDemo appWin = new DrawLineTestDemo();
        appWin.setSize(400, 400);
        appWin.setTitle("DrawLineTestDemo");
        appWin.setVisible(true);
    }
}

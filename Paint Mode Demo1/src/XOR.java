import java.awt.*;
import java.awt.event.*;

public class XOR extends Frame {
    int cX=100, cY=100;
    public XOR(){
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                cX = x;
                cY = y;
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
        g.setColor(Color.green);
        g.fillRect(20, 40, 60, 70);

        g.setColor(Color.blue);
        g.fillRect(110, 40, 60, 70);

        g.setColor(Color.black);
        g.fillRect(200, 40, 60, 70);

        g.setColor(Color.red);
        g.fillRect(60, 120, 160, 110);

        g.setXORMode(Color.black);
        g.drawLine(cX-10, cY, cX+10, cY);
        g.drawLine(cX, cY-10, cX, cY+10);
        g.setPaintMode();
    }

    public static void main(String[] args) {
        XOR appWin = new XOR();

        appWin.setSize(new Dimension(300, 260));
        appWin.setTitle("XORDemo");
        appWin.setVisible(true);
    }
}

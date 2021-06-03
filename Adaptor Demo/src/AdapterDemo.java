import java.awt.*;
import java.awt.event.*;

public class AdapterDemo extends Frame{
    String msg = "";

    public AdapterDemo()
    {
        addMouseListener(new MyMouseAdapter());
        addWindowListener(new MyWindowAdapter());
    }

    class MyMouseAdapter extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            msg = "Mouse Pressed.";
            repaint();
        }
    }

    class MyWindowAdapter extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    @Override
    public void paint(Graphics g){
        g.drawString(msg, 20, 80);
    }

    public static void main(String[] args){
        AdapterDemo appWin = new AdapterDemo();

        appWin.setSize(new Dimension(200, 150));
        appWin.setTitle("AdapterDemo");
        appWin.setVisible(true);
    }
}

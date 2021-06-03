import java.awt.*;
import java.awt.event.*;

public class MousePressedDemo extends Frame{
    String msg = "";

    public MousePressedDemo()
    {
        addMouseListener((new MyMouseAdapter(this)));
        addMouseMotionListener(new MyMouseAdapter(this));
        addWindowListener(new MyWindowAdapter());
    }

    @Override
    public void paint(Graphics g){
        g.drawString(msg, 20, 80);
    }

    public static void main(String[] args){
        MousePressedDemo appWin = new MousePressedDemo();

        appWin.setSize(new Dimension(200, 150));
        appWin.setTitle("MousePressedDemo");
        appWin.setVisible(true);
    }
}

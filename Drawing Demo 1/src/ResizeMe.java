import java.awt.*;
import java.awt.event.*;
public class ResizeMe extends Frame{
    final int inc = 25;
    int max = 500;
    int min = 200;
    Dimension d;

    public ResizeMe()
    {
        //Graphics appGraphic = getGraphics();

        //appGraphic.setColor(color);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int w = (d.width + inc) > max?min : (d.width+inc);
                int h = (d.height + inc) > max?min : (d.height + inc);
                setSize(new Dimension(w, h));
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Insets i = getInsets();
        //System.out.println(g);

        d = getSize();
        Color color = new Color(255, 0, 0);
        g.drawLine(i.left, i.top, d.width-i.right, d.height-i.bottom);
        g.drawLine(i.left, d.height-i.bottom, d.width-i.right, i.top);
    }

    public static void main(String[] args){
        ResizeMe appWin = new ResizeMe();
        appWin.setSize(new Dimension(200, 200));
        appWin.setTitle("ResizeMe");
        appWin.setVisible(true);
    }
}

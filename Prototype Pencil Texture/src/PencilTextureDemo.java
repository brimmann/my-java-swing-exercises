import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

public class PencilTextureDemo extends JFrame {
    PencilTextureDemo(){
        setTitle("Pencil Texture Prototype");
        setSize(1000, 1000);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        MyCanvas canvas = new MyCanvas();
        add(canvas);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //canvas.setConnect(true);
                //canvas.setPrePoint(new Point(e.getX(), e.getY()));
                //System.out.println();
                //canvas.setMouseX(e.getX());
                //canvas.getGraphics().drawOval(e.getX()-100, e.getY()-100, 200, 200);
                //canvas.setMouseY(e.getY());
                //canvas.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
               canvas.setConnect(false);

            }
        });
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                canvas.setMouseX(e.getX());
                canvas.setMouseY(e.getY());
                //System.out.print("(" + canvas.getMouseX() + "," + e.getY() + ")");
                canvas.repaint();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PencilTextureDemo();
            }
        });
    }



}

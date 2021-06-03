import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DrawingDemo extends Frame {
    DrawingDemo(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setSize(600, 600);
        setTitle("DrawingDemo");
        setVisible(true);
        Graphics graphics = getGraphics();
        graphics.drawRoundRect(200, 200, 100, 100, 5, 5);
    }


    public static void main(String[] args) {
        new DrawingDemo();

    }
}

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PixelDraw extends JPanel {

    private BufferedImage canvas;

    public PixelDraw(int width, int height) {
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//        fillCanvas(Color.GRAY);
        drawLine(10, 20, 300, 300);
    }

    public Dimension getPreferredSize() {
        return new Dimension(canvas.getWidth(), canvas.getHeight());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
    }


    public void fillCanvas(Color c) {
        int color = c.getRGB();
        for (int x = 30; x < canvas.getWidth(); x++) {
            for (int y = 20; y < canvas.getHeight(); y++) {
                canvas.setRGB(x, y, color);
            }
        }
        repaint();
    }

    // Bresenham's line algorithm.
    public void drawLine(int x1, int y1, int x2, int y2) {


        int deltax = Math.abs(x2 - x1);
        int deltay = Math.abs(y2 - y1);
        int error = 0;
        int y = y1;
        for( int x=x1; x<x2; x++) {
            //canvas.getGraphics().setColor(Color.RED);
            canvas.getGraphics().fillOval(x, y, 5, 5);
            error = error + deltay;
            if( 2*error >= deltax ) {
                y = y + 1;
                error=error - deltax;
            }
        }

        repaint();
    }


    public static void main(String[] args) {
        int width = 640;
        int height = 480;
        JFrame frame = new JFrame("Bresenham's line algorithm.");

        PixelDraw panel = new PixelDraw(width, height);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
//        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

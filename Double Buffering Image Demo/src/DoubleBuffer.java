import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.time.Clock;
import java.time.Instant;

public class DoubleBuffer extends Frame{
    int gap = 3;
    int mx, my;
    boolean flicker = false;
    Image buffer;
    int w = 500, h = 500;

    public DoubleBuffer() throws IOException {
        File imageFile = new File("C:/Users/Mohammad Rashid/Pictures/mot.png");
        buffer = ImageIO.read(imageFile);
        /*addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mx = e.getX();
                my = e.getY();
                flicker = false;
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                mx = e.getX();
                my = e.getY();
                flicker = true;
                repaint();
            }
        });*/

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //System.out.println(flicker);
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if(flicker == true) flicker = false;
                    else flicker = true;
                    System.out.println(flicker);
                    repaint();
                }
            }
        });


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setSize(new Dimension(500, 500));
        setTitle("Double Buffer");
        setVisible(true);
        buffer = createImage(w, h);
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint() is called!");
        Graphics screengc = null;
        Clock clock = Clock.systemDefaultZone();
        Instant c1 = clock.instant();
        if(!flicker){
            screengc = g;
            g = buffer.getGraphics();
        }
        //g.setColor(Color.blue);
        //g.fillRect(0,0, w, h);
        g.setColor(Color.red);
        //g.drawLine(7, 30, w, h);
        //System.out.println(getInsets().left + " " + getInsets().top);
        int inX1 = getInsets().left;
        int inY1 = getInsets().top;
        for(int i = 0; i<h; i+=gap)
            g.drawLine(i+inX1, inY1, w-i, h);
        for(int i=0; i<w; i+=gap)
            g.drawLine(inX1, i+inY1, w, h-i);

        //g.setColor(Color.black);
        //g.drawString("Presss mouse button to double buffer", 10, h/2);

        //g.setColor(Color.yellow);
        //g.fillOval(mx - gap, my - gap, gap * 2+1, gap*2+1);
        if(!flicker){
            screengc.drawImage(buffer, 0,0, null);
            Instant c2 = clock.instant();
            long t = c2.getEpochSecond() - c1.getEpochSecond();
            screengc.drawString("Drawn in " + t + " sec", 10, 450);
        }
        Instant c2 = clock.instant();
        long t = c2.getEpochSecond() - c1.getEpochSecond();
        System.out.println("Drawn in " + t + " sec");
        g.drawString("Drawn in " + t + " sec", 10, 450);

    }

   /* @Override
    public void update(Graphics g) {
        System.out.println("update() is called!");
        paint(g);
    }*/

    public static void main(String[] args) throws IOException{
        DoubleBuffer appWin = new DoubleBuffer();



    }
}

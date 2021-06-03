import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public class HistoGrab extends Frame {
    Dimension d;
    Image img;
    int iw, ih;
    int pixels[];
    int hist[] = new int[256];
    int max_hist = 0;
    Insets ins;

    public HistoGrab(){
        try{
            File imageFile = new File("C:/Users/Mohammad Rashid/Pictures/mot.png");

            img = ImageIO.read(imageFile);
            iw = img.getWidth(null);
            ih = img.getHeight(null);
            pixels = new int[iw * ih];
            PixelGrabber pg = new PixelGrabber(img, 0, 0, iw, ih, pixels, 0, iw);
            pg.grabPixels();
        }
        catch (InterruptedException e){
            System.out.println("Interrupted");
            return;
        }
        catch (IOException e){
            System.out.println("Cannot loage image file.");
            System.exit(0);
        }

        for(int i = 0; i < iw*ih; i++){
            int p = pixels[i];
            int r = 0xff & (p >> 16);
            int g = 0xff & (p >> 8);
            int b = 0xff & (p);
            int y = (int) (.33 * r + .56 * g + .11 * b);
            hist[y]++;
        }

        for(int i = 0; i < 256; i++){
            if(hist[i] > max_hist)
                max_hist = hist[i];
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        ins = getInsets();
        g.drawImage(img, ins.left, ins.top, null);
        int x = (iw - 256) / 2;
        int lasty = ih - ih * hist[0] / max_hist;

        for(int i = 0;  i < 256; i++, x++){
            int y = ih - ih * hist[i] / max_hist;
            g.setColor(new Color(i, i, i));
            g.fillRect(x+ins.left, y+ins.top, 1, ih-y);
            g.setColor(Color.red);
            g.drawLine((x-1) + ins.left, lasty+ins.top, x+ins.left, y+ins.top);
            lasty = y;
        }
    }

    public static void main(String[] args) {
        HistoGrab appWin = new HistoGrab();
        appWin.setSize(new Dimension(appWin.iw, appWin.ih));
        appWin.setTitle("HistoGrab");
        appWin.setVisible(true);
    }
}

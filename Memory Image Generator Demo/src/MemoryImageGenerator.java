import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

public class MemoryImageGenerator extends Frame{
    Image img;
    int w = 512;
    int h = 512;
    boolean swt = true;
    public MemoryImageGenerator(){
        int pixels[] = new int[w * h];

        int i = 0;

        for(int y=0; y<h; y++){
            for(int x=0; x<w; x++){

                int r = (x^y)&0xff;
                int g = (x*2^y*2)&0xff;
                int b = (x*4^y*4)&0xff;
                pixels[i++] = (255 << 24) | (r << 16) | (g << 8) | b;
            }
        }
        /*for(int i = 0; i < h*w; i++){
            if(swt == true && i%32 == 0){
                pixels[i] = 0xffff0000;
                swt = false;
            }
            else{
                pixels[i] = 0xff0000ff;
                swt = true;
            }
        }*/
        /*for(int i = 0, c = 0, r = 1; i < 256*256; i++, c++){
            if(c == 256+(512*r)){
                System.out.println(c);
                c = c + (256);
                r++;
            }
            pixels[c] = 0xffff0000;
        }*/
        img = createImage(new MemoryImageSource(w, h, pixels, 0, w));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, getInsets().left, getInsets().top, null);
    }

    public static void main(String[] args) {
        MemoryImageGenerator appWin = new MemoryImageGenerator();
        appWin.setSize(new Dimension(512, 512));
        appWin.setTitle("MemoryImageGenerator");
        appWin.setVisible(true);
    }
}

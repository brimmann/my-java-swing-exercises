import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.*;

public class ImageGrabberDemo extends Frame {
    Image image, genImage;
    int ix;
    int iy;
    int outArr[];
    int inArr[];

    ImageGrabberDemo(){
        File imageFile = new File("C:/Users/Mohammad Rashid/Pictures/mot.png");
        try{
            image = ImageIO.read(imageFile);
        }
        catch(IOException e){
            System.out.println("Cannot load the image.");
            System.exit(0);
        }

        ix = image.getWidth(null);
        iy = image.getHeight(null);
        outArr = new int[ix*iy];
        inArr = new int[ix*iy];
        PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, ix, iy, inArr, 0, ix);
        try{
            pixelGrabber.grabPixels();
        }
        catch (InterruptedException e){
            System.out.println("Interrepted!");
            System.exit(0);
        }

        for(int i = 0; i < ix*iy; i++){
            outArr[i] = 0xffa8a8a8;
        }

        for(int i = 0; i < ix*iy; i++){
           /* if(inArr[i] >= 0xff8b9b02 && inArr[i] <= 0xfff4ff9b){

            }*/
            outArr[i] = inArr[i]/2;
            outArr[i] &= 0x00_ff_ff_ff;
            outArr[i] |= 0xff_00_00_00;
            //outArr[i] = inArr[i] & 0xff_ff_00_ff;
            //inArr[i] |= 0xff_00_0b_ff;

            System.out.println(Integer.toHexString(outArr[i]));

        }
        genImage = createImage(new MemoryImageSource(ix, iy, outArr, 0, ix));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(genImage, getInsets().left, getInsets().top, null);
    }

    public static void main(String[] args) {
        ImageGrabberDemo appWin = new ImageGrabberDemo();
        appWin.setSize(appWin.ix, appWin.iy);
        appWin.setTitle("ImageGrabberDem");
        appWin.setVisible(true);
    }
}

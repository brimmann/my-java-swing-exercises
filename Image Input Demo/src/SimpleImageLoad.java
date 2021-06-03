import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
public class SimpleImageLoad extends Frame{
    Image img;

    public SimpleImageLoad(){
        try{
            File imageFile = new File("C:/Users/Mohammad Rashid/Pictures/mot.png");
            img = ImageIO.read(imageFile);
        }catch (IOException exc){
            System.out.println("Cannot load image file.");
            System.exit(0);
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g){
        g.drawImage(img, getInsets().left, getInsets().top, null);
    }

    public static void main(String[] args){
        SimpleImageLoad appWin = new SimpleImageLoad();
        appWin.setSize(appWin.img.getWidth(null), appWin.img.getHeight(null));
        appWin.setTitle("SimpleImageLoad");

        appWin.setVisible(true);
    }
}

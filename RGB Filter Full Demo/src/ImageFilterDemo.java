//This Demo is incomplete. Contrast, Blur and Sharpen filters must be developed and understood.Also the written codes must be understood.

import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import java.lang.reflect.*;

public class ImageFilterDemo extends Frame implements ActionListener{
    Image img;
    PlugInFilter pif;
    Image fimg;
    Image curImg;
    LoadedImage lim;
    Label lab;
    Button reset;

    String[] filters = {"Grayscale", "Invert", "Contrast", "Blur", "Sharpen"};

    public ImageFilterDemo(){
        Panel p = new Panel();
        add(p, BorderLayout.SOUTH);

        reset = new Button("Reset");
        reset.addActionListener(this);
        p.add(reset);

        for(String fstr: filters){
            Button b = new Button(fstr);
            b.addActionListener(this);
            p.add(b);
        }

        lab = new Label("");
        add(lab, BorderLayout.NORTH);

        try{
            File imageFile = new File("C:/Users/Mohammad Rashid/Pictures/mot.jpg");
            img = ImageIO.read(imageFile);
        }
        catch (IOException e){
            System.out.println("Cannot load image file.");
            System.exit(0);
        }

        lim = new LoadedImage(img);
        add(lim, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a = "";

        try{
            a = e.getActionCommand();
            if(a.equals("Reset")){
                lim.set(img);
                lab.setText("Normal");
            }
            else{
                pif = (PlugInFilter) (Class.forName(a).getConstructor().newInstance());
                fimg = pif.filter(this, img);
                lim.set(fimg);
                lab.setText("Filtered: " + a);
            }
            repaint();
        }
        catch (ClassNotFoundException exc){
            lab.setText(a + " not found");
            lim.set(img);
            repaint();
        }
        catch (InstantiationException exc){
            lab.setText("couldn't new " + a);
        }
        catch (IllegalAccessException exc){
            lab.setText("no access: " + a);
        }
        catch(NoSuchMethodException | InvocationTargetException exc)
        {
            lab.setText("Filter creation erro: " + exc);
        }
    }

    public static void main(String[] args) {
        ImageFilterDemo appWin = new ImageFilterDemo();
        appWin.setSize(new Dimension(420, 420));
        appWin.setTitle("ImageFilterDemo");
        appWin.setVisible(true);
    }
}

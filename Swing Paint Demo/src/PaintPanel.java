import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class PaintPanel extends JPanel{
    Insets ins;
    Random rand;
    PaintPanel(){
        //setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        rand = new Random();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x, y, x2, y2;
        int height = getHeight();
        int width = getWidth();

        ins = getInsets();

        for(int i = 0; i < 10; i++){
            x = rand.nextInt(width);
            System.out.println(ins.top);
            y = rand.nextInt(height);
            x2 = rand.nextInt(width);
            y2 = rand.nextInt(height);

            g.drawLine(x, y, x2, y2);
        }
    }
}



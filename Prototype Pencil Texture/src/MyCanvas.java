import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Map;

public class MyCanvas extends Canvas {
    private int mouseX, mouseY;
    private Point prePoint;
    private boolean connect = false;
    private int count = 0;
    private ArrayList<Point> points = new ArrayList<Point>();
    MyCanvas(){
        super();
    }

    /*@Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.addRenderingHints(rh);

        count++;
        if(connect){
            g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            Line2D.Double co = new Line2D.Double(prePoint.x+2.5, prePoint.y+2.5, mouseX+2.5, mouseY+2.5);
            g2d.draw(co);

        }
        Ellipse2D.Double oval = new Ellipse2D.Double(mouseX, mouseY, 5, 5);
        g2d.setStroke(new BasicStroke(0));
        g2d.fill(oval);
        g2d.draw(oval);
        prePoint = new Point(mouseX, mouseY);
        connect = true;
    }*/

    @Override
    public void update(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.addRenderingHints(rh);

        count++;
        if(connect){
            g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            Line2D.Double co = new Line2D.Double(prePoint.x+2.5, prePoint.y+2.5, mouseX+2.5, mouseY+2.5);
            g2d.draw(co);

        }
        /*Ellipse2D.Double oval = new Ellipse2D.Double(mouseX, mouseY, 5, 5);
        g2d.setStroke(new BasicStroke(0));
        g2d.fill(oval);
        g2d.draw(oval);*/
        prePoint = new Point(mouseX, mouseY);
        connect = true;

    }

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPrePoint(Point prePoint) {
        this.prePoint = prePoint;
    }

    public boolean isConnect() {
        return connect;
    }

    public void setConnect(boolean connect) {
        this.connect = connect;
    }
}


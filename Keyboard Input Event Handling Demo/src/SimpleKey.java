import java.awt.*;
import java.awt.event.*;
public class SimpleKey extends Frame implements KeyListener {
    String msg = "";
    String keyState = "";

    public SimpleKey() {
        addKeyListener(this);
        addWindowListener(new MyWindowAdapter());

    }


    @Override
    public void keyTyped(KeyEvent e) {
        /*int a = (int) e.getKeyChar();
        msg += Integer.toString(a) + " ";*/
        msg += e.getKeyChar();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyState = "Key Down";
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_F1:
                msg += "<F1>";
                break;
            case KeyEvent.VK_F2:
                msg += "<F2>";
                break;
            case KeyEvent.VK_F3:
                msg += "<F3>";
                break;
            case KeyEvent.VK_PAGE_DOWN:
                msg += "<PgDn>";
                break;
            case KeyEvent.VK_PAGE_UP:
                msg += "<PgUp>";
                break;
            case KeyEvent.VK_LEFT:
                msg += "<Left Arrow>";
                break;
            case KeyEvent.VK_RIGHT:
                msg += "<Right Arrow>";
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyState = "Key Up";
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 100);
        g.drawString(keyState, 20, 50);
    }

    public static void main(String[] args){
        SimpleKey appWin = new SimpleKey();

        appWin.setSize(new Dimension(200, 150));
        appWin.setTitle("SimpleKey");
        appWin.setVisible(true);
    }
}

class MyWindowAdapter extends WindowAdapter{
    public void windowClosing(WindowEvent we){
        System.exit(0);
    }
}


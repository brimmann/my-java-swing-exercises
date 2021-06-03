import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyMouseAdapter extends MouseAdapter {
    MousePressedDemo mousePressedDemo;

    public MyMouseAdapter(MousePressedDemo adapterDemo){
        this.mousePressedDemo = mousePressedDemo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Component a = e.getComponent();
        Object a = e.getSource();
        //if(a instanceof AdapterDemo) AdapterDemo b = (AdapterDemo) a;
        MousePressedDemo b = (MousePressedDemo) a;

        b.msg = "Mouse Clicked";
        b.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mousePressedDemo.msg = "Mouse Dragged";
        mousePressedDemo.repaint();
        Label label = new Label();
        label.setText("s");

    }
}

class MyWindowAdapter extends WindowAdapter{
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

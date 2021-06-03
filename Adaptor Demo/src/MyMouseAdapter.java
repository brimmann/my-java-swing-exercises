import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyMouseAdapter extends MouseAdapter {
    AdapterDemo adapterDemo;

    public MyMouseAdapter(AdapterDemo adapterDemo){
        this.adapterDemo = adapterDemo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Component a = e.getComponent();
        Object a = e.getSource();
        //if(a instanceof AdapterDemo) AdapterDemo b = (AdapterDemo) a;
        AdapterDemo b = (AdapterDemo) a;

        b.msg = "Mouse Clicked";
        b.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        adapterDemo.msg = "Mouse Dragged";
        adapterDemo.repaint();
    }
}

class MyWindowAdapter extends WindowAdapter{
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

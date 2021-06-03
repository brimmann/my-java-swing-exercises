import java.awt.*;
import java.awt.event.*;

public class GridLayoutDemo extends Frame {
    static final int n = 4;
    public GridLayoutDemo(){
        setLayout(new GridLayout(n,n));
        setFont(new Font("SansSerif", Font.BOLD, 24));
        for(int i = 1; i < n*n; i++){
            add(new Button("" + i));
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        GridLayoutDemo appWin = new GridLayoutDemo();
        appWin.setSize(new Dimension(300, 220));
        appWin.setTitle("GridLayoutDemo");
        appWin.setVisible(true);
    }

}

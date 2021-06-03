import java.awt.*;

public class OnlyLabelTest extends Label {
    OnlyLabelTest(){
        super("Hello World!");
        Container container = new Frame();
        container.add(this);
        container.setVisible(true);
    }

    public static void main(String[] args) {
        new OnlyLabelTest();
    }
}

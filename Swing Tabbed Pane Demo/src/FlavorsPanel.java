import javax.swing.*;

public class FlavorsPanel extends JPanel {
    public FlavorsPanel(){
        JComboBox<String> jcb = new JComboBox<String>();
        jcb.addItem("Vanilla");
        jcb.addItem("Chocolate");
        jcb.addItem("Strawberry");
        add(jcb);
    }
}

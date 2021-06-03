import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.nio.ByteOrder;

public class BeepDemo extends JFrame{
    JButton beepBtn;
    public BeepDemo(){
        setTitle("Beep Demo");
        setSize(100, 100);
        //setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //BorderLayout bLayout = new BorderLayout();
        //setLayout(bLayout);

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(new BorderLayout());


        /*JButton b2 = new JButton("Test");
        gridBagLayout.setConstraints(b2, gridBagConstraints);
        add(b2);*/
        //pack();


        /*Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Toolkit.getDefaultToolkit().beep();
                System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
            }
        };*/

        class Test extends AbstractAction{
            Test(Icon a, String n, int k){
                super(n, a);
                putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(k, 0));
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                Toolkit.getDefaultToolkit().beep();
                System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
                System.out.println(e.getActionCommand());
            }
        }
        Test action = new Test(null, "Beep", KeyEvent.VK_B);
        action.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_B, 0));
        beepBtn = new JButton(action);
        JToolBar tb = new JToolBar();
        tb.add(beepBtn);
        //beepBtn.setName("Beep");
        beepBtn.getActionMap().put(beepBtn.getActionCommand(), action);
        beepBtn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) action.getValue(Action.ACCELERATOR_KEY), beepBtn.getActionCommand());
        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        //gridBagConstraints.weightx = 1;
        //gridBagConstraints.weighty = 1;
        //gridBagConstraints.insets = new Insets(0, 0, 0, 50);
        gridBagLayout.setConstraints(beepBtn, gridBagConstraints);
        add(tb, BorderLayout.NORTH);
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel("I'm Label"), BorderLayout.CENTER);
        add(p);

        //JPanel panel = new JPanel();
        //BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.X_AXIS);
        //panel.add(beepBtn);
        //add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BeepDemo();
            }
        });
    }
}

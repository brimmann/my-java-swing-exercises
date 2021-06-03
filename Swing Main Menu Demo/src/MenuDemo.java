import java.awt.*;
import java.awt.desktop.SystemSleepEvent;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.concurrent.ThreadPoolExecutor;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.metal.MetalIconFactory;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MenuDemo implements ActionListener{
    JLabel jlab;
    JPopupMenu jpu;
    class DebugAction extends AbstractAction{
        public DebugAction(String name, Icon image, int mnem, int accel, String tTip){
            super(name, image);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(accel, InputEvent.CTRL_DOWN_MASK));
            putValue(MNEMONIC_KEY, mnem);
            putValue(SHORT_DESCRIPTION, tTip);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String comStr = e.getActionCommand();
            jlab.setText(comStr + " Selected");

            if(comStr.equals("Set Breakpoint")){
                clearAct.setEnabled(true);
                setAct.setEnabled(false);
            }else if(comStr.equals("Clear Breakpoint")){
                clearAct.setEnabled(false);
                setAct.setEnabled(true);
            }
        }
    }
    //Image setWA, clearWA, resumeWA;
    //Image setImage, clearImage, resumeImage;
    DebugAction setAct;
    DebugAction clearAct;
    DebugAction resumeAct;


    MenuDemo(){
        //MetalLookAndFeel.setCurrentTheme(new );


        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        //JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame jfrm = new JFrame("Menu Demo");

        jfrm.setLayout(new BorderLayout());
        jfrm.setSize(220, 200);

        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jlab = new JLabel();

        JMenuBar jmb = new JMenuBar();
        JMenu jmFile = new JMenu("File");
        jmFile.setMnemonic(KeyEvent.VK_F);
        JMenuItem jmiOpen = new JMenuItem("Open", KeyEvent.VK_O);
        //jmiOpen.setHorizontalAlignment(SwingConstants.LEFT);

        jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));

        JMenuItem jmiClose = new JMenuItem("Close", KeyEvent.VK_C);
        jmiClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));

        JMenuItem jmiSave = new JMenuItem("Save", KeyEvent.VK_S);

        //jmiSave.setIcon(new ImageIcon("D:/Hourglass.png"));
        jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));

        JMenuItem jmiExit = new JMenuItem("Exit", KeyEvent.VK_E);
        jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        jmFile.add(jmiOpen);
        jmFile.add(jmiClose);
        jmFile.add(jmiSave);
        jmFile.addSeparator();
        jmFile.add(jmiExit);
        jmb.add(jmFile);

        /*JMenu jmOptions = new JMenu("Option");
        JMenu jmColors = new JMenu("Colors");
        JMenuItem jmiRed = new JMenuItem("Red");
        JMenuItem jmiGreen = new JMenuItem("Green");
        JMenuItem jmiBlue = new JMenuItem("Blue");

        jmColors.add(jmiRed);
        jmColors.add(jmiGreen);
        jmColors.add(jmiBlue);
        jmOptions.add(jmColors);

        JMenu jmPriority = new JMenu("Priority");
        JMenuItem jmiHigh = new JMenuItem("High");
        JMenuItem jmiLow = new JMenuItem("Low");
        jmPriority.add(jmiHigh);
        jmPriority.add(jmiLow);
        jmOptions.add(jmPriority);

        JMenuItem jmiReset = new JMenuItem("Reset");
        jmOptions.addSeparator();
        jmOptions.add(jmiReset);
        jmb.add(jmOptions);*/

        JMenu jmOption = new JMenu("Options");

        JMenu jmColors = new JMenu("Colors");

        JCheckBoxMenuItem jmiRed = new JCheckBoxMenuItem("Red");
        JCheckBoxMenuItem jmiGreen = new JCheckBoxMenuItem("Green");
        JCheckBoxMenuItem jmiBlue = new JCheckBoxMenuItem("Blue");

        jmColors.add(jmiRed);
        jmColors.add(jmiGreen);
        jmColors.add(jmiBlue);
        jmOption.add(jmColors);

        JMenu jmPriority = new JMenu("Priority");

        JRadioButtonMenuItem jmiHigh = new JRadioButtonMenuItem("High", true);
        JRadioButtonMenuItem jmiLow = new JRadioButtonMenuItem("Low");

        jmPriority.add(jmiHigh);
        jmPriority.add(jmiLow);
        jmOption.add(jmPriority);

        ButtonGroup bg = new ButtonGroup();
        bg.add(jmiHigh);
        bg.add(jmiLow);

        JMenuItem jmiReset = new JMenuItem("Reset");
        jmOption.addSeparator();
        jmOption.add(jmiReset);

        jmb.add(jmOption);

        JMenu jmHelp = new JMenu("Help");
        JMenuItem jmiAbout = new JMenuItem("About");
        jmHelp.add(jmiAbout);
        jmb.add(jmHelp);

        jmiOpen.addActionListener(this);
        jmiClose.addActionListener(this);
        jmiSave.addActionListener(this);
        jmiExit.addActionListener(this);
        jmiRed.addActionListener(this);
        jmiGreen.addActionListener(this);
        jmiBlue.addActionListener(this);
        jmiHigh.addActionListener(this);
        jmiLow.addActionListener(this);
        jmiReset.addActionListener(this);
        jmiAbout.addActionListener(this);


        jpu = new JPopupMenu();

        JMenuItem jmiCut = new JMenuItem("Cut");
        JMenuItem jmiCopy = new JMenuItem("Copy");
        JMenuItem jmiPaste = new JMenuItem("Paste");
        jmiCut.addActionListener(this);
        jmiCopy.addActionListener(this);
        jmiPaste.addActionListener(this);
        jpu.add(jmiCut);
        jpu.add(jmiCopy);
        jpu.add(jmiPaste);

        jfrm.addMouseListener(new MouseAdapter() {
            /*@Override
            public void mousePressed(MouseEvent e) {
                if(e.isPopupTrigger())
                    jpu.show(e.getComponent(), e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.isPopupTrigger())
                    jpu.show(e.getComponent(), e.getX(), e.getY());
            }*/

            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON3) jpu.show(e.getComponent(), e.getX(), e.getY());
                System.out.println(e.getButton());
            }


        });

        //JToolBar jtb = new JToolBar("Debug");
        ImageIcon set = new ImageIcon("D:/gif/Create.gif");
        ImageIcon clear = new ImageIcon("D:/gif/Erase.gif");
        ImageIcon resume = new ImageIcon("D:/gif/Go.gif");
        int[] setArr, clearArr, resumeArr;

       /* setArr = new int[24*24];
        clearArr = new int[24*24];
        resumeArr = new int[24*24];
        try{
            setImage = ImageIO.read(new File("D:/gif/Create.gif"));
            clearImage = ImageIO.read(new File("D:/gif/Erase.gif"));
            resumeImage = ImageIO.read(new File("D:/gif/Go.gif"));

        }
        catch (IOException e){
            System.out.println("Image cannot be loaded");
        }
        PixelGrabber setPG = new PixelGrabber(setImage, 0, 0, 24, 24, setArr, 0, 24);
        PixelGrabber clearPG = new PixelGrabber(clearImage, 0, 0, 24, 24, clearArr, 0, 24);
        PixelGrabber resumePG = new PixelGrabber(resumeImage, 0, 0, 24, 24, resumeArr, 0, 24);

        try{


            setPG.grabPixels();
            clearPG.grabPixels();
            resumePG.grabPixels();
            for(int i = 0; i < 24*24; i++){
                setArr[i] = setArr[i] & 0x00_ff_ff_ff;
                clearArr[i] = clearArr[i] & 0x00_ff_ff_ff;
                resumeArr[i] = clearArr[i] & 0x00_ff_ff_ff;
            }
        }
        catch (Exception e){
            System.out.println("Error Occured!");
        }
        setWA = jfrm.createImage(new MemoryImageSource(24, 24, setArr, 0, 24 ));
        clearWA = jfrm.createImage(new MemoryImageSource(24, 24, clearArr, 0, 24));
        resumeWA = jfrm.createImage(new MemoryImageSource(24, 24, resumeArr, 0, 24));
        set = new ImageIcon(setWA);
        clear = new ImageIcon(clearWA);
        resume = new ImageIcon(resumeWA);*/

        /*JButton jbtnSet = new JButton(set);
        jbtnSet.setActionCommand("Set Breakpoint");
        jbtnSet.setToolTipText("Set a Breakpoint");

        JButton jbtnClear = new JButton(clear);
        jbtnClear.setActionCommand("Clear Breakpoint");
        jbtnClear.setToolTipText("Clear the Breakpoint");
        JButton jbtnResume = new JButton(resume);
        jbtnResume.setActionCommand("Resume");
        jbtnResume.setToolTipText("Resume from the created breakpoint");
        jbtnSet.addActionListener(this);
        jbtnClear.addActionListener(this);
        jbtnResume.addActionListener(this);


        jtb.add(jbtnSet);
        jtb.add(jbtnClear);
        jtb.add(jbtnResume);
        jtb.setBackground(Color.white);
        jtb.setBorderPainted(false);
        jfrm.add(jtb, BorderLayout.NORTH);
        jfrm.add(jlab, BorderLayout.CENTER);*/


        setAct = new DebugAction("Set Breakpoint", set, KeyEvent.VK_S, KeyEvent.VK_B, "Set a break point.");
        clearAct = new DebugAction("Clear Breakpoint",clear, KeyEvent.VK_C, KeyEvent.VK_L, "Clear a break point.");
        resumeAct = new DebugAction("Resume", resume, KeyEvent.VK_R, KeyEvent.VK_R, "Resume executionn after breakpoint.");
        clearAct.setEnabled(false);
        // Create the toolbar buttons by using the actions.
        JButton jbtnSet = new JButton(setAct);
        JButton jbtnClear = new JButton(clearAct);
        JButton jbtnResume = new JButton(resumeAct);
        // Create a Debug toolbar.
        JToolBar jtb = new JToolBar("Breakpoints");
        // Add the buttons to the toolbar.
        jtb.add(jbtnSet);
        jtb.add(jbtnClear);
        jtb.add(jbtnResume);
        // Add the toolbar to the north position of
        // the content pane.
        jfrm.add(jtb, BorderLayout.NORTH);
        jfrm.add(jlab, BorderLayout.CENTER);
        JMenu jmDebug = new JMenu("Debug");
        JMenuItem jmiSetBP = new JMenuItem(setAct);
        JMenuItem jmiClearBP = new JMenuItem(clearAct);
        JMenuItem jmiResume = new JMenuItem(resumeAct);
        jmDebug.add(jmiSetBP);
        jmDebug.add(jmiClearBP);
        jmDebug.add(jmiResume);
        jmOption.add(jmDebug);

        jfrm.setJMenuBar(jmb);
        jfrm.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String comStr = e.getActionCommand();

        if(comStr.equals("Exit")) System.exit(0);
        jlab.setText(comStr + " Selected");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuDemo();
            }
        });
    }
}


package keypadFromScratch;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class KeyPadFrame extends JFrame {
    private static final short FRAME_WIDTH = 270;
    private static final short FRAME_HEIGHT = 320;
    private static final Dimension OUTER_PANEL_DIM =
            new Dimension(FRAME_WIDTH, FRAME_HEIGHT);
    
    private static final Dimension BUTTONS_PANEL_DIM = new Dimension(270, 280); 
    private static final Dimension BUTTON_DIM = new Dimension(90, 70); 
    private static final Dimension DISPLAY_PANEL_DIM = new Dimension(270, 40);
    private static final Color DARK = new Color(51, 51, 51);
    private static final Color LIGHT = new Color(204, 204, 204);
    
    private JTextField display;
    private JPanel outerPanel, displayPanel, buttonsPanel;
    private JButton one, two, three, four, five, six, seven, eight, nine, zero, clear;
    private JToggleButton secondF;
    
   /**
    * Constructs the Frame
    */
    public KeyPadFrame() {
        createComponents();
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLocation(400,200);
        this.setResizable(false);
        this.setTitle("Basic Acceptable Keypad");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Initializes the components
     */
    private void createComponents() {
        //Create the panels
        outerPanel = new JPanel();
        outerPanel.setLayout(new BorderLayout());
        outerPanel.setBackground(DARK);
        outerPanel.setSize(OUTER_PANEL_DIM);
        
        displayPanel = new JPanel();
        displayPanel.setBackground(DARK);
        displayPanel.setSize(DISPLAY_PANEL_DIM);
        GridLayout gr = new GridLayout();
        gr.setHgap(2);
        gr.setVgap(2);
        displayPanel.setLayout(gr);
        
        buttonsPanel = new JPanel();
        buttonsPanel.setBackground(DARK);
        GridLayout bl = new GridLayout(4, 3);
        bl.setHgap(2);
        bl.setVgap(2);
        buttonsPanel.setLayout(bl);
        buttonsPanel.setPreferredSize(BUTTONS_PANEL_DIM);
        
        //Create the display and add it to the displayPanel
        display = new JTextField();
        display.setPreferredSize(DISPLAY_PANEL_DIM);
        display.setBackground(DARK);
        display.setForeground(LIGHT);
        display.setFont(new Font("Dialog", 1, 14));
        displayPanel.add(display); //Yep
        
        //Create the buttons
        one = new JButton();
        one.setBackground(DARK);
        one.setPreferredSize(BUTTON_DIM);
        one.setIcon(new ImageIcon(getClass().getResource("/keypad/1.png")));
        one.addActionListener(new oneButtonListener());
        
        two = new JButton();
        two.setBackground(DARK);
        two.setIcon(new ImageIcon(getClass().getResource("/keypad/2.png")));
        
        three = new JButton();
        three.setBackground(DARK);
        three.setIcon(new ImageIcon(getClass().getResource("/keypad/3.png")));
        
        four = new JButton();
        four.setBackground(DARK);
        four.setIcon(new ImageIcon(getClass().getResource("/keypad/4.png")));
        
        five = new JButton();
        five.setBackground(DARK);
        five.setIcon(new ImageIcon(getClass().getResource("/keypad/5.png")));
        
        six = new JButton();
        six.setBackground(DARK);
        six.setIcon(new ImageIcon(getClass().getResource("/keypad/6.png")));
        
        seven = new JButton();
        seven.setBackground(DARK);
        seven.setIcon(new ImageIcon(getClass().getResource("/keypad/7.png")));
       
        eight = new JButton();
        eight.setBackground(DARK);
        eight.setIcon(new ImageIcon(getClass().getResource("/keypad/8.png")));
        
        nine = new JButton();
        nine.setBackground(DARK);
        nine.setIcon(new ImageIcon(getClass().getResource("/keypad/9.png")));
        
        zero = new JButton();
        zero.setBackground(DARK);
        zero.setIcon(new ImageIcon(getClass().getResource("/keypad/0.png")));
        
        clear = new JButton();
        clear.setBackground(DARK);
        clear.setIcon(new ImageIcon(getClass().getResource("/keypad/CE.png")));
        clear.addActionListener(new clearButtonListener());
        
        secondF = new JToggleButton();
        secondF.setBackground(DARK);
        secondF.setIcon(new ImageIcon(getClass().getResource("/keypad/2ND.png")));

        //Add the buttons to the buttons Panel
        buttonsPanel.add(one);
        buttonsPanel.add(two);
        buttonsPanel.add(three);
        buttonsPanel.add(four);
        buttonsPanel.add(five);
        buttonsPanel.add(six);
        buttonsPanel.add(seven);
        buttonsPanel.add(eight);
        buttonsPanel.add(nine);
        buttonsPanel.add(secondF);
        buttonsPanel.add(zero);
        buttonsPanel.add(clear);
        
        //Add the inputPanel and ButtonsPanel to the outerPanel with Border Layout
        outerPanel.add(displayPanel, BorderLayout.NORTH);
        outerPanel.add(buttonsPanel, BorderLayout.SOUTH);
        
        //Add outer panel to the Frame
        this.add(outerPanel);
        
    }
    
    //inner class for the one Button Listener
    class oneButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            display.setText(display.getText() + "1");
        }
    }
    
    //inner class for the clear Button Listener
    class clearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            display.setText("");
        }
    }
    
    //Programming logic of other buttons ommited...
}

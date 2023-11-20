package cash_machine;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Class represents message display buttons and related functionality.
 *
 * @author Martin Dekanovský
 */
public class MessageDisplayButtons extends JPanel {

    private static JButton A_Button;
    private static JButton B_Button;
    private static JButton C_Button;

    /**
     * Constructor for creating message display buttons.
     */
    public MessageDisplayButtons() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        A_Button = new JButton("A");
        add(A_Button);

        B_Button = new JButton("B");
        add(B_Button);

        C_Button = new JButton("C");
        add(C_Button);
    }

    /**
     * Method for adding an action listener.
     *
     * @param button for which an action listener is added.
     * @param event action listener.
     */
    public static void addButtonActionListener(String button, ActionListener event) {
        switch (button) {
            case "A" -> A_Button.addActionListener(event);
            case "B" -> B_Button.addActionListener(event);
            case "C" -> C_Button.addActionListener(event);
        }
    }

    /**
     * Method for removing an action listener.
     *
     * @param A action listener for button A.
     * @param B action listener for button B.
     * @param C action listener for button C.
     */
    public static void removeButtonActionListeners(ActionListener A, ActionListener B, ActionListener C) {
        A_Button.removeActionListener(A);
        B_Button.removeActionListener(B);
        C_Button.removeActionListener(C);
    }
}
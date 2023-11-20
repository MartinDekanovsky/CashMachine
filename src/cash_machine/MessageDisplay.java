package cash_machine;

import javax.swing.*;

/**
 * Class represents the display where cash machine messages for user are displayed and related functionality.
 *
 * @author Martin Dekanovský
 */
public class MessageDisplay extends JPanel {

    private static JTextArea messageDisplay;

    /**
     * Constructor for creating message display.
     */
    public MessageDisplay() {
        messageDisplay = new JTextArea(6, 20);
        messageDisplay.setEditable(false);
        add(messageDisplay);
    }

    /**
     * Method for setting the text displayed on message display.
     *
     * @param text to be displayed on message display.
     */
    public static void setMessageDisplayText(String text) {
        messageDisplay.setText(text);
    }
}
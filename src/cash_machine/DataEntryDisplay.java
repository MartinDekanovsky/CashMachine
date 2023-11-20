package cash_machine;

import javax.swing.*;
import java.awt.*;

/**
 * Class represents the display where user input is displayed and related functionality.
 *
 * @author Martin Dekanovský
 */
public class DataEntryDisplay extends JPanel {

    private static JTextField dataEntryDisplay;

    /**
     * Constructor for creating display.
     */
    public DataEntryDisplay() {
        dataEntryDisplay = new JTextField(15);
        dataEntryDisplay.setLayout(new BorderLayout());
        add(dataEntryDisplay);
    }

    /**
     * Method for updating displayed text by appending numbers and decimal separator as clicked by user.
     *
     * @param text to be appended.
     */
    public static void appendToDataEntryDisplay(String text) {
        dataEntryDisplay.setText(dataEntryDisplay.getText() + text);
    }

    /**
     * Method returns displayed text.
     *
     * @return displayed text.
     */
    public static String getDataEntryDisplayText() {
        return dataEntryDisplay.getText();
    }

    /**
     * Method for clearing the display.
     */
    public static void clearDataEntryDisplay() {
        dataEntryDisplay.setText("");
    }
}
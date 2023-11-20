package cash_machine;

import javax.swing.*;
import java.awt.*;

/**
 * Class represents the keyboard user interacts with.
 *
 * @author Martin Dekanovský
 */
public class Keyboard extends JPanel {

    /**
     * Constructor for creating the keyboard.
     */
    public Keyboard() {
        setLayout(new GridLayout(4, 3));

        String[] buttons = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "."};

        for (String buttonText : buttons) {
            JButton button = new JButton(buttonText);
            button.addActionListener(event -> DataEntryDisplay.appendToDataEntryDisplay(buttonText));
            add(button);
        }

        JButton clearEntryButton = new JButton("CE");
        clearEntryButton.addActionListener(event -> DataEntryDisplay.clearDataEntryDisplay());
        add(clearEntryButton);
    }
}
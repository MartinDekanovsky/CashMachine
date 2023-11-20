package cash_machine;

import javax.swing.*;
import java.io.IOException;

/**
 * Class represents a test class for CashMachine class and related classes.
 *
 * @author Martin Dekanovský
 */
public class Tester {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try {
                new CashMachine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
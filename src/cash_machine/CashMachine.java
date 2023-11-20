package cash_machine;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

/**
 * Class represents the basic understanding of GUI and functionality of real-life cash machine.
 *
 * @author Martin Dekanovský
 */
public class CashMachine extends JFrame {

    /**
     * Constructor for creating cash machine GUI.
     *
     * @throws FileNotFoundException
     */
    public CashMachine() throws FileNotFoundException {
        setTitle("Bank of Slovakia");
        setLayout(new BorderLayout());
        setSize(470, 180);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        add(container);

        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.add(new DataEntryDisplay(), BorderLayout.NORTH);
        panel1.add(new Keyboard(), BorderLayout.SOUTH);
        container.add(panel1);

        JPanel panel2 = new JPanel(new GridBagLayout());
        panel2.add(new MessageDisplay());
        container.add(panel2);

        JPanel panel3 = new JPanel(new GridBagLayout());
        panel3.add(new MessageDisplayButtons());
        container.add(panel3);

        checkID();
    }

    /**
     * Method for checking whether input ID is valid.
     */
    public static void checkID() {
        MessageDisplay.setMessageDisplayText("Please enter your ID.\nA = OK\nC = End");
        ActionListeners.checkID_ButtonsActions();
    }

    /**
     * Method for checking whether input PIN is correct.
     */
    public static void checkPIN() {
        MessageDisplay.setMessageDisplayText("Please enter your PIN.\nA = OK");
        ActionListeners.checkPIN_ButtonsActions();
    }

    /**
     * Method for choosing account.
     */
    public static void chooseAccount() {
        MessageDisplay.setMessageDisplayText("Please choose account.\nA = Current\nB = Saving\nC = Logout");
        ActionListeners.chooseAccount_ButtonsActions();
    }

    /**
     * Method for choosing transaction.
     */
    public static void chooseTransaction() {
        ActionListeners.chooseTransaction_ButtonsActions();
    }
}
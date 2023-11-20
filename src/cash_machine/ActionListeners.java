package cash_machine;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * Class represents different action listeners for message display buttons depending on cash machine state.
 *
 * @author Martin Dekanovský
 */
public class ActionListeners {

    private static Bank bank;

    static {
        try {
            bank = new Bank();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Client client;
    private static String account;
    private static double balance;

    private static ActionListener A_ButtonEvent;
    private static ActionListener B_ButtonEvent;
    private static ActionListener C_ButtonEvent;

    /**
     * Method for adding checkID() action listeners.
     */
    public static void checkID_ButtonsActions() {
        MessageDisplayButtons.removeButtonActionListeners(A_ButtonEvent, B_ButtonEvent, C_ButtonEvent);

        MessageDisplayButtons.addButtonActionListener("A", A_ButtonEvent = checkID -> {
            String input = DataEntryDisplay.getDataEntryDisplayText();
            if (!input.isEmpty() && input.matches("^\\d*$") && bank.findClient(Integer.parseInt(input)) != null) {
                client = bank.findClient(Integer.parseInt(input));
                CashMachine.checkPIN();
            } else {
                MessageDisplay.setMessageDisplayText("Invalid ID!\nPlease enter your ID.\nA = OK");
            }
            DataEntryDisplay.clearDataEntryDisplay();
        });

        MessageDisplayButtons.addButtonActionListener("C", C_ButtonEvent = end -> System.exit(0));
    }

    /**
     * Method for adding checkPIN() action listeners.
     */
    public static void checkPIN_ButtonsActions() {
        MessageDisplayButtons.removeButtonActionListeners(A_ButtonEvent, B_ButtonEvent, C_ButtonEvent);

        MessageDisplayButtons.addButtonActionListener("A", A_ButtonEvent = checkPIN -> {
            String input = DataEntryDisplay.getDataEntryDisplayText();
            if (!input.isEmpty() && input.matches("^\\d*$") && Integer.parseInt(input) == client.getPIN()) {
                CashMachine.chooseAccount();
            } else {
                MessageDisplay.setMessageDisplayText("Incorrect PIN!\nPlease enter correct PIN.\nA = OK");
            }
            DataEntryDisplay.clearDataEntryDisplay();
        });
    }

    /**
     * Method for adding chooseAccount() action listeners.
     */
    public static void chooseAccount_ButtonsActions() {
        MessageDisplayButtons.removeButtonActionListeners(A_ButtonEvent, B_ButtonEvent, C_ButtonEvent);

        MessageDisplayButtons.addButtonActionListener("A", A_ButtonEvent = currentAccount -> {
            account = "Current";
            balance = client.getCurrentAccountBalance();
            MessageDisplay.setMessageDisplayText("Balance: " + balance + " Eur");
            CashMachine.chooseTransaction();
        });

        MessageDisplayButtons.addButtonActionListener("B", B_ButtonEvent = savingAccount -> {
            account = "Saving";
            balance = client.getSavingAccountBalance();
            MessageDisplay.setMessageDisplayText("Balance: " + balance + " Eur");
            CashMachine.chooseTransaction();
        });

        MessageDisplayButtons.addButtonActionListener("C", C_ButtonEvent = logout -> {
            try {
                Bank.updateClientList(client);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            CashMachine.checkID();
        });
    }

    /**
     * Method for adding chooseTransaction() action listeners.
     */
    public static void chooseTransaction_ButtonsActions() {
        MessageDisplayButtons.removeButtonActionListeners(A_ButtonEvent, B_ButtonEvent, C_ButtonEvent);

        String message = " Eur\nEnter amount and choose transaction.\nA = Deposit\nB = Withdraw\nC = Back";
        MessageDisplay.setMessageDisplayText("Balance: " + balance + message);

        MessageDisplayButtons.addButtonActionListener("A", A_ButtonEvent = deposit -> {
            String amount = DataEntryDisplay.getDataEntryDisplayText();
            if (!amount.isEmpty() && amount.matches("^(\\d+(?:.\\d{1,2})?)")) {
                balance = Math.round((balance + Double.parseDouble(amount)) * 100.0) / 100.0;
                MessageDisplay.setMessageDisplayText(amount + " Eur has been deposited.\nBalance: " + balance + message);
            } else {
                MessageDisplay.setMessageDisplayText("Incorrect amount!\nBalance: " + balance + message);
            }
            DataEntryDisplay.clearDataEntryDisplay();
        });

        MessageDisplayButtons.addButtonActionListener("B", B_ButtonEvent = withdraw -> {
            String amount = DataEntryDisplay.getDataEntryDisplayText();
            if (!amount.isEmpty() && amount.matches("^(\\d+(?:.\\d{1,2})?)") && Double.parseDouble(amount) <= balance) {
                balance = Math.round((balance - Double.parseDouble(amount)) * 100.0) / 100.0;
                MessageDisplay.setMessageDisplayText(amount + " Eur has been withdrawn.\nBalance: " + balance + message);
            } else {
                MessageDisplay.setMessageDisplayText("Incorrect amount!\nBalance: " + balance + message);
            }
            DataEntryDisplay.clearDataEntryDisplay();
        });

        MessageDisplayButtons.addButtonActionListener("C", C_ButtonEvent = goBack -> {
            switch (account) {
                case "Current" -> client.setCurrentAccountBalance(balance);
                case "Saving" -> client.setSavingAccountBalance(balance);
            }
            DataEntryDisplay.clearDataEntryDisplay();
            CashMachine.chooseAccount();
        });
    }
}
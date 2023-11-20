package cash_machine;

/**
 * Class represents the client, the information about the client and related functionality.
 *
 * @author Martin Dekanovský
 */
public class Client {

    private int ID;
    private int PIN;
    private double currentAccountBalance;
    private double savingAccountBalance;

    /**
     * Constructor for creating a new client.
     *
     * @param ID client's ID.
     * @param PIN client's PIN.
     * @param currentAccountBalance client's current account balance.
     * @param savingAccountBalance client's saving account balance.
     */
    public Client(int ID, int PIN, double currentAccountBalance, double savingAccountBalance) {
        this.ID = ID;
        this.PIN = PIN;
        this.currentAccountBalance = currentAccountBalance;
        this.savingAccountBalance = savingAccountBalance;
    }

    /**
     * Method returns client's ID.
     *
     * @return client's ID.
     */
    public int getID() {
        return ID;
    }

    /**
     * Method returns client's PIN.
     *
     * @return client's PIN.
     */
    public int getPIN() {
        return PIN;
    }

    /**
     * Method returns client's current account balance.
     *
     * @return client's current account balance.
     */
    public double getCurrentAccountBalance() {
        return currentAccountBalance;
    }

    /**
     * Method returns client's saving account balance.
     *
     * @return client's saving account balance.
     */
    public double getSavingAccountBalance() {
        return savingAccountBalance;
    }

    /**
     * Method for setting client's current account balance.
     *
     * @param currentAccountBalance new current account balance.
     */
    public void setCurrentAccountBalance(double currentAccountBalance) {
        this.currentAccountBalance = currentAccountBalance;
    }

    /**
     * Method for setting client's saving account balance.
     *
     * @param savingAccountBalance new saving account balance.
     */
    public void setSavingAccountBalance(double savingAccountBalance) {
        this.savingAccountBalance = savingAccountBalance;
    }

    /**
     * Method for formatting the information about the client.
     *
     * @return formatted information about the client.
     */
    @Override
    public String toString() {
        return String.format("%d %d %.2f %.2f", ID, PIN, currentAccountBalance, savingAccountBalance);
    }
}
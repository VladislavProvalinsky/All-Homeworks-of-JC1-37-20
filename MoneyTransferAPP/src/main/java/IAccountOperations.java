public interface IAccountOperations {

    public void depositBankAccount (ECurrency currency, double amount);
    public void withdrawBankAccount (ECurrency currency, double amount);
    public void depositPersonAccount (String IBAN, double amount);
    public void withdrawPersonAccount (String IBAN, double amount);
    public void transferBankToBank (Account from, Account to, double amount);
    public void transferP2PWithID (String personIBAN_From, String personIBAN_To, double amount);

}

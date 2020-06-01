public interface IAccountOperations {

    public void depositBankAccount (ECurrency currency, double amount);
    public void withdrawBankAccount (ECurrency currency, double amount);
    public void depositPersonAccount (String IBAN, double amount);
    public void withdrawPersonAccount (String IBAN, double amount);
    public void transferBankToBank (Account acc1, Account acc2, double amount);
    public void transferP2PWithID (String personID_From, String personID_To, double amount);

}

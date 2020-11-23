import java.math.BigDecimal;
import java.lang.String;

public class BankAccount {

    private AccountOwner accountOwner;
    private double balance;
    private static long nextAccountNumber = 10000000L;

    private final long accountNumber;

    public BankAccount(AccountOwner accountOwner, double balance) {
        this.accountOwner = accountOwner;
        this.balance = balance;

        this.accountNumber = BankAccount.nextAccountNumber++;
    }

    public int deposit(double amount) {
        if (amount <= 0) {
            return 2;
        } else {
            this.balance += amount;
            return 1;
        }
    }

    public long getAccountNumber() {
        return this.accountNumber;
    }

    public AccountOwner getAccountOwner() {
        return this.accountOwner;
    }

    public BigDecimal getBalance() {
        return BigDecimal.valueOf(this.balance);
    }

    public String getFormattedBalance() {
        return String.format("$%,.2f", this.balance);
    }

    public String getMaskedAccountNumber() {
        String accNumber = String.valueOf(this.accountNumber);
        return ("####" + accNumber.substring(4));
    }

    public void setAccountOwner(AccountOwner accountOwner) {
        this.accountOwner = accountOwner;
    }

    public int transfer(long account, double amount) {
        if (amount <= 0) return 2;
        if (this.balance < amount) return 3;
        BankAccount destination = ATM.lookup(account);
        if (destination == null) return 4;

        this.balance -= amount;
        destination.balance += amount;
        return 1;
    }

    public BigDecimal validateBalance(double balance) {
        if (balance < 0) return new BigDecimal(0);
        return BigDecimal.valueOf(balance);
    }

    public int withdraw(double amount) {
        if (amount <= 0) return 2;
        if (this.balance < amount) return 3;
        this.balance -= amount;
        return 1;
    }

}
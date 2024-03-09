public class BankAccount {
    
    private long accountNumber;
    private char tipe;
    // /private Bank account;

    public BankAccount(long accountNumber, char tipe) {
        this.accountNumber = accountNumber;
        this.tipe = tipe;
        //this.account = new Bank(accountNumber, tipe);
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setTipe(char tipe) {
        this.tipe = tipe;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public char getTipe() {
        return tipe;
    }

    public String Array(){
        String x = String.format("Account number: " + this.accountNumber + "\nTipe of account: " + tipe + "\n");
        return x;
    }
    
    
            
}
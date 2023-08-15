import java.util.UUID;

public class SBIaccount implements BankAccountInterface{
   private String name;

   private String accountNo;

   private String password;

   private double balance;

   final double rateOfInterest=5.5;

   final String IFSC="SBI002876";
   // default constructor
    public SBIaccount() {
    }
    // Parametarized constructor


    public SBIaccount(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountNo=String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public String getIFSC() {
        return IFSC;
    }

    @Override
    public String fetchBalance(String password) {
        if(this.password.equals(password))
        {
            return "Dear Customer, Your current a/c balance is: "+this.balance;
        }
        return "WARNING:Invalid password!!!";
    }

    @Override
    public String addMoney(double amount) {
        this.balance+=amount;
        return "Dear Customers, "+amount+" is credited in your SBI a/c, Your current balance is: "+this.balance;
    }

    @Override
    public String withdrawMoney(double amount, String password) {
        if(this.password.equals(password))
        {
            if(amount>100.0)
            {
                if(this.balance>amount) {
                    this.balance -= amount;
                    return "Dear Customer, " + amount + " is debitedted in your SBI a/c, Your current balance is: " + this.balance + " If this transaction is not done by you then immediate contact your nearby SBI branch";
                }
                else {
                   return "Insufficient funds !!";
                }
            }
            else {
                return "Amount cannot be less than 100!!";
            }
        }

        return "Invalid password";

    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.password.equals(oldPassword))
        {
            this.password=newPassword;
            return "Password change succeefully!!";
        }
        return "Incoreect original password";
    }

    @Override
    public double calculateInterest(int year) {
        return (this.balance*year*rateOfInterest)/100.0 ;  // Formula:- P*R*T/100;
    }

    @Override
    public String toString() {
        return "SBIaccount{" +
                "name='" + name + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", rateOfInterest=" + rateOfInterest +
                ", IFSC='" + IFSC + '\'' +
                '}';
    }
}

import java.util.UUID;

public class HDFCaccount implements BankAccountInterface{
    private String name;

    private String accountNo; // will generate through UUID-Universally Unique Identify

    private String password;

    private double balance;

    final double rateOfInterest=7.1; // This is never going to be change that's why it is final

    final String IFSCCode="HDFC002876";
   // Default Constructor---Alt+ Insert is shortcut key on intellijIDEA to get constructors
    public HDFCaccount() {
    }

    // Parametarized Constructor

    public HDFCaccount(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountNo=String.valueOf(UUID.randomUUID());  // random 128 bit number
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

    public String getIFSCCode() {
        return IFSCCode;
    }

    @Override
    public String fetchBalance(String password) {
        if(this.password.equals(password))
        {
            return "Your Balance is "+this.balance;
        }
        return "Incorrect password!!!";
    }

    @Override
    public String addMoney(double amount) {
        this.balance+=amount;
        return "Amount added successfully,New balance is: "+this.balance;
    }

    @Override
    public String withdrawMoney(double amount, String password) {
        if(this.password.equals(password))
        {
            if(this.balance>=amount) {
                this.balance -= amount;
                return "Money withdrawl of " + amount + " is successfully in your HDFC a/c. Your current Balance is: "+this.balance;
            }
            else
            {
                return "Insufficient Funds";
            }
        }
        return "Warning:-Invalid credentials!!";
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
        return (this.balance*year*rateOfInterest)/100.0 ;  // Formula:- P*R*T/100
    }

    @Override
    public String toString() {
        return "HDFCaccount{" +
                "name='" + name + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", rateOfInterest=" + rateOfInterest +
                ", IFSCCode='" + IFSCCode + '\'' +
                '}';
    }
}

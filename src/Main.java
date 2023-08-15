public class Main {
    public static void main(String[] args) {
// For HDFC account;
      HDFCaccount yogeshAcc=new HDFCaccount("Yogesh","Pass@123",2000);
        System.out.println(yogeshAcc);// This will show reference of object name in hashcode, but we want some meaningful stuff
        // so we will put toString defination in HDFCaccount class by using key alt+insert

        //fetch balance
        System.out.println(yogeshAcc.fetchBalance("random"));  // with wrong password
        System.out.println(yogeshAcc.fetchBalance("Pass@123"));  // with correct password

        // add money
        System.out.println(yogeshAcc.addMoney(100000));

        // withdraw
        System.out.println(yogeshAcc.withdrawMoney(200000,"Pass@123"));
        System.out.println(yogeshAcc.withdrawMoney(50000,"Pass@123"));
        System.out.println(yogeshAcc.withdrawMoney(200000,"Pass@112223"));

        // change password
        System.out.println(yogeshAcc.changePassword("Pass@123","Pass@1234"));
        System.out.println(yogeshAcc.fetchBalance("Pass@1234"));
        // rate of interest
      System.out.println("Interest for 5 years on yogeshAcc is : "+ yogeshAcc.calculateInterest(5));

        //For SBI account
        SBIaccount kunalAcc=new SBIaccount("Kunal","Kunal@123",5000);

        //fetch balance
        System.out.println(kunalAcc.fetchBalance("random@234"));  // with wrong password
        System.out.println(kunalAcc.fetchBalance("Kunal@123"));  // with correct password

        // add money
        System.out.println(kunalAcc.addMoney(5000));

        // withdraw
        System.out.println(kunalAcc.withdrawMoney(11000,"Kunal@123"));
        System.out.println(kunalAcc.withdrawMoney(3000,"Kunal@123"));
        System.out.println(kunalAcc.withdrawMoney(100,"Kunal@123"));

        // change password
        System.out.println(kunalAcc.changePassword("Kunal@123","Kunal@1234"));
        System.out.println(kunalAcc.fetchBalance("Kunal@1234"));

        // ROInterest
        System.out.println("Interest for 3 years on your SBI a/c is : "+ kunalAcc.calculateInterest(3));
    }


}

import java.util.*;
public class Employee {
    private String name;
    private int age;
    private double salary;
    private int maxNumAcc=10;
    private ArrayList <BankAccount> account = new ArrayList<BankAccount>(); 
    private int ammountAcc=0;
    
    

    Scanner scanner = new Scanner(System.in);


    public Employee(String name, int age, double salary, long accountNumber, char typeAccount) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.account.add(new BankAccount(accountNumber, typeAccount));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18 && age <= 65) {
            this.age = age;
        } else {
            System.out.println("Invalid age");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary");
        }
    }


    public int getAmmountAcc() {
        return ammountAcc;
    }

    public int getMaxNumAcc() {
        return maxNumAcc;
    }

/////////////////////////////
/////////////////////////////


    

    public void withdraw(double amount, int i){
        
        if (amount <= this.account.get(i).getAmount()) {
            this.account.get(i).setAmount(this.account.get(i).getAmount()-amount);
            System.out.println(String.format("Saldo restante: %f", this.account.get(i).getAmount()));
        }else{
            System.out.println("Saldo insuficiente");
        }
        
    }
    
    public void deposit(double amount, int i){
        this.account.get(i).setAmount(this.account.get(i).getAmount()+amount);
        System.out.println(String.format("Saldo actualizado: %f", this.account.get(i).getAmount()));
    }

/////////////////////////////
/////////////////////////////
    

    public BankAccount getBankAcc(int i){
        return account.get(i);
    }

    public void setAccNum(int i, long accNum){
        account.get(i).setAccountNumber(accNum);
    }

    public void setAccTyp(int i, char tAcc){
        account.get(i).setTypeAccount(tAcc);;
    }

    public void setAccount(int i, long accountNumber) {
        this.account.get(i).setAccountNumber(accountNumber);
    }

    public void setTypeAccount(int i, char type){
        this.account.get(i).setTypeAccount(type);
    }
    public void addBankAcc(long accNumber, char typ){
        this.account.add(new BankAccount(accNumber, typ));
    }
    public ArrayList<BankAccount> getAccount() {
        return account;
    }
    

}

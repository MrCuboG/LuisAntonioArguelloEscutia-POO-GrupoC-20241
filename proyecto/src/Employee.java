import java.util.*;
public class Employee {
    private String name;
    private int age;
    private double salary;
    private int maxNumAcc=10;
    private Bank bank;
    private BankAccount account[] = new BankAccount[maxNumAcc];
    private int ammountAcc=1;
    
    

    Scanner scanner = new Scanner(System.in);

    

    public Employee(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.account[ammountAcc] = new BankAccount(111111, 'A');
        bank.addEmployees();
    }

    public Employee(String name, int age, double salary, long accountNumber, char typeAccount) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.account[ammountAcc] = new BankAccount(accountNumber, typeAccount);
        bank.addEmployees();
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
    public void setAmmountAcc(int ammountAcc) {
        this.ammountAcc = ammountAcc;
    }

    public int getMaxNumAcc() {
        return maxNumAcc;
    }

/////////////////////////////
/////////////////////////////


    

    public void withdraw(double amount, int i){
        
        if (amount <= this.account[i].getAmount()) {
            this.account[i].setAmount(this.account[i].getAmount()-amount);
            System.out.println(String.format("Saldo restante: %f", this.account[i].getAmount()));
        }else{
            System.out.println("Saldo insuficiente");
        }
        
    }
    
    public void deposit(double amount, int i){
        this.account[i].setAmount(this.account[i].getAmount()+amount);
        System.out.println(String.format("Saldo actualizado: %f", this.account[i].getAmount()));
    }

/////////////////////////////
/////////////////////////////
    

    public BankAccount getBankAcc(int i){
        return account[i];
    }

    public void setAccount(int i, long accountNumber) {
        account[i].setAccountNumber(accountNumber);
    }

    public void setTypeAccount(int i, char type){
        account[i].setTypeAccount(type);
    }
    

}

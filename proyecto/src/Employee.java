
public class Employee {
 
    private String name;
    private int age;
    private double salary;
    private BankAccount account;
    private long accountNumber;
    private char tipe;
    int z = 0;
    String array [] = new String [10]; 

    public Employee(long accountNumber, char tipe) {
        this.account = new BankAccount(accountNumber, tipe);
    }
    
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    
    public Employee(String name, int age, double salary, long accountNumber, char tipe) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.account = new BankAccount(accountNumber, tipe);
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

    public void setAccount(long accountNumber, char tipe) {
        this.account = new BankAccount(accountNumber, tipe); 
    }  

    public BankAccount getAccount() {
        return account;
    }
    
    public void addAccount(){
        String x = account.Array();
        this.array[z] = x;
        z = z + 1;
    }
    
    public void Accounts(){
        addAccount();
        int h = 0;
        boolean band = true;
        for (; h < array.length && band == true; h++){
            if (array[h] == null){
                band = false;
            }
            else {
                System.out.println(array[h]);
            }
       }
        
    }

    public void getData() {
        String m;
        m = String.format("-------- \nNombre: %s \nAge: %d \nSalary: %f",
                    this.getName(), this.getAge(), this.getSalary());
        System.out.println(m);
        System.out.println("\nAccounts:\n ");
        Accounts();
    }
}
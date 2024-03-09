public class Bank {
    private Employee employee [] = new Employee[30];
    private int numEmployees = 1;
    private BankAccount employeAcc [] = new BankAccount[employee.length * 10];

    public void addEmployees() {
        this.numEmployees++;
    }
}

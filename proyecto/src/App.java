
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner read = new Scanner (System.in);
        Scanner read2 = new Scanner (System.in);
        Scanner read3 = new Scanner (System.in);
        
        int y;
        boolean band = true;
        long account;
        String n;
        char tipe;
        //Bank accounts = new Bank();
        Employee employee = new Employee ("Mariana Esteves", 25, 7000, 759497490,'A');
        employee.getData();
        for (; band == true ;){ 
            System.out.println("Add another account?");
            System.out.println("\n1. Yes.\t 2. No.");
            y = read.nextInt();
            if (y == 1){
                System.out.print("Account number: ");
                account = read2.nextLong();
                System.out.print("Account tipe: ");
                n = read3.nextLine();
                tipe = n.charAt(0);
                employee.setAccount(account, tipe); 
            } 
            else{
                band = false;
            } 
        }
        
        
        Employee employee1 = new Employee ("Luis Rodriguez", 31, 12500.43, 453688939, 'B');
        employee1.getData();
        for(; band == false; ){
            System.out.println("Add another account?");
            System.out.println("\n1. Yes.\t 2. No.");
            y = read.nextInt();
             if (y == 1){
                System.out.print("Account number: ");
                account = read2.nextLong();
                System.out.print("Account tipe: ");
                n = read3.nextLine();
                tipe = n.charAt(0);
                employee1 = new Employee (account, tipe);
                employee1.addAccount();
            } 
            else{
                band = true;
            } 
        }
        
        
        Employee employee2 = new Employee ("Elizabeth Castro", 40, 15000.87, 74943990, 'C');
        employee2.getData();
        for (; band == true ;){
            System.out.println("Add another account?");
            System.out.println("\n1. Yes.\t 2. No.");
            y = read.nextInt();
             if (y == 1){
                System.out.print("Account number: ");
                account = read2.nextLong();
                System.out.print("Account tipe: ");
                n = read3.nextLine();
                tipe = n.charAt(0);
                employee2 = new Employee (account, tipe);
                employee2.addAccount();
            } 
            else{
                band = false;
            } 
        }

        for (; band == false; ){
            System.out.println("--- Welcome ---\n");
            System.out.println("What do you want to do?\n");
            System.out.println("1. Employees information.\t 2. Consult employee.\t 3. Existing accounts.\t 4. Consult account.\t 5. Exit.");
            int x = read.nextInt();
            switch (x){

                case 1:
                    employee.getData();
                    employee1.getData();
                    employee2.getData();
                    
                    break;

                case 2:
                    System.out.println("1. Mariana Esteves\t 2. Luis Rodriguez\t 3. Elizabeth Castro");
                    y = read.nextInt();
                    switch (y){
                        case 1: 
                            employee.getData();
                            break;
                            
                        case 2:
                            employee1.getData();
                            break;
                            
                        default:
                            employee2.getData();
                    }

                    break;

                case 3: 
//                    accounts.showAccounts();
                    break;

                case 4: 
                    break;

                default:
                    band = true;
            }
        }
    }        
    
}
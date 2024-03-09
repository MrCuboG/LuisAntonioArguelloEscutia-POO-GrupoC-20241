import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Bank bank;
        Employee employee = new Employee("Luis", 18, 30000, 123123, 'A');

        int i = 0;
        int election;
        double amount;

        Scanner scanner = new Scanner(System.in);//enteros
        Scanner scanner2 = new Scanner(System.in);//doubles
        Scanner scanner3 = new Scanner(System.in);//longs
        Scanner scanner4 = new Scanner(System.in);//char


        boolean working = true;
        int selector;


        while (working) {
            System.out.println("1. Modificar/Mostrar Datos Usuario");
            System.out.println("2. Modificar/Mostrar Datos del banco");
            System.out.println("3. Salir");
            
            selector = scanner.nextInt();

            switch (selector) {
                case 1:
                    System.out.println("1. Añadir cuenta de banco");
                    System.out.println("2. Mostrar todos los usuarios y su informacion");
                    System.out.println("3. Mostrar informacion de usuario especifico");
                    System.out.println("4. Retirar");
                    System.out.println("5. Depositar");
                    System.out.println("6. Salir");

                    selector = scanner.nextInt();

                    switch (selector) {
                        case 1:
                            if (employee.getAmmountAcc()+1 < employee.getMaxNumAcc()) {
                                employee.setAmmountAcc(employee.getAmmountAcc()+1);
                                employee.getBankAcc(employee.getAmmountAcc());
                                System.out.println("Intruduce nuevo numero de Cuenta");
                                employee.setAccount(employee.getAmmountAcc()-1, scanner3.nextLong());
                                System.out.println("Intruduce el tipo de Cuenta");
                                employee.setAccount(employee.getAmmountAcc()-1, scanner4.nextLine().charAt(0));
                                System.out.println("Se ah añadido la cuenta");
                            }else{
                                System.out.println("Ya tiene el numero maximo de cuentas creadas para un usuario");
                            }

                            break;
                        case 3:
                            System.out.println("elige una cuenta para retirar:");
                            
                            for(; i < employee.getAmmountAcc(); i++){
                                System.out.println(String.format("%d. = numero de cuenta: %d", i+1, employee.getBankAcc(i).getAccountNumber()));
                            }
                            election = scanner.nextInt();
                            System.out.println("Añade la cantidad a retirar");
                            amount = scanner2.nextDouble();
                            employee.withdraw(amount, election-1);
                            i=0;
                        break;
                        case 4:
                            System.out.println("elige una cuenta para retirar:");

                            for(; i < employee.getAmmountAcc(); i++){
                                System.out.println(String.format("%d. = numero de cuenta: %d", i+1, employee.getBankAcc(i).getAccountNumber()));
                            }
                            election = scanner.nextInt();
                            System.out.println("Añade la cantidad a retirar");
                            amount = scanner2.nextDouble();
                            employee.withdraw(amount, election-1);
                            i=0;

                            break;
                        default:
                            break;
                    }

                    break;
                case 3:
                    working = false;
                    break;
                default:
                    break;
            }
        }
    }
}

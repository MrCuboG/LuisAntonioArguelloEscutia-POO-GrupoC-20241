import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();

        double amount;

        Scanner sInt = new Scanner(System.in);// enteros
        Scanner sDouble = new Scanner(System.in);// doubles
        Scanner sLong = new Scanner(System.in);// longs
        Scanner sChar = new Scanner(System.in);// char
        Scanner sString = new Scanner(System.in);// strings

        boolean working = true;
        int selector;
        int selector2;

        bank.getEmployee().add(new Employee("Luis", 18, 10000, 123123, 'A'));
        bank.getEmployee().add(new Employee("Lizeth", 18, 12000, 321321, 'B'));

        while (working) {

            System.out.println("1. Modificar/Mostrar Datos Usuario");
            System.out.println("2. Modificar/Mostrar Datos del banco");
            System.out.println("3. Salir");

            selector = sInt.nextInt();

            switch (selector) {
                case 1:
                    System.out.println("1. Añadir empleado");
                    System.out.println("2. Mostrar todos los usuarios y su informacion");
                    System.out.println("3. Mostrar informacion de usuario especifico");

                    System.out.println("6. Salir");

                    selector = sInt.nextInt();

                    switch (selector) {
                        case 1:
                            String n;
                            int a;
                            double s;
                            long an;
                            char ta;
                            System.out.println("Introduzca el nombre:");
                            n = sString.nextLine();
                            System.out.println("Introduzca la edad:");
                            a = sInt.nextInt(); 
                            System.out.println("Introduzca numero de cuenta");
                            s = sDouble.nextDouble();
                            System.out.println("introduzca el salario:");
                            an = sLong.nextLong(); 
                            System.out.println("Introduzca el tipo de cuenta:");
                            ta = sString.nextLine().charAt(0);
                            bank.addEmployees(n, a, s, an, ta);
                            break;
                        case 2:
                            if (bank.getEmployee().size() > 0) {
                                for (int j = 0; j < bank.getEmployee().size(); j++) {
                                    System.out.println(bank.getEmployee().get(j).getName());
                                    for (int j2 = 0; j2 < bank.getEmployee().get(j).getAccount().size(); j2++) {
                                        System.out.println(j2 + 1 + ".-"
                                                + bank.getEmployee().get(j).getAccount().get(j2).getAccountNumber()
                                                + " "
                                                + bank.getEmployee().get(j).getAccount().get(j2).getTypeAccount());
                                    }
                                }
                            } else {
                                System.out.println("No se tiene ningun usuario para mostrar \n");
                            }
                            break;
                        case 3:
                            System.out.println("Elija de que empleado mostrar su infomacion");
                            for (int j = 0; j < bank.getEmployee().size(); j++) {
                                System.out.println(j + ".-" + bank.getEmployee().get(j).getName());
                            }
                            selector = sInt.nextInt();

                            for (int j2 = 0; j2 < bank.getEmployee().get(selector).getAccount().size(); j2++) {
                                System.out.println(j2 + 1 + ".-"
                                        + bank.getEmployee().get(selector).getAccount().get(j2).getAccountNumber()
                                        + " "
                                        + bank.getEmployee().get(selector).getAccount().get(j2).getTypeAccount());
                            }

                            break;
                    }

                    break;
                case 2:
                    System.out.println("1. Añadir cuenta de banco");//
                    System.out.println("2. Retirar");//
                    System.out.println("3. Depositar");//
                    System.out.println("4. Cambiar numero de Cuenta");
                    System.out.println("5. Cambiar tipo de cuenta");
                    selector = sInt.nextInt();
                    switch (selector) {
                        case 1:
                            System.out.println("Elija a que empleado agregar ");
                            for (int j = 0; j < bank.getEmployee().size(); j++) {
                                System.out.println(j + ".-" + bank.getEmployee().get(j).getName());
                            }

                            selector = sInt.nextInt();
                            System.out.println("Intruduce nuevo numero de Cuenta");
                            long nAcNum = sLong.nextLong();
                            System.out.println("Intruduce el tipo de Cuenta");
                            char nType = sChar.nextLine().charAt(0);
                            bank.getEmployee().get(selector).addBankAcc(nAcNum, nType);
                            System.out.println("Se ah añadido la cuenta");
                            break;
                        case 2:
                            System.out.println("Elija con que empleado hacer el retiro");
                            for (int j = 0; j < bank.getEmployee().size(); j++) {
                                System.out.println(j + ".-" + bank.getEmployee().get(j).getName());
                            }
                            selector = sInt.nextInt();
                            System.out.println("Elija una cuenta del empleado para hacer el retiro");
                            for (int j = 0; j < bank.getEmployee().get(selector).getAccount().size(); j++) {
                                System.out.println(j + ".-" + bank.getEmployee().get(selector).getAccount().get(j));
                            }
                            selector2 = sInt.nextInt();
                            System.out.println("El dinero en cuenta es:"
                                    + bank.getEmployee().get(selector).getAccount().get(selector2).getAmount()
                                    + "Introduzca la cantidad que quiere retirar");
                            amount = sDouble.nextDouble();
                            bank.getEmployee().get(selector).withdraw(amount, selector2);
                            break;
                        case 3:
                            System.out.println("Elija con que empleado hacer el deposito:");
                            for (int j = 0; j < bank.getEmployee().size(); j++) {
                                System.out.println(j + ".-" + bank.getEmployee().get(j).getName());
                            }
                            selector = sInt.nextInt();
                            System.out.println("Elija una cuenta del empleado para hacer el deposito:");
                            for (int j = 0; j < bank.getEmployee().get(selector).getAccount().size(); j++) {
                                System.out.println(j + ".-" + bank.getEmployee().get(selector).getAccount().get(j));
                            }
                            selector2 = sInt.nextInt();
                            System.out.println("El dinero en cuenta es:"
                                    + bank.getEmployee().get(selector).getAccount().get(selector2).getAmount()
                                    + "Introduzca la cantidad que quiere Depositar");
                            amount = sDouble.nextDouble();
                            bank.getEmployee().get(selector).deposit(amount, selector2);
                            break;
                        case 4:
                            System.out.println("Elija a que empleado cambiar el numero de cuenta:");
                            for (int j = 0; j < bank.getEmployee().size(); j++) {
                                System.out.println(j + ".-" + bank.getEmployee().get(j).getName());
                            }
                            selector = sInt.nextInt();
                            System.out.println("Elija una cuenta del empleado para cambiar el numero de cuenta:");
                            for (int j = 0; j < bank.getEmployee().get(selector).getAccount().size(); j++) {
                                System.out.println(j + ".-" + bank.getEmployee().get(selector).getAccount().get(j));
                            }
                            selector2 = sInt.nextInt();
                            System.out.println("Introduzca el nuevo numero de cuenta");
                            bank.getEmployee().get(selector).setAccNum(selector2, sLong.nextLong());
                            break;
                        case 5:
                            System.out.println("Elija a que empleado cambiar el numero de cuenta:");
                            for (int j = 0; j < bank.getEmployee().size(); j++) {
                                System.out.println(j + ".-" + bank.getEmployee().get(j).getName());
                            }
                            selector = sInt.nextInt();
                            System.out.println("Elija una cuenta del empleado para cambiar el numero de cuenta:");
                            for (int j = 0; j < bank.getEmployee().get(selector).getAccount().size(); j++) {
                                System.out.println(j + ".-" + bank.getEmployee().get(selector).getAccount().get(j));
                            }
                            selector2 = sInt.nextInt();
                            System.out.println("Introduzca el nuevo numero de cuenta");
                            bank.getEmployee().get(selector).setAccTyp(selector2, sChar.nextLine().charAt(0));
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

from Bank import bank
class main:
    bank = []
    working = True
    while working:
        print("1. Modificar/Mostrar Datos Usuario")
        print("2. Modificar/Mostrar Datos del banco")
        print("3. Salir")

        selector = input()
        
        match selector:
            case 1:
                n = input('Introduzca un nombre')
                a = input('Introduzca la edad')
                s = input('Introduzca el salario')
                aN = input('Introduzca el numero de cuenta')
                aT = input('Introduzca el tipo de cuenta')
                bank.ad
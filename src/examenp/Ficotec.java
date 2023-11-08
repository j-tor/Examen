/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenp;

/**
 *
 * @author aleja
 */
import java.util.Scanner;

public class Ficotec {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner read = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {
            System.out.println("Selecciona una opción:\n"+
                                "1. Agregar Cuenta\n"+
                                "2. Desactivar Cuenta de Ahorro\n"+
                                "3. Aplicar Intereses a Cuentas de Plazo Fijo\n"+
                                "4. Transferir entre Cuentas\n"+
                                "5. Salir\n");
            int menu = read.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("Ingrese el número de cuenta: ");
                    int numCuenta = read.nextInt();
                    System.out.println("Ingrese el nombre del cliente: ");
                    String nombreCliente = read.next();
                    System.out.println("Seleccione el tipo de cuenta (AHORRO o CHEQUE): ");
                    TipoCuenta tipoCuenta = TipoCuenta.valueOf(read.next().toUpperCase());
                    
                    banco.add(numCuenta, nombreCliente, tipoCuenta);
                    break;
                case 2:
                    banco.evalDeactivations();
                    System.out.println("Cuentas de ahorro desactivadas.");
                    break;
                case 3:
                    banco.applyInterests();
                    System.out.println("Intereses aplicados a cuentas de plazo fijo.");
                    break;
                case 4:
                    System.out.println("Ingrese el número de cuenta de origen: ");
                    int numCuentaOrigen = read.nextInt();
                    System.out.println("Ingrese el número de cuenta de destino: ");
                    int numCuentaDestino = read.nextInt();
                    System.out.println("Ingrese el monto a transferir: ");
                    double monto = read.nextDouble();

                    banco.transfer(numCuentaOrigen, numCuentaDestino, monto);
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.\n");
            }
        }
    }
}


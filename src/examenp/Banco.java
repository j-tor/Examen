/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenp;
import java.util.ArrayList;
/**
 *
 * @author aleja
 */

import java.util.ArrayList;

public class Banco {
    private ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

    public CuentaBancaria search(int nc) {
        return search(nc, 0);
    }

    private CuentaBancaria search(int nc, int index) {
    if (index < cuentas.size()) {
        CuentaBancaria cuenta = cuentas.get(index);
        if (Integer.parseInt(cuenta.getNumeroCuenta()) == nc) {
            return cuenta;
        } else {
            return search(nc, index + 1);
        }
    } else {
        return null;
    }
}

    public void add(int num, String cliente, TipoCuenta tipo) {
        if (search(num) != null) {
            System.out.println("El número de cuenta ya existe. No se puede agregar la cuenta.");
            return;
        }

        CuentaBancaria nuevaCuenta = null;
        if (tipo == TipoCuenta.AHORRO) {
            nuevaCuenta = new CuentaAhorro(Integer.toString(num), cliente);
        } else if (tipo == TipoCuenta.CHEQUE) {
            nuevaCuenta = new CuentaPlazoFijo(Integer.toString(num), cliente);
        } 

        cuentas.add(nuevaCuenta);
        System.out.println("Nueva cuenta agregada: " + nuevaCuenta);
    }

    public void evalDeactivations() {
        evalDeactivationsRecursive(0);
    }

    private void evalDeactivationsRecursive(int index) {
        if (index < cuentas.size()) {
            CuentaBancaria cuenta = cuentas.get(index);
            if (cuenta instanceof CuentaAhorro) {
                ((CuentaAhorro) cuenta).desactivar();
            }
            evalDeactivationsRecursive(index + 1);
        }
    }

    public void applyInterests() {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta instanceof CuentaPlazoFijo) {
                ((CuentaPlazoFijo) cuenta).deposito(((CuentaPlazoFijo) cuenta).saldoDisponible * CuentaPlazoFijo.TASA);
            }
        }
    }

    public boolean transfer(int nc1, int nc2, double monto) {
        CuentaBancaria cuentaOrigen = search(nc1);
        CuentaBancaria cuentaDestino = search(nc2);

        if (cuentaOrigen != null && cuentaDestino != null) {
            if (cuentaOrigen.retiro(monto)) {
                cuentaDestino.deposito(monto);
                System.out.println("Transferencia de $" + monto + " realizada de la cuenta " + nc1 + " a la cuenta " + nc2);
                return true;
            }
        }

        System.out.println("No se pudo realizar la transferencia.");
        return false;
    }
}


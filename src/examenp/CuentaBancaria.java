/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenp;

/**
 *
 * @author aleja
 */
public abstract class CuentaBancaria {
    private String numeroCuenta;
    private String nombreCliente;
    double saldoDisponible;

    
    public CuentaBancaria(String numeroCuenta, String nombreCliente) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.saldoDisponible = 500.0;
    }
    
    public abstract boolean retiro(double m);
    
    public void deposito(double m) {
        if (m > 0) {
            saldoDisponible += m;
            System.out.println("Depósito de L." + m + " realizado."+"\nSaldo actual: L." + saldoDisponible);
        } else {
            System.out.println("El monto del depósito debe ser mayor que cero.");
        }
    }

    @Override
    public String toString() {
        return "Número de Cuenta: " + numeroCuenta + "\nNombre del Cliente: " + nombreCliente + "\nSaldo Disponible: L." + saldoDisponible;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    

    
}


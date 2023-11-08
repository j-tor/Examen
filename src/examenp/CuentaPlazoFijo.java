/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenp;

/**
 *
 * @author aleja
 */
public final class CuentaPlazoFijo extends CuentaBancaria {
    private double intereses;
    static final double TASA = 0.15; 

    public CuentaPlazoFijo(String numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
        this.intereses = 0.0;
    }

    private void calcularIntereses() {
        intereses += saldoDisponible * TASA;
    }
    
    @Override
    public void deposito(double m) {
        super.deposito(m);
        calcularIntereses();
    }
    
    @Override
    public boolean retiro(double m) {
        if (m <= intereses) {
            intereses -= m;
            System.out.println("Retiro de intereses de L." + m + " realizado. Intereses actuales: L." + intereses);
            return true;
        } else {
            System.out.println("No se pueden retirar más intereses de los disponibles.");
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nIntereses Generados: L." + intereses;
    }
}


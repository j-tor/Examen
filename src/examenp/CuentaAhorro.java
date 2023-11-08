/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenp;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 *
 * @author aleja
 */


public final class CuentaAhorro extends CuentaBancaria {
    private LocalDate ultimaModificacion;
    private boolean activa;

    public CuentaAhorro(String numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
        this.ultimaModificacion = LocalDate.now();
        this.activa = true;
    }


    @Override
    public boolean retiro(double m) {
        if (activa) {
            if (saldoDisponible >= m) {
                saldoDisponible -= m;
                System.out.println("Retiro de " + m + " realizado. Saldo actual: " + saldoDisponible);
                actualizarUltimaModificacion();
                return true;
            } else {
                System.out.println("No se puede realizar el retiro. Saldo insuficiente.");
                return false;
            }
        } else {
            activarCuenta();
            if (saldoDisponible >= m) {
                saldoDisponible -= m;
                System.out.println("Retiro de " + m + " realizado. Saldo actual: " + saldoDisponible);
                actualizarUltimaModificacion();
                return true;
            } else {
                System.out.println("No se puede realizar el retiro. Saldo insuficiente.");
                return false;
            }
        }
    }
    
    
    @Override
    public void deposito(double m) {
        if (!activa) {            
            activarCuenta();
            m = m * 0.9;
        }
        
        super.deposito(m);
        actualizarUltimaModificacion();
    }

    public void desactivar() {
        LocalDate fechaActual = LocalDate.now();
        long mesesDesdeUltimaModificacion = ChronoUnit.MONTHS.between(ultimaModificacion, fechaActual);
        
        if (mesesDesdeUltimaModificacion > 6) {
            activa = false;
            System.out.println("La cuenta ha sido desactivada debido a inactividad.");
        }
    }
  

    private void activarCuenta() {
        activa = true;
        System.out.println("La cuenta ha sido activada.");
    }

    private void actualizarUltimaModificacion() {
        ultimaModificacion = LocalDate.now();
    }
    
    @Override
    public String toString() {
        String estado ;
          if(activa){ 
              estado = "ACTIVA";
          } else{ 
              estado = "DESACTIVADA";};
        return super.toString() + "\nEstado de la Cuenta: " + estado+"\n";
    }
}



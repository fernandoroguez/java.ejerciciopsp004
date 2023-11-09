/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg04;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ferna
 */


public class Empleado implements Serializable, Comparable<Empleado>{

    int numero;
    transient String nombre;
    float sueldo;
    float sueldo_maximo;
    Calendar fecha;

    public Empleado(String nombre, float sueldo, float sueldo_maximo, int numero) {
        this.nombre = nombre;
        this.sueldo=sueldo;
        this.sueldo_maximo = sueldo_maximo;
        this.fecha = new GregorianCalendar();       
        this.numero=numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public int compareTo(Empleado otro){
        return Integer.compare(this.numero, otro.numero);
        
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isprog() {
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) throws SaldoExepcion{
            this.sueldo = sueldo;
            try{
                if(sueldo>this.sueldo_maximo){
                    throw new SaldoExepcion("El sueldo no puede ser mayor al sueldo base");
                };
                this.sueldo=sueldo;
            }catch(SaldoExepcion e){
                //javax.swing.JPanel jpanel = null;
                //JOptionPane.showMessageDialog(jpanel,"Hello World");
                //System.out.println(e.getMessage());
                throw e;
            }
    }

    public float getSueldo_maximo() {
        return sueldo_maximo;
    }

    public void setSueldo_maximo(float sueldo_maximo)throws Exception{

            try{
                if(this.sueldo>sueldo_maximo){
                    throw new SaldoExepcion("El sueldo no puede ser mayor al sueldo base");
                };
                this.sueldo_maximo=sueldo_maximo;
            }catch(SaldoExepcion e){
                //javax.swing.JPanel jpanel = null;
                //JOptionPane.showMessageDialog(jpanel,"Hello World");
                //System.out.println(e.getMessage());
                throw e;
            }

    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }
    
    public void calcular()throws Exception{
    }

    @Override
    public String toString() {
        return "Empleado{" + "numero=" + numero + ", nombre=" + nombre + ", sueldo=" + sueldo + ", sueldo_maximo=" + sueldo_maximo + ", fecha=" + fecha + '}';
    }

}

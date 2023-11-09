/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg04;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author ferna
 */
public class Programador extends Empleado{
    
    float sueldo_extra_mensual;
    String lenguaje;

    public Programador(float sueldo_extra_mensual, String lenguaje, String nombre, float sueldo, float sueldo_maximo, int numero){
        super(nombre, sueldo, sueldo_maximo, numero);
        this.sueldo_extra_mensual = sueldo_extra_mensual;
        this.lenguaje = lenguaje;
    }
    
    @Override
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public float getSueldo_extra_mensual() {
        return sueldo_extra_mensual;
    }

    @Override
    public boolean isprog(){
        return true;
    }
    public void setSueldo_extra_mensual(float sueldo_extra_mensual) {
        this.sueldo_extra_mensual = sueldo_extra_mensual;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }
        public void calcular()throws Exception{
        try{
            if(sueldo+sueldo_extra_mensual>sueldo_maximo){
                throw new SaldoExepcion("El sueldo no puede ser mayor al sueldo base");
            }
            else{
                setSueldo(sueldo+sueldo_extra_mensual);
            }
        }catch(SaldoExepcion e){
                //javax.swing.JPanel jpanel = null;
                //JOptionPane.showMessageDialog(jpanel,"Hello World");
                //System.out.println(e.getMessage());
                throw e;}
    }

    @Override
    public String toString() {
        DateFormat formateador= new SimpleDateFormat("dd/M/yy");
        
        return "Empleado{" + "numero=" + numero + ", nombre=" + nombre + ", sueldo=" + sueldo + ", sueldo_maximo=" + sueldo_maximo + ", fecha=" +formateador.format(fecha.getTime())+ ", tipo=Progamador, extra mensual=" +sueldo_extra_mensual+", lenguaje favorito="+lenguaje+'}';
         
    }


    
}

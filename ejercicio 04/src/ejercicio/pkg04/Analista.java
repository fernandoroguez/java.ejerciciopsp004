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
public class Analista extends Empleado{
    
    float plus_anual;
    int numdepart;

    public Analista(float plus_anual, int numdepart, String nombre, float sueldo, float sueldo_maximo, int numero) {
        super(nombre, sueldo, sueldo_maximo, numero);
        this.plus_anual = plus_anual;
        this.numdepart = numdepart;
    }

    public float getPlus_anual() {
        return plus_anual;
    }

    public void setPlus_anual(float plus_anual) {
        this.plus_anual = plus_anual;
    }

    public int getNumdepart() {
        return numdepart;
    }
    
    @Override
    public boolean isprog(){
        return false;
    }

    public void setNumdepart(int numdepart) {
        this.numdepart = numdepart;
    }
    @Override
    public void calcular()throws Exception{
        try{
            if(sueldo+plus_anual>sueldo_maximo){
                throw new SaldoExepcion("El sueldo no puede ser mayor al sueldo base");
            }
            else{
                setSueldo(sueldo+plus_anual);
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
        
        return "Empleado{" + "numero=" + numero + ", nombre=" + nombre + ", sueldo=" + sueldo + ", sueldo_maximo=" + sueldo_maximo + ", fecha=" +formateador.format(fecha.getTime())+ ", tipo=Analista, extra anual=" +plus_anual+", numero de departamento="+numdepart+'}';
         
    }
}

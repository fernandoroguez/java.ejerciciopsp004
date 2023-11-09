/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg04;

/**
 *
 * @author ferna
 */
public class SaldoExepcion extends Exception {
    public SaldoExepcion(){}
    public SaldoExepcion(String mensaje){
        super(mensaje);
    }
    
}

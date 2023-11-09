/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import sun.applet.Main;

/**
 *
 * @author ferna
 * @param <E>
 */
public class MyList<E> implements Serializable{

    private Node<E> firstNode;
    private Node<E> lastNode;
    private Node<E> actualNode;
    int cont = 0;
    int maxnum = 0;

    public MyList() {
        this.firstNode = null;
    }

    public void showMyList() {
        Node<E> temporary = this.firstNode;
        while (temporary != null) {

            System.out.println(temporary.getMain().toString());
            temporary = temporary.getNextNode();

        }
    }

    public void finall() {
        actualNode = lastNode;
    }

    public void inicio() {
        actualNode = firstNode;
    }

    public void adelante() {
        if (!esultimo()) {
            actualNode = actualNode.getNextNode();
        }

        // System.out.println(actualNode.getMain().toString());
    }
    
        public void adelante(int i) {
            actualNode = actualNode.getNextNode();
        

        // System.out.println(actualNode.getMain().toString());
    }
    public void getaux1(){
        
    }

    public void destruir() {
        firstNode = null;
        actualNode = null;
        lastNode = null;
        cont = 1;
    }

    public E getmain() {

        return actualNode.main;
    }

    public void atras() {
        if (!esprimero()) {
            actualNode = actualNode.getReturnNode();
        }
        //System.out.println(actualNode.getMain().toString());
    }

    public void modificar(E p) {
        actualNode.setMain(p);
        actualNode.main = p;
        // System.out.println("Ha modificado");

    }

    public boolean esultimo() {
        return actualNode.nextNode == null;
    }

    public boolean esprimero() {
        return actualNode.returnNode == null;
    }

    public int getnumero() {
        Empleado aux;
        aux = (Empleado) actualNode.getMain();
        return aux.getNumero();
    }

    public String getnombre() {
        Empleado aux;
        aux = (Empleado) actualNode.getMain();
        return aux.getNombre();
    }

    public float getsueldo() {
        Empleado aux;
        aux = (Empleado) actualNode.getMain();
        return aux.getSueldo();
    }

    public float getsueldomax() {
        Empleado aux;
        aux = (Empleado) actualNode.getMain();
        return aux.getSueldo_maximo();
    }

    public String getfecha() {
        Empleado aux;
        aux = (Empleado) actualNode.getMain();
        DateFormat formateador = new SimpleDateFormat("dd/M/yy");
        return formateador.format(aux.getFecha().getTime());
    }

        public String getdia() {
        Empleado aux;
        aux = (Empleado) actualNode.getMain();
        DateFormat formateador = new SimpleDateFormat("dd");
        return formateador.format(aux.getFecha().getTime());
    }
            public String getmes() {
        Empleado aux;
        aux = (Empleado) actualNode.getMain();
        DateFormat formateador = new SimpleDateFormat("M");
        return formateador.format(aux.getFecha().getTime());
    }
    public Calendar getcalendar() {
        Empleado aux;
        aux = (Empleado) actualNode.getMain();
        return aux.getFecha();
    }

    public float getextrames() {
        Programador aux;
        aux = (Programador) actualNode.getMain();
        return aux.getSueldo_extra_mensual();
    }

    public String getlenguaje() {
        Programador aux;
        aux = (Programador) actualNode.getMain();
        return aux.getLenguaje();
    }

    public float getextraanio() {
        Analista aux;
        aux = (Analista) actualNode.getMain();
        return aux.getPlus_anual();
    }

    public int getdepart() {
        Analista aux;
        aux = (Analista) actualNode.getMain();
        return aux.getNumdepart();
    }

    public void add(E p) {
        Empleado aux;
        aux = (Empleado) p;
        cont++;
        if (aux.getNumero() > maxnum) {
            maxnum = aux.getNumero();
        }
        Node<E> newNode = new Node(aux);
        if (firstNode == null) {
            firstNode = newNode;
            lastNode = newNode;
            actualNode = newNode;
        } else {
            newNode.setReturnNode(lastNode);
            lastNode.setNextNode(newNode);
            lastNode = newNode;
        }
    }
    
    public void guardar(){
                try {
            FileOutputStream archivo = new FileOutputStream("testSer.ser");
            
            
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            inicio();
            while (actualNode != null) {
                escritor.writeObject(getmain());
                adelante(1);
            }

            escritor.close();
            archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargar(){
                try {
            FileInputStream archivo = new FileInputStream("testSer.ser");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            while (true) {
                try {
                    add((E) lector.readObject());
                } catch (Exception exx) {
                    break;
                }
            }
            lector.close();
            archivo.close();
        } catch (Exception ex) {

            System.out.println("Error " + ex.getMessage());

        }
    }
    
    public int getindice() {
        return actualNode.indice;
    }

    public void setindice(int i) {
        actualNode.setindice(i);
    }

    public void setindice() {
        actualNode.setindice();
    }

    public boolean sort(List c) {
        Node<E> tem = this.firstNode;
        Node<E> tem2 = tem.getNextNode();

        long tiempo1;
        long tiempo2;
        
        tiempo1=System.currentTimeMillis();
        System.out.println("va a empezar el metodo burbuja");
        while (tem != null) {
            while (tem2 != null) {
                if (tem.getindice() > tem2.getindice()) {
                    interCambiar(tem.getindice(), tem2.getindice());
                }
                tem2 = tem2.getNextNode();
            }
            tem = tem.getNextNode();
            tem2 = tem;

        }
        tiempo2=System.currentTimeMillis();
        System.out.println("metodo burbuja completado");
        long tiempo3=System.currentTimeMillis();
        long tiempo4;

        Collections.sort(c);

        tiempo4=System.currentTimeMillis();
        tiempo1=tiempo2-tiempo1; 
        tiempo3=tiempo4-tiempo3;
        JOptionPane p = new JOptionPane();
        for(int i=0;i<100;i++){
            System.out.println("numero " + (i+1)+ "="+c.get(i));
        }
        JOptionPane.showMessageDialog(p, "El tiemo de el metodo burbuja es de "+tiempo1+" milisegundos\n el tiempo del sort collections es de "+tiempo3+" milisegundos");
        System.out.println("El tiemo de el metodo burbuja es de "+tiempo1+"milisegundos\n el tiempo del sort collections es de "+tiempo3);
        return true;
    }

    public void interCambiar(int uno, int dos) {
        Node<E> auxiliar1 = firstNode;
        Node<E> marcador = null;
        Empleado aux;
        if (existe(uno) && existe(dos)) {
            while (true) {
                if (auxiliar1.getindice() == uno || auxiliar1.getindice() == dos) {
                    if (marcador == null) {
                        marcador = auxiliar1;
                    } else {
                        //auxiliar3.setMain(auxiliar1.getMain());
                       // auxiliar3.setindice(auxiliar1.getindice());
                        aux=(Empleado)auxiliar1.getMain();
                        auxiliar1.setMain(marcador.getMain());
                        //auxiliar1.setindice(marcador.getindice());
                        marcador.setMain((E) aux);
                       // marcador.setindice(auxiliar3.getindice());
                        break;
                    }

                }
                auxiliar1 = auxiliar1.getNextNode();
            }
        }
    }

    public boolean existe(int i) {
        Node<E> temp = firstNode;
        //System.out.println("Entra al existe");
        actualNode = firstNode;
        while (true) {
            if (temp.getindice() == i) {
                //System.out.println(i + " Existe");
                return true;
            }
            if (temp == lastNode) {
                break;
            }
            if (!esultimo()) {
                adelante();
                temp = actualNode;
            }
            if (esultimo()) {
                break;
            }

        }
        return false;
    }

    public String actual() {
        return actualNode.getMain().toString();
    

}

// Inner class
    public class Node<E> implements Serializable {

    private Node<E> nextNode;
    private Node<E> returnNode;
    E main;
    int indice;

    public Node(E p) {
        this.nextNode = null;
        this.returnNode = null;
        this.main = p;
        Empleado aux = (Empleado) p;
        this.indice = aux.getNumero();
    }

    public Node<E> getNextNode() {
        return this.nextNode;
    }

    public boolean esultimo() {
        return null == nextNode;
    }

    public boolean esprimero() {
        return null == returnNode;
    }

    public int getindice() {
        return this.indice;
    }

    public void setindice(int i) {
        this.indice = i;
    }

    public void setindice() {
        Empleado aux = (Empleado) main;
        this.indice = aux.getNumero();
    }

    public void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }

    public Node<E> getReturnNode() {
        return this.returnNode;
    }

    public void setReturnNode(Node<E> xe) {
        this.returnNode = xe;
    }

    public E getMain() {
        return main;
    }

    public void setMain(E p) {
        this.main = p;
        Empleado aux = (Empleado) main;
        this.indice = aux.getNumero();
    }
}
}

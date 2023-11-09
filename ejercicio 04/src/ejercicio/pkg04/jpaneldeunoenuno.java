/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg04;

import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ferna
 */
public class jpaneldeunoenuno extends javax.swing.JPanel {

    /**
     * Creates new form jpaneldeunoenuno
     */
    MyList<Empleado> lista;
    public final static int DIA_DEL_MES = Calendar.DAY_OF_MONTH;
    public final static int MES_DEL_ANO = Calendar.MONTH;
    public final static int ANO = Calendar.YEAR;
    boolean creacion = false;
    List<Empleado> coll;
    
    public MyList actualizarlista() {
        return lista;
    }

    public int dia() {
        GregorianCalendar fechaActual = new GregorianCalendar();
        return fechaActual.get(DIA_DEL_MES);
    }

    public int mes() {
        GregorianCalendar fechaActual = new GregorianCalendar();
        return fechaActual.get(MES_DEL_ANO) + 1;
    }

    public int ano() {
        GregorianCalendar fechaActual = new GregorianCalendar();
        return fechaActual.get(ANO);
    }

    private void mostrar() {
        txtnumero.setText("" + lista.getnumero());
        txtnombre.setText(lista.getnombre());
        txtsueldo.setText("" + lista.getsueldo());
        txtsueldo_max.setText("" + lista.getsueldomax());
        txtfecha.setText(lista.getfecha());
        Empleado aux = (Empleado) lista.getmain();
        if (aux.isprog()) {
            txtaux1.setText("" + lista.getextrames());
            txtaux2.setText(lista.getlenguaje());
            lblaux1.setText("Extra Mensual");
            lblaux2.setText("Lenguaje favorito");
            setprog();
            if (Integer.parseInt(lista.getdia()) == dia()) {
                btncalcular.setEnabled(true);
            } else {
                btncalcular.setEnabled(false);
            }
        } else {
            txtaux1.setText("" + lista.getextraanio());
            txtaux2.setText("" + lista.getdepart());
            lblaux1.setText("Extra Anual");
            lblaux2.setText("Departamento");
            setana();
            if (Integer.parseInt(lista.getdia()) == dia() && Integer.parseInt(lista.getmes()) == mes()) {
                btncalcular.setEnabled(true);
            } else {
                btncalcular.setEnabled(false);
            }
        }
    }

    void settipoemple() {
        String[] a = new String[2];
        a[0] = ("Programador");
        a[1] = ("Analista");
        tipoemple.setModel(new javax.swing.DefaultComboBoxModel<>(a));
    }

    void setprog() {
        tipoemple.setSelectedIndex(0);
    }

    void setana() {
        tipoemple.setSelectedIndex(1);
    }

    void desactivartextos() {
        txtnumero.setEditable(false);
        txtnombre.setEditable(false);
        txtsueldo.setEditable(false);
        txtsueldo_max.setEditable(false);
        txtfecha.setEditable(false);
        txtaux1.setEditable(false);
        txtaux2.setEditable(false);
    }

    public void avanzar() {
        lista.adelante();
        if (lista.esultimo()) {
            btnsiguiente.setEnabled(false);
            btnanterior.setEnabled(true);
        } else {
            btnsiguiente.setEnabled(true);
        }
        mostrar();
    }

    public void ultimo() {
        btnsiguiente.setEnabled(false);
        btnanterior.setEnabled(true);
        lista.finall();
        mostrar();
    }

    public void primero() {
        btnsiguiente.setEnabled(true);
        btnanterior.setEnabled(false);
        lista.inicio();
        mostrar();
    }

    public void retroceder() {
        lista.atras();
        if (lista.esprimero()) {
            btnsiguiente.setEnabled(true);
            btnanterior.setEnabled(false);
        } else {
            btnsiguiente.setEnabled(true);
        }
        mostrar();
    }

    public void setemple() {
        String[] s = new String[2];
        s[0] = "Programador";
        s[1] = "Analista";
        tipoemple.setEditable(false);
        tipoemple.setEnabled(false);
        tipoemple.setModel(new javax.swing.DefaultComboBoxModel<>(s));
    }

    public void exportar() {
        lista.guardar();
    }

    public void importar() {
        lista.cargar();
    }

    public void prepararcreacion() {
        btnsiguiente.setText("Aceptar");
        btnanterior.setText("Cancelar");
        btnCargar.setEnabled(false);
        btncalcular.setEnabled(false);
        btncreado_masivo.setEnabled(false);
        btncrear.setEnabled(false);
        btnexportar.setEnabled(false);
        btnfinal.setEnabled(false);
        btninicio.setEnabled(false);
        btnanterior.setEnabled(true);
        btnordenar.setEnabled(false);
        btnsiguiente.setEnabled(true);
        txtaux1.setText("");
        txtaux2.setText("");
        txtfecha.setText("");
        txtnombre.setText("");
        txtnumero.setText("");
        txtsueldo.setText("");
        txtsueldo_max.setText("");
        txtaux1.setEditable(true);
        txtaux2.setEditable(true);
        txtfecha.setEditable(true);
        txtnombre.setEditable(true);
        txtnumero.setEditable(true);
        txtsueldo.setEditable(true);
        txtsueldo_max.setEditable(true);
        //   tipoemple.setEditable(true);
        tipoemple.setEnabled(true);
    }
    
    public void desactivar_btns(){
                btnCargar.setEnabled(false);
        btncalcular.setEnabled(false);
        btncreado_masivo.setEnabled(false);
        btncrear.setEnabled(false);
        btnexportar.setEnabled(false);
        btnfinal.setEnabled(false);
        btninicio.setEnabled(false);
        btnanterior.setEnabled(false);
        btnordenar.setEnabled(false);
        btnsiguiente.setEnabled(false);
    }
        public void activar_btns(){
                btnCargar.setEnabled(true);
        btncalcular.setEnabled(true);
        btncreado_masivo.setEnabled(true);
        btncrear.setEnabled(true);
        btnexportar.setEnabled(true);
        btnfinal.setEnabled(true);
        btninicio.setEnabled(true);
        btnanterior.setEnabled(true);
        btnordenar.setEnabled(true);
        btnsiguiente.setEnabled(true);
    }

    public void sort() {
        lista.inicio();
        lista.sort(coll);
        lista.inicio();
        mostrar();
    }

    public void adioscreacion() {
        btnsiguiente.setText("Empleado Siguiente");
        btnanterior.setText("Empleado Anterior");
        btnCargar.setEnabled(true);
        btncalcular.setEnabled(true);
        btncreado_masivo.setEnabled(true);
        btncrear.setEnabled(true);
        btnexportar.setEnabled(true);
        btnfinal.setEnabled(true);
        btninicio.setEnabled(true);
        btnanterior.setEnabled(false);
        btnordenar.setEnabled(true);
        btnsiguiente.setEnabled(true);
        desactivartextos();
        tipoemple.setEditable(false);
        tipoemple.setEnabled(false);
        lista.inicio();
        mostrar();
        creacion = false;

    }

    public void cambio(int i) {
        if (i == 0) {
            lblaux1.setText("Extra Mensual");
            lblaux2.setText("Lenguaje favorito");
            setprog();
        }
        if (i == 1) {

            lblaux1.setText("Extra Anual");
            lblaux2.setText("Departamento");
        }
    }

    public void cancelar() {
        adioscreacion();
    }

    public void aceptar() {
        int i = tipoemple.getSelectedIndex();
        boolean bool = false;
        boolean existe = false;
        lista.inicio();
        while (true) {
            if (Integer.parseInt(txtnumero.getText()) == lista.getnumero()) {
                existe = true;
            }
            lista.adelante();
            if (bool) {
                break;
            }
            if (lista.esultimo()) {
                bool = true;
            }

            System.out.println("bucle");
        }
        if (existe) {
            JOptionPane.showMessageDialog(this, "Ya existe un empleado con ese numero, por favor, cambialo");
        } else {
            if (i == 0) {
                Programador p = new Programador(Float.parseFloat(txtaux1.getText()), txtaux2.getText(), txtnombre.getText(), Float.parseFloat(txtsueldo.getText()), Float.parseFloat(txtsueldo_max.getText()), Integer.parseInt(txtnumero.getText()));
                lista.add(p);
            }
            if (i == 1) {
                Analista a = new Analista(Float.parseFloat(txtaux1.getText()), Integer.parseInt(txtaux2.getText()), txtnombre.getText(), Float.parseFloat(txtsueldo.getText()), Float.parseFloat(txtsueldo_max.getText()), Integer.parseInt(txtnumero.getText()));
                lista.add(a);
            }
            adioscreacion();
        }

    }

    public void calcular() throws Exception {
        if (tipoemple.getSelectedIndex() == 0) {
            Programador aux = (Programador) lista.getmain();
            try {
                aux.calcular();
                mostrar();
            } catch (SaldoExepcion e) {
                JOptionPane.showMessageDialog(this, e);
            }

        } else {
            Analista aux = (Analista) lista.getmain();
            try {
                aux.calcular();
                mostrar();
            } catch (SaldoExepcion e) {
                JOptionPane.showMessageDialog(this, e);
            }

        }

    }

    public Calendar getFechaAleatoria(int anioInicio, int anioFin) {
        // Crear una instancia del objeto Random
        Random random = new Random();

        // Obtener un año aleatorio entre anioInicio y anioFin
        int anio = random.nextInt(anioFin - anioInicio + 1) + anioInicio;

        // Obtener un mes aleatorio entre 0 y 11 (enero a diciembre)
        int mes = random.nextInt(12);

        // Obtener un día aleatorio entre 1 y 28 (para simplificar)
        int dia = random.nextInt(28) + 1;

        // Crear una instancia del objeto Calendar con la fecha aleatoria generada
        Calendar fechaAleatoria = new GregorianCalendar(anio, mes, dia);

        return fechaAleatoria;
    }

    public void creado_masivo() {

        String[] nombres = {
            "Adrián", "Alejandro", "Alonso", "Álvaro", "Amelia", "Ana", "Antonia", "Antonio", "Ariadna", "Arturo",
            "Beatriz", "Benjamín", "Blanca", "Bruno", "Carla", "Carlos", "Carmen", "Catalina", "Cecilia", "César",
            "Clara", "Claudia", "Cristian", "Cristina", "Daniel", "David", "Diego", "Dolores", "Eduardo", "Elena",
            "Emilia", "Emilio", "Enrique", "Ernesto", "Esmeralda", "Esteban", "Estela", "Eva", "Fabián", "Federico",
            "Fernanda", "Fernando", "Francisca", "Francisco", "Gabriel", "Gabriela", "Gerardo", "Gonzalo", "Graciela",
            "Guillermo", "Gustavo", "Héctor", "Hugo", "Inés", "Ignacio", "Irene", "Isabel", "Ismael", "Jacobo",
            "Javier", "Jesús", "Jimena", "Joaquín", "Jonathan", "Jorge", "José", "Josefa", "Josefina", "Juan",
            "Juana", "Julia", "Julián", "Laura", "Leandro", "Leonardo", "Leticia", "Lorenzo", "Lucas", "Lucía",
            "Luis", "Luisa", "Manuel", "Manuela", "Marcelo", "María", "Mariana", "Marina", "Mario", "Marta",
            "Martín", "Mateo", "Matías", "Miguel", "Mónica", "Natalia", "Nicolás", "Olivia", "Óscar", "Pablo",
            "Patricia", "Paula", "Pedro", "Raquel", "Rebeca", "Ricardo", "Roberto", "Rodrigo", "Rosa", "Rubén",
            "Salvador", "Samuel", "Sandra", "Santiago", "Sara", "Sebastián", "Sergio", "Silvia", "Simón", "Sofía",
            "Sonia", "Susana", "Teresa", "Tomás", "Valentina", "Valentín", "Vicente", "Victoria", "Violeta", "Yolanda",
            "Zoe"
        };

        String[] lenguajes = {
            "Java", "Python", "JavaScript", "C++", "Ruby", "Go", "Swift"
        };

        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            int tipoemple = random.nextInt(2);
            int aux=random.nextInt(nombres.length);
            String nombre = nombres[aux];
            //
            float salario = random.nextInt(3000) + 1;
            float salario_max;
            int numero=random.nextInt(998000)+2001;
            int x;
            x = random.nextInt(5000) + 1;
            while (x < salario) {
                x = random.nextInt(5000) + 1;
            }
            salario_max=x;
            float extra=random.nextInt(500)+1;
            if(tipoemple==0){
                aux=random.nextInt(lenguajes.length);
                String lenguaje = lenguajes[aux];
                Programador p=new Programador(extra, lenguaje, nombre, salario, salario_max, numero);
                p.setFecha(getFechaAleatoria(2000, 2023));
                lista.add(p);
                coll.add(p);
            }
            if(tipoemple==1){
                int ndepart=random.nextInt(80)+1;
                Analista a = new Analista(extra, ndepart, nombre, salario, salario_max, numero);
                a.setFecha(getFechaAleatoria(2000, 2023));
                lista.add(a);
                coll.add(a);
            }
        }
    }

        public void creado_semimasivo() {

        String[] nombres = {
            "Adrián", "Alejandro", "Alonso", "Álvaro", "Amelia", "Ana", "Antonia", "Antonio", "Ariadna", "Arturo",
            "Beatriz", "Benjamín", "Blanca", "Bruno", "Carla", "Carlos", "Carmen", "Catalina", "Cecilia", "César",
            "Clara", "Claudia", "Cristian", "Cristina", "Daniel", "David", "Diego", "Dolores", "Eduardo", "Elena",
            "Emilia", "Emilio", "Enrique", "Ernesto", "Esmeralda", "Esteban", "Estela", "Eva", "Fabián", "Federico",
            "Fernanda", "Fernando", "Francisca", "Francisco", "Gabriel", "Gabriela", "Gerardo", "Gonzalo", "Graciela",
            "Guillermo", "Gustavo", "Héctor", "Hugo", "Inés", "Ignacio", "Irene", "Isabel", "Ismael", "Jacobo",
            "Javier", "Jesús", "Jimena", "Joaquín", "Jonathan", "Jorge", "José", "Josefa", "Josefina", "Juan",
            "Juana", "Julia", "Julián", "Laura", "Leandro", "Leonardo", "Leticia", "Lorenzo", "Lucas", "Lucía",
            "Luis", "Luisa", "Manuel", "Manuela", "Marcelo", "María", "Mariana", "Marina", "Mario", "Marta",
            "Martín", "Mateo", "Matías", "Miguel", "Mónica", "Natalia", "Nicolás", "Olivia", "Óscar", "Pablo",
            "Patricia", "Paula", "Pedro", "Raquel", "Rebeca", "Ricardo", "Roberto", "Rodrigo", "Rosa", "Rubén",
            "Salvador", "Samuel", "Sandra", "Santiago", "Sara", "Sebastián", "Sergio", "Silvia", "Simón", "Sofía",
            "Sonia", "Susana", "Teresa", "Tomás", "Valentina", "Valentín", "Vicente", "Victoria", "Violeta", "Yolanda",
            "Zoe"
        };

        String[] lenguajes = {
            "Java", "Python", "JavaScript", "C++", "Ruby", "Go", "Swift"
        };

        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            int tipoemple = random.nextInt(2);
            int aux=random.nextInt(nombres.length);
            String nombre = nombres[aux];
            //
            float salario = random.nextInt(3000) + 1;
            float salario_max;
            int numero=random.nextInt(2000);
            int x;
            x = random.nextInt(5000) + 1;
            while (x < salario) {
                x = random.nextInt(5000) + 1;
            }
            salario_max=x;
            float extra=random.nextInt(500)+1;
            if(tipoemple==0){
                aux=random.nextInt(lenguajes.length);
                String lenguaje = lenguajes[aux];
                Programador p=new Programador(extra, lenguaje, nombre, salario, salario_max, numero);
                p.setFecha(getFechaAleatoria(2000, 2023));
                lista.add(p);
                coll.add(p);
            }
            if(tipoemple==1){
                int ndepart=random.nextInt(80)+1;
                Analista a = new Analista(extra, ndepart, nombre, salario, salario_max, numero);
                a.setFecha(getFechaAleatoria(2000, 2023));
                lista.add(a);
                coll.add(a);
            }
        }
    }
    
    public void sort_coll(){
        
    }
        
    public jpaneldeunoenuno() {
        lista = new MyList<>();
        coll = new ArrayList<>();
        //Programador p = new Programador(150, "java", "Pedro", 150, 1000, 3);
        Analista a = new Analista(150, 2, "josefina", 150, 150, 5);
        GregorianCalendar c = (GregorianCalendar) getFechaAleatoria(2000, 2023);
        a.setFecha(c);
        lista.add(a);
        Programador p = new Programador(100, "python", "antouni", 100, 300, 7);
        GregorianCalendar x = (GregorianCalendar) getFechaAleatoria(2000, 2023);
        p.setFecha(x);
        lista.add(p);
        coll.add(p);
        coll.add(a);
        initComponents();
        //lista.showMyList();
        setemple();
        mostrar();
        desactivartextos();
        btnanterior.setEnabled(false);
        //btncalcular.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanelempleado = new javax.swing.JPanel();
        btnCargar = new javax.swing.JButton();
        btnexportar = new javax.swing.JButton();
        btncrear = new javax.swing.JButton();
        lblnumero = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblsueldo = new javax.swing.JLabel();
        lblsueldo_max = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        lblaux1 = new javax.swing.JLabel();
        lblaux2 = new javax.swing.JLabel();
        tipoemple = new javax.swing.JComboBox<>();
        txtnumero = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtsueldo = new javax.swing.JTextField();
        txtsueldo_max = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();
        txtaux1 = new javax.swing.JTextField();
        txtaux2 = new javax.swing.JTextField();
        btninicio = new javax.swing.JButton();
        btnanterior = new javax.swing.JButton();
        btnfinal = new javax.swing.JButton();
        btnsiguiente = new javax.swing.JButton();
        btncreado_masivo = new javax.swing.JButton();
        btncalcular = new javax.swing.JButton();
        btnordenar = new javax.swing.JButton();

        jpanelempleado.setBackground(new java.awt.Color(255, 255, 255));

        btnCargar.setText("Cargar Empleados");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        btnexportar.setText("Exportar Empleados");
        btnexportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexportarActionPerformed(evt);
            }
        });

        btncrear.setText("Crear nuevo Empleado");
        btncrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncrearActionPerformed(evt);
            }
        });

        lblnumero.setText("NUMERO");

        lblnombre.setText("NOMBRE");

        lblsueldo.setText("SUELDO");

        lblsueldo_max.setText("SUELDO MAXIMO");

        lblfecha.setText("FECHA DE ALTA");

        lblaux1.setText("aaaaaaa");

        lblaux2.setText("AAAAAAA");

        tipoemple.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        tipoemple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoempleActionPerformed(evt);
            }
        });

        btninicio.setText("Ir al primer Empleado");
        btninicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninicioActionPerformed(evt);
            }
        });

        btnanterior.setText("Empleado Anterior");
        btnanterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanteriorActionPerformed(evt);
            }
        });

        btnfinal.setText("Ir al ultimo Empleado");
        btnfinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfinalActionPerformed(evt);
            }
        });

        btnsiguiente.setText("Empleado Siguiente");
        btnsiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsiguienteActionPerformed(evt);
            }
        });

        btncreado_masivo.setText("Creado masivo de Empleados");
        btncreado_masivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreado_masivoActionPerformed(evt);
            }
        });

        btncalcular.setText("Calcular");
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });

        btnordenar.setText("Ordenar Empleados");
        btnordenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnordenarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanelempleadoLayout = new javax.swing.GroupLayout(jpanelempleado);
        jpanelempleado.setLayout(jpanelempleadoLayout);
        jpanelempleadoLayout.setHorizontalGroup(
            jpanelempleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelempleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelempleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelempleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jpanelempleadoLayout.createSequentialGroup()
                            .addComponent(btninicio)
                            .addGap(18, 18, 18)
                            .addComponent(btnanterior)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnsiguiente)
                            .addGap(18, 18, 18)
                            .addComponent(btnfinal))
                        .addGroup(jpanelempleadoLayout.createSequentialGroup()
                            .addGroup(jpanelempleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btncreado_masivo)
                                .addComponent(btncrear)
                                .addComponent(btnordenar)
                                .addComponent(btnexportar)
                                .addComponent(btncalcular))
                            .addGroup(jpanelempleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpanelempleadoLayout.createSequentialGroup()
                                    .addGroup(jpanelempleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblnumero, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblaux2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblaux1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblfecha, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblsueldo_max, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblsueldo, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblnombre, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGap(18, 18, 18)
                                    .addGroup(jpanelempleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtaux1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtfecha, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtsueldo_max, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtsueldo, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtnombre, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtnumero)
                                        .addComponent(txtaux2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jpanelempleadoLayout.createSequentialGroup()
                                    .addGap(75, 75, 75)
                                    .addComponent(tipoemple, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(btnCargar))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jpanelempleadoLayout.setVerticalGroup(
            jpanelempleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelempleadoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(tipoemple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnCargar)
                .addGap(18, 18, 18)
                .addGroup(jpanelempleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnumero)
                    .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncalcular))
                .addGap(18, 18, 18)
                .addGroup(jpanelempleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnombre)
                    .addComponent(btncreado_masivo))
                .addGap(18, 18, 18)
                .addGroup(jpanelempleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblsueldo)
                    .addComponent(btncrear))
                .addGap(18, 18, 18)
                .addGroup(jpanelempleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsueldo_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblsueldo_max)
                    .addComponent(btnordenar))
                .addGap(18, 18, 18)
                .addGroup(jpanelempleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanelempleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblfecha)
                        .addComponent(btnexportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jpanelempleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtaux1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblaux1))
                .addGap(18, 18, 18)
                .addGroup(jpanelempleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtaux2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblaux2))
                .addGap(40, 40, 40)
                .addGroup(jpanelempleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btninicio)
                    .addComponent(btnanterior)
                    .addComponent(btnfinal)
                    .addComponent(btnsiguiente))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelempleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelempleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        importar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCargarActionPerformed

    private void tipoempleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoempleActionPerformed
        // TODO add your handling code here:
        cambio(tipoemple.getSelectedIndex());
    }//GEN-LAST:event_tipoempleActionPerformed

    private void btninicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninicioActionPerformed
        // TODO add your handling code here:
        primero();
    }//GEN-LAST:event_btninicioActionPerformed

    private void btnanteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanteriorActionPerformed
        if (creacion) {
            cancelar();
        } else {
            retroceder();
        }
    }//GEN-LAST:event_btnanteriorActionPerformed

    private void btnfinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfinalActionPerformed
        ultimo();
    }//GEN-LAST:event_btnfinalActionPerformed

    private void btnsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsiguienteActionPerformed

        if (creacion) {
            aceptar();
        } else {
            avanzar();
        }
    }//GEN-LAST:event_btnsiguienteActionPerformed

    private void btncrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncrearActionPerformed
        // TODO add your handling code here:
        creacion = true;
        prepararcreacion();
    }//GEN-LAST:event_btncrearActionPerformed

    private void btnexportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexportarActionPerformed
        // TODO add your handling code here:
        exportar();
    }//GEN-LAST:event_btnexportarActionPerformed

    private void btnordenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnordenarActionPerformed
        // TODO add your handling code here:
        desactivar_btns();
        sort();
        //sort_coll();
        activar_btns();
        
    }//GEN-LAST:event_btnordenarActionPerformed

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
        try {
            // TODO add your handling code here:
            calcular();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btncalcularActionPerformed

    private void btncreado_masivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreado_masivoActionPerformed
        // TODO add your handling code here:
        desactivar_btns();
        creado_masivo();
        creado_semimasivo();
        activar_btns();
    }//GEN-LAST:event_btncreado_masivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnanterior;
    private javax.swing.JButton btncalcular;
    private javax.swing.JButton btncreado_masivo;
    private javax.swing.JButton btncrear;
    private javax.swing.JButton btnexportar;
    private javax.swing.JButton btnfinal;
    private javax.swing.JButton btninicio;
    private javax.swing.JButton btnordenar;
    private javax.swing.JButton btnsiguiente;
    private javax.swing.JPanel jpanelempleado;
    private javax.swing.JLabel lblaux1;
    private javax.swing.JLabel lblaux2;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblnumero;
    private javax.swing.JLabel lblsueldo;
    private javax.swing.JLabel lblsueldo_max;
    private javax.swing.JComboBox<String> tipoemple;
    private javax.swing.JTextField txtaux1;
    private javax.swing.JTextField txtaux2;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnumero;
    private javax.swing.JTextField txtsueldo;
    private javax.swing.JTextField txtsueldo_max;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;


import Controlador.Controlador;
import com.sun.awt.AWTUtilities;
import hilos.*;
import java.awt.Point;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import methods.*;



/**
 *
 * @author JORGE DELGADILLO
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    int x,y; //para guardar poscicion y permitir el movimiento del frame
    //instanciamos clase para hacer el cambio de tamaño de ls imagenes
    cambioTamaño pantalla = new cambioTamaño();
    //instanciamos la clase para le hora y fecha actual
    reloj_fecha date = new reloj_fecha();
    //instanciamos la clase qeu nos permite hacer el intercambio de las imagenes
    cambioImagenes imgCambio = new cambioImagenes();
    
    botones boton = new botones();
    
    private Controlador controlador;
    
    public login() {
        
        controlador = new Controlador();
        
        initComponents();
        //ubicamos en el centro el frame 
        setLocationRelativeTo(null);
        //colocamos el fondo de la pantalla 
        Icon icono = pantalla.cambio(750, 530, "/img/fondo.png");
        
        fondo.setIcon(icono);
        //colocamos la primera imagen qeu se verea antes de hacer los cambios
        Icon label = pantalla.cambio(300,300,"/img/info_sistemas.png");
        
        lbCambio.setIcon(label);
        //hacemos el borde redondo
        Shape form = new RoundRectangle2D.Double(0,0,this.getBounds().width,this.getBounds().height,27,27);
        
        AWTUtilities.setWindowShape(this,form);
        //corremos la hora 
        date.iniciar(lbHora, lbFecha);
        //corremos el cambio de imagenes 
        imgCambio.cambio2(lbCambio);
        
    }
    //eliminar el contenido de la contraseña
    void eliminarContraseña(){
        txtContraseña.setText("");
    }
    //comprueba el llenado de datos
    boolean comprobarLlenado(){
        //verifica que los espacios de usuario y contraseña no sean colocados el blanco
        boolean comp = false;
        String usuario = txtUsuario.getText();
        String contraseña = String.valueOf(txtContraseña.getPassword());
        if(usuario.equals("")  ||  contraseña.equals("")){
            comp = true;
        }return comp;  
    }
    //valida los datos
    private boolean validar (String usuario){
        boolean resp = false;
        //comprovar que el correo tenga @ con alguna cuenta
        String valido = "gmail.com";
        String valido2 = "hotmail.com";
        //siclo para llegar al caracter @ en el correo
        for(int i = 0; i < usuario.length();i++){
            if(usuario.charAt(i)=='@'){
                if(formarCadena(usuario,i+1).equals(valido)){
                    resp = true;}
                if(formarCadena(usuario,i+1).equals(valido2)){
                    resp = true;}
            }
        }return resp;
    }
    //formamos la cadena
    private String formarCadena(String usuario, int i){
        //metodo privado formarCadena usado por validar
        String resp = "";
        if(i<usuario.length()){
            resp = usuario.charAt(i)+formarCadena(usuario,i+1);
        }return resp;
    }

    
    //metodo que permite cambiar el icono de la plataformaen la barar de tareas de windows
     public Image getIconImage(){       
        Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/info_sistemas.png"));       
        return retvalue;  
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        lbLabo = new javax.swing.JLabel();
        lbUniversidad = new javax.swing.JLabel();
        lbNomHora = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();
        lbNomFecha = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        lbCambio = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        lbContraseña = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        btnSesion = new javax.swing.JButton();
        btnRegistro = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setBackground(new java.awt.Color(204, 204, 255));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 90, 40));

        lbLabo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbLabo.setText("LABORATORIOS DE INFORMATICA SISTEMAS");
        getContentPane().add(lbLabo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 400, -1));

        lbUniversidad.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbUniversidad.setText("\"UNIVERSIDAD MAYOR DE SAN SIMON \"");
        getContentPane().add(lbUniversidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 460, -1));

        lbNomHora.setForeground(new java.awt.Color(255, 255, 255));
        lbNomHora.setText("Hora:");
        getContentPane().add(lbNomHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        lbHora.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 70, 20));

        lbNomFecha.setForeground(new java.awt.Color(255, 255, 255));
        lbNomFecha.setText("Fecha:");
        getContentPane().add(lbNomFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        lbFecha.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 84, 80, 20));

        lbCambio.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 300, 300));

        lbUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbUsuario.setText("Usuario:");
        getContentPane().add(lbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, -1, -1));

        lbContraseña.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbContraseña.setText("Contraseña:");
        getContentPane().add(lbContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, -1, -1));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 240, -1));

        txtContraseña.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 240, -1));

        btnSesion.setBackground(new java.awt.Color(204, 204, 255));
        btnSesion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSesion.setText("Iniciar Sesión");
        btnSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSesionMouseExited(evt);
            }
        });
        btnSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSesionActionPerformed(evt);
            }
        });
        getContentPane().add(btnSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 280, 140, 30));

        btnRegistro.setBackground(new java.awt.Color(204, 204, 255));
        btnRegistro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistro.setText("Registrarse");
        btnRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistroMouseExited(evt);
            }
        });
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 360, 130, 30));

        fondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                fondoMouseDragged(evt);
            }
        });
        fondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fondoMousePressed(evt);
            }
        });
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 750, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        try {
            // cerramos el programa
            controlador.cierraConexion();
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void fondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMousePressed
        // capturamos la poscicion en x al hacer click 
        x = evt.getX();
        //capturamos la poscicion y al hacer click
        y = evt.getY();
        
    }//GEN-LAST:event_fondoMousePressed

    private void fondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMouseDragged
        //capturamos la posicion del mause al moverlo 
        Point p = MouseInfo.getPointerInfo().getLocation();
        //movemos el frame en la direccion en la que arrastremos el mouse
        setLocation(p.x-x,p.y-y);
        
    }//GEN-LAST:event_fondoMouseDragged

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        // TODO add your handling code here:
        crearUsuario usuario = new crearUsuario("profesor",controlador);
        
        usuario.setVisible(true);
        
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void btnSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSesionActionPerformed
         if(!comprobarLlenado()){
            if(validar(txtUsuario.getText())){
                String validar = controlador.validarUsuario(txtUsuario.getText(), String.valueOf(txtContraseña.getPassword()));
                if(validar.equals(""))
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
                else{ 
                    if(validar.equalsIgnoreCase("Administrador")){
                        Administrador administrador = new Administrador();
                        administrador.setControlador(controlador);
                        administrador.setCorreo(txtUsuario.getText());
                        try {
                            administrador.setInicio();
                        } catch (SQLException ex) {
                            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        administrador.setLogin(this);
                        administrador.setVisible(true);
                        this.setVisible(false);
                    }
                    if(validar.equalsIgnoreCase("Profesor")){
                        Educador educador = new Educador();
                        educador.setControlador(controlador);
                        educador.setCorreo(txtUsuario.getText());
                         try {
                            educador.setInicio();
                        } catch (SQLException ex) {
                            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        educador.setLogin(this);
                        educador.setVisible(true);
                        this.setVisible(false);
                    }
                    if(validar.equalsIgnoreCase("Alumno")){
                        Estudiante estudiante = new Estudiante();
                        estudiante.setControlador(controlador);
                        estudiante.setCorreo(txtUsuario.getText());
                        try {
                            estudiante.setInicio();
                        } catch (SQLException ex) {
                            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        estudiante.setLogin(this);
                        estudiante.setVisible(true);
                        this.setVisible(false);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Usuario es una direccion E-MAIL");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Falta llenar algunos datos");
        }
    }//GEN-LAST:event_btnSesionActionPerformed

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        // TODO add your handling code here:
        boton.cambioColorSalir(btnSalir, "entrada");
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        // TODO add your handling code here:
        boton.cambioColorSalir(btnSalir, "salida");
    }//GEN-LAST:event_btnSalirMouseExited

    private void btnSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSesionMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(btnSesion, "entrada");
    }//GEN-LAST:event_btnSesionMouseEntered

    private void btnSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSesionMouseExited
        // TODO add your handling code here:
        boton.cambioColor(btnSesion, "salida");
    }//GEN-LAST:event_btnSesionMouseExited

    private void btnRegistroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(btnRegistro, "entrada");
    }//GEN-LAST:event_btnRegistroMouseEntered

    private void btnRegistroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMouseExited
        // TODO add your handling code here:
        boton.cambioColor(btnRegistro, "salida");
    }//GEN-LAST:event_btnRegistroMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistro;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSesion;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel lbCambio;
    private javax.swing.JLabel lbContraseña;
    public static javax.swing.JLabel lbFecha;
    public static javax.swing.JLabel lbHora;
    private javax.swing.JLabel lbLabo;
    private javax.swing.JLabel lbNomFecha;
    private javax.swing.JLabel lbNomHora;
    private javax.swing.JLabel lbUniversidad;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
}

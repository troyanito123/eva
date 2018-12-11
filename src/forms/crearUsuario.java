/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import Controlador.Controlador;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import methods.cambioTamaño;
import methods.validarCorreo;
import methods.botones;
/**
 *
 * @author JORGE DELGADILLO
 */
public class crearUsuario extends javax.swing.JFrame {

    /**
     * Creates new form crearUsuario
     */
    //variable para crear e combo depende de donde estemos mandando la cfeacion del usuario 
    private String variacion;
    //estas variables definen donde se movera el grame
    int x,y;
    //instanciamos la clase para hacer el cambio de tamaño de las imagenes
    cambioTamaño pantalla = new cambioTamaño();

    //instanciamos la clase para la validacion delos correos
    validarCorreo validacion = new validarCorreo();
    //instanciamos la clase para cambiar el color a los bortones
    botones boton = new botones();
    
    private String correo;
   
    private String entrada;
    private Controlador controlador; 
    public crearUsuario(String entrada , String correo, String variacion,Controlador controlador) throws SQLException{
        this.variacion = variacion;
        this.correo = correo ;
        this.entrada = entrada;
        this.controlador = controlador;
        initComponents();
        //colocamos el frae al centro de la pantalla
        setLocationRelativeTo(null);
        //hacemos el borde redondo
        Shape form = new RoundRectangle2D.Double(0,0,this.getBounds().width,this.getBounds().height,27,27);
        
        AWTUtilities.setWindowShape(this,form);
        
        recuperarDatos(correo);
        
        titulo.setText("Edicion del Usuario");
        
        btnTerminar.setText("Actualizar");
        
        txtCorreo.setEditable(false);
        
        labelCorreo.setVisible(false);
        
        combo.setVisible(false);
        
    }
    //metodo que permite cambiar el icono de la plataformaen la barar de tareas de windows
     public Image getIconImage(){       
        Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/info_sistemas.png"));       
        return retvalue;  
    }
    public crearUsuario(String variacion,Controlador controlador){
        
        this.variacion = variacion;
        
        this.correo = "";
        this.controlador = controlador;
        this.entrada = "";
        
        initComponents();
        //colocamos el frae al centro de la pantalla
        setLocationRelativeTo(null);
        //hacemos el borde redondo
        Shape form = new RoundRectangle2D.Double(0,0,this.getBounds().width,this.getBounds().height,27,27);
        
        AWTUtilities.setWindowShape(this,form);
        //cambiamos el comboBox administrador tiene mayor privilegio
        comboCambiar();
        //ponemos la imagen por defecto 
        poner_imagen();
        
    }
    
    public crearUsuario() {
        
        initComponents();
        setLocationRelativeTo(null);
    }
  
   //para recuperar los datos en a interfaz
    public void recuperarDatos(String correo) throws SQLException{
        ImageIcon imagen= controlador.getImagenPerfil(correo);
        labelImagen.setIcon(imagen);
        String datos [] = controlador.editarUsuario(correo);
        txtCorreo.setText(datos[0]);
        txtNombres.setText(datos[3]);
        txtApellidos.setText(datos[4]);
        txtTelefono.setText(datos[5]);
        
        
    }
    //para limpiar una vez insertado
    private void limpiar(){
        
        txtCorreo.setText("");
        labelCorreo.setText("");
        txtContraUno.setText("");
        txtContraDos.setText("");
        labelIgual.setText("");
        poner_imagen();
        txtNombres.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        combo.setSelectedIndex(0);
    }
   
    //colocamos la imagen por defecto y la ruta al label para enviar a la base de datos
    private void poner_imagen(){
    
        //colocamos el fondo de la pantalla 
        Icon icono = pantalla.cambio(150, 150, "/img/usuario.png");
        
        labelImagen.setIcon(icono);
        
        labelRuta.setText("C:\\usuario.png");
        
    }
    //para saber con que tipos de usuarios se podra crear en este frame varia si es administrador
    private void comboCambiar(){
        if(variacion == "login"){
            combo.setVisible(false);
            combo.setEnabled(false);
        }else{
        
            if(variacion == "estudiantes"){
            
            combo.addItem("Estudiante");
            
            combo.addItem("Profesor");
        
        }else if(variacion == "administrador"){

            
            combo.addItem("Administrador");
            
            combo.addItem("profesor");
            
            combo.addItem("Estudiante");
        
        }else if(variacion == "profesor" ){
            
            combo.addItem("Profesor");
            combo.addItem("Estudiante");
        
        }
            
        }
    
        
        
    }
    //para hacer la aztualizacion de la persona
    private void ActualizarPersona() throws SQLException, FileNotFoundException{
        if(String.valueOf(txtContraUno.getPassword()).equals("") && String.valueOf(txtContraDos.getPassword()).equals("")){
            if(labelRuta.getText().equals("")){
                if(controlador.actualizarPersona(null, txtNombres.getText(), txtApellidos.getText(), txtTelefono.getText(), correo)){
                    JOptionPane.showMessageDialog(null, "Datos Actualizados");
                }else{
                    JOptionPane.showMessageDialog(null,"ha ocurrido un error,los datos no se actualizaron");
                }
        
            }else{
                FileInputStream fi = null;
                File file = new File(labelRuta.getText());
                 fi = new FileInputStream(file);
                if(controlador.actualizarPersona(fi, txtNombres.getText(), txtApellidos.getText(), txtTelefono.getText(), correo)){
                    JOptionPane.showMessageDialog(null, "Datos Actualizados");
                }else{
                    JOptionPane.showMessageDialog(null,"ha ocurrido un error,los datos no se actualizaron");
                }
            }
        }else{
            if(String.valueOf(txtContraUno.getPassword()).equals(String.valueOf(txtContraDos.getPassword()))){
                
                    
                    if(controlador.actualizarCuenta(String.valueOf(txtContraUno.getPassword()), correo)){
                        if(labelRuta.getText()==""){
                            
                            if(controlador.actualizarPersona(null, txtNombres.getText(),txtApellidos.getText(),txtTelefono.getText(),txtCorreo.getText())){
                                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                            }else{
                                    JOptionPane.showMessageDialog(null,"ha ocurrido un error,los datos no se actualizaron");
                            }
                        }else{
                            FileInputStream fi = null;
                            File file = new File(labelRuta.getText());
                            fi = new FileInputStream(file);
                            if(controlador.actualizarPersona(fi, txtNombres.getText(),txtApellidos.getText(),txtTelefono.getText(),txtCorreo.getText())){
                                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                            }else{
                                    JOptionPane.showMessageDialog(null,"ha ocurrido un error,los datos no se actualizaron");
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"ha ocurrido un error,los datos no se actualizaron");
                    }
                    
                
            }else{
                JOptionPane.showMessageDialog(null,"Contraseñas no coinciden");
            }
        }
    }
    //metodo para insertar la persona a la base de datos
    private void insertarPersona(String tipo_usuario){
            FileInputStream fi = null;
            File file = new File(labelRuta.getText());
            if(tipo_usuario.equals("Estudiante")){
                
                try {
                    fi = new FileInputStream(file);
                    if(controlador.insertarCuenta(txtCorreo.getText(),String.valueOf(txtContraUno.getPassword()),3)){
                           if(txtTelefono.getText().equals("")){
                                if(controlador.insertarPersona(fi, txtNombres.getText(),txtApellidos.getText(),0,txtCorreo.getText())){
                                   JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente");
                                }else{
                                    JOptionPane.showMessageDialog(null,"ha ocurrido un error, no se pudo crear la cuenta");
                                }
                            }else{
                                
                                if(controlador.insertarPersona(fi, txtNombres.getText(),txtApellidos.getText(),Integer.parseInt(txtTelefono.getText()),txtCorreo.getText())){
                                   JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente");
                                }else{
                                    JOptionPane.showMessageDialog(null,"ha ocurrido un error, no se pudo crear la cuenta");
                                }
                           }  
                    }
                    
                }  catch (SQLException ex) {
                 Logger.getLogger(crearUsuario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(crearUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
        }else if(tipo_usuario.equals("Profesor")){
                    
                try {
                    fi = new FileInputStream(file);
                    if(controlador.insertarCuenta(txtCorreo.getText(),String.valueOf(txtContraUno.getPassword()),2)){
                           if(txtTelefono.getText().equals("")){
                                if(controlador.insertarPersona(fi, txtNombres.getText(),txtApellidos.getText(),0,txtCorreo.getText())){
                                   JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente");
                                }else{
                                    JOptionPane.showMessageDialog(null,"ha ocurrido un error, no se pudo crear la cuenta");
                                }
                            }else{
                                
                                if(controlador.insertarPersona(fi, txtNombres.getText(),txtApellidos.getText(),Integer.parseInt(txtTelefono.getText()),txtCorreo.getText())){
                                   JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente");
                                }else{
                                    JOptionPane.showMessageDialog(null,"ha ocurrido un error, no se pudo crear la cuenta");
                                }
                           }  
                    }
                    
                }  catch (SQLException ex) {
                 Logger.getLogger(crearUsuario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(crearUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
        }else{
                   
                try {
                    fi = new FileInputStream(file);
                    if(controlador.insertarCuenta(txtCorreo.getText(),String.valueOf(txtContraUno.getPassword()),1)){
                           if(txtTelefono.getText().equals("")){
                                if(controlador.insertarPersona(fi, txtNombres.getText(),txtApellidos.getText(),0,txtCorreo.getText())){
                                   JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente");
                                }else{
                                    JOptionPane.showMessageDialog(null,"ha ocurrido un error, no se pudo crear la cuenta");
                                }
                            }else{
                                
                                if(controlador.insertarPersona(fi, txtNombres.getText(),txtApellidos.getText(),Integer.parseInt(txtTelefono.getText()),txtCorreo.getText())){
                                   JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente");
                                }else{
                                    JOptionPane.showMessageDialog(null,"ha ocurrido un error, no se pudo crear la cuenta");
                                }
                           }  
                    }
                    
                }  catch (SQLException ex) {
                 Logger.getLogger(crearUsuario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(crearUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
    //metodo para verificar si dicho numero es entero
    private static boolean entero(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labelImagen = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelRuta = new javax.swing.JLabel();
        btnTerminar = new javax.swing.JButton();
        btnElegir = new javax.swing.JButton();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        combo = new javax.swing.JComboBox<>();
        txtContraDos = new javax.swing.JPasswordField();
        txtContraUno = new javax.swing.JPasswordField();
        labelIgual = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labelCorreo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(242, 242, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setBackground(new java.awt.Color(204, 204, 255));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setText("CERRAR");
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
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, 35));

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setText("REGISTRO DEL USUARIO");
        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 320, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("(*)CORREO:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("(*)CONTRASEÑA:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("(*)REPITA_CONTRASEÑA:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("(*)NOMBRES:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("(*)APELLIDOS:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("TELEFONO:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("(*)TIPO USUARIO:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, -1, -1));

        labelImagen.setBackground(new java.awt.Color(255, 255, 255));
        labelImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(labelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 180, 150));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("PERFIL:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, -1));
        jPanel1.add(labelRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 150, 25));

        btnTerminar.setBackground(new java.awt.Color(204, 204, 255));
        btnTerminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTerminar.setText("Terminar Registro");
        btnTerminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTerminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTerminarMouseExited(evt);
            }
        });
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnTerminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 510, -1, 50));

        btnElegir.setBackground(new java.awt.Color(204, 204, 255));
        btnElegir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnElegir.setText("Elegir Imagen");
        btnElegir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnElegirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnElegirMouseExited(evt);
            }
        });
        btnElegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirActionPerformed(evt);
            }
        });
        jPanel1.add(btnElegir, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 150, -1));
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 210, -1));

        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 220, -1));
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 210, -1));
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 210, -1));

        jPanel1.add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 210, -1));

        txtContraDos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContraDosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContraDosFocusLost(evt);
            }
        });
        jPanel1.add(txtContraDos, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 220, -1));

        txtContraUno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContraUnoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContraUnoFocusLost(evt);
            }
        });
        jPanel1.add(txtContraUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 220, -1));
        jPanel1.add(labelIgual, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 140, 20));

        jLabel10.setText("Nota: los puntos marcados con (*) son de caracter obligatorio.");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, -1, -1));
        jPanel1.add(labelCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 150, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // para cerrar el frame
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
       // capturamos la poscicion en x al hacer click 
        x = evt.getX();
        //capturamos la poscicion y al hacer click
        y = evt.getY();
        
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
       //capturamos la posicion del mause al moverlo 
        Point p = MouseInfo.getPointerInfo().getLocation();
        //movemos el frame en la direccion en la que arrastremos el mouse
        setLocation(p.x-x,p.y-y);
        
    }//GEN-LAST:event_jPanel1MouseDragged

    private void btnElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirActionPerformed
        File archivo ;
        JFileChooser AbrirArchivo = new JFileChooser();
        AbrirArchivo.setFileFilter(new FileNameExtensionFilter("Extensiones de Imagenes","jpg","png","jpeg"));
        int respuesta = AbrirArchivo.showOpenDialog(this);
        if(respuesta == JFileChooser.APPROVE_OPTION){
            archivo = AbrirArchivo.getSelectedFile();
            labelRuta.setText(archivo.getAbsolutePath());
            Image foto = getToolkit().getImage(labelRuta.getText());
            foto = foto.getScaledInstance(150,150, 1);
            labelImagen.setIcon(new ImageIcon(foto));
        }   else{
            JOptionPane.showMessageDialog(null,"Error de extensiones");
        }
    }//GEN-LAST:event_btnElegirActionPerformed

    private void txtContraUnoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraUnoFocusGained
        //
        labelIgual.setText("");
    }//GEN-LAST:event_txtContraUnoFocusGained

    private void txtContraDosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraDosFocusGained
        // TODO add your handling code here:
        labelIgual.setText("");
    }//GEN-LAST:event_txtContraDosFocusGained

    private void txtContraDosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraDosFocusLost
        // verificaos la compatibilidad de las contraseñas
         if(String.valueOf(txtContraUno.getPassword()).equals(String.valueOf(txtContraDos.getPassword()))){
            labelIgual.setText("");
        }else{
            labelIgual.setText("Las contraseñas no coinciden");
            labelIgual.setForeground(Color.red.darker());
        }
    }//GEN-LAST:event_txtContraDosFocusLost

    private void txtContraUnoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraUnoFocusLost
        // verificamos para poner en rojo si es que las contraseñas no son iguales
          if(String.valueOf(txtContraUno.getPassword()).equals(String.valueOf(txtContraDos.getPassword()))){
            labelIgual.setText("");
        }else{
            labelIgual.setText("Las contraseñas no coinciden");
            labelIgual.setForeground(Color.red.darker());
        }
    }//GEN-LAST:event_txtContraUnoFocusLost

    private void txtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusGained
        // TODO add your handling code here:
        labelCorreo.setText("");
    }//GEN-LAST:event_txtCorreoFocusGained

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        if(validacion.validar(txtCorreo.getText())){
            if(controlador.existe(txtCorreo.getText())){
                labelCorreo.setText("Este correo ya esta en uso ");
                labelCorreo.setForeground(Color.red.darker());
            }else{
                labelCorreo.setText("Correo Valido");
                labelCorreo.setForeground(Color.green.darker());
            }
        }else{
            labelCorreo.setText("debe terminar en @gmail.com");
            labelCorreo.setForeground(Color.red.darker());
        }
    }//GEN-LAST:event_txtCorreoFocusLost

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        // TODO add your handling code here:
        String tipo_usuario = String.valueOf(combo.getSelectedItem());
        if(entrada.equals("actualizacion")){
            if(entero(txtTelefono.getText())){
                try {
                    ActualizarPersona();
                    this.dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(crearUsuario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(crearUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }else{

                    JOptionPane.showMessageDialog(null,"EL CAMPO TELEFONO TIENE QUE SER UN NUMERO");
                
            }
            
         }else{
                if(entero(txtTelefono.getText())){
                    insertarPersona(tipo_usuario);
                    limpiar();
              
             }else{
                   
                    JOptionPane.showMessageDialog(null,"EL CAMPO TELEFONO TIENE QUE SER UN NUMERO");
                    
                }
             
        }
        
        
    }//GEN-LAST:event_btnTerminarActionPerformed

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        //cambiamos el color del boton 
        boton.cambioColorSalir(btnSalir, "entrada");
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        //cambiamos el color del boton 
        boton.cambioColorSalir(btnSalir, "salida");
    }//GEN-LAST:event_btnSalirMouseExited

    private void btnElegirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnElegirMouseEntered
        //cambiamos el color del boton 
        boton.cambioColor(btnElegir, "entrada");
    }//GEN-LAST:event_btnElegirMouseEntered

    private void btnElegirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnElegirMouseExited
        //cambiamos el color del boton 
        boton.cambioColor(btnElegir, "salida");
    }//GEN-LAST:event_btnElegirMouseExited

    private void btnTerminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTerminarMouseEntered
        //cambiamos el color del boton 
        boton.cambioColor(btnTerminar, "entrada");
    }//GEN-LAST:event_btnTerminarMouseEntered

    private void btnTerminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTerminarMouseExited
        //cambiamos el color del boton 
        boton.cambioColor(btnTerminar, "salir");
    }//GEN-LAST:event_btnTerminarMouseExited

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
            java.util.logging.Logger.getLogger(crearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crearUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElegir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelIgual;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelRuta;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JPasswordField txtContraDos;
    private javax.swing.JPasswordField txtContraUno;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}

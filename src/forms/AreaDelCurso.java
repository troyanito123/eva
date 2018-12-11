/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;
import Controlador.Controlador;
import hilos.*;
import com.sun.awt.AWTUtilities;
import static forms.login.lbFecha;
import static forms.login.lbHora;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import methods.*;
/**
 *
 * @author JORGE DELGADILLO
 */
public class AreaDelCurso extends javax.swing.JFrame {

    /**
     * Creates new form AreaDelCurso
     */
    
   int x,y;
   //instanciamos clase para hacer el cambio de tamaño de ls imagenes
    cambioTamaño pantalla = new cambioTamaño();
    //instanciamos la clase para le hora y fecha actual
    reloj_fecha date = new reloj_fecha();
    //para los eventos al pasar el mouse sobre un bootn en especifico
    botones boton = new botones();
    
    private Controlador controlador;
    private String tipo;
    private String idCurso;
    private String correo;
    cambioPaneles cambioPanel = new cambioPaneles();
    public AreaDelCurso() {
        
        initComponents();
        
        //colocamos el fondo de la pantalla 
        Icon icono = pantalla.cambio(1205, 700, "/img/fondo.png");
        
        fondo.setIcon(icono);
        
        setLocationRelativeTo(null);
        //hacemos el borde redondo
        Shape form = new RoundRectangle2D.Double(0,0,this.getBounds().width,this.getBounds().height,27,27);
        
        AWTUtilities.setWindowShape(this,form);
        //corremos la hora 
        date.iniciar(lbHora, lbFecha);
        
    }
    public void setCorreo(String usuario) {
        this.correo = usuario;
        
    }
    public void setIdCurso(String id){
        this.idCurso = id;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setControlador (Controlador controlador){
        this.controlador = controlador;
    }
    public void setTituloCurso(String nombre){
    
            labelTitulo.setText("Nombre del Curso : "+nombre);
    }
    public void setInicio() throws SQLException{
            cambioPanel.cambiar_panel("anunciosCurso",panelPrincipal,850,450,idCurso,tipo,controlador);
    }
    public void anularConfiguracion(){
        if(tipo.equals("inscritos")){
            btnConfig.setVisible(false);
            btnConfig.setEnabled(false);
        }else{
            btnConfig.setVisible(true);
            btnConfig.setEnabled(true);
        }
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

        lbNomHora = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();
        lbNomfecha = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        umss = new javax.swing.JLabel();
        laboNombre = new javax.swing.JLabel();
        pEstudiante = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnExamenes = new javax.swing.JButton();
        btnDescripcion = new javax.swing.JButton();
        btnAnuncios = new javax.swing.JButton();
        btnForo = new javax.swing.JButton();
        btnNotas = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        btnConfig = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbNomHora.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbNomHora.setForeground(new java.awt.Color(255, 255, 255));
        lbNomHora.setText("Hora:");
        getContentPane().add(lbNomHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        lbHora.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbHora.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 56, 110, 20));

        lbNomfecha.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbNomfecha.setForeground(new java.awt.Color(255, 255, 255));
        lbNomfecha.setText("Fecha :");
        getContentPane().add(lbNomfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        lbFecha.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbFecha.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 96, 110, 30));

        umss.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        umss.setText("\" Universidad Mayor de San Simón \"");
        getContentPane().add(umss, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));

        laboNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        laboNombre.setText("Laboratorios de Informática Sistemas");
        getContentPane().add(laboNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, -1));

        pEstudiante.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pEstudiante.setText("ÁREA DEL CURSO");
        getContentPane().add(pEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, -1, -1));

        btnSalir.setBackground(new java.awt.Color(204, 204, 255));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, 130, 40));

        btnExamenes.setBackground(new java.awt.Color(204, 204, 255));
        btnExamenes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnExamenes.setText("Examenes");
        btnExamenes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExamenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExamenesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExamenesMouseExited(evt);
            }
        });
        btnExamenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExamenesActionPerformed(evt);
            }
        });
        getContentPane().add(btnExamenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 160, 50));

        btnDescripcion.setBackground(new java.awt.Color(204, 204, 255));
        btnDescripcion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDescripcion.setText("Descripcion del Curso");
        btnDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDescripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDescripcionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDescripcionMouseExited(evt);
            }
        });
        btnDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescripcionActionPerformed(evt);
            }
        });
        getContentPane().add(btnDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 160, 50));

        btnAnuncios.setBackground(new java.awt.Color(204, 204, 255));
        btnAnuncios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAnuncios.setText("Anuncios");
        btnAnuncios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnuncios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAnunciosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAnunciosMouseExited(evt);
            }
        });
        btnAnuncios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnunciosActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnuncios, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 160, 50));

        btnForo.setBackground(new java.awt.Color(204, 204, 255));
        btnForo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnForo.setText("Foro");
        btnForo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnForo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnForoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnForoMouseExited(evt);
            }
        });
        btnForo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForoActionPerformed(evt);
            }
        });
        getContentPane().add(btnForo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 160, 50));

        btnNotas.setBackground(new java.awt.Color(204, 204, 255));
        btnNotas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNotas.setText("Notas");
        btnNotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNotasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNotasMouseExited(evt);
            }
        });
        btnNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotasActionPerformed(evt);
            }
        });
        getContentPane().add(btnNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 160, 50));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 880, 460));

        labelTitulo.setText("NOMBRE DEL CURSO.-");
        getContentPane().add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 630, -1));

        btnConfig.setBackground(new java.awt.Color(204, 204, 255));
        btnConfig.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnConfig.setText("Configuraciones");
        btnConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConfigMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConfigMouseExited(evt);
            }
        });
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 70, 130, 40));

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
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 1200, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void fondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_fondoMousePressed

    private void fondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMouseDragged
        //capturamos la posicion del mause al moverlo 
        Point p = MouseInfo.getPointerInfo().getLocation();
        //movemos el frame en la direccion en la que arrastremos el mouse
        setLocation(p.x-x,p.y-y);
    }//GEN-LAST:event_fondoMouseDragged

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        // TODO add your handling code here:
        boton.cambioColorSalir(btnSalir, "entrada");
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        // TODO add your handling code here:
        boton.cambioColorSalir(btnSalir, "salida");
    }//GEN-LAST:event_btnSalirMouseExited

    private void btnAnunciosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnunciosMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(btnAnuncios, "entrada");
    }//GEN-LAST:event_btnAnunciosMouseEntered

    private void btnAnunciosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnunciosMouseExited
        // TODO add your handling code here:
        boton.cambioColor(btnAnuncios, "salida");
    }//GEN-LAST:event_btnAnunciosMouseExited

    private void btnDescripcionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescripcionMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(btnDescripcion, "entrada");
    }//GEN-LAST:event_btnDescripcionMouseEntered

    private void btnDescripcionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescripcionMouseExited
        // TODO add your handling code here:
        boton.cambioColor(btnDescripcion, "salida");
    }//GEN-LAST:event_btnDescripcionMouseExited

    private void btnExamenesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExamenesMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(btnExamenes,"entrada");
    }//GEN-LAST:event_btnExamenesMouseEntered

    private void btnExamenesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExamenesMouseExited
        // TODO add your handling code here:
        boton.cambioColor(btnExamenes, "salida");
    }//GEN-LAST:event_btnExamenesMouseExited

    private void btnNotasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotasMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(btnNotas, "entrada");
    }//GEN-LAST:event_btnNotasMouseEntered

    private void btnNotasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotasMouseExited
        // TODO add your handling code here:
        boton.cambioColor(btnNotas, "salida");
    }//GEN-LAST:event_btnNotasMouseExited

    private void btnForoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnForoMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(btnForo,"entrada");
    }//GEN-LAST:event_btnForoMouseEntered

    private void btnForoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnForoMouseExited
        // TODO add your handling code here:
        boton.cambioColor(btnForo, "salida");
    }//GEN-LAST:event_btnForoMouseExited

    private void btnConfigMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfigMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(btnConfig, "entrada");
    }//GEN-LAST:event_btnConfigMouseEntered

    private void btnConfigMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfigMouseExited
        // TODO add your handling code here:
        boton.cambioColor(btnConfig, "salida");
    }//GEN-LAST:event_btnConfigMouseExited

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
       try {
           // TODO add your handling code here:
           cambioPanel.cambiar_panel("cursoConfig",panelPrincipal,850,450,idCurso,tipo,controlador);
       } catch (SQLException ex) {
           Logger.getLogger(AreaDelCurso.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btnConfigActionPerformed

    private void btnAnunciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnunciosActionPerformed
       try {
           // TODO add your handling code here:
           cambioPanel.cambiar_panel("anunciosCurso",panelPrincipal,850,450,idCurso,tipo,controlador);
       } catch (SQLException ex) {
           Logger.getLogger(AreaDelCurso.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btnAnunciosActionPerformed

    private void btnExamenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExamenesActionPerformed
        // TODO add your handling code here:
        if(tipo.equalsIgnoreCase("inscritos")){
            try {
                cambioPanel.cursos("listaExamen", panelPrincipal, 850, 450, correo, Integer.parseInt(idCurso), tipo, controlador);
                
            } catch (SQLException ex) {
                Logger.getLogger(AreaDelCurso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                 cambioPanel.cursos("examen", panelPrincipal, 850, 450, correo, Integer.parseInt(idCurso), tipo, controlador);
            } catch (SQLException ex) {
                Logger.getLogger(AreaDelCurso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnExamenesActionPerformed

    private void btnNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotasActionPerformed
       try {
           // TODO add your handling code here:
           cambioPanel.cursos("notas", panelPrincipal, 850, 450, correo, Integer.parseInt(idCurso), tipo, controlador);
       } catch (SQLException ex) {
           Logger.getLogger(AreaDelCurso.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btnNotasActionPerformed

    private void btnForoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForoActionPerformed
       try {
           // TODO add your handling code here:
           cambioPanel.cursos("foro", panelPrincipal, 850, 450, correo, Integer.parseInt(idCurso), tipo, controlador);
       } catch (SQLException ex) {
           Logger.getLogger(AreaDelCurso.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btnForoActionPerformed

    private void btnDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescripcionActionPerformed
         try {
           // TODO add your handling code here:
           cambioPanel.cursos("descripcion", panelPrincipal, 850, 450, correo, Integer.parseInt(idCurso), tipo, controlador);
       } catch (SQLException ex) {
           Logger.getLogger(AreaDelCurso.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }//GEN-LAST:event_btnDescripcionActionPerformed

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
            java.util.logging.Logger.getLogger(AreaDelCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AreaDelCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AreaDelCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AreaDelCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AreaDelCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnuncios;
    private javax.swing.JButton btnConfig;
    private javax.swing.JButton btnDescripcion;
    private javax.swing.JButton btnExamenes;
    private javax.swing.JButton btnForo;
    private javax.swing.JButton btnNotas;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel laboNombre;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel lbNomHora;
    private javax.swing.JLabel lbNomfecha;
    private javax.swing.JLabel pEstudiante;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel umss;
    // End of variables declaration//GEN-END:variables

    
}
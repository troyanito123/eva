/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;
import Controlador.Controlador;
import Paneles.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import methods.*;
/**
 *
 * @author JORGE DELGADILLO
 */
public class mensajes extends javax.swing.JPanel {

    /**
     * Creates new form mensajes
     */
    cambioPaneles cambio = new cambioPaneles();
    
    private String usuario;
    
    private String tipo ;
    
    botones boton = new botones();
    
    private Controlador controlador;
    
    public mensajes(String usuario,String tipo,Controlador controlador) throws SQLException {
        
        this.usuario = usuario;
        
        this.tipo = tipo;
        
        this.controlador = controlador;
        
        initComponents();
        
        setOpaque(false);
        
        panelCambioMensajes.setOpaque(false);
        
        inicio();
        
         
    }
    public void inicio() throws SQLException{
    
        cambio.cambiar_panel("recibido", panelCambioMensajes, 713, 361,usuario,tipo,controlador);
    
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRecibido = new javax.swing.JButton();
        btnEnviados = new javax.swing.JButton();
        btnNuevoMensaje = new javax.swing.JButton();
        panelCambioMensajes = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mensajeria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRecibido.setBackground(new java.awt.Color(204, 204, 255));
        btnRecibido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRecibido.setText("Recibidos");
        btnRecibido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRecibido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRecibidoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRecibidoMouseExited(evt);
            }
        });
        btnRecibido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecibidoActionPerformed(evt);
            }
        });
        add(btnRecibido, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 30, 107, 30));

        btnEnviados.setBackground(new java.awt.Color(204, 204, 255));
        btnEnviados.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEnviados.setText("Enviados");
        btnEnviados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnviadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnviadosMouseExited(evt);
            }
        });
        btnEnviados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviadosActionPerformed(evt);
            }
        });
        add(btnEnviados, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 104, 30));

        btnNuevoMensaje.setBackground(new java.awt.Color(204, 204, 255));
        btnNuevoMensaje.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNuevoMensaje.setText("Nuevo Mensaje");
        btnNuevoMensaje.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoMensaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNuevoMensajeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevoMensajeMouseExited(evt);
            }
        });
        btnNuevoMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoMensajeActionPerformed(evt);
            }
        });
        add(btnNuevoMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 131, 30));

        panelCambioMensajes.setPreferredSize(new java.awt.Dimension(715, 362));

        javax.swing.GroupLayout panelCambioMensajesLayout = new javax.swing.GroupLayout(panelCambioMensajes);
        panelCambioMensajes.setLayout(panelCambioMensajesLayout);
        panelCambioMensajesLayout.setHorizontalGroup(
            panelCambioMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
        );
        panelCambioMensajesLayout.setVerticalGroup(
            panelCambioMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );

        add(panelCambioMensajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 71, 747, 361));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecibidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecibidoActionPerformed
        try {
            // cambiamos al panel recibido
            cambio.cambiar_panel("recibido", panelCambioMensajes, 713, 361,usuario,tipo,controlador);
        } catch (SQLException ex) {
            Logger.getLogger(mensajes.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }//GEN-LAST:event_btnRecibidoActionPerformed

    private void btnEnviadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviadosActionPerformed
        try {
            // cambiamos al panel enviado
            cambio.cambiar_panel("enviados",panelCambioMensajes,713,361,usuario,tipo,controlador);
        } catch (SQLException ex) {
            Logger.getLogger(mensajes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEnviadosActionPerformed

    private void btnNuevoMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMensajeActionPerformed
        try {
            // cambiamos al panel nuevo
            cambio.cambiar_panel("nuevo",panelCambioMensajes,713,361,usuario,tipo,controlador);
        } catch (SQLException ex) {
            Logger.getLogger(mensajes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnNuevoMensajeActionPerformed

    private void btnRecibidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecibidoMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(btnRecibido,"entrada");
    }//GEN-LAST:event_btnRecibidoMouseEntered

    private void btnRecibidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecibidoMouseExited
        // TODO add your handling code here:
        boton.cambioColor(btnRecibido,"salida");
    }//GEN-LAST:event_btnRecibidoMouseExited

    private void btnEnviadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviadosMouseExited
        // TODO add your handling code here:
        boton.cambioColor(btnEnviados,"salida");
    }//GEN-LAST:event_btnEnviadosMouseExited

    private void btnEnviadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviadosMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(btnEnviados,"entrada");
    }//GEN-LAST:event_btnEnviadosMouseEntered

    private void btnNuevoMensajeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMensajeMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(btnNuevoMensaje,"entrada");
    }//GEN-LAST:event_btnNuevoMensajeMouseEntered

    private void btnNuevoMensajeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMensajeMouseExited
        // TODO add your handling code here:
        boton.cambioColor(btnNuevoMensaje,"salida");
    }//GEN-LAST:event_btnNuevoMensajeMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviados;
    private javax.swing.JButton btnNuevoMensaje;
    private javax.swing.JButton btnRecibido;
    private javax.swing.JPanel panelCambioMensajes;
    // End of variables declaration//GEN-END:variables
}

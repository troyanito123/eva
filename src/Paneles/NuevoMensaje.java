/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;
import Controlador.Controlador;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import methods.*;
/**
 *
 * @author JORGE DELGADILLO
 */
public class NuevoMensaje extends javax.swing.JPanel {

    /**
     * Creates new form NuevoMensaje
     */
    private String usuario;
    
    private String tipo ;
    
    botones boton = new botones();
    
    private Controlador controlador;
    
    public NuevoMensaje(String usuario,String tipo,Controlador controlador) {
        
        this.usuario = usuario;
        
        this.tipo = tipo;
        
        this.controlador = controlador;
        
        initComponents();
        
        setOpaque(false);
        
        atxtMensaje.setLineWrap(true);
        
    }
    
    public void limpiar (){
        
        txtPara.setText("");
        txtAsunto.setText("");
        atxtMensaje.setText("");
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbPara = new javax.swing.JLabel();
        txtPara = new javax.swing.JTextField();
        lbAsunto = new javax.swing.JLabel();
        txtAsunto = new javax.swing.JTextField();
        lbMensaje = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        atxtMensaje = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo Mensaje"));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbPara.setText("PARA:");
        add(lbPara, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 46, -1));
        add(txtPara, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 260, 40));

        lbAsunto.setText("ASUNTO:");
        add(lbAsunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));
        add(txtAsunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 260, 40));

        lbMensaje.setText("MENSAJE:");
        add(lbMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 59, -1));

        atxtMensaje.setColumns(20);
        atxtMensaje.setRows(5);
        jScrollPane1.setViewportView(atxtMensaje);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 410, 280));

        btnEnviar.setBackground(new java.awt.Color(204, 204, 255));
        btnEnviar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEnviar.setText("Enviar Mensaje");
        btnEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnviarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnviarMouseExited(evt);
            }
        });
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 140, 40));

        btnCancelar.setBackground(new java.awt.Color(204, 204, 255));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 140, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(btnEnviar,"entrada");
    }//GEN-LAST:event_btnEnviarMouseEntered

    private void btnEnviarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarMouseExited
        // TODO add your handling code here:
        boton.cambioColor(btnEnviar,"salida");
    }//GEN-LAST:event_btnEnviarMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(btnCancelar,"entrada");
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        // TODO add your handling code here:
        boton.cambioColor(btnCancelar,"salida");
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
       
        
        if(controlador.enviarMensaje(txtAsunto.getText(),atxtMensaje.getText(), usuario,txtPara.getText())){
            JOptionPane.showMessageDialog(null,"Mensaje enviado Correctamente");
            limpiar();
        }else{
            JOptionPane.showMessageDialog(null,"No se puedo enviar el mensaje");
        }
        
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea atxtMensaje;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAsunto;
    private javax.swing.JLabel lbMensaje;
    private javax.swing.JLabel lbPara;
    private javax.swing.JTextField txtAsunto;
    private javax.swing.JTextField txtPara;
    // End of variables declaration//GEN-END:variables
}

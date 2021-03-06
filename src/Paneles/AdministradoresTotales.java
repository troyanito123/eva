/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import Controlador.Controlador;

import forms.crearUsuario;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import methods.*;

/**
 *
 * @author JORGE DELGADILLO
 */
public class AdministradoresTotales extends javax.swing.JPanel {

    /**
     * Creates new form AdministradoresTotales
     */
    
    private String usuario;
    
    botones boton = new botones();
    
   
    
    private Controlador controlador;
    public AdministradoresTotales(String usuario,Controlador controlador) throws SQLException {
        
        this.controlador = controlador;
        this.usuario = usuario;
        
        initComponents();
        
        setOpaque(false);
        
        
        
        setTable();
    }
    private void setTable(){
        DefaultTableModel modelo = controlador.usuarios("administrador");
        tablaAdmin.setModel(modelo);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAdmin = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        bntEditar = new javax.swing.JButton();
        bntActualizar = new javax.swing.JButton();
        bntEliminar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Administradores en la plataforma", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaAdmin);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 551, 370));

        btnNuevo.setBackground(new java.awt.Color(204, 204, 255));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNuevoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevoMouseExited(evt);
            }
        });
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 130, 40));

        bntEditar.setBackground(new java.awt.Color(204, 204, 255));
        bntEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntEditar.setText("Editar");
        bntEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bntEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bntEditarMouseExited(evt);
            }
        });
        bntEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEditarActionPerformed(evt);
            }
        });
        add(bntEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 130, 40));

        bntActualizar.setBackground(new java.awt.Color(204, 204, 255));
        bntActualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntActualizar.setText("Actualizar lista");
        bntActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bntActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bntActualizarMouseExited(evt);
            }
        });
        bntActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntActualizarActionPerformed(evt);
            }
        });
        add(bntActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 130, 40));

        bntEliminar.setBackground(new java.awt.Color(204, 204, 255));
        bntEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntEliminar.setText("Eliminar");
        bntEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bntEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bntEliminarMouseExited(evt);
            }
        });
        bntEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEliminarActionPerformed(evt);
            }
        });
        add(bntEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 130, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(btnNuevo,"entrada");
    }//GEN-LAST:event_btnNuevoMouseEntered

    private void btnNuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseExited
        // TODO add your handling code here:
        boton.cambioColor(btnNuevo,"salida");
    }//GEN-LAST:event_btnNuevoMouseExited

    private void bntEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntEditarMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(bntEditar,"entrada");
    }//GEN-LAST:event_bntEditarMouseEntered

    private void bntEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntEditarMouseExited
        // TODO add your handling code here:
        boton.cambioColor(bntEditar,"salida");
    }//GEN-LAST:event_bntEditarMouseExited

    private void bntActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntActualizarMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(bntActualizar,"entrada");
    }//GEN-LAST:event_bntActualizarMouseEntered

    private void bntActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntActualizarMouseExited
        // TODO add your handling code here:
        boton.cambioColor(bntActualizar,"salida");
    }//GEN-LAST:event_bntActualizarMouseExited

    private void bntEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntEliminarMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(bntEliminar,"entrada");
    }//GEN-LAST:event_bntEliminarMouseEntered

    private void bntEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntEliminarMouseExited
        // TODO add your handling code here:
        boton.cambioColor(bntEliminar,"salida");
    }//GEN-LAST:event_bntEliminarMouseExited

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        crearUsuario usuario = new crearUsuario("administrador",controlador);
        usuario.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void bntEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEditarActionPerformed
        // TODO add your handling code here:
        int fila = tablaAdmin.getSelectedRow();
        if(fila>=0){
            try {
                String correo = tablaAdmin.getValueAt(fila,3).toString();
                crearUsuario editar = new crearUsuario("actualizacion", correo,"profesor",controlador);
                editar.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(AdministradoresTotales.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Fila no seleccionada");
        }
    }//GEN-LAST:event_bntEditarActionPerformed

    private void bntActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntActualizarActionPerformed
        setTable();
    }//GEN-LAST:event_bntActualizarActionPerformed

    private void bntEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEliminarActionPerformed
        // TODO add your handling code here:
        int fila = tablaAdmin.getSelectedRow();
        if(fila>=0){
            int id = Integer.parseInt(tablaAdmin.getValueAt(fila,0).toString());
            String correo = tablaAdmin.getValueAt(fila,3).toString();
            try {
                if(controlador.eliminarUsuario(id, correo)){
                     JOptionPane.showMessageDialog(null, "Datos Eliminados");
                     setTable();
                }else{
                       JOptionPane.showMessageDialog(null,"Ocurrio un error al ejecutar la operacion");
                }
            } catch (SQLException ex) {
                Logger.getLogger(estudiantesTotales.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Fila no seleccionada");
        }
    }//GEN-LAST:event_bntEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntActualizar;
    private javax.swing.JButton bntEditar;
    private javax.swing.JButton bntEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAdmin;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import Controlador.Controlador;
import java.awt.Color;
import javax.swing.JPanel;
import forms.*;
import java.sql.ResultSet;
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
public class misCursos extends javax.swing.JPanel {

    /**
     * Creates new form misCursos
     */
    private String usuario;
    
    private String tipo;
    
    private Controlador controlador;
    
    botones boton = new botones();
    
    public misCursos(String usuario,String tipo,Controlador controlador) {
        
        this.usuario = usuario;
        
        this.tipo = tipo;
        
        this.controlador = controlador;
        
        initComponents();
       
       setOpaque(false);
       
       inicio();
       
       disabled();
       
       colocarTabla();
        
    }
    //metodo para mostrar la tabla 
    private void colocarTabla(){

        if(tipo == "inscritos"){
               DefaultTableModel modelo = controlador.misCursos(usuario);
               tableMisCursos.setModel(modelo);
            
        }else{
            DefaultTableModel modelo = controlador.getTablaCursos(usuario);
               tableMisCursos.setModel(modelo);
           
        }

    }
    //metodo para desabilitar el boton nuevo 
    private void disabled(){
    
        if(tipo.equals("inscritos")){
            btnNuevoCurso.setVisible(false);
        }else{
            btnNuevoCurso.setVisible(true);
        }
        
    }
    
    //metodo para los ajustes inniciales del frame
    private void inicio(){
        
        if(tipo.equals("inscritos")){
            
            btnBaja.setText("Darse de Baja");
            
            
        }else{
           
            btnBaja.setText("Eliminar Curso");
            
        }
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
        tableMisCursos = new javax.swing.JTable();
        btnIngresar = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        btnNuevoCurso = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mi lista de cursos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableMisCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableMisCursos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 510, 350));

        btnIngresar.setBackground(new java.awt.Color(204, 204, 255));
        btnIngresar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresarMouseExited(evt);
            }
        });
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 160, 60));

        btnBaja.setBackground(new java.awt.Color(204, 204, 255));
        btnBaja.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBaja.setText("Darse de Baja");
        btnBaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBajaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBajaMouseExited(evt);
            }
        });
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });
        add(btnBaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 160, 60));

        btnNuevoCurso.setBackground(new java.awt.Color(204, 204, 255));
        btnNuevoCurso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNuevoCurso.setText("Nuevo");
        btnNuevoCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNuevoCursoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevoCursoMouseExited(evt);
            }
        });
        btnNuevoCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCursoActionPerformed(evt);
            }
        });
        add(btnNuevoCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 160, 60));

        btnActualizar.setBackground(new java.awt.Color(204, 204, 255));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnActualizar.setText("Actualizar Lista");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnActualizarMouseExited(evt);
            }
        });
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 160, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        int fila = tableMisCursos.getSelectedRow();
        if(fila >= 0){
            int id  = Integer.parseInt(tableMisCursos.getValueAt(fila,0).toString());
            String nombre = tableMisCursos.getValueAt(fila,1).toString();
            AreaDelCurso area = new AreaDelCurso();
            area.setControlador(controlador);
            area.setCorreo(usuario);
            area.setTituloCurso(nombre);
            area.setTipo(tipo);
            area.setIdCurso(String.valueOf(id));
            area.anularConfiguracion();
            try {
                area.setInicio();
            } catch (SQLException ex) {
                Logger.getLogger(misCursos.class.getName()).log(Level.SEVERE, null, ex);
            }
            area.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"Fila no seleccionada");
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(btnIngresar,"entrada");
    }//GEN-LAST:event_btnIngresarMouseEntered

    private void btnIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseExited
        // TODO add your handling code here:
        boton.cambioColor(btnIngresar,"salida");
    }//GEN-LAST:event_btnIngresarMouseExited

    private void btnNuevoCursoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoCursoMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(btnNuevoCurso, "entrada");
    }//GEN-LAST:event_btnNuevoCursoMouseEntered

    private void btnNuevoCursoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoCursoMouseExited
        // TODO add your handling code here:
        boton.cambioColor(btnNuevoCurso,"salida");
    }//GEN-LAST:event_btnNuevoCursoMouseExited

    private void btnBajaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBajaMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(btnBaja, "entrada");
    }//GEN-LAST:event_btnBajaMouseEntered

    private void btnBajaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBajaMouseExited
        // TODO add your handling code here:
        boton.cambioColor(btnBaja, "salida");
    }//GEN-LAST:event_btnBajaMouseExited

    private void btnNuevoCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCursoActionPerformed
        // TODO add your handling code here:
        CrearCurso curso = new CrearCurso();
        curso.setControlador(controlador);
        curso.setCorreo(usuario);
        curso.setVisible(true);
    }//GEN-LAST:event_btnNuevoCursoActionPerformed

    private void btnActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseEntered
        // TODO add your handling code here:
        boton.cambioColor(btnActualizar, "entrada");
    }//GEN-LAST:event_btnActualizarMouseEntered

    private void btnActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseExited
        // TODO add your handling code here:
        boton.cambioColor(btnActualizar, "salida");
    }//GEN-LAST:event_btnActualizarMouseExited

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        // TODO add your handling code here:
       int fila = tableMisCursos.getSelectedRow();
        if(fila >= 0){
            int id  = Integer.parseInt(tableMisCursos.getValueAt(fila,0).toString());
            if(btnBaja.getText()=="Darse de Baja"){
                if(controlador.removerInscripcion(id)){
                    JOptionPane.showMessageDialog(null,"Se ha removido la inscripcion a el curso seleccionado");
                }else{
                    JOptionPane.showMessageDialog(null,"No se ha podido remover la inscripcion al curso");
                }
            }else{
                if(controlador.eliminarCurso(id)){
                    JOptionPane.showMessageDialog(null,"Curso eliminado exitosamente");
                }else{
                    JOptionPane.showMessageDialog(null,"Error al eliminar el curso ");
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"Fila no seleccionada");
        }
    }//GEN-LAST:event_btnBajaActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        colocarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnNuevoCurso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMisCursos;
    // End of variables declaration//GEN-END:variables
}
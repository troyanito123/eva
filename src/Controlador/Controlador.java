/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import forms.login;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author JORGE DELGADILLO
 */
public class Controlador {

    private login login;
    private Modelo modelo;
    public Controlador(){
    
    }
    public boolean actualizaDescripcion(String descripcion,int idCurso){
        return modelo.actualizarDescripcion(descripcion, idCurso);
    }
    public String dameDescripcion(int id){
        return modelo.dameDescripcion(id);
    }
    public boolean actualizarEstadoCurso(int estado,int curso){
        return modelo.actualizarEstadoCurso(estado, curso);
    }
    public boolean insertarForoMensaje(String resp,int idForo, String usuario ){
        return modelo.insertarMensajeForo(resp, idForo, usuario);
    }
    public ArrayList<String> mensajesForo(int id){
        return modelo.mensajesForo(id);
    }
    public DefaultTableModel mostrarForo(int id){
        return modelo.recuperaForo(id);
    }
    public boolean eliminarForo(int id){
        return modelo.eliminarForo(id);
    }
    public boolean iniciarForo(String nombre, int idCurso){
        return modelo.iniciarForo(nombre, idCurso);
    }
    public boolean eliminarExamen(int examenID) {
        return modelo.eliminarExamen(examenID);
    }
    public boolean eliminarPregunta(int idPregunta) {
        return modelo.eliminarPregunta(idPregunta);
    }
    
    public boolean updatePreguntaRespuesta(int idExamen, int idPregunta, String pre, String res1, String res2, String res3, String res4, int vf1, int vf2, int vf3, int vf4) {
        return modelo.updatePreguntaRespuesta(idExamen, idPregunta, pre, res1, res2, res3, res4, vf1, vf2, vf3, vf4);
    }
     public boolean setPreguntas(int id, String pre, String res1, String res2, String res3, String res4, 
            int vf1, int vf2, int vf3, int vf4) {
        return modelo.setPreguntas(id, pre, res1, res2, res3, res4, vf1, vf2, vf3, vf4);}
    public DefaultTableModel getPreguntas(int idExamen) {
        return modelo.getTablaPreguntas(idExamen);
    }
    public DefaultTableModel getRespuestas(String idPregunta) {
        return modelo.getRespuestas(Integer.parseInt(idPregunta));
    }
    public boolean guardarCalificacion(String idUsuario, int idCurso, int idExamen, ArrayList<Integer> listaVF, ArrayList<Integer> listaLlenado) {
       return modelo.guardarCalificacion(idUsuario, idCurso, idExamen, listaVF, listaLlenado);
    }
    public boolean actualizarIntentosRea(int idExamen, int intento) {
        return modelo.actualizarIntentosRea(idExamen, intento);
    }
    public String getNombreExamen(int idExamen) {
        return modelo.getNombreExamen(idExamen);
    }

    public String getCantidadExamen(int idExamen) {
        return modelo.getCantidadExamen(idExamen);
    }

    public ArrayList<String> getListaPreguntas(int idExamen) {
        return modelo.getListaPreguntas(idExamen);
    }

    public ArrayList<String> getListaRespuestas(int idExamen) {
        return modelo.getListaRespuestas(idExamen);
    }

    public ArrayList<Integer> getListaVF(int idExamen) {
        return modelo.getListaVF(idExamen);
    }
     public int getIntentosRea(int idExamen) {
        return modelo.getIntentoRea(idExamen);
    }

    public int getIntentosMax(int idExamen) {
        return modelo.getIntentosMax(idExamen);
    }
    public ArrayList<String> dameAnuncios(int idCurso){
        return modelo.dameAnuncios(idCurso);
    }
    public boolean eliminarAnunciosCurso(){
        return modelo.removerAnunciosCursos();
    }
    public boolean anuncioCurso(int idCurso,String anuncio){
        return modelo.insertarAnuncioCurso(idCurso, anuncio);
    }
    public boolean removerInscripcion(int identi){
        return modelo.removerInscripcion(identi);
    }
    public boolean eliminarCurso(int id){
    
        return modelo.eliminarCurso(id);
    }
    public DefaultTableModel dameCursosGlobalesAdministracion(String correo){
        
        return modelo.dameCursosSR(correo);
    
    }
    public boolean existeInscripcion(int id ,String correo){
        return modelo.estaInscrito(id, correo);
    }
    public boolean inscribirse(int id,String correo){
        return modelo.inscripcion(id, correo);
    }
    public DefaultTableModel glabalCursos(String correo){
        return modelo.cursosGlobales(correo);
    }
    public DefaultTableModel misCursos(String correo){
        return modelo.misCursos(correo);
    }
    public DefaultTableModel getTablaCursos(String correo ){
        
        return modelo.getTablaCursosEducador(correo);
    }
    public boolean insertarCursos(String correo,String nombre,int estado){
        return modelo.insertarCursos(correo, nombre, estado);
    }
    public boolean existe(String correo ){
        return modelo.existe(correo);
    }
    public boolean insertarPersona(FileInputStream file,String nombres,String apellidos,int telefono,String correo) throws SQLException{
        return modelo.insertarPersona(file, nombres, apellidos, telefono, correo);
    }
    public boolean insertarCuenta(String correo,String contraseña, int tipo) throws SQLException{
        return modelo.insertarCuenta(correo, contraseña,  tipo );
    }
    public boolean actualizarCuenta(String contraseña, String correo){
        
        return modelo.actualizarCuenta(contraseña, correo);
    
    }
    public boolean actualizarPersona(FileInputStream file,String nombres,String apellidos,String telefono,String correo){
        return modelo.actualizarPersona(file, nombres, apellidos, telefono, correo);
    }
    public boolean insertarMensaje(String mensaje,String correo){
        return modelo.insertarMensaje(mensaje, correo);
    }
    public boolean eliminarInicio(){
        return modelo.eliminarInicioMensajes();
    }
    public boolean enviarMensaje(String asunto ,String mensaje,String usu_envia,String usu_recibe){
    
        return modelo.enviarMensaje(asunto, mensaje, usu_envia, usu_recibe);
        
    }
    public void cierraConexion() throws SQLException{
            modelo.cerrarConexion();
    }
    public boolean eliminarMensaje(String id){
        return modelo.eliminarMensaje(id);
    }
    public DefaultTableModel mensajes(String usuario,String tipo) throws SQLException{
        return modelo.mensajes(usuario, tipo);
    }
    
   public boolean eliminarUsuario(int id,String correo) throws SQLException{
       return modelo.eliminarPersona(id,correo);
    }
    
    
    public DefaultTableModel usuarios(String tipo){
            return modelo.getUsuarios(tipo);
    }
    
    public ArrayList<String> mensajesInicio(){
     
        ArrayList<String> respuesta =null;
        respuesta = modelo.mensajesPlataforma();
            
        return respuesta;
    }
    
    public String[] editarUsuario(String correo) throws SQLException{
        
        return modelo.dameDatosTotales(correo);
    
    }
     public void setVista(login login) {
        this.login = login;
    }
     public void setLogin(login login) {
        this.login = login;
    }

    public void setModelo(Modelo modelo){
        this.modelo = modelo;
    }

    public String validarUsuario(String usuario, String contraseña) {
        return modelo.validar(usuario, contraseña);
 
    }
    public String[] getDatosUsuario(String correo) {
        return modelo.getDatosUsuario(correo);
    }

    public ImageIcon getImagenPerfil(String correo) {
        return modelo.getImagenPerfil(correo);
    }
    
    public String getNombreCurso(int idCurso) {
        return modelo.getNombreCurso(idCurso);
    }

    public String getNombreEducador(String idUsuario) {
        return modelo.getNombreEducador(idUsuario);
    }

    public TableModel getExamenesCursoEstudiante(int idCurso,String correo) {
        return modelo.getExamenesCursoEstudiante(idCurso,correo);
    }
    public TableModel getNotasCursoEstudiante(String idUsuario, int idCurso) {
        return modelo.getNotasCursoEstudiante(idUsuario, idCurso);
    }
     public DefaultTableModel llenarTablaExamenesCurso(int idCurso) {
       return modelo.llenarTablaExamenesCurso(idCurso);
     }
     public boolean insertarExamen(int idCurso, String nombreExamen, String fechaEx, String horaInicio, String minutoInicio, String horaFin, String minutoFin, String tiempo, int intentos) {
        return modelo.insertarExamen(idCurso, nombreExamen, fechaEx, horaInicio, minutoInicio,
                horaFin, minutoFin, tiempo, intentos);}
      public boolean habilitarExamen(int idExamen) {
        return modelo.habilitarExamen(idExamen);
    }
    
    public boolean deshabilitarExamen(int idExamen) {
        return modelo.deshabilitarExamen(idExamen);
    }

    public TableModel getNotasCursoCompleto(String idUsuario, int idCurso) {
        return modelo.getNotasCursoCompleto(idUsuario, idCurso);
    }
}

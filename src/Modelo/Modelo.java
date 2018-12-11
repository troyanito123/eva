/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controlador;
import conexionBD.conexion;
import java.awt.Image;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.TableModel;
/**
 *
 * @author JORGE DELGADILLO
 */
public class Modelo {
    private conexion con;
    private Connection cn;
    private Controlador controlador;
    
    public Modelo(){
        con = new conexion();
        cn = con.conexion();
    }
    //metodo para actualizar la descripcion del usuario
    public boolean actualizarDescripcion(String descripcion,int idCurso){
            boolean respuesta = false;
            String sql = "";
            try{
                sql = "UPDATE curso SET descripcion = ? WHERE id_curso="+idCurso;
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1,descripcion);
                
                int n = ps.executeUpdate();
                if (n>0){
                   respuesta = true;
                }
                }catch(Exception e){
                
                }
         return respuesta;
    }
    //dame lal descripcion 
    public String dameDescripcion(int idCurso){
            String respuesta = "";
            String sql = "select descripcion from curso where id_curso = " + idCurso;
            Statement st;
            ResultSet rs;
            try {
                st = cn.createStatement();
                rs = st.executeQuery(sql);
            while(rs.next()){
                respuesta = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
            return respuesta;
     }
    //actualizamos el estado del curso 
    public boolean actualizarEstadoCurso(int estado,int idCurso){
         boolean respuesta = false;
        String sql = "";
         try{
                sql = "UPDATE curso SET estado_curso = ? WHERE id_curso ="+idCurso+"";
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1,estado);
                
                int n = ps.executeUpdate();
                if (n>0){
                   respuesta = true;
                }
                }catch(Exception e){
                
                }
         return respuesta;
    }
    //insertar mensajes al foro 
    public boolean insertarMensajeForo(String resp,int idDestino,String usuario){
          boolean respuesta = false;
        
         String sql = "insert into foro_respuesta(respuestaForo,foro_id,usuarioForo) values(?,?,?)";
        
            try{
                
                PreparedStatement ps = cn.prepareCall(sql);
        
                ps.setString(1,resp);
        
                ps.setInt(2,idDestino);
                
                ps.setString(3,usuario);
        
                int n = ps.executeUpdate();
        
                if(n>0){
                    respuesta = true;
                    
                }
        
             }catch(Exception e){
        
                JOptionPane.showMessageDialog(null,"Error"+ e.getMessage());
       
              }
            return respuesta;
        
    }
    //recuperar mensajes de un foro
    public ArrayList<String> mensajesForo(int idForo){
        ArrayList<String> array= new ArrayList<String>();
        String sql= ""; 
       sql = "SELECT id_foro_respuesta,respuestaForo FROM foro_respuesta WHERE  foro_id = '"+idForo+"'" ;

        Statement st ;
         ResultSet respuesta = null;
         
        try {
           st= cn.createStatement();
           respuesta = st.executeQuery(sql);
          
                  while(respuesta.next()){
                      
                      array.add(respuesta.getString(2));
                    }
           
        
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error"+ e.getMessage());
        
        }
       return array;
    }
    //recuperar los foros
    public DefaultTableModel recuperaForo(int idForo){
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("ID");
        res.addColumn("Nombre Foro");
       
        String datos[] = new String[2];
        String sql = "SELECT id_foro,nombreForo FROM foro WHERE id_curso_foro="+idForo;
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                res.addRow(datos);
            }
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    //aliminar foro 
    public boolean eliminarForo(int id){
        boolean respuesta = false;
            try {
            
                PreparedStatement pps = cn.prepareStatement("DELETE FROM foro WHERE id_foro = "+id);
            
                 pps.executeUpdate();
                 respuesta = true;
            
            } catch (SQLException ex) {
                Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            }
       return respuesta ;
    }
    public boolean iniciarForo(String nombre,int idCurso){
         boolean res = false;
        String sql = "insert into foro (nombreForo, id_curso_foro) values (?,?)";
        PreparedStatement ps;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1,nombre );
            ps.setInt(2,idCurso);
            ps.execute();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    public ArrayList<String> dameAnuncios(int idcurso){
         
        ArrayList<String> array= new ArrayList<String>();
        String sql= ""; 
       sql = "SELECT id_anuncio_curso,nombreAnuncio FROM anunciocurso WHERE id_curso_anuncio = "+idcurso+" ORDER BY id_anuncio_curso DESC";

        Statement st ;
         ResultSet respuesta = null;
         
        try {
           st= cn.createStatement();
           respuesta = st.executeQuery(sql);
          
                  while(respuesta.next()){
                      
                      array.add(respuesta.getString(2));
                    }
           
        
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error"+ e.getMessage());
        
        }
       return array;
    }
    public boolean removerAnunciosCursos(){
        boolean respuesta = false;
            try {
            
                PreparedStatement pps = cn.prepareStatement("DELETE FROM anunciocurso");
            
                 pps.executeUpdate();
                 respuesta = true;
            } catch (SQLException ex) {
                Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            }
       return respuesta ;
    }
    //para insertar anuncios dentro el estar del lcurso 
    public boolean insertarAnuncioCurso(int id,String anuncio){
        
        boolean respuesta = false;
        
         String sql = "INSERT INTO anunciocurso(nombreAnuncio,id_curso_anuncio)"+"VALUES(?,?)";
        
            try{
                
                PreparedStatement ps = cn.prepareCall(sql);
        
                ps.setString(1,anuncio);
        
                ps.setInt(2,id);
        
                int n = ps.executeUpdate();
        
                if(n>0){
                    respuesta = true;
                    
                }
        
             }catch(Exception e){
        
                JOptionPane.showMessageDialog(null,"Error"+ e.getMessage());
       
              }
            return respuesta;
    }
    public boolean removerInscripcion(int id){
        boolean respuesta = false;
        try {
            
            PreparedStatement pps = cn.prepareStatement("DELETE FROM inscripcioncurso where id_cursoInscripcion = "+id+"");
            
            pps.executeUpdate();
            respuesta = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    //eliminar un curso de la plataforma
    public boolean eliminarCurso(int id){
        boolean respuesta = false;
        try {
            
            PreparedStatement pps = cn.prepareStatement("DELETE FROM curso where id_curso = "+id+"");
            
            pps.executeUpdate();
            respuesta = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta ;
    }
    //todos los cursos para el administrador
    public DefaultTableModel dameCursosSR(String correo){
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("ID");
        res.addColumn("Nombre Curso");
       
        String datos[] = new String[2];
        String sql = "SELECT id_curso,nombre_curso FROM curso WHERE correoEncargado NOT IN (select correoEncargado FRom curso WHERE correoEncargado = '"+correo+"')";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                res.addRow(datos);
            }
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    //verificarcion de la inscripcion
    public boolean estaInscrito(int id,String correo){
        boolean respuesta = false;
        String sql = "select * from inscripcioncurso where id_cursoInscripcion="+id+" and usuarioInscripcion = '"+correo+"'";
        Statement st;
        int idPregunta = 0;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                respuesta = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta; 
    }
    //inscribirse a el curso 
    public boolean inscripcion(int id, String correo){
         boolean res = false;
        String sql = "insert into inscripcioncurso (id_cursoInscripcion, usuarioInscripcion) values (?,?)";
        PreparedStatement ps;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2,correo);
            ps.execute();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    //para los cursos globales
    public DefaultTableModel cursosGlobales(String correo){
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("ID");
        res.addColumn("Nombre Curso");
       
        String datos[] = new String[2];
        String sql = "SELECT id_curso,nombre_curso FROM curso WHERE estado_curso = 1 and correoEncargado NOT IN (select correoEncargado FRom curso WHERE correoEncargado = '"+correo+"')";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                res.addRow(datos);
            }
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    //para los cursos en el que el usuario se inscribe
    public DefaultTableModel misCursos(String correo) {
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("ID");
        res.addColumn("Nombre Curso");
        
        String datos[] = new String[2];
        String sql = "select c.id_curso,c.nombre_curso from inscripcioncurso as i,curso as c where i.id_cursoInscripcion = c.id_curso and i.usuarioInscripcion = '"+correo+"'";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
             
                res.addRow(datos);
            }
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    //existe correo 
    public boolean existe(String correo){
        boolean respuesta = false;
            String sql = "SELECT correo FROM usuario WHERE correo ='"+correo+"'";
            
            Statement st;
            try {
            st = cn.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);
            if(rs.first()){
                respuesta = true;
            } 

            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error"+ e.getMessage());                 
            }
          return respuesta;
    }
    //para insertar en la tabla usuaario donde se registra el usuaio contraseña
    public boolean insertarCuenta(String Correo,String Contraseña,int tipo) throws SQLException{
        boolean respuesta = true;
        String sql = "INSERT INTO usuario(correo,contrasena,tipo)"+"VALUES(?,?,?)";
        
        try{
        
            PreparedStatement ps = cn.prepareCall(sql);
        
            ps.setString(1,Correo);
        
            ps.setString(2,Contraseña);
        
            ps.setInt(3,tipo);
        
            int n = ps.executeUpdate();
        
            if(n>0){
                respuesta = true;
                //JOptionPane.showMessageDialog(null,"datos guardados en cuenta");
            }
        
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(null,"Error"+ e.getMessage());
       
        }
        return respuesta;
    }
    
    //metodo para insertar los datos del usuario
    public boolean insertarPersona(FileInputStream file,String nombres,String apellidos,int telefono,String correo) throws SQLException{
       boolean respuesta = false;
         if(telefono > 0){
         
             
            String sql = "INSERT INTO persona(perfil,nombres,apellidos,telefono,correo)"+"VALUES(?,?,?,?,?)";
        
            try{
                
                PreparedStatement ps = cn.prepareCall(sql);
        
                 ps.setBinaryStream(1,file);
        
                ps.setString(2,nombres);
        
                ps.setString(3,apellidos);
                
                ps.setInt(4,telefono);
                
                ps.setString(5,correo);
        
                int n = ps.executeUpdate();
        
                if(n>0){
                    respuesta = true;
                    //JOptionPane.showMessageDialog(null,"DATOS GUARDADOS CORRECTAMENTE");
                }
        
             }catch(Exception e){
        
                JOptionPane.showMessageDialog(null,"Error"+ e.getMessage());
       
              }
         }else{
             
            String sql = "INSERT INTO persona(perfil,nombres,apellidos,correo)"+"VALUES(?,?,?,?)";
        
            try{
        
                PreparedStatement ps = cn.prepareCall(sql);
        
               ps.setBinaryStream(1,file);
        
                ps.setString(2,nombres);
        
                ps.setString(3,apellidos);
                
                ps.setString(4,correo);
        
              int n = ps.executeUpdate();
        
             if(n>0){
                    respuesta = true;
                    //JOptionPane.showMessageDialog(null,"DATOS GUARDADOS CORRECTAENTE");
                }
        
            }catch(Exception e){
        
                JOptionPane.showMessageDialog(null,"Error"+ e.getMessage());
       
            }
         }
         return respuesta;
         
    }
    
    //actualizar cuenta
    public boolean actualizarCuenta(String contraseña,String correo){
        boolean respuesta = false;
        String sql = "";
         try{
                sql = "UPDATE usuario SET contrasena = ? WHERE correo='"+correo+"'";
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1,contraseña);
                
                int n = ps.executeUpdate();
                if (n>0){
                   respuesta = true;
                }
                }catch(Exception e){
                
                }
         return respuesta;
    }
    //consulta para actualizar los datos de la persona 
    public boolean actualizarPersona(FileInputStream file,String nombres,String apellidos,String telefono,String correo){
        boolean respuesta = false;
        String sql = "";
            if(file == null){
                try{
                sql = "UPDATE persona SET nombres = ?, apellidos = ?, telefono = ? WHERE correo='"+correo+"'";
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1,nombres);
                ps.setString(2,apellidos);
                ps.setString(3,telefono);
                int n = ps.executeUpdate();
                if (n>0){
                    respuesta = true;
                    
                }
                }catch(Exception e){
                
                }
            }else{
            
                try{
                sql = "UPDATE persona SET perfil = ? , nombres = ?, apellidos = ?, telefono = ? WHERE correo='"+correo+"'";
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setBinaryStream(1,file);
                ps.setString(2,nombres);
                ps.setString(3,apellidos);
                ps.setString(4,telefono);
                int n = ps.executeUpdate();
                if (n>0){
                    respuesta = true;
                    //JOptionPane.showMessageDialog(null, "Datos Actualizados");
                }else{
                    JOptionPane.showMessageDialog(null,"ha ocurrido un error,los datos no se actualizaron");
                }
                }catch(Exception e){
                
                }
                
            }
            return respuesta ;
    }
    //insertar mensaje 
    public boolean insertarMensaje(String mensaje,String correo){
        
        boolean respuesta = false;
        
         String sql = "INSERT INTO mensajes_inicio(mensaje_inicio,administrador)"+"VALUES(?,?)";
        
            try{
                
                PreparedStatement ps = cn.prepareCall(sql);
        
                ps.setString(1,mensaje);
        
                ps.setString(2,correo);
        
                int n = ps.executeUpdate();
        
                if(n>0){
                    respuesta = true;
                    
                }
        
             }catch(Exception e){
        
                JOptionPane.showMessageDialog(null,"Error"+ e.getMessage());
       
              }
            return respuesta;
    }
    //eliminar todos los mensajes de inicio 
    public boolean eliminarInicioMensajes(){
        boolean respuesta = false;
        try {
            
            PreparedStatement pps = cn.prepareStatement("DELETE FROM mensajes_inicio");
            
            pps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta ;
    }
    //consulta para enviar mensaje
    public boolean enviarMensaje(String asunto ,String mensaje,String usu_envia,String usu_recibe){
    
     
        boolean respuesta = false;
        
        String sql = "INSERT INTO mensajes(asuntoMensaje,textoMensaje,usuarioEnvia,usuarioRecibe)"+"VALUES(?,?,?,?)";
        
        try{
            
            PreparedStatement ps = cn.prepareCall(sql);
            
            ps.setString(1,asunto);
            
            ps.setString(2,mensaje);
            
            ps.setString(3,usu_envia);
            
            ps.setString(4,usu_recibe);
            
            int n = ps.executeUpdate();
            
            if(n>0){

     
                respuesta = true;

            }
        
        }catch(Exception e){
           
            JOptionPane.showMessageDialog(null,"Error"+ e.getMessage());
        
        }
        return respuesta;
        
    }
    //cerrar la conexion 
    public void cerrarConexion() throws SQLException{
        
        cn.close();
    
    }
    //eliminar mensaje
    public boolean eliminarMensaje(String id){
        boolean respuesta = false;
        try {
            PreparedStatement pps = cn.prepareStatement("DELETE FROM mensajes WHERE nroMensajes = "+id+"");
            pps.executeUpdate();
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    //eliminar una persona 
    public boolean eliminarPersona(int id,String correo) throws SQLException{
        boolean respuesta = false;
        try {
            PreparedStatement pps = cn.prepareStatement("DELETE FROM persona WHERE nroPersona = "+id+"");
            pps.executeUpdate();
            PreparedStatement pps2 = cn.prepareStatement("DELETE FROM usuario WHERE correo = '"+correo+"'");
            pps2.executeUpdate();
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    //extraer los mensajes enviados o recibidos de la base de datos 
    public DefaultTableModel mensajes(String usuario, String tipoMensaje) throws SQLException{
        
        //primero generamos las variables que tendra dicha tabla
        DefaultTableModel modelo;
        
        modelo = new DefaultTableModel();
        
        modelo.addColumn("ID");
        
        modelo.addColumn("De");
        
        modelo.addColumn("Asunto");
        
        modelo.addColumn("Mensaje");
  
        //ahora realizamos la consulta
       
        
        String[] datos = new String [4];
        String sql= ""; 
        if(tipoMensaje == "recibido"){
             sql = "SELECT * FROM mensajes WHERE usuarioRecibe ='"+usuario+"' ORDER BY nroMensajes DESC";
        }else{
            
            sql = "SELECT * FROM mensajes WHERE usuarioEnvia ='"+usuario+"' ORDER BY nroMensajes DESC";
        }
        
        Statement st ;
         ResultSet respuesta = null;
        try {
           st= cn.createStatement();
           respuesta = st.executeQuery(sql);
           while(respuesta.next()){
                datos[0]= String.valueOf(respuesta.getInt(1));
              
                datos[1]= respuesta.getString(4);
              
                datos[2]= respuesta.getString(2);
              
                datos[3]= respuesta.getString(3);
              
                modelo.addRow(datos);
            }
        
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error"+ e.getMessage());
        
        }
        return modelo;
        
  }
    //extraer todos los estudiantes de la plataforma 
    public DefaultTableModel getUsuarios(String tipo_usuario) {
        DefaultTableModel modelo;
        
        modelo = new DefaultTableModel();
        
        modelo.addColumn("NRO_REGISTRO");
        
        modelo.addColumn("APELLIDOS");
        
        modelo.addColumn("NOMBRES");
        
        modelo.addColumn("CORREO");
        
        
        //ahora realizamos la consulta
       
        
        String[] datos = new String [4];
        String sql= ""; 
        if(tipo_usuario == "estudiantes"){
             sql = "SELECT nroPersona,apellidos,nombres,u.correo FROM usuario as u ,persona as p WHERE u.correo = p.correo AND tipo ="+3+" ORDER BY apellidos ASC";
        }else if(tipo_usuario == "educador"){
            
            sql = "SELECT nroPersona,apellidos,nombres,u.correo FROM usuario as u ,persona as p WHERE u.correo = p.correo AND tipo ="+2+" ORDER BY apellidos ASC";
        }else if(tipo_usuario == "administrador"){
            sql = "SELECT nroPersona,apellidos,nombres,u.correo FROM usuario as u ,persona as p WHERE u.correo = p.correo AND tipo ="+1+" ORDER BY apellidos ASC";
        }
        
        Statement st ;
         ResultSet respuesta = null;
        try {
           st= cn.createStatement();
           respuesta = st.executeQuery(sql);
           while(respuesta.next()){
                datos[0]= String.valueOf(respuesta.getInt(1));
              
                datos[1]= respuesta.getString(2);
              
                datos[2]= respuesta.getString(3);
                
                datos[3]= respuesta.getString(4);
       
                modelo.addRow(datos);
            }
    
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error"+ e.getMessage());
        
        }
        return modelo;
    }

    //consulta para extraer los mensajes de la plataforma
    public ArrayList<String> mensajesPlataforma(){
        
        ArrayList<String> array= new ArrayList<String>();
        String sql= ""; 
       sql = "SELECT id_mensaje_inicio,mensaje_inicio FROM mensajes_inicio ORDER BY id_mensaje_inicio DESC";

        Statement st ;
         ResultSet respuesta = null;
         
        try {
           st= cn.createStatement();
           respuesta = st.executeQuery(sql);
          
                  while(respuesta.next()){
                      
                      array.add(respuesta.getString(2));
                    }
           
        
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error"+ e.getMessage());
        
        }
       return array;
    }
    //consulta para recuperarDatos y editar usuario
    public String[] dameDatosTotales(String correo) {
        
        String sql= ""; 

            sql = "SELECT u.correo,tipo,nroPersona,nombres,apellidos,telefono FROM usuario as u , persona as p WHERE u.correo = p.correo AND u.correo ='"+correo+"'";
            String [] datos = new String[6];
        Statement st ;
         ResultSet respuesta = null;
        try {
           st= cn.createStatement();
           respuesta = st.executeQuery(sql);
           while(respuesta.next()){
                datos[0] = respuesta.getString(1);
                datos[1] = String.valueOf(respuesta.getInt(2));
                datos[2] = String.valueOf(respuesta.getInt(3));
                datos[3] = respuesta.getString(4);
                datos[4] = respuesta.getString(5);
                datos[5] = respuesta.getString(6);
            }
           
        } catch(Exception ex){
           Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        return datos;
    }
    public boolean insertarExamen(String nombreExamen, String fechaEx, String horaInicio, 
            String minutoInicio, String horaFin, String minutoFin, String tiempo) {
        boolean res = false;
        String sql = "insert into examen (nombre_examen, fecha_examen, hora_ini_exa, hora_fin_exa, tiempo_examen, estado) values (?,?,?,?,?,?)";
        PreparedStatement ps;
        String horaI = horaInicio + ":"+minutoInicio;
        String horaF = horaFin + ":" + minutoFin;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombreExamen);
            ps.setString(2, fechaEx);
            ps.setString(3, horaI);
            ps.setString(4, horaF);
            ps.setString(5, tiempo);
            ps.setBoolean(6, false);
            ps.execute();
            
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public DefaultTableModel llenarTabla() {
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("ID");
        res.addColumn("Nombre");
        res.addColumn("Fecha");
        res.addColumn("Hora Inicio");
        res.addColumn("Hora fin");
        res.addColumn("tiempo");
        res.addColumn("Estado");
        String sql = "select * from examen";
        String datos[] = new String[7];
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);

                if(rs.getBoolean(7))
                    datos[6] = "DESHABILITADO";
                else
                    datos[6] = "HABILITADO";
                res.addRow(datos);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public boolean setPreguntas(int id, String pre, String res1, String res2, String res3, String res4, int vf1, int vf2, int vf3, int vf4) {
        boolean res = false;
        boolean pregunta = setPregunta(id, pre);
        boolean respuesta = setRespuestas(pre, res1, res2, res3, res4, vf1, vf2, vf3, vf4);
        if(pregunta && respuesta)
            res = true;
        return res;
    }

    private boolean setPregunta(int id, String pre) {
        boolean res = false;
        String sql = "insert into pregunta (id_examen, pregunta_examen) values (?,?)";
        PreparedStatement ps;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, pre);
            ps.execute();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    private boolean setRespuestas(String pre, String res1, String res2, String res3, String res4, int vf1, int vf2, int vf3, int vf4) {
        boolean res = false;
        int idPregunta = getIdPregunta(pre);
        String sql = "insert into respuesta (id_pregunta, respuesta_pregunta, correcto) "
                + "values ('"+idPregunta+"', '"+res1+"', '"+vf1+"'), ('"+idPregunta+"', '"+res2+"', '"+vf2+"'), "
                + "('"+idPregunta+"', '"+res3+"', '"+vf3+"') ,('"+idPregunta+"', '"+res4+"', '"+vf4+"')";
        Statement st;
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    private int getIdPregunta(String pre) {
        String sql = "select id_pregunta from pregunta where pregunta_examen = '" + pre + "'";
        Statement st;
        int idPregunta = 0;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                idPregunta = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idPregunta; 
    }

    public DefaultTableModel getTablaPreguntas(int idExamen) {
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("ID");
        res.addColumn("PREGUNTA");
        String datos[] = new String[2];
        String sql = "select pre.id_pregunta, pre.pregunta_examen\n" +
                    "from pregunta as pre\n" +
                    "where pre.id_examen = " + idExamen;
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                res.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return res;
    }

    public DefaultTableModel getRespuestas(int idPregunta) {
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("ID");
        res.addColumn("RESPUESTA");
        res.addColumn("V-F");
        String datos[] = new String[3];
        String sql = "select id_respuesta, respuesta_pregunta, correcto\n" +
                    "from respuesta\n" +
                    "where ID_PREGUNTA = " + idPregunta;
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                if(rs.getBoolean(3))
                    datos[2] = "V";
                else
                    datos[2] = "F";
                res.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return res;
    }

    public boolean updatePreguntaRespuesta(int idExamen, int idPregunta, String pre, String res1, String res2, String res3, String res4, int vf1, int vf2, int vf3, int vf4) {
        boolean res = false;
        boolean pregunta = updatePregunta(idExamen, idPregunta, pre);
        boolean respuesta = updateRespuesta(idPregunta, res1, res2, res3 ,res4, vf1, vf2, vf3, vf4);
        if(pregunta && respuesta)
            res = true;
        return res;
    }

    private boolean updatePregunta(int idExamen, int idPregunta, String pre) {
        boolean res = false;
        String sql = "UPDATE pregunta SET pregunta_examen = '"+ pre +"' WHERE id_pregunta = " + idPregunta;
        PreparedStatement ps;
        try {
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    private boolean updateRespuesta(int idPregunta, String res1, String res2, String res3, String res4, int vf1, int vf2, int vf3, int vf4) {
        boolean res = false;
        String[] idRespuestas = new String[4];
        idRespuestas = buscarRespuestas(idPregunta);
        String sql1 = "UPDATE respuesta SET respuesta_pregunta = '"+ res1 +"', correcto = '"+ vf1 +"' WHERE id_respuesta = " + idRespuestas[0];
        String sql2 = "UPDATE respuesta SET respuesta_pregunta = '"+ res2 +"', correcto = '"+ vf2 +"' WHERE id_respuesta = " + idRespuestas[1];
        String sql3 = "UPDATE respuesta SET respuesta_pregunta = '"+ res3 +"', correcto = '"+ vf3 +"' WHERE id_respuesta = " + idRespuestas[2];
        String sql4 = "UPDATE respuesta SET respuesta_pregunta = '"+ res4 +"', correcto = '"+ vf4 +"' WHERE id_respuesta = " + idRespuestas[3];
        PreparedStatement ps;
        try {
            ps = cn.prepareStatement(sql1);
            ps.executeUpdate();
            ps = cn.prepareStatement(sql2);
            ps.executeUpdate();
            ps = cn.prepareStatement(sql3);
            ps.executeUpdate();
            ps = cn.prepareStatement(sql4);
            ps.executeUpdate();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }

    public String[] buscarRespuestas(int idPregunta) {
        String [] res = new String[4];
        String sql = "select id_respuesta from respuesta where id_pregunta = "+ idPregunta;
        Statement st;
        int cont = 0;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                res[cont] = rs.getString(1);
                cont++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public boolean eliminarPregunta(int idPregunta) {
        boolean res = false;
        String sql = "DELETE FROM pregunta WHERE ID_PREGUNTA = " + idPregunta;
        String sql1 = "DELETE FROM respuesta WHERE ID_PREGUNTA = " + idPregunta;
        PreparedStatement ps;
        try {
            ps = cn.prepareStatement(sql1);
            ps.executeUpdate();
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public boolean insertarUsuario(String correo, String contraseña, String tipo, String nombre, String apellido) {
        boolean res = false;
        String sql = "insert into cuenta (correo, contraseña, tipo, nombre, apellido) values (?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contraseña);
            ps.setString(3, tipo);
            ps.setString(4, nombre);
            ps.setString(5, apellido);
            ps.execute();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public String validar(String usuario, String contraseña) {
        String res = "";
        String sql = "SELECT nombre_tipo FROM usuario,tipo_usuario WHERE tipo = idTipo and correo = '"+usuario+"' and contrasena ='"+contraseña+"'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                res = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return res;
    } 

    public String[] getDatosUsuario(String correo) {
        String[] res = new String[3];
        String sql = "select correo,nombres, apellidos from persona where correo = '"+ correo +"'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet  rs = st.executeQuery(sql);
            while(rs.next()){
                res[0] = rs.getString(1);
                res[1] = rs.getString(2);
                res[2] = rs.getString(3);
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public ImageIcon getImagenPerfil(String correo) {
        ImageIcon res = null;
        String sql = "select perfil from persona where correo = '"+ correo +"'";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            try{
                while(rs.next()){
                Blob blob = rs.getBlob("perfil");
                Image i = null;
                i = javax.imageio.ImageIO.read(blob.getBinaryStream());
                Image n = i.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                if(i == null)
                    System.out.println("la imagen es null");
                else
                    res = new ImageIcon(n);
                }
            }
            catch(Exception e){System.out.println(e.toString());}
            
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public boolean actualizarDatosUsuario(int idUsuario, String nombre, String apellido, String correo, String pass, FileInputStream archivoFoto) {
        boolean res = false;
        String sql = "UPDATE cuenta SET nombre ='"+nombre+"', apellido ='"+apellido+"', "
                + "correo = '"+correo+"', contraseña = '"+pass+"', imagen = ? WHERE id_cuenta ='"+idUsuario+"'";
        Statement st;
        ResultSet rs;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setBinaryStream(1, archivoFoto);
            ps.executeUpdate();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public boolean insertarCursos(String correo, String nombre, int estado) {
        boolean res = false;
        
        String sql = "insert into curso (nombre_curso, estado_curso,descripcion,correoEncargado) values (?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setInt(2, estado);
            ps.setString(3,"ESTE CURSO NO DISPONE DE UNA DESCRIPCION");
            ps.setString(4,correo);
            ps.execute();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return res;
    }

    private boolean enlazarUsuarioCurso(int idUsuario) {
        boolean res = false;
        int idCurso = 0;
        String sql = "SELECT MAX(id_curso) FROM curso";
        String sql1 = "insert into cuenta_curso (id_curso, id_cuenta, creado) values (?,?,?)";
        Statement st;
        PreparedStatement ps;
        try {
            st = cn.createStatement();
            ResultSet  rs = st.executeQuery(sql);
            while(rs.next()){
                idCurso = rs.getInt(1);
            }
            System.out.println(idCurso);
            ps = cn.prepareStatement(sql1);
            ps.setInt(1, idCurso);
            ps.setInt(2, idUsuario);
            ps.setInt(3, 1);
            ps.execute();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return res;
    }

    public DefaultTableModel getTablaCursosEducador(String correo){
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("ID");
        res.addColumn("Nombre Curso");
        res.addColumn("Estado");
        String datos[] = new String[3];
        String sql = "SELECT id_curso,nombre_curso,estado_curso FROM curso WHERE correoEncargado='"+correo+"'";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                if(rs.getInt(3) == 0)
                    datos[2] = "No visible";
                else
                    datos[2] = "visible";
                res.addRow(datos);
            }
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public String getNombreCurso(int idCurso) {
        String res = "";
        String sql = "select nombre_curso from curso where id_curso = " + idCurso;
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                res = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;  
    }

    public String getNombreEducador(String idUsuario) {
        String res = "";
        String sql = "select nombres from persona as p,usuario as u,tipo_usuario as t where p.correo = u.correo and u.tipo = t.idTipo and p.correo = '"+idUsuario+"'";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                res = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res; 
    }

    public TableModel getExamenesCursoEstudiante(int idCurso, String correo) {
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("ID");
        res.addColumn("Nombre Examen");
        res.addColumn("Fecha");
        res.addColumn("Hora Inicio");
        res.addColumn("Tiempo");
        res.addColumn("Intentos MAX");
        res.addColumn("Intentos Realizados");
        String datos[] = new String[7];
        String sql = "select x.ID_EXAMEN,x.NOMBRE_EXAMEN,x.FECHA_EXAMEN,x.HORA_INI_EXA,x.TIEMPO_EXAMEN,x.intentos_permitidos,x.intentos_realizados FROM examen as x, curso as c WHERE x.id_curso = c.id_curso and x.estado = 1 and c.id_curso = "+idCurso;
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                res.addRow(datos);
            }
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    public int getIntentosMax(int idExamen) {
        int res = 0;
        String sql = "select intentos_permitidos from examen where id_examen = " + idExamen;
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                res = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
 public int getIntentoRea(int idExamen) {
        int res = 0;
        String sql = "select intentos_realizados from examen where id_examen = " + idExamen;
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                res = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    public String getNombreExamen(int idExamen) {
        String res = "";
        String sql = "select nombre_examen from examen where id_examen = " + idExamen;
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                res = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    public String getCantidadExamen(int idExamen) {
        String res = "";
        String sql = "select ID_EXAMEN, count(*) as preguntas from pregunta where ID_EXAMEN = " + idExamen;
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                res = rs.getString(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;        
    }
     public ArrayList<String> getListaPreguntas(int idExamen) {
        ArrayList<String> res = new ArrayList();
        String sql = "select PREGUNTA_EXAMEN from pregunta where ID_EXAMEN = " + idExamen;
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                res.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;        
    }
     public ArrayList<String> getListaRespuestas(int idExamen) {
        ArrayList<String> res = new ArrayList();
        String sql = "select res.respuesta_pregunta from respuesta as res, pregunta as pre "
                + "where pre.ID_PREGUNTA = res.ID_PREGUNTA and pre.id_examen = " + idExamen;
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                res.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;        
    }
     public ArrayList<Integer> getListaVF(int idExamen) {
        ArrayList<Integer> res = new ArrayList();
        String sql = "select res.correcto from respuesta as res, pregunta as pre "
                + "where pre.ID_PREGUNTA = res.ID_PREGUNTA and pre.id_examen = " + idExamen;
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                res.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;        
    }
     public boolean guardarCalificacion(String idUsuario, int idCurso, int idExamen, ArrayList<Integer> listaVF, ArrayList<Integer> listaLlenado) {
        boolean res = false;
        double nota = 0;
        int correctos = 0;
        int max = listaVF.size();
        int cantPre = listaVF.size()/4;
        int cont;
        for (int i = 0; i < cantPre; i++) {
            cont = 0;
            for (int j = 0; j < 4; j++) {
                if(listaVF.get(i*4+j) == listaLlenado.get(i*4+j))
                    cont++;
                if(j == 3){
                    if(cont == 4)
                        correctos++;
                }
            }
        }
        System.out.println(correctos);
        nota = (correctos*100)/cantPre;
        System.out.println(nota);
        double nota1 = Math.round(nota);
        System.out.println(nota1);
        String sql = "INSERT INTO calificacion (correo_usuario, id_curso, id_examen, nota) "
                + "VALUES (?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1,idUsuario);
            ps.setInt(2,idCurso);
            ps.setInt(3,idExamen);
            ps.setDouble(4, nota);
            ps.execute();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
     public boolean actualizarIntentosRea(int idExamen, int intento) {
        boolean res = false;
        String sql = "UPDATE examen SET intentos_realizados = "+ intento +" WHERE id_examen = "+ idExamen;
        PreparedStatement ps;
        try {
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    public TableModel getNotasCursoEstudiante(String idUsuario, int idCurso) {
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("ID");
        res.addColumn("EXAMEN");
        res.addColumn("NOTA");
        String datos[] = new String[3];
        String sql = "SELECT ex.id_examen, ex.nombre_examen, AVG(ca.nota) from examen as ex, calificacion as ca WHERE ex.ID_EXAMEN = ca.id_examen and ca.id_curso ="+idCurso+" and ca.correo_usuario = '"+idUsuario+"' GROUP BY ex.ID_EXAMEN";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                res.addRow(datos);
            }
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;

    }
    
    
    
    
    
    
     public DefaultTableModel llenarTablaExamenesCurso(int idCurso) {
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("ID");
        res.addColumn("Nombre");
        res.addColumn("Fecha");
        res.addColumn("Hora Inicio");
        res.addColumn("Hora fin");
        res.addColumn("tiempo");
        res.addColumn("Estado");
        res.addColumn("Intentos");
        String sql = "select * from examen where id_curso = " + idCurso;
        String datos[] = new String[8];
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(3);
                datos[2] = rs.getString(4);
                datos[3] = rs.getString(5);
                datos[4] = rs.getString(6);
                datos[5] = rs.getString(7);
                if(rs.getBoolean(8))
                    datos[6] = "HABILITADO";
                else
                    datos[6] = "DESHABILITADO";
                datos[7] = rs.getString(9);
                res.addRow(datos);
            }           
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
     public boolean insertarExamen(int idCurso, String nombreExamen, String fechaEx, String horaInicio, 
        String minutoInicio, String horaFin, String minutoFin, String tiempo, int intentos) {
        boolean res = false;
        String sql = "insert into examen (id_curso, nombre_examen, fecha_examen, hora_ini_exa, hora_fin_exa, tiempo_examen, estado, intentos_permitidos) values (?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        String horaI = horaInicio + ":"+minutoInicio;
        String horaF = horaFin + ":" + minutoFin;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idCurso);
            ps.setString(2, nombreExamen);
            ps.setString(3, fechaEx);
            ps.setString(4, horaI);
            ps.setString(5, horaF);
            ps.setString(6, tiempo);
            ps.setBoolean(7, false);
            ps.setInt(8, intentos);
            ps.execute();
            
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
     public boolean eliminarExamen(int examenID) {
        boolean res = false;
        String sql = "DELETE FROM examen WHERE id_examen = " + examenID;
        ArrayList<Integer> preguntas = getIdPreguntas(examenID);
        for (int i = 0; i < preguntas.size(); i++) {
            this.eliminarPregunta(preguntas.get(i));
        }
        PreparedStatement ps;
        try {
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
     private ArrayList<Integer> getIdPreguntas(int examenID) {
        ArrayList<Integer> res = new ArrayList();
        String sql = "select id_pregunta from pregunta where id_examen = " + examenID;
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                res.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
     public boolean habilitarExamen(int idExamen) {
        boolean res = false;
        String sql = "UPDATE examen SET estado = 1 WHERE id_examen = "+ idExamen;
        PreparedStatement ps;
        try {
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public boolean deshabilitarExamen(int idExamen) {
        boolean res = false;
        String sql = "UPDATE examen SET estado = 0 WHERE id_examen = "+ idExamen;
        PreparedStatement ps;
        try {
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public TableModel getNotasCursoCompleto(String idUsuario, int idCurso) {
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("CORREO");
        res.addColumn("NOMBRE");
        res.addColumn("APELLIDO");
        res.addColumn("EXAMEN");
        res.addColumn("NOTA");
        String datos[] = new String[5];
        String sql = "SELECT per.correo,per.nombres,per.apellidos, ex.nombre_examen, AVG(ca.nota) "
                + "from examen as ex, calificacion as ca, curso as cur, inscripcioncurso as ins,persona as per,usuario as u "
                + "WHERE ex.ID_EXAMEN = ca.id_examen and cur.id_curso = ex.id_curso and ins.id_cursoInscripcion = cur.id_curso "
                + "and ins.usuarioInscripcion = per.correo and u.correo = per.correo and u.tipo = 3 and cur.id_curso = "+ idCurso +" GROUP BY ex.ID_EXAMEN";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                res.addRow(datos);
            }
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}

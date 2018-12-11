
package methods;
//librerias
import Controlador.Controlador;
import Paneles.*;
import java.awt.BorderLayout;
import java.sql.SQLException;
import javax.swing.JPanel;

public class cambioPaneles { 
    //metodo para hacer qeu en el panel destino aparezcan los paneles necesarios
    public void cambiar_panel(String panel, JPanel destino,int tam1,int tam2,String usuario,String tipo,Controlador controlador) throws SQLException{     
    //variable para instanciar panel necesario
        JPanel cambio = null ;
            //para ver nediante el strign que panel instanciar
            switch(panel){
                case "inicio":
                    cambio = new inicio(controlador);
                break;                
                case "mensajes":                   
                    cambio = new mensajes(usuario,tipo,controlador);                                   
                break;                    
                case "misCursos":                   
                    cambio = new misCursos(usuario,tipo,controlador);                   
                break;                   
                case "cursos":  
                    cambio = new totalCursos(usuario,tipo,controlador);
                break;
                case "recibido":
                    cambio = new recibidos(usuario,tipo,controlador);
                break;
                    
                case "enviados": 
                    cambio = new Enviados(usuario,tipo,controlador);
                break; 
                case "nuevo": 
                    cambio = new NuevoMensaje(usuario,tipo,controlador);
                break;  
                case "estudiantes":  
                    cambio = new estudiantesTotales(usuario,tipo,controlador);
                break;                   
                case "profesores":  
                    cambio = new profesoresTotales(usuario,tipo,controlador);                   
                break;                   
                case "administradores" :                    
                    cambio = new AdministradoresTotales(usuario,controlador);                   
                break;              
                case "config":               
                    cambio = new configuracion(usuario,controlador);
                break;
                case "anunciosCurso":
                    cambio = new anunciosCursos(usuario,controlador,tipo);
                break;
                case "cursoConfig":
                    cambio = new configuracionCurso(usuario,controlador,tipo);
                break;
            } 
           cambio.setSize(tam1,tam2);//cambiamos el tamaño del jpanel que instanciamos anteriormente
           cambio.setLocation(1,1);//ubicamos dentro el panel principal
           destino.removeAll();//removemos todos los items dentro el panel
           destino.add(cambio,BorderLayout.CENTER);//agregamoe le item dentro el panel pasado como parametro
           destino.revalidate();//revalidar el componente
           destino.repaint();//redibujamos el componente
    }
    public void cursos(String panel, JPanel destino,int tam1,int tam2,String usuario,int idCurso,String tipo,Controlador controlador) throws SQLException{
    //variable para instanciar panel necesario
        JPanel cambio = null ;
            switch(panel){//para ver nediante el strign que panel instanciar
                case "listaExamen":
                    cambio = new ListaExamenesEstudiante(usuario,tipo,controlador,idCurso);
                break;
                case "notas":
                    cambio = new Notas(usuario,tipo,controlador,idCurso);
                break;
                case "examen":
                    cambio = new examenes(usuario,tipo,controlador,idCurso);
                break;
                case "foro":
                    cambio = new foro(usuario,idCurso,tipo,controlador);
                break;
                case "descripcion":
                    cambio = new descripcion(idCurso,controlador);
                break;
            }
           cambio.setSize(tam1,tam2);//cambiamos el tamaño del jpanel que instanciamos anteriormente 
           cambio.setLocation(1,1);//ubicamos dentro el panel principal        
           destino.removeAll();//removemos todos los items dentro el panel
           destino.add(cambio,BorderLayout.CENTER);//agregamoe le item dentro el panel pasado como parametro 
           destino.revalidate();//revalidar el componente
           destino.repaint();//redibujamos el componente
    }  
}


package methods;
//librerias
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class cambioImagenes {
    //este es la clase qeu hace el cambio de imagen en el login 
    static int contador = 0;
    //instanciamos la clase para cambiar el tamaño de la imagen
    cambioTamaño tamaño = new cambioTamaño();
    public  void cambio2(JLabel imagen){
        
        int velocidad = 4;//velocidad en seg del semaforo
        
        Timer timer;
        
        TimerTask tarea;
        
        int velmil = velocidad *1000;
        
        //creamos la tarea
        
        tarea = new TimerTask(){
            
            public void run(){
                
                Icon icono ;
                //para cada switch cambiamos el contador  y el icono a un tamaño establecido
                switch(contador){
                    
                    case 0:
                        
                        contador = 1;
                        icono = tamaño.cambio(300, 300, "/img/sistemas.png");
                        imagen.setIcon(icono);
                        
                        break;
                        
                    case 1:
                        
                        contador = 2;
                        icono = tamaño.cambio(300, 300, "/img/informatica.png");
                        imagen.setIcon(icono);
                        
                        break;
                    
                    case 2:
                    
                        contador = 3;
                        icono = tamaño.cambio(300, 300, "/img/fcyt.png");
                        imagen.setIcon(icono);
                        
                        break;
                    
                    case 3:
                    
                        contador = 4;
                        icono = tamaño.cambio(300, 300, "/img/umss.png");
                        imagen.setIcon(icono);
                        
                        break;
                    
                    case 4:
                        contador = 0;
                        icono = tamaño.cambio(300, 300, "/img/info_sistemas.png");
                        imagen.setIcon(icono);
                    
                        break;
                }
            
            }
        };
        
        timer = new Timer();
        
        timer.scheduleAtFixedRate(tarea, velmil, velmil);
    }
}

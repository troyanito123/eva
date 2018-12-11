
package methods;
//librerias
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JToggleButton;

public class botones {
    public void cambioColor(JButton boton,String entrada){
        if(entrada.equals("entrada")){   
            boton.setBackground(new Color(102,102,255));
            boton.setForeground(Color.WHITE);
        }else{
            boton.setBackground(new Color(204,204,204));
            boton.setForeground(Color.BLACK);  
        }        
    }
    public void cambioColorSalir(JButton boton,String entrada){
        if(entrada.equals("entrada")){
            boton.setBackground(Color.RED);
            boton.setForeground(Color.WHITE);
        }else{
            boton.setBackground(new Color(204,204,204));
            boton.setForeground(Color.BLACK); 
        }
    }
    
    public void cambioColorToggle(JToggleButton boton,String entrada){       
        if(entrada.equals("entrada")){
            boton.setBackground(new Color(102,102,255));
            boton.setForeground(Color.WHITE);
        }else{
            boton.setBackground(new Color(204,204,204));
            boton.setForeground(Color.BLACK);
        } 
    }
}

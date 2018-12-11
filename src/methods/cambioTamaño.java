
package methods;
//librerias
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class cambioTamaño {
    //con este metodo hacemos lo que es el cambio de icono 
    public Icon cambio(int ancho, int largo,String ruta){   
        Icon respuesta;
        //sacamos la imagen
        ImageIcon icono = new ImageIcon(getClass().getResource(ruta));  
        respuesta = new ImageIcon(icono.getImage().getScaledInstance(ancho,largo,Image.SCALE_DEFAULT));
        return respuesta;  
    }
}

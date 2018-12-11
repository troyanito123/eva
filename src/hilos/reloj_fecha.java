/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

/**
 *
 * @author JORGE DELGADILLO
 */
public class reloj_fecha {
    //con este metodo colocamos el reloj y la hora respectiva
    public void iniciar (JLabel reloj,JLabel fecha){
        
     Thread marcador = new Thread(){
         
         public void run(){
             
             do{
                 
                int hora,minuto,segundo;
            
                 Calendar calendar = GregorianCalendar.getInstance();
                 
                Date date = Calendar.getInstance().getTime();
                
                SimpleDateFormat sdf = new SimpleDateFormat("E dd/MM/yyyy");
                
                hora = calendar.get(Calendar.HOUR_OF_DAY);
                
                minuto = calendar.get(Calendar.MINUTE);
                
                segundo = calendar.get(Calendar.SECOND);
                
                reloj.setText(hora+":"+minuto+":"+segundo);
                
                fecha.setText(sdf.format(date));
                
            }while(true);
        
        }
         
    };
     
     marcador.start();
     
 }   
    
}


import Controlador.Controlador;
import Modelo.Modelo;
import forms.login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *
 * @author JORGE DELGADILLO
 *
 */
public class Principal {
    
    public static void main (String [] args){
        
         Modelo modelo = new Modelo();
         
        Controlador controlador = new Controlador();
        
        login login = new login();
        
        login.setControlador(controlador);
        
        modelo.setControlador(controlador);
        
        controlador.setModelo(modelo);
        
        controlador.setLogin(login);

        login.setVisible(true);
    }
}

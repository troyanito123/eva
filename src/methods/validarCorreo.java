
package methods;

public class validarCorreo {
    public boolean validar (String usuario){
        boolean resp = false;
        String valido= "gmail.com";
        for(int i = 0; i < usuario.length();i++){
            if(usuario.charAt(i)=='@'){
                if(formarCadena(usuario,i+1).equals(valido)){
                    resp = true;}    
            }
        }
        return resp;
    }
    private String formarCadena(String usuario, int i){
        String resp="";
        if(i<usuario.length()){
            resp = usuario.charAt(i)+formarCadena(usuario,i+1);
        }
        return resp;
    }
}

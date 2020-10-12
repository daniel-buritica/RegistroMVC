
package ejemplomvc;

import Controlador.CtrlProducto;
import Modelo.ConsultasProducto;
import Modelo.producto;
import Vista.frmRegistro;


public class EjemploMVC {

   
    public static void main(String[] args) {
        
        
        producto mod= new producto();
        ConsultasProducto modC= new  ConsultasProducto(); 
        frmRegistro frm = new frmRegistro();
        
        CtrlProducto Ctrl= new CtrlProducto(mod, modC, frm);
        
        Ctrl.iniciar();
        frm.setVisible(true);
        
    }
    
}

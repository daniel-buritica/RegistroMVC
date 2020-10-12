
package Controlador;

import Modelo.*;
import Vista.frmRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class CtrlProducto implements ActionListener {
    
    private producto mod;
    private ConsultasProducto modC;
    private frmRegistro frm;
    
    /**
     * Se crean los objetos de clase  que van a interactura entre si 
     * y los bonotes que va a utilizar el método ActionListener,  para poder utilizar 
     * los objetos de otras clases tenemos que importar los paquetes con sus clases
     * @param mod
     * @param modC
     * @param frm 
     */

    public CtrlProducto(producto mod, ConsultasProducto modC, frmRegistro frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnEditar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnRegistrar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
    }

    public void iniciar (){
        frm.setTitle("Productos");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if (e.getSource()==frm.btnRegistrar) {
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            
            if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado" );
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Registrar ");
                limpiar();
            }
                
            
        }
        
        if (e.getSource()==frm.btnEditar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            
            if (modC.editar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro modificado" );
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al modificar ");
                limpiar();
            }
                
            
        }
        
        if (e.getSource()==frm.btnEliminar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            
            
            if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro eliminar" );
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar ");
                limpiar();
            }
                
            
        }
        
        if (e.getSource()==frm.btnBuscar) {
            mod.setCodigo(frm.txtCodigo.getText());
            
            
            if (modC.buscar(mod)) {
                
                frm.txtId.setText(String.valueOf(mod.getId()));
                frm.txtCodigo.setText(mod.getCodigo());
                frm.txtNombre.setText(mod.getNombre());
                frm.txtPrecio.setText(String.valueOf(mod.getPrecio()));
                frm.txtCantidad.setText(String.valueOf(mod.getCantidad()));
                
                
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro el resultado ");
                limpiar();
            }
                
            
        }
        if (e.getSource()==frm.btnLimpiar) {
        limpiar();
        
        }
    
    }
    
    public void limpiar(){
        frm.txtCantidad.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtId.setText(null);
        frm.txtNombre.setText(null);
        frm.txtPrecio.setText(null);
        
        
    }
    
    
    
    
    
   
    
    
    
}


package pruebas;

import gui.InterfazGrafica;
import gui.Usuario;
import javax.swing.JFrame;

/**
 *
 * @author t1pas
 */
public class Ejecutable {

    public static void main(String[] args) {
        
        Usuario usuario=new Usuario();
        usuario.setUsername("pruebapatrones@gmail.com");
        usuario.setGmailPassword("suft yhxw bxoz pjgd");
        usuario.setOutlookPassword("ssqarybljlnyugai");
        usuario.setSengridPassword("");
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        InterfazGrafica gui = new InterfazGrafica(usuario); 
        //gui.setSize(400, 300); 
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        gui.setVisible(true); 
    }
    
}

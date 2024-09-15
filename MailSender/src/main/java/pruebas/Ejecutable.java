
package pruebas;

import gui.InterfazGrafica;
import javax.swing.JFrame;

/**
 *
 * @author t1pas
 */
public class Ejecutable {

    public static void main(String[] args) {
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
        InterfazGrafica gui = new InterfazGrafica(); 
        //gui.setSize(400, 300); 
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        gui.setVisible(true); 
    }
    
}

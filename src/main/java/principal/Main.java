/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import vistas.Principal;
import vistas.dialogos.DlgLogin;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author fesquivelc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equalsIgnoreCase(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {

        }
        DlgLogin principal = new DlgLogin(null, true);
        principal.setVisible(true);
        
    }

}

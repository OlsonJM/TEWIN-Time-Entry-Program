/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tewin;
import java.io.*;
import javax.swing.*;


/**
 *
 * @author James M. Olson
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Main m = new Main();

        //verify program is not already running
        if(m.onlyInstance()){
            /*try {

            
	    // Set System Look and Feel
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
            }
            catch (UnsupportedLookAndFeelException e) {
               // handle exception
            }
            catch (ClassNotFoundException e) {
               // handle exception
            }
            catch (InstantiationException e) {
               // handle exception
            }
            catch (IllegalAccessException e) {
               // handle exception
            }*/

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TEMainForm().setVisible(true);
                }
            });
        }else
            System.exit(0);
            
    }

    /**Check to see if instance of Application is already running
     * Check to see if holder temporary file exists.
     * This indicates the TE program is already running.
     * @return boolean true if TE program is not alreadyrunning
     */
    private boolean onlyInstance(){
        File dir1 = new File (".");
        String location="";

        try{
            location = dir1.getCanonicalPath();
        } catch (IOException e) {
        }
        File temp = new File(location+"\\holder.tmp");

        if (!temp.exists())
            return true;
        else
        {
            int result = JOptionPane.showConfirmDialog(null,
                    "Instance of TEWIN already running (or at least I think it is)!\n" +
                    "Click YES to load anyway, or NO to exit","I think I'm already running",
                    JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION)
            {
                temp.delete();
                return true;
            }else
                return false;
        }
            
    }

}
